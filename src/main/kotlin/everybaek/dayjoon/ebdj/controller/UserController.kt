package everybaek.dayjoon.ebdj.controller

import everybaek.dayjoon.ebdj.domain.entity.User
import everybaek.dayjoon.ebdj.service.UserService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(originPatterns = ["*"])
@RestController
class UserController(
    val userService: UserService,
) {

    @GetMapping("/api/users")
    fun getAllUsers(): List<User> {
        return userService.readAllUsers()
    }
}