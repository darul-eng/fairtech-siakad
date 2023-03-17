package siakad

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.time.LocalDateTime

class Major {
    String name
    String code
    Date createdAt
    Date updatedAt
    static hasMany = [students: Student]
    Faculty faculty

    static constraints = {
        name blank: false
        code unique: true, blank: false
    }
}
