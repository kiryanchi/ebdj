package everybaek.dayjoon.ebdj.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne

@Entity
class Repository(
    @Id
    val id: Long,

    @OneToOne(cascade = [CascadeType.ALL])
    val user: User,


    ) {
}