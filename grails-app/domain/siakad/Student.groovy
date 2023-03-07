package siakad

import java.sql.Timestamp

class Student {
    String nim
    String name
    Integer yearOfEntry
    Timestamp createdAt
    Timestamp updatedAt
    Major major
    static constraints = {
        nim blank: false
        nim unique: true
        name blank: false
        yearOfEntry nullable: false
    }

    static mapping = {
        table 'student'
        version false
        id column: 'student_id'
        nim column: 'nim'
        name column: 'name'
        yearOfEntry column: 'year_of_entry'
        createdAt column: 'created_at'
        updatedAt column: 'updated_at'
        major column: 'major'
        major fetch: 'join', column: 'major_id'
    }
}
