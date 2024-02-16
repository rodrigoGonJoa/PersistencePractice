package android.template.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "director")
data class Director(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "dir_id")
    val id: Int,
    @ColumnInfo(name = "dir_fname")
    val firstName: String,
    @ColumnInfo(name = "dir_lname")
    val lastName: String
)

data class DirectorWithMovies(
    @Embedded val director: Director,
    @Relation(
        entity = Movie::class,
        parentColumn = "dir_id",
        entityColumn = "mov_id"
    )
    val movie: List<Movie>
)