package android.template.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reviewer")
data class Reviewer(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "rev_id", index = true)
    val id: Int,
    @ColumnInfo(name = "rev_name")
    val name: String
)