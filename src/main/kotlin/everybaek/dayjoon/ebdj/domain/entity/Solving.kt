package everybaek.dayjoon.ebdj.domain.entity

import everybaek.dayjoon.ebdj.domain.dto.GithubWebhookPushPayload
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
) {
    companion object {
        fun fromPayload(user: User, payload: GithubWebhookPushPayload): Solving {
            return Solving(
                user = user,
                date = LocalDate.now(),
                difficulty = payload.headCommit.difficulty,
                title = payload.headCommit.title,
                url = payload.headCommit.url,
            )
        }
    }
}