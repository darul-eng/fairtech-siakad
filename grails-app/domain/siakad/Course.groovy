package siakad

import java.time.LocalDateTime

class Course {
    String name
    String code
    String semester
    Integer sks
    LocalDateTime createdAt
    LocalDateTime updatedAt

    static constraints = {
        name nullable: false
        code nullable: false
        code unique: true
        semester nullable: false
        sks nullable: false
    }

    static mapping = {
        table 'course'
        version false
        id column: 'course_id'
        name column: 'name'
        code column: 'code'
        semester column: 'semester'
        sks column: 'sks'
        createdAt column: 'created_at'
        updatedAt column: 'updated_at'
    }
}
