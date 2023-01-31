package everybaek.dayjoon.ebdj.domain.dto

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

    val difficulty: String
        get() = let {
            it.message
                .split("Time")[0]
                .split("Title")[0]
                .trim()
        }

    val title: String
        get() = let {
            it.message
                .split("Time")[0]
                .split("Title")[1]
                .substring(2)
                .trim()
                .let { trimmed ->
                    trimmed.substring(0, trimmed.length - 1)
                }
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
                id = 50714602,
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
                id = 244926449,
                isPrivate = false,
                url = "https://github.com/kiryanchi/AlgoStudy",
                owner = Owner.fixture(),
            )
        }
    }
}

