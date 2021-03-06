package com.ewenlucas.mad_rentable.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fullcars")
data class CarWithEquipementAndOption(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nom: String,
    val image: String,
    val disponible: Int,
    val prixjournalierbase: Int,
    val promotion: Int,
    val agemin: Int,
    val categorieco2: String,
    val equipements: List<Equipement>,
    val options: List<Option>
)
