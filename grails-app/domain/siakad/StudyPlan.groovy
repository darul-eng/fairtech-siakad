package siakad

import java.time.LocalDateTime

class StudyPlan {
    Integer studentId
    Integer courseId
    String status
    Integer grade
    LocalDateTime createdAt
    LocalDateTime updatedAt

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
        courseId column: 'course_id'
        status column: 'status'
        grade column: 'grade'
        createdAt column: 'created_at'
        updatedAt column: 'updated_at'
    }
}
