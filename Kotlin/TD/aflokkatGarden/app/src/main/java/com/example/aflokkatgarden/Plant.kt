package com.example.aflokkatgarden

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "garden_table")
data class Plant(
    @PrimaryKey
    @ColumnInfo(name = "plantId") val plantId: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "growZoneNumber") val growZoneNumber: Int,
    @ColumnInfo(name = "wateringInterval") val wateringInterval: Int,
    @ColumnInfo(name = "imageUrl") val imageUrl: String,
 ) : Serializable
