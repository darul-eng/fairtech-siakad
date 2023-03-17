package siakad

import io.micronaut.http.HttpStatus

import java.security.MessageDigest

class AuthController {
    def index() {
        if (session.user){
            flash.message = "Welcome " + session.user.name
            redirect(uri: '/dashboard')
        }else{
            render(view: '/login')
        }
    }

    def authenticate() {
        def username = params.username
        def password = params.password
        String salt = 'mysalt'

        MessageDigest digest = MessageDigest.getInstance("SHA-256")
        byte[] hash = digest.digest((password + salt).getBytes("UTF-8"))
        String encodedPassword = new String(hash, "UTF-8")

        if (username == "" || password == ""){
            flash.message = "Invalid username or password"
            respond[:], view: "/login", status: 400
        }else{
            if (isStudent(username)) {
                Student student = Student.findByNimAndPassword(username, encodedPassword)
                if (student != null && student.password == encodedPassword){
                    session.user = student
                    redirect(action: 'index')
                }else{
                    flash.message = "Invalid username or password"
                    respond[:], view: "/login", status: 400
                }
            }else{
                Lecturer lecturer = Lecturer.findByNipAndPassword(username, encodedPassword)
                if (lecturer != null && lecturer.password == encodedPassword){
                    session.user = lecturer
                    redirect(action: 'index')
                }else{
                    flash.message = "Invalid username or password"
                    respond[:], view: "/login", status: 400
                }
            }
        }
    }

    def logout(){
        session.user = null
        redirect(action: 'index')
    }

    def isStudent(String username) {
        if (Character.isLetter(username.charAt(0))) {
            return true
        }else {
            return false
        }
    }
}
