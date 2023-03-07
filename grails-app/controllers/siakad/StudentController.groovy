package siakad

import grails.gorm.transactions.Transactional

@Transactional
class StudentController {
    def studentService

    def index() {
        def data = [
                "name": "Darul Ikhsan"
        ]
        render(view: "/student/index", model: data)
    }
    def save() {
        def student = new Student(params)
        try {
            studentService.saveStudent(student)
            flash.message = "Data Siswa Berhasil di simpan"
            redirect(action: "list")
        }catch (Exception e){
            log.error("Terjadi kesalahan saat menyimpan data: " + e.message)
            flash.message = "Terjadi kesalahan saat menyimpan data: " + e.message
            redirect(action: "create")
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
