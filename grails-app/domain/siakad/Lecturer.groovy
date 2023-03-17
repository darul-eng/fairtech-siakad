package siakad

import java.time.LocalDateTime

class Lecturer {
    Integer nip
    String name
    String password
    Date createdAt
    Date updatedAt

    static constraints = {
        nip blank: false, unique: true
        password nullable: false
        name nullable: false
    }
}
