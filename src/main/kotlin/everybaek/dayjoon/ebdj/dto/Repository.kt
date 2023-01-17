package everybaek.dayjoon.ebdj.dto

import com.fasterxml.jackson.annotation.JsonProperty


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

