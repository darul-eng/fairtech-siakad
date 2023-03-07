package siakad

import java.time.LocalDateTime

class Lecturer {
    Integer nip
    String name
    String password
    LocalDateTime createdAt
    LocalDateTime updatedAt

    static constraints = {
        nip nullable: false
        nip unique: true
        password nullable: false
        name nullable: false
    }

    static mapping = {
        table 'lecturer'
        version false
        id column: 'lecturer_id'
        nip column: 'nip'
        name column: 'name'
        password column: 'password'
        createdAt column: 'created_at'
        updatedAt column: 'updated_at'
    }

    static Object findByNipAndPassword(LinkedHashMap<String, Object> stringObjectLinkedHashMap) {
        null
    }
}
