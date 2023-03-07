package seeders

import siakad.Student

import java.security.MessageDigest
import java.time.LocalDateTime

class StudentSeeder {
    def dataSource

    def seed(){
        Student.withTransaction { status ->
            String password = 'password'
            String salt = 'mysalt'

            MessageDigest digest = MessageDigest.getInstance("SHA-256")
            byte[] hash = digest.digest((password + salt).getBytes("UTF-8"))
            String encodedPassword = new String(hash, "UTF-8")

            def student = new Student(name: "Darul Ikhsan", nim: D121181017, password: encodedPassword, major: 1, createdAt: LocalDateTime.now(), updatedAt: LocalDateTime.now())

            student.save()
        }
    }

    def destroy(){
        Student.withTransaction {status->
            def conn = dataSource.getConnection()
            try{
                conn.createStatement().executeUpdate('DELETE FROM student')
            }finally {
                conn.close()
            }
        }
    }
}
