package com.ewenlucas.mad_rentable.db

import androidx.room.*
import com.ewenlucas.mad_rentable.models.Equipement

@Dao
abstract class EquipementDAO
{
    @Query("SELECT * FROM equipements")
    abstract fun getListeEquipements(): MutableList<Equipement>

    @Insert
    abstract fun insert(vararg equipements: Equipement)

    @Update
    abstract fun update(vararg equipements: Equipement)

    @Delete
    abstract fun delete(vararg equipements: Equipement)
}
