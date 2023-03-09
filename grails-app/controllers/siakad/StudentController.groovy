package siakad

import grails.gorm.transactions.Transactional

import java.security.MessageDigest

@Transactional
class StudentController {
    def studentService

    def index() {
        def data = [
                "name": "Darul Ikhsan",
                "students": Student::list(),
                "uri": "/student"
        ]
        render(view: "/student/index", model: data)
    }

    def createStudent(){
        def data = [
                "uri": "/create-student",
                "majors": Major::list()
        ]
        render(view: "/student/createStudent", model: data)
    }
    def saveStudent() {
        def password = params.password
        String salt = 'mysalt'

        MessageDigest digest = MessageDigest.getInstance("SHA-256")
        byte[] hash = digest.digest((password + salt).getBytes("UTF-8"))
        String encodedPassword = new String(hash, "UTF-8")

        def today = new Date()
        def student = new Student(
                nim: params.nim,
                name: params.name,
                yearOfEntry: params.year_of_entry,
                major: params.major,
                password: encodedPassword,
                createdAt: today.toTimestamp(),
                updatedAt: today.toTimestamp()
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
            redirect(action: "index")
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

    def updateStudent(Integer id){
        def student = Student.findById(id)
       if (student == null){
           flash.message = "Student not found"
           redirect(action: "index")
       }else {
           def data = [
                   "student": student,
                   "uri": "/update-student",
                   "majors": Major::list()
           ]
           render(view: '/student/updateStudent', model: data)
       }

    }

    def storeStudent(){
        def id = params.id
        def student = Student.findById(id)

        def today = new Date()
        def major = Major.get(params.major)

        student.nim = params.nim
        student.name = params.name
        student.yearOfEntry = params.year_of_entry
        student.major = major
        student.updatedAt = today.toTimestamp()

        try {
            student.save(flush:true)
            if (!student.save(flush:true)) {
                student.errors.allErrors.each {error ->
                    log.error(error.toString())
                }
            }
            flash.message = "Data Siswa Berhasil di perbarui"
            redirect(action: "index")
        }catch (Exception e){
            log.error("Terjadi kesalahan saat menyimpan data: " + e.message)
            flash.message = "Terjadi kesalahan saat menyimpan data: " + e.message
            throw new RuntimeException("Error" + e.message)
            redirect(action: "updateStudent")
        }
    }

    def deleteStudent(Integer id){
        def student = Student.get(id)
        try {
            student.delete(flush: true)
            flash.message = "Data student berhasil dihapus"
            redirect(action: "index")
        }catch (Exception e){
            log.error("Terjadi kesalahan saat menghapus data: " + e.message)
            flash.message = "Terjadi kesalahan saat menghapus data: " + e.message
            redirect(action: "index")
        }
    }
}
