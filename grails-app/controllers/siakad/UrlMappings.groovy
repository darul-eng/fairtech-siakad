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

        "/student"(controller: "student", action: 'index')
//        "/student"(controller: "student", action: 'save', method: "POST")

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
