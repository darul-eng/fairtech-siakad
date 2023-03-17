package siakad

import java.time.LocalDateTime

class Transaction {
    Long studentId
    String status
    String paymentURL
    Date createdAt
    Date updatedAt

    static constraints = {
        studentId nullable: false
        status blank: false
    }
}
