package everybaek.dayjoon.ebdj.repository

import everybaek.dayjoon.ebdj.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

}
