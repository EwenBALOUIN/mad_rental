package com.ewenlucas.mad_rentable.db

import androidx.room.*
import com.ewenlucas.mad_rentable.models.Option

@Dao
abstract class OptionDAO
{
    @Query("SELECT * FROM options")
    abstract fun getListeOptions(): MutableList<Option>

    @Insert
    abstract fun insert(vararg options: Option)

    @Update
    abstract fun update(vararg options: Option)

    @Delete
    abstract fun delete(vararg options: Option)
}