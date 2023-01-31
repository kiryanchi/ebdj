package everybaek.dayjoon.ebdj.service

import everybaek.dayjoon.ebdj.domain.dto.GithubWebhookPushPayload
import everybaek.dayjoon.ebdj.domain.dto.request.UserCreateRequest
import everybaek.dayjoon.ebdj.domain.entity.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class WebhookService(
    private val userService: UserService,
    private val solvingService: SolvingService,
) {

    fun push(payload: GithubWebhookPushPayload) {
        ifPrivateRepositoryThrowException(payload.repository.isPrivate)

        val user = findUserIfNullCreate(payload)

        this.solvingService.saveSolve(user, payload)
    }

    private fun ifPrivateRepositoryThrowException(isPrivate: Boolean) {
        // TODO("RepositoryPrivateException")
        if (isPrivate)
            throw IllegalArgumentException("Repository must be public")
        println("public 입니다")
    }

    private fun findUserIfNullCreate(payload: GithubWebhookPushPayload): User {
        return this.userService.readUserById(payload.repository.owner.id)
            ?.let { user ->
                user
            }
            ?: let {
                println("${payload.repository.owner.name} 유저가 존재하지 않습니다.")
                this.userService.createUser(UserCreateRequest.fromPayload(payload))
            }
    }
}
