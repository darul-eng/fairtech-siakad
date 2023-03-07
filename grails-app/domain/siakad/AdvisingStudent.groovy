package siakad

import java.time.LocalDateTime

class AdvisingStudent {
    Integer studentId
    Integer lecturerId
    LocalDateTime createdAt
    LocalDateTime updatedAt

    static constraints = {
        studentId nullable: false
        lecturerId nullable: false
    }

    static mapping = {
        table 'advising_student'
        version false
        id column: 'advising_student_id'
        studentId column: 'student_id'
        lecturerId column: 'lecturer_id'
        createdAt column: 'created_at'
        updatedAt column: 'updated_at'
    }
}
