package db.project.ghorbanian.models

import javax.persistence.*


@Entity
@Table(name = "customer")
class Customer (
        val firstName :String = "",
        val lastName : String = "",
        val nationalNumber : Long = 0,
        val phoneNumber : Long = 0
//        @OneToMany(fetch = FetchType.EAGER ,cascade = [CascadeType.MERGE])
//        val addresses: MutableList<Address> = mutableListOf()
): BaseEntity()