package db.project.ghorbanian.repository

import db.project.ghorbanian.models.RawMaterial
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RawMaterialRepo : JpaRepository<RawMaterial , Long>{
    fun findAllByIsAvailableAndStoreDbIdAndStoreIsActive(isAvailable : Boolean , id:Long , isActive : Boolean):List<RawMaterial>
}
