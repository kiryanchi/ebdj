package everybaek.dayjoon.ebdj.domain.dto.response

import everybaek.dayjoon.ebdj.domain.entity.Solving

data class UserSolvingResponse(
    val name: String,
    val solving: List<Solving>,
)
