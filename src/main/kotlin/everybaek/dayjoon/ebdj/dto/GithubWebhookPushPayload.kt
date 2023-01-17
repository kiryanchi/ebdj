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

data class HeadCommit(
    @JsonProperty("message")
    val message: String,

    @JsonProperty("url")
    val url: String,
) {

    fun parseMessage() {
//            val difficulty: String = this.message.split(" ")
    }

    companion object {
        fun fixture(): HeadCommit {
            return HeadCommit(
                message = "[Bronze V] Title: A+B, Time: 0 ms, Memory: 2020 KB -BaekjoonHub",
                url = "https://github.com/kiryanchi/AlgoStudy/commit/5a96b22cae7fde99008b5fd28eb5f767343eeebc",
            )
        }
    }
}

data class Owner(
    @JsonProperty("id")
    val id: Long,

    @JsonProperty("name")
    val name: String,
) {

    companion object {
        fun fixture(): Owner {
            return Owner(
                id = 1,
                name = "kiryanchi",
            )
        }
    }
}

data class Repository(
    @JsonProperty("id")
    val id: Long,

    @JsonProperty("private")
    val isPrivate: Boolean,

    @JsonProperty("url")
    val url: String,

    @JsonProperty("owner")
    val owner: Owner,
) {
    companion object {
        fun fixture(): Repository {
            return Repository(
                id = 1,
                isPrivate = false,
                url = "https://github.com/kiryanchi/AlgoStudy",
                owner = Owner.fixture(),
            )
        }
    }
}

