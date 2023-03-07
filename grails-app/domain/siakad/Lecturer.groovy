package siakad

import java.time.LocalDateTime

class Lecturer {
    Integer nip
    String name
    LocalDateTime createdAt
    LocalDateTime updatedAt

    static constraints = {
        nip nullable: false
        name nullable: false
    }

    static mapping = {
        table 'lecturer'
        version false
        id column: 'lecturer_id'
        nip column: 'nip'
        name column: 'name'
        createdAt column: 'created_at'
        updatedAt column: 'updated_at'
    }
}
