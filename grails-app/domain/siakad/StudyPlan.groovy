package siakad

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.sql.Timestamp
import java.time.LocalDateTime

class StudyPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    Long studentId
    String status
    Double grade
    Course course
    Timestamp createdAt
    Timestamp updatedAt

    static constraints = {
        studentId nullable: false
        courseId nullable: false
        status nullable: false
        grade nullable: false
    }

    static mapping = {
        table 'study_plan'
        version false
        id column: 'study_plan_id'
        studentId column: 'student_id'
        course column: 'course'
        course fetch: 'join', column: 'course_id'
        status column: 'status'
        grade column: 'grade'
        createdAt column: 'created_at'
        updatedAt column: 'updated_at'
    }
}
