package db.project.ghorbanian.models


import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.lang.NonNull
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table


@Entity
@Table(name = "raw_material")
class RawMaterial (
        @NonNull
        val name :String,
        @NonNull
        var price :Long,
        @ManyToOne
        val store: Store,
        var number: Int = 0,
        @JsonIgnore
        var isAvailable :Boolean = true,
        @JsonIgnore
        var hasBeenSold : Boolean = false

): BaseEntity(){
        open fun updateValues(rawMaterial: RawMaterial) {
                this.price = rawMaterial.price
        }
}