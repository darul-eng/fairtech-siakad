package siakad

import java.security.MessageDigest

class AuthController {
    def index() {
        if (session.user){
            flash.message = "Welcome " + session.user[0][1]
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

        if (Character.isLetter(username.charAt(0))){
            def student = Student.executeQuery("SELECT nim, name, password FROM Student WHERE nim =:nim", [nim: username])

//            return render(student[0][1])
            if (student != null) {
                if (student[0][2] == encodedPassword) {
                    session.user = student
                    redirect(action: 'index')
                }else{
                    flash.message = "password salah"
//                    flash.message = "Invalid username or password"
                    redirect(action: 'index')
                }
            }else{
                flash.message = "User not found"
//                flash.message = "Invalid username or password"
                redirect(action: 'index')
            }
        }else{
            def lecturer = Lecturer.findByNipAndPassword(nip: username, password: password)
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
