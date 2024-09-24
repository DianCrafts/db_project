package db.project.ghorbanian.repository


import db.project.ghorbanian.models.Store
import org.springframework.data.jpa.repository.JpaRepository

interface StoreRepo : JpaRepository<Store, Long>{
    fun findAllByIsActive(isActive : Boolean):List<Store>
}
