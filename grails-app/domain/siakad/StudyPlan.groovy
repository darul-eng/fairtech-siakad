package siakad

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.sql.Timestamp
import java.time.LocalDateTime

class StudyPlan {
    Long studentId
    String status
    Double grade
    Course course
    Date createdAt
    Date updatedAt

    static constraints = {
        studentId nullable: false
        status blank: false
        grade nullable: false
    }
}
