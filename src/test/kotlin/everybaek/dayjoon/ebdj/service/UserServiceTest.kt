package everybaek.dayjoon.ebdj.service

import everybaek.dayjoon.ebdj.dto.request.UserCreateRequest
import jakarta.transaction.Transactional
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@Transactional
class UserServiceTest private constructor(

    @Autowired private val userService: UserService,
) {

    @BeforeEach
    fun beforeEach() {
        this.userService.clear()
    }

    @Test
    @DisplayName("존재하지 않는 user id 조회는 실패한다.")
    fun readUserByIdTest() {
        // given

        // when
        val user = this.userService.readUserById(1)

        // then
        assertNull(user)
    }

    @Test
    @DisplayName("User 조회에 성공한다.")
    fun readUserByIdTest2() {
        // given
        val request = UserCreateRequest(
            id = 1,
            githubName = "kiryanchi",
            name = "박기현",
        )
        this.userService.createUser(request)

        // when
        val user = this.userService.readUserById(1)
        val users = this.userService.readAllUsers()

        // then

        assertEquals(user!!.id, 1)
        assertEquals(users.size, 1)
    }

    @Test
    @DisplayName("User 2명을 추가하면 size가 2여야한다.")
    fun readAllUsersTest() {
        // given
        val request = UserCreateRequest(
            id = 1,
            githubName = "hong",
            name = "gildong",
        )

        val request2 = UserCreateRequest(
            id = 2,
            githubName = "kim",
            name = "cheolsoo",
        )

        this.userService.createUser(request)
        this.userService.createUser(request2)

        // when
        val users = this.userService.readAllUsers()

        // then
        assertEquals(users.size, 2)
    }
}