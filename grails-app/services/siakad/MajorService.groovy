package siakad

import grails.gorm.transactions.Transactional

@Transactional
class MajorService {

    List<Major> getMajorList() {
        List<Major> majors = Major.findAll()
        return majors
    }
}
