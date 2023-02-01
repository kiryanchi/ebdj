package everybaek.dayjoon.ebdj.service

import everybaek.dayjoon.ebdj.domain.dto.request.UserCreateRequest
import everybaek.dayjoon.ebdj.domain.entity.User
import everybaek.dayjoon.ebdj.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository,
) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun createUser(request: UserCreateRequest): User {
        log.debug("${this::createUser::name} 메소드 호출")

        val user = User.fromRequest(request)
        log.debug("user: $user")

        return userRepository.save(user)
    }

    @Transactional(readOnly = true)
    fun readUserById(id: Long): User? {
        log.debug("${this::readUserById::name} 메소드 호출")

        return userRepository.findByIdOrNull(id)
    }

    @Transactional(readOnly = true)
    fun readAllUsers(): List<User> {
        log.debug("${this::readAllUsers::name} 메소드 호출")

        return userRepository.findAll()
    }

    fun updateUser() {

    }

    fun deleteUser() {

    }

    fun clear() {
        log.debug("${this::clear::name} 메소드 호출")

        userRepository.deleteAll()
    }
}