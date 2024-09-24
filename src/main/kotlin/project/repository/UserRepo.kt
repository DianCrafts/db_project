package db.project.ghorbanian.repository

import db.project.ghorbanian.models.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo : JpaRepository<Customer, Long>
