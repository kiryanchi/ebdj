package everybaek.dayjoon.ebdj.controller

import everybaek.dayjoon.ebdj.domain.entity.Solving
import everybaek.dayjoon.ebdj.domain.vo.UserSolving
import everybaek.dayjoon.ebdj.service.SolvingService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@CrossOrigin(originPatterns = ["*"])
@RestController
class SolvingController(
    val solvingService: SolvingService,
) {

    @GetMapping("/api/solving")
    fun getAllSolvingByDate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") date: LocalDate): List<Solving> {
        return solvingService.getAllSolvingsByDate(date)

    }

    @GetMapping("/api/solvings")
    fun getAllSolving(): List<Solving> {
        return solvingService.getAllSolvings()
    }

    @GetMapping("/api/solving/check")
    fun isSolveProblem(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") date: LocalDate): List<UserSolving> {
        return solvingService.getAllSolvingsWithUserByDate(date)
    }
}