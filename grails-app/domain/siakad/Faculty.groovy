package siakad

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.time.LocalDateTime

class Faculty {
    String name
    String code
    Date createdAt
    Date updatedAt
    static hasMany = [major: Major]

    static constraints = {
        name blank: false
        code unique: true, nullable: false
    }
}
