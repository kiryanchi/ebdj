package everybaek.dayjoon.ebdj.repository

import everybaek.dayjoon.ebdj.entity.Solving
import everybaek.dayjoon.ebdj.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate

interface SolvingRepository : JpaRepository<Solving, Long> {

    fun findAllByUserAndDate(user: User, date: LocalDate): List<Solving>?
}