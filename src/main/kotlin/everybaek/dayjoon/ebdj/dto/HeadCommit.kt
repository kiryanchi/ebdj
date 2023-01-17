package everybaek.dayjoon.ebdj.dto

import com.fasterxml.jackson.annotation.JsonProperty


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
