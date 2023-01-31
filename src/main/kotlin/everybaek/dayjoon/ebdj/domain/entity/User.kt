package everybaek.dayjoon.ebdj.domain.entity

import everybaek.dayjoon.ebdj.domain.dto.request.UserCreateRequest
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
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