package db.project.ghorbanian.models

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "food")
data class Food(
        var food: String = "",              //food Type
        var price: Long = 0,
        var number: Int = 0,
        @JsonIgnore
        var isAvailable :Boolean = true,
        @JsonIgnore
        var hasBeenSold : Boolean = false
) : BaseEntity() {

    open fun updateValues(food: Food) {
        this.food = food.food
        this.price = food.price
    }
}