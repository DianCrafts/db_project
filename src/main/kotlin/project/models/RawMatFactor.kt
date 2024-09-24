package db.project.ghorbanian.models


import org.springframework.lang.NonNull
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "raw_material_factor")
class RawMatFactor (

        @ManyToMany(cascade= [CascadeType.ALL])//, inverseJoinColumns=@JoinColumn(name="author_id")
        @JoinTable(name="raw_materials_relation", joinColumns= [JoinColumn(name = "raw_material_db_id")])
        val rawMaterials: MutableList<RawMaterial> = mutableListOf(),
        val date : LocalDateTime

): BaseEntity()