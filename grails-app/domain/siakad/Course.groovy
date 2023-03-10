package siakad

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.time.LocalDateTime

class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String name
    String code
    String semester
    Integer sks
    static hasMany = [studyPlans: StudyPlan]
    LocalDateTime createdAt
    LocalDateTime updatedAt

    static constraints = {
        name nullable: false
        code nullable: false
        code unique: true
        semester nullable: false
        sks nullable: false
    }

    static mapping = {
        table 'course'
        version false
        id column: 'course_id'
        name column: 'name'
        code column: 'code'
        semester column: 'semester'
        sks column: 'sks'
        createdAt column: 'created_at'
        updatedAt column: 'updated_at'
        studyPlans joinTable: [name: 'course_studyPlan', key: 'course_id', column: 'study_plan_id']
    }
}
