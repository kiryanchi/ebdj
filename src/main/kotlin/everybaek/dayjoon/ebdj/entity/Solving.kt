package everybaek.dayjoon.ebdj.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Solving(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(targetEntity = User::class, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id")
    val user: User,

    val date: LocalDate,

    val difficulty: String,

    val title: String,

    val url: String,
)