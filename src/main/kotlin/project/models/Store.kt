package db.project.ghorbanian.models

import org.springframework.lang.NonNull
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.Table


@Entity
@Table(name = "store")
class Store (
        @NonNull
        val storeName :String,
        var isActive : Boolean = true
//        @OneToMany(fetch = FetchType.EAGER)
//        val rawMaterials: MutableList<RawMaterial> = mutableListOf()

): BaseEntity(){
        open fun updateValues(store: Store) {
                this.isActive = store.isActive
        }
}