package everybaek.dayjoon.ebdj.domain.dto.request

import everybaek.dayjoon.ebdj.domain.dto.GithubWebhookPushPayload

class UserCreateRequest(
    val id: Long,
    val githubName: String,
    val name: String,
) {
    companion object {
        fun fromPayload(payload: GithubWebhookPushPayload): UserCreateRequest {
            return UserCreateRequest(
                id = payload.repository.owner.id,
                githubName = payload.repository.owner.name,
                name = payload.repository.owner.name,
            )
        }
    }
}