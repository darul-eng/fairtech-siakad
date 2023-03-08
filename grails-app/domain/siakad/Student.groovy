package siakad

import javax.persistence.Table
import java.sql.Timestamp
import java.time.Year

@Table(name = 'student')
class Student {
    String nim
    String name
    String password
    Year yearOfEntry
    String createdAt
    String updatedAt
//    Major major
    static constraints = {
        nim blank: false
        nim unique: true
        name blank: false
        password nullable: false
        yearOfEntry nullable: false
    }

    static mapping = {
        table 'student'
        version false
        id column: 'student_id'
        nim column: 'nim'
        name column: 'name'
        password column: 'password'
        yearOfEntry column: 'year_of_entry'
        createdAt column: 'created_at'
        updatedAt column: 'updated_at'
//        major column: 'major'
//        major fetch: 'join', column: 'major_id'
    }

}
