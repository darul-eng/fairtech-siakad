package siakad

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.sql.Timestamp
import java.time.Year

class Student {
    String nim
    String name
    String password
    Integer yearOfEntry
    Timestamp createdAt
    Timestamp updatedAt
    Major major

    static constraints = {
        nim blank: false, unique: true
        name blank: false
        password blank: false
        yearOfEntry nullable: false
        createdAt nullable: true
        updatedAt nullable: true
        major nullable: false
    }
}
