package db.project.ghorbanian.models

import org.springframework.lang.NonNull
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table


@Entity
@Table(name = "delivery")
class Delivery (
        @NonNull
        val firstName :String,
        @NonNull
        val lastName : String,
        val nationalNumber : Long = 0,
        val phoneNumber : Long = 0
): BaseEntity()