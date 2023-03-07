package siakad

import java.time.LocalDateTime

class Major {
    String name
    String code
    LocalDateTime createdAt
    LocalDateTime updatedAt
    static hasMany = [students: Student]
    Faculty faculty

    static constraints = {
        name blank: false
        code unique: true
    }

    static mapping = {
        table 'major'
        version false
        id column: 'major_id'
        name column: 'name'
        code column: 'code'
        createdAt column: 'created_at'
        updatedAt column: 'updated_at'
        students joinTable: [name: 'major_student', key: 'major_id', column: 'student_id']
        faculty fetch: 'join', column: 'faculty_id'
    }
}
