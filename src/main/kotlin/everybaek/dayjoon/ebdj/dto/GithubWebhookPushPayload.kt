package everybaek.dayjoon.ebdj.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class GithubWebhookPushPayload(
    @JsonProperty("repository")
    val repository: Repository,

    @JsonProperty("head_commit")
    val headCommit: HeadCommit,
) {

    companion object {
        fun fixture(): GithubWebhookPushPayload {
            return GithubWebhookPushPayload(
                repository = Repository.fixture(),
                headCommit = HeadCommit.fixture(),
            )
        }
    }
}