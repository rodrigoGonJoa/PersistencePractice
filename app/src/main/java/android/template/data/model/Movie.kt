package android.template.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "mov_id", index = true)
    val id: Int,
    @ColumnInfo(name = "mov_title")
    val title: String,
    @ColumnInfo(name = "mov_year")
    val year: Int,
    @ColumnInfo(name = "mov_time")
    val time: Int,
    @ColumnInfo(name = "mov_lang")
    val language: String,
    @ColumnInfo(name = "mov_dt_rel")
    val releaseDate: Date,
    @ColumnInfo(name = "mov_rel_country")
    val releaseCountry: String
)