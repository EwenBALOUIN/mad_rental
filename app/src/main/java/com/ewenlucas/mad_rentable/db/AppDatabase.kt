package com.ewenlucas.mad_rentable.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ewenlucas.mad_rentable.models.Car

@Database(entities = [Car::class], version = 1)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun carsDAO(): CarDAO
}