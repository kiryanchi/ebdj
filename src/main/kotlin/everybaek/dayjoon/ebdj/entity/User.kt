package everybaek.dayjoon.ebdj.entity

import everybaek.dayjoon.ebdj.dto.request.UserCreateRequest
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class User(
    @Id
    val id: Long,

    val githubName: String,

    val name: String,
) {

    override fun toString(): String {
        return "User(id=${id}, githubName=${githubName}, name=${name})"
    }

    companion object {
        fun fromRequest(request: UserCreateRequest): User {
            return User(
                id = request.id,
                githubName = request.githubName,
                name = request.name,
            )
        }
    }
}