package db.project.ghorbanian.models


import org.springframework.lang.NonNull
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table



@Entity
@Table(name = "address")
class Address (
        @NonNull
        val name :String,
        val address :String ,
        @NonNull
        val phoneNumber :Long,
        @ManyToOne
        val customer: Customer

): BaseEntity()