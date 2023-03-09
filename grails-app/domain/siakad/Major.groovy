package siakad

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.time.LocalDateTime

class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
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
