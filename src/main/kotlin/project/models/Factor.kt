package db.project.ghorbanian.models

import org.springframework.lang.NonNull
import javax.persistence.Entity
import javax.persistence.Table


@Entity
@Table(name = "factor")
class Factor (
        val name :String = "",
        val address :String = "",
        @NonNull
        val foodNAme :String ,
        @NonNull
        val price :Long

): BaseEntity()