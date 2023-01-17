package everybaek.dayjoon.ebdj

import everybaek.dayjoon.ebdj.dto.GithubWebhookPushPayload
import org.springframework.stereotype.Service

@Service
class WebhookService {

    fun push(payload: GithubWebhookPushPayload) {
        val repository = payload.repository
        val headCommit = payload.headCommit

        ifPrivateRepositoryThrowException(repository.isPrivate)

        
    }

    private fun ifPrivateRepositoryThrowException(isPrivate: Boolean) {
        // TODO("RepositoryPrivateException")
        if (isPrivate)
            IllegalArgumentException("Repository must be public")
    }
}
