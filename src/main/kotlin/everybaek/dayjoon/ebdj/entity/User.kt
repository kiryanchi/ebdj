package everybaek.dayjoon.ebdj.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class User(
    @Id
    val id: Long,

    val githubName: String,

    val name: String,
)