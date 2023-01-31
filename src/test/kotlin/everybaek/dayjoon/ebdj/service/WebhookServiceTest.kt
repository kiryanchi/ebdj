package everybaek.dayjoon.ebdj.service

import everybaek.dayjoon.ebdj.domain.dto.GithubWebhookPushPayload
import everybaek.dayjoon.ebdj.domain.dto.HeadCommit
import everybaek.dayjoon.ebdj.domain.dto.Owner
import everybaek.dayjoon.ebdj.domain.dto.Repository
import jakarta.transaction.Transactional
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@Transactional
class WebhookServiceTest private constructor(
    @Autowired private val webhookService: WebhookService,
    @Autowired private val userService: UserService,
    @Autowired private val solvingService: SolvingService,
) {

    @BeforeEach
    fun beforeEach() {
        this.userService.clear()
        this.solvingService.clear()
    }

    @Test
    @DisplayName("Private Repository는 Error가 발생한다.")
    fun pushPrivateTest() {
        // given
        var payload = GithubWebhookPushPayload(
            repository = Repository(
                id = 244926449,
                isPrivate = true,
                url = "https://github.com/kiryanchi/AlgoStudy",
                owner = Owner.fixture(),
            ),
            headCommit = HeadCommit.fixture(),
        )

        // when
        // then
        val exception = assertThrows<IllegalArgumentException> {
            this.webhookService.push(payload)
        }

        Assertions.assertEquals(exception.message, "Repository must be public")


    }
}