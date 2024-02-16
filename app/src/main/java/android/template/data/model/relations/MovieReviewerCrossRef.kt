package android.template.data.model.relations

import android.template.data.model.Movie
import android.template.data.model.Reviewer
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Junction
import androidx.room.Relation

@Entity(
    tableName = "rating",
    foreignKeys = [
        ForeignKey(entity = Reviewer::class, parentColumns = ["rev_id"], childColumns = ["rev_id"]),
        ForeignKey(entity = Movie::class, parentColumns = ["mov_id"], childColumns = ["mov_id"])
    ]
)
data class MovieReviewerCrossRef(
    @ColumnInfo("mov_id")
    val movieId: Int,
    @ColumnInfo("rev_id")
    val reviewerId: Int,
    @ColumnInfo(name = "rev_stars")
    val rate: Int,
    @ColumnInfo(name = "num_o_ratings")
    val numRatings: Int
)


data class MovieWithReviewers(
    @Embedded val movie: Movie,
    @Relation(
        entity = Reviewer::class,
        parentColumn = "mov_id",
        entityColumn = "rev_id",
        associateBy = Junction(MovieReviewerCrossRef::class)
    )
    val reviewers: List<Reviewer>
)

data class ReviewerWithMovies(
    @Embedded val reviewer: Reviewer,
    @Relation(
        entity = Movie::class,
        parentColumn = "rev_id",
        entityColumn = "mov_id",
        associateBy = Junction(MovieReviewerCrossRef::class)
    )
    val movies: List<Movie>
)