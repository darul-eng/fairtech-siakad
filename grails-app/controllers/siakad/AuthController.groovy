package siakad

import java.security.MessageDigest

class AuthController {
    def index() {
        if (session.user){
            render('login sukses' + session.user)
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

        if (Character.isLetter(username.charAt(0))){
            def student = Student.findByNimAndPassword(username: username, password: encodedPassword)
            if (student != null) {
                session.user = student
                redirect(action: 'index')
            }else{
                flash.message = "Invalid username or password"
                redirect(action: 'index')
            }
        }else{
            def lecturer = Lecturer.findByNipAndPassword(username: username, password: password)
            if (lecturer != null) {
                session.user = lecturer
                redirect(action: 'index')
            }else{
                flash.message = "Invalid username or password"
                redirect(action: 'index')
            }
        }
    }

    def logout(){
        session.user = null
        redirect(action: 'index')
    }
}
