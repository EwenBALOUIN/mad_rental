package com.ewenlucas.mad_rentable.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "options")
data class Option(
    @PrimaryKey(autoGenerate = true)
    val id: Integer,
    val nom: String,
    val prix: Integer,
    val carId: Integer,
    )
