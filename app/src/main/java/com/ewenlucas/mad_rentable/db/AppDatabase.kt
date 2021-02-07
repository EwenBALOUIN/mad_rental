package com.ewenlucas.mad_rentable.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ewenlucas.mad_rentable.models.Car
import com.ewenlucas.mad_rentable.models.Equipement
import com.ewenlucas.mad_rentable.models.Option

@Database(entities = [Car::class, Equipement::class, Option::class], version = 1)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun carsDAO(): CarDAO

    abstract fun equipementsDAO(): EquipementDAO

    abstract fun optionsDAO(): OptionDAO
}
