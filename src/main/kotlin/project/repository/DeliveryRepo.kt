package db.project.ghorbanian.repository

import db.project.ghorbanian.models.Delivery
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface DeliveryRepo : JpaRepository<Delivery , Long>{
    @Query(value = "SELECT * FROM Delivery ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    fun findDelivery():Delivery
}
