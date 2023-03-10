package siakad

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Transactional
@Service
class StudentService {

    def saveStudent(Student student) {
        try {
            student.save(flush:true)
        }catch (Exception e){
            log.error("Terjadi kesalahan saat menyimpan data: " + e.message)
            throw new RuntimeException("Terjadi kesalahan saat menyimpan data:" + e)
        }
    }
    //
    def findStudent(Long id) {
        try {
            return Student.findById(id)
        }catch (Exception e){
            log.error("Terjadi kesalahan saat mencari data: " + e.message)
            throw new RuntimeException("Terjadi kesalahan saat mencari data:" + e)
        }
    }

    def getAllStudent(){
        try {
            return Student.list()
        }catch (Exception e){
            log.error("Terjadi kesalahan saat mencari data: " + e.message)
            throw new RuntimeException("Terjadi kesalahan saat mencari data:" + e)
        }
    }

    def deleteStudent(Student student){
        try {
            if (student == null){
                throw new IllegalArgumentException("Student tidak boleh null")
            }
            student.delete(flush: true)
        }catch (Exception e){
            log.error("Terjadi kesalahan saat menghapus data: " + e.message)
            throw new RuntimeException("Terjadi kesalahan saat menghapus data:" + e)
        }
    }

    def updateStudent(Student student){
        try {
            if (student == null){
                throw new IllegalArgumentException("Student tidak boleh null")
            }
            student.save(flush: true)
        }catch (Exception e){
            log.error("Terjadi kesalahan saat memperbarui data: " + e.message)
            throw new RuntimeException("Terjadi kesalahan saat memperbarui data:" + e)
        }
    }
}
