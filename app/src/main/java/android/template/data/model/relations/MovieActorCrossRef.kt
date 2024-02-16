package android.template.data.model.relations

import android.template.data.model.Actor
import android.template.data.model.Movie
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Junction
import androidx.room.Relation
@Entity(
    tableName = "movie_actor",
    foreignKeys = [
        ForeignKey(entity = Actor::class, parentColumns = ["act_id"], childColumns = ["act_id"]),
        ForeignKey(entity = Movie::class, parentColumns = ["mov_id"], childColumns = ["mov_id"])
    ]
)
data class MovieActorCrossRef(
    @ColumnInfo("mov_id")
    val movieId: Int,
    @ColumnInfo("act_id")
    val actorId: Int,
    @ColumnInfo(name = "role")
    val role: String
)

data class MovieWithActors(
    @Embedded val movie: Movie,
    @Relation(
        entity = Actor::class,
        parentColumn = "mov_id",
        entityColumn = "actor_id",
        associateBy = Junction(MovieActorCrossRef::class)
    )
    val actors: List<Actor>
)

data class ActorWithMovies(
    @Embedded val actor: Actor,
    @Relation(
        entity = Movie::class,
        parentColumn = "actor_id",
        entityColumn = "mov_id",
        associateBy = Junction(MovieActorCrossRef::class)
    )
    val movies: List<Movie>
)