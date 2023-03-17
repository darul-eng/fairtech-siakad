package siakad

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.time.LocalDateTime

class Course {
    String name
    String code
    String semester
    Integer sks
    static hasMany = [studyPlans: StudyPlan]
    LocalDateTime createdAt
    LocalDateTime updatedAt

    static constraints = {
        name blank: false
        code blank: false, unique: true
        semester blank: false
        sks nullable: false
    }
}
