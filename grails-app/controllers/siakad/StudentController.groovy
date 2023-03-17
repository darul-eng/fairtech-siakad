package siakad

import grails.gorm.transactions.Transactional

import java.security.MessageDigest

@Transactional
class StudentController {
    StudentService studentService
    MajorService majorService

    def index() {
        List<Student> students = studentService.getStudentList()
        render(view: "/student/index", model: [
                students: students
        ])
    }

    def createStudent(){
        List<Major> majors = majorService.getMajorList()
        render(view: "/student/createStudent", model: [
                majors: majors
        ])
    }

    def saveStudent() {
        Student student = new Student(params)

        if (student.validate()){
            String password = student.password
            String salt = 'mysalt'

            MessageDigest digest = MessageDigest.getInstance("SHA-256")
            byte[] hash = digest.digest((password + salt).getBytes("UTF-8"))
            String encodedPassword = new String(hash, "UTF-8")

            Date today = new Date()
            student.password = encodedPassword
            student.createdAt = today.toTimestamp()
            student.updatedAt = today.toTimestamp()
            student.save(flush:true)

            flash.message = "Data Siswa Berhasil di simpan"
            redirect(action: "index")
        }else{
           render(view: 'createStudent', model: [student: student, majors: Major.getAll()])
        }
    }

    def updateStudent(Long id){
        Student student = studentService.getStudentById(id)
        if (student == null){
            flash.message = "Student not found"
            redirect(action: "index")
        }else {
           render(view: '/student/updateStudent', model: [
                   student: student,
                   majors: majorService.getMajorList()
           ])
       }

    }

    def storeStudent(){
        Student request = new Student(params)
        Student student = studentService.getStudentById(params.id as Long)
        if (request.validate()){


        }else{
            request.errors.allErrors.each {
                println(it)
            }
            render(view: 'updateStudent', model: [student: student, majors: majorService.getMajorList()])
        }
//        def id = params.id
//        def student = Student.findById(id)
//
//        def today = new Date()
//        def major = Major.get(params.major)
//
//        student.nim = params.nim
//        student.name = params.name
//        student.yearOfEntry = params.year_of_entry
//        student.major = major
//        student.updatedAt = today.toTimestamp()
//
//        try {
//            student.save(flush:true)
//            if (!student.save(flush:true)) {
//                student.errors.allErrors.each {error ->
//                    log.error(error.toString())
//                }
//            }
//            flash.message = "Data Siswa Berhasil di perbarui"
//            redirect(action: "index")
//        }catch (Exception e){
//            log.error("Terjadi kesalahan saat menyimpan data: " + e.message)
//            flash.message = "Terjadi kesalahan saat menyimpan data: " + e.message
//            throw new RuntimeException("Error" + e.message)
//            redirect(action: "updateStudent")
//        }
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

}
