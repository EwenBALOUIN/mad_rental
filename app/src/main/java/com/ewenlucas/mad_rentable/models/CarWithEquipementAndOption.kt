package com.ewenlucas.mad_rentable.models

import androidx.room.Embedded
import androidx.room.Relation


data class CarWithEquipementAndOption (
    @Embedded val car: Car,

    @Relation(
        parentColumn = "id",
        entityColumn = "carId"
    )
    val equipements: List<Equipement>,

    @Relation(
        parentColumn = "id",
        entityColumn = "carId"
    )
    val options: List<Option>
)
