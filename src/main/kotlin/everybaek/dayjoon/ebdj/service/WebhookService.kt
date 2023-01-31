package everybaek.dayjoon.ebdj.service

import everybaek.dayjoon.ebdj.domain.dto.GithubWebhookPushPayload
import everybaek.dayjoon.ebdj.domain.dto.request.UserCreateRequest
import everybaek.dayjoon.ebdj.domain.entity.User
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class WebhookService(
    private val userService: UserService,
    private val solvingService: SolvingService,
) {

    private val log = LoggerFactory.getLogger(javaClass)

    fun push(payload: GithubWebhookPushPayload) {
        ifPrivateRepositoryThrowException(payload.repository.isPrivate)

        val user = findUserIfNullCreate(payload)
        log.debug("user: $user")

        this.solvingService.saveSolve(user, payload)
    }

    private fun ifPrivateRepositoryThrowException(isPrivate: Boolean) {
        val repositoryStatus = when (isPrivate) {
            true -> "Private"
            false -> "Public"
        }
        log.debug("레포지토리가 $repositoryStatus 입니다.")

        if (isPrivate)
            throw IllegalArgumentException("레포지토리가 Private 입니다.")
    }

    private fun findUserIfNullCreate(payload: GithubWebhookPushPayload): User {
        return this.userService.readUserById(payload.repository.owner.id)
            ?.let { user ->
                log.debug("${payload.repository.owner.name} 유저가 존재합니다.")
                user
            }
            ?: let {
                log.debug("${payload.repository.owner.name} 유저가 존재하지 않습니다.")
                val user = this.userService.createUser(UserCreateRequest.fromPayload(payload))
                user
            }
    }
}
