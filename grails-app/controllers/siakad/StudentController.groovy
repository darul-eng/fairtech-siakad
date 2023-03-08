package siakad

import grails.gorm.transactions.Transactional

import java.security.MessageDigest

@Transactional
class StudentController {
    def studentService

    def index() {
        def data = [
                "name": "Darul Ikhsan"
        ]
        render(view: "/student/index", model: data)
    }

    def createStudent(){
        def data = [
                "uri": "/create-student"
        ]
        render(view: "/student/createStudent", model: data)
    }
    def saveStudent() {
//        return render(params)
        def password = params.password
        String salt = 'mysalt'

        MessageDigest digest = MessageDigest.getInstance("SHA-256")
        byte[] hash = digest.digest((password + salt).getBytes("UTF-8"))
        String encodedPassword = new String(hash, "UTF-8")

        def student = new Student(
                nim: params.nim,
                name: params.name,
                yearOfEntry: params.year_of_entry,
                password: encodedPassword,
                createdAt: new Date(),
                updatedAt: new Date()
        )

        try {
            student.save(flush:true)
            if (!student.save(flush:true)) {
                student.errors.allErrors.each {error ->
                    log.error(error.toString())
                }
            }
//            studentService.saveStudent(student)
            flash.message = "Data Siswa Berhasil di simpan"
            redirect(action: "createStudent")
        }catch (Exception e){
            log.error("Terjadi kesalahan saat menyimpan data: " + e.message)
            flash.message = "Terjadi kesalahan saat menyimpan data: " + e.message
            throw new RuntimeException("Error" + e.message)
            redirect(action: "createStudent")
        }
    }

    def list() {
        try {
            def students = studentService.getAllStudent()
            [students: students]
        }catch (Exception e){
            log.error("Terjadi kesalahan saat mencari data: " + e.message)
            flash.message = "Terjadi kesalahan saat mencari data: " + e.message
            redirect(action: "index")
        }
    }

    def find(int id) {
        try {
            def student = studentService.findStudent(id)
            [student: student]
        }catch (Exception e){
            log.error("Terjadi kesalahan saat mencari data: " + e.message)
            flash.message = "Terjadi kesalahan saat mencari data: " + e.message
            redirect(action: "list")
        }
    }

    def delete(int id){
        def student = Student.get(id: id)
        try {
            studentService.deleteStudent(student)
            flash.message = "Data student berhasil dihapus"
            redirect(action: "list")
        }catch (Exception e){
            log.error("Terjadi kesalahan saat menghapus data: " + e.message)
            flash.message = "Terjadi kesalahan saat menghapus data: " + e.message
            redirect(action: "list")
        }
    }

    def update(int id){
        def student = Student.get(id: id)
        try {
            studentService.updateStudent(student)
            flash.message = "Data student berhasil diperbarui"
            redirect(action: "list")
        }catch (Exception e){
            log.error("Terjadi kesalahan saat memperbarui data: " + e.message)
            flash.message = "Terjadi kesalahan saat memperbarui data: " + e.message
            redirect(action: "edit")
        }

    }
}
