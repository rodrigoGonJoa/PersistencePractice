package android.template.data.model.relations

import android.template.data.model.Genre
import android.template.data.model.Movie
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Junction
import androidx.room.Relation


@Entity(
    tableName = "movie_genre",
    foreignKeys = [
        ForeignKey(entity = Genre::class, parentColumns = ["gen_id"], childColumns = ["gen_id"]),
        ForeignKey(entity = Movie::class, parentColumns = ["mov_id"], childColumns = ["mov_id"])
    ]
)
data class MovieGenreCrossRef(
    @ColumnInfo("mov_id")
    val movieId: Int,
    @ColumnInfo("gen_id")
    val genreId: Int
)

data class MovieWithGenres(
    @Embedded val movie: Movie,
    @Relation(
        entity = Genre::class,
        parentColumn = "mov_id",
        entityColumn = "gen_id",
        associateBy = Junction(MovieGenreCrossRef::class)
    )
    val genres: List<Genre>
)

data class GenreWithMovies(
    @Embedded val genre: Genre,
    @Relation(
        entity = Movie::class,
        parentColumn = "gen_id",
        entityColumn = "mov_id",
        associateBy = Junction(MovieGenreCrossRef::class)
    )
    val movies: List<Movie>
)