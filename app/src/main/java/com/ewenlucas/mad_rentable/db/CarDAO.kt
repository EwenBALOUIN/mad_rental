package com.ewenlucas.mad_rentable.db

import androidx.room.*
import com.ewenlucas.mad_rentable.models.Car
import com.ewenlucas.mad_rentable.models.CarWithEquipementAndOption

@Dao
abstract class CarDAO
{

//    @Transaction
//    @Query("SELECT * FROM cars")
//    abstract fun getCarWithEquipementAndOption(): MutableList<CarWithEquipementAndOption>

    @Insert
    abstract fun insert(vararg cars: Car)

    @Update
    abstract fun update(vararg cars: Car)

    @Delete
    abstract fun delete(vararg cars: Car)
}
