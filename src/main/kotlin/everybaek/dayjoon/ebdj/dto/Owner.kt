package everybaek.dayjoon.ebdj.dto

import com.fasterxml.jackson.annotation.JsonProperty

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