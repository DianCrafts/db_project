package db.project.ghorbanian.repository

import db.project.ghorbanian.models.FoodReservation
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate

interface FoodReservationRepo : JpaRepository<FoodReservation, Long>{
    fun findAllByDate(date : LocalDate) :List<FoodReservation>
}
