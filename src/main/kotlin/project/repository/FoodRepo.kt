package db.project.ghorbanian.repository

import db.project.ghorbanian.models.Food
import org.springframework.data.jpa.repository.JpaRepository

interface FoodRepo : JpaRepository<Food, Long>
