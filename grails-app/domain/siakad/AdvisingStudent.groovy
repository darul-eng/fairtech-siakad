package siakad

import java.time.LocalDateTime

class AdvisingStudent {
    Long studentId
    Long lecturerId
    Date createdAt
    Date updatedAt

    static constraints = {
        studentId nullable: false
        lecturerId nullable: false
    }
}
