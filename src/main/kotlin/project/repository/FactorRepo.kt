package db.project.ghorbanian.repository

import db.project.ghorbanian.models.Factor
import org.springframework.data.jpa.repository.JpaRepository

interface FactorRepo : JpaRepository<Factor , Long>
