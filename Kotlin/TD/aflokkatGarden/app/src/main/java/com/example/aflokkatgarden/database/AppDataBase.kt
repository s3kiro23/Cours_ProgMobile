package com.example.aflokkatgarden.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [GardenPlanting::class ,Plant::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
public abstract class AppDataBase : RoomDatabase() {

    abstract fun gardenDao(): GardenDao
    abstract fun plantDao(): PlantDao

    private class GardenDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.gardenDao())
                }
            }
        }

        suspend fun populateDatabase(gardenDao: GardenDao) {
            gardenDao.delete()

            val word = Plant(
                plantId = "plantId",
                name = "nom",
                description = "Description",
                growZoneNumber = 4,
                wateringInterval = 7,
                imageUrl = "TestUrl"
            )
            gardenDao.insert(word)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ) : AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "garden_database"
                )
                    .addCallback(GardenDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}