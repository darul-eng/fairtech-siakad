package siakad

import grails.gorm.transactions.Transactional

@Transactional
class StudyPlanController {

    def index() {
        def currentUser = session.user
        def studentId = currentUser[0][0]

        def data = [
                "studyPlans": StudyPlan.findAllByStudentId(studentId),
                "uri": "/study-plan"
        ]
        render(view: '/studyPlan/index', model: data)
    }

    def addCourse(){
        def data = [
                'uri': '/add-course',
                'courses': Course::list()
        ]
        render(view: '/studyPlan/listCourse', model: data)
    }

    def saveCourse(){
        def currentUser = session.user
        def studentId = currentUser[0][0]
        def course = Course.get(params.id)

        def today = new Date()
        def studyPlan = new StudyPlan(
                studentId: studentId,
                course: course,
                grade: 0,
                status: "on-progress",
                createdAt: today.toTimestamp(),
                updatedAt: today.toTimestamp()
        )

        try {
            studyPlan.validate()
            if (studyPlan.hasErrors()){
                flash.message = "Terjadi kesalahan saat menyimpan data"
                redirect(action: "addCourse")
            }
            studyPlan.save()
            flash.message = "Course Berhasil ditambahkan"
            redirect(uri: '/add-course')
        }catch (Exception e){
            log.error("Terjadi kesalahan saat menyimpan data: " + e.message)
            flash.message = "Terjadi kesalahan saat menyimpan data: " + e.message
            throw new RuntimeException("Error" + e.message)
        }
    }

    def deleteCourse(Integer id){
        StudyPlan studyPlan = StudyPlan.get(id)
        if (studyPlan){
            studyPlan.delete(flush: true)
            flash.message = "Course berhasil dihapus"
            redirect(action: "index")
        }else{
            flash.message = "Course tidak ditemukan"
        }
    }

    def studyPlanResult(){
        def currentUser = session.user
        def studentId = currentUser[0][0]

        def data = [
                "studyPlans": StudyPlan.findAllByStudentId(studentId),
                "uri": "/study-plan-result"
        ]
        render(view: '/studyPlan/studyPlanResult', model: data)
    }
}
