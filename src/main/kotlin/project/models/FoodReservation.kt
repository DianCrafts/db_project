package db.project.ghorbanian.models

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.lang.Nullable
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "food_reservation")
data class FoodReservation(
        @ManyToMany(cascade= [CascadeType.ALL] , fetch = FetchType.EAGER)//, inverseJoinColumns=@JoinColumn(name="author_id")
        @JoinTable(name="reservations_relation", joinColumns= [JoinColumn(name = "reservation_db_id")])
        val reservations: MutableList<Food>,



        val address: Address?= null,

        @ManyToOne
        @Nullable
        val customer: Customer? = null,
      //  @Nullable



        val date:LocalDateTime,





        @JsonIgnore
        @Nullable
        var delivery: Delivery ?= null
) : BaseEntity()