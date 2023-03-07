package siakad

import java.time.LocalDateTime

class FixedTuitionFee {
    Integer studentId
    Integer amount
    LocalDateTime createdAt
    LocalDateTime updatedAt

    static constraints = {
        studentId nullable: false
        amount nullable: false
    }

    static mapping = {
        table 'fixed_tuition_fee'
        version false
        id column: 'fixed_tuition_fee_id'
        studentId column: 'student_id'
        amount column: 'amount'
        createdAt column: 'created_at'
        updatedAt column: 'updated_at'
    }
}
