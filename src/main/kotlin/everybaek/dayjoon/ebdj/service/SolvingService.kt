package everybaek.dayjoon.ebdj.service

import everybaek.dayjoon.ebdj.domain.dto.GithubWebhookPushPayload
import everybaek.dayjoon.ebdj.domain.entity.Solving
import everybaek.dayjoon.ebdj.domain.entity.User
import everybaek.dayjoon.ebdj.domain.vo.UserSolving
import everybaek.dayjoon.ebdj.repository.SolvingRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
@Transactional
class SolvingService(
    val solvingRepository: SolvingRepository,
) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun saveSolve(user: User, payload: GithubWebhookPushPayload): Solving {
        log.debug("${this::saveSolve::name} 메소드 호출")

        val solving = Solving.fromPayload(user, payload)

        log.debug("solving: $solving")

        return this.solvingRepository.save(solving)
    }

    @Transactional(readOnly = true)
    fun getSolveByUserAndDate(user: User, date: LocalDate): List<Solving>? {
        log.debug("${this::getSolveByUserAndDate::name} 메소드 호출")
        return this.solvingRepository.findAllByUserAndDate(user, date)
    }

    fun clear() {
        log.debug("${this::clear::name} 메소드 호출")
        this.solvingRepository.deleteAll()
    }

    @Transactional(readOnly = true)
    fun getAllSolvingsByDate(date: LocalDate): List<Solving> {
        log.debug("${this::getAllSolvingsByDate::name} 메소드 호출")
        return this.solvingRepository.findAllByDate(date)
    }

    @Transactional(readOnly = true)
    fun getAllSolvings(): List<Solving> {
        log.debug("${this::getAllSolvings::name} 메소드 호출")
        return solvingRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun getAllSolvingsWithUserByDate(date: LocalDate): List<UserSolving> {
        log.debug("${this::getAllSolvingsWithUserByDate::name} 메소드 호출")
        return solvingRepository.getAllSolvingsWithUserByDate(date)
    }
}
