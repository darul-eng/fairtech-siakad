package siakad

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.sql.Timestamp
import java.time.Year

class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String nim
    String name
    String password
    String yearOfEntry
    Timestamp createdAt
    Timestamp updatedAt
    Major major
    static constraints = {
        nim nullable: false
        nim unique: true
        name nullable: false
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
        major column: 'major'
        major fetch: 'join', column: 'major_id'
    }
}
