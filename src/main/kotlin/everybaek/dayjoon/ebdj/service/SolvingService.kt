package everybaek.dayjoon.ebdj.service

import everybaek.dayjoon.ebdj.dto.GithubWebhookPushPayload
import everybaek.dayjoon.ebdj.entity.Solving
import everybaek.dayjoon.ebdj.entity.User
import everybaek.dayjoon.ebdj.repository.SolvingRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class SolvingService(
    val solvingRepository: SolvingRepository,
) {

    fun saveSolve(user: User, payload: GithubWebhookPushPayload) {
        val solving = Solving(
            user = user,
            date = LocalDate.now(),
            difficulty = payload.headCommit.difficulty,
            title = payload.headCommit.title,
            url = payload.headCommit.url,
        )

        this.solvingRepository.save(solving)
    }

    @Transactional(readOnly = true)
    fun getSolveByUserAndDate(user: User, date: LocalDate): List<Solving>? {
        return this.solvingRepository.findAllByUserAndDate(user, date)
    }

    fun clear() {
        this.solvingRepository.deleteAll()
    }
}
