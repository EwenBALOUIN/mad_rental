package com.ewenlucas.mad_rentable.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "equipements")
data class Equipement(
    @PrimaryKey(autoGenerate = true)
    val id: Integer,
    val nom: String,
    val carId: Integer,
    )
