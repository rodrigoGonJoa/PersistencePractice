package android.template.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "actor")
data class Actor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "act_id", index = true)
    val id: Int,
    @ColumnInfo(name = "act_fname")
    val firstName: String,
    @ColumnInfo(name = "act_lname")
    val lastName: String,
    @ColumnInfo(name = "act_gender")
    val gender: Char
)