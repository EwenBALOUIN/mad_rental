package com.ewenlucas.mad_rentable.db

import androidx.room.*
import com.ewenlucas.mad_rentable.models.Car
import com.ewenlucas.mad_rentable.models.CarWithEquipementAndOption

@Dao
abstract class CarDAO
{
//    @Query("SELECT * FROM cars")
//    abstract fun getListeCars(): MutableList<Car>

    @Transaction
    @Query("SELECT * FROM cars")
    abstract fun getCarWithEquipementAndOption(): MutableList<CarWithEquipementAndOption>


//    @Query("SELECT * FROM cars WHERE favorite=1")
//    abstract fun getFavoriteListeCars(): MutableList<Car>

    @Insert
    abstract fun insert(vararg cars: Car)

    @Update
    abstract fun update(vararg cars: Car)

    @Delete
    abstract fun delete(vararg cars: Car)
}
