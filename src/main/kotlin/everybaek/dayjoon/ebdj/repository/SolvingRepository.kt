package everybaek.dayjoon.ebdj.repository

import everybaek.dayjoon.ebdj.domain.entity.Solving
import everybaek.dayjoon.ebdj.domain.entity.User
import everybaek.dayjoon.ebdj.domain.vo.UserSolving
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDate
import java.util.*

interface SolvingRepository : JpaRepository<Solving, Long> {

    fun findAllByUserAndDate(user: User, date: LocalDate): List<Solving>

    fun findAllByDate(date: LocalDate): List<Solving>

    @Query(
        "SELECT " +
                "NEW everybaek.dayjoon.ebdj.domain.vo.UserSolving(u.name, s) " +
                "FROM User u LEFT JOIN Solving s ON u.id = s.user.id AND s.date =:date"
    )
    fun getAllSolvingWithUser(@Param("date") date: LocalDate): List<UserSolving>
}