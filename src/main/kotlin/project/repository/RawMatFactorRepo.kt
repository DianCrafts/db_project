package db.project.ghorbanian.repository

import db.project.ghorbanian.models.RawMatFactor
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate

interface RawMatFactorRepo : JpaRepository<RawMatFactor , Long>{
    fun findAllByDate(date : LocalDate):List<RawMatFactor>
}
