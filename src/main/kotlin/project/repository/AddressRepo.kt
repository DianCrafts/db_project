package db.project.ghorbanian.repository

import db.project.ghorbanian.models.Address
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepo : JpaRepository<Address , Long>
