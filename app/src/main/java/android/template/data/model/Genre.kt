package android.template.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genres")
data class Genre(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "gen_id", index = true)
    val id: Int,
    @ColumnInfo(name = "gen_title")
    val title: String
)