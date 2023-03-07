package siakad

import java.time.LocalDateTime

class Transaction {
    Integer studentId
    String status
    String paymentURL
    LocalDateTime createdAt
    LocalDateTime updatedAt

    static constraints = {
        studentId nullable: false
        status nullable: false
    }

    static mapping = {
        table 'transaction'
        version false
        id column: 'fixed_tuition_fee_id'
        studentId column: 'student_id'
        status column: 'status'
        paymentURL column: 'payment_url'
        createdAt column: 'created_at'
        updatedAt column: 'updated_at'
    }
}
