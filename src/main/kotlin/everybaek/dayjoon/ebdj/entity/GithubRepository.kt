package everybaek.dayjoon.ebdj.entity

import jakarta.persistence.*

@Entity
class GithubRepository(
    @Id
    val id: Long,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "UserId")
    val user: User,
) {
}