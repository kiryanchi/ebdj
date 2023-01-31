package everybaek.dayjoon.ebdj.service

import everybaek.dayjoon.ebdj.domain.dto.GithubWebhookPushPayload
import everybaek.dayjoon.ebdj.domain.dto.request.UserCreateRequest
import everybaek.dayjoon.ebdj.repository.SolvingRepository
import jakarta.transaction.Transactional
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
@Transactional
class SolvingServiceTest private constructor(
    @Autowired private val solvingService: SolvingService,
    @Autowired private val solvingRepository: SolvingRepository,
    @Autowired private val userService: UserService,
) {

    @Test
    @DisplayName("문제를 저장한다.")
    fun saveSolveTest() {
        // given
        val user = this.userService.createUser(UserCreateRequest.fromPayload(GithubWebhookPushPayload.fixture()))

        // when
        this.solvingService.saveSolve(user, GithubWebhookPushPayload.fixture())

        // then
        val solves = this.solvingRepository.findAll()

        assertEquals(solves.size, 1)
    }

    @Test
    @DisplayName("오늘 저장한 문제를 확인한다.")
    fun getSolveByUserAndDateTest() {
        // given
        val user = this.userService.createUser(UserCreateRequest.fromPayload(GithubWebhookPushPayload.fixture()))
        this.solvingService.saveSolve(user, GithubWebhookPushPayload.fixture())

        // when
        val solves = this.solvingService.getSolveByUserAndDate(user, LocalDate.now())
        val solve = solves?.get(0)

        // then
        assertEquals(solves?.size, 1)

        assertEquals(solve!!.user, user)
        assertEquals(solve!!.date, LocalDate.now())
        assertEquals(solve!!.difficulty, "[Bronze V]")
        assertEquals(solve!!.title, "A+B")
        assertEquals(
            solve!!.url,
            "https://github.com/kiryanchi/AlgoStudy/commit/5a96b22cae7fde99008b5fd28eb5f767343eeebc"
        )
    }
}