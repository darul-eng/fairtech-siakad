package siakad

import java.time.LocalDateTime

class Faculty {
    String name
    String code
    LocalDateTime createdAt
    LocalDateTime updatedAt
//    static hasMany = [major: Major]

    static constraints = {
        name blank: false
        code unique: true
    }

    static mapping = {
        table 'faculty'
        version false
        id column: 'faculty_id'
        name column: 'name'
        code column: 'code'
        createdAt column: 'created_at'
        updatedAt column: 'updated_at'
//        major joinTable: [name: 'faculty_major', key: 'faculty_id', column: 'major_id']
    }
}
