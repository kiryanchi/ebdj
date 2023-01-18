package everybaek.dayjoon.ebdj.service

import everybaek.dayjoon.ebdj.dto.request.UserCreateRequest
import everybaek.dayjoon.ebdj.entity.User
import everybaek.dayjoon.ebdj.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository,
) {

    fun createUser(request: UserCreateRequest): User {
        val user = User.fromRequest(request)
        this.userRepository.save(user)
        return user
    }

    @Transactional(readOnly = true)
    fun readUserById(id: Long): User? {
        return userRepository.findByIdOrNull(id)
    }

    fun readAllUsers(): MutableList<User> {
        return userRepository.findAll()
    }

    fun updateUser() {

    }

    fun deleteUser() {

    }

    fun clear() {
        userRepository.deleteAll()
    }
}