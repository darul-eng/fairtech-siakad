package siakad

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }


        "/login" (controller: "auth", action: 'index')
        "/logout" (controller: 'auth', action: 'logout')

        //mahasiswa
        "/dashboard" (controller: "dashboard", action: 'index')
        "/student"(controller: "student", action: 'index')
        "/create-student"(controller: "student", action: 'createStudent')
        "/save-student"(controller: "student", action: 'saveStudent', method: "POST")
        "/update-student/$id" (controller: "student", action: 'updateStudent')
        "/store-student" (controller: 'student', action: 'storeStudent', method: "PATCH")
        "/delete-student/$id"(controller: "student", action: "deleteStudent")

        "/study-plan" (controller: 'studyPlan', action: 'index')
        "/add-course" (controller: "studyPlan", action: 'addCourse')
        "/delete-study-plain/$id" (controller: "studyPlan", action: 'deleteCourse')

        "/study-plan-result" (controller: 'studyPlan', action: 'studyPlanResult')

        //dosen
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
