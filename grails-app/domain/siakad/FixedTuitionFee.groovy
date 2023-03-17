package siakad

import java.time.LocalDateTime

class FixedTuitionFee {
    Long studentId
    Integer amount
    Date createdAt
    Date updatedAt

    static constraints = {
        studentId nullable: false
        amount nullable: false
    }
}
