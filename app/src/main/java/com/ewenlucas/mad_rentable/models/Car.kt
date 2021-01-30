package com.ewenlucas.mad_rentable.models
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cars")
data class Car(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val nom: String,
    val image: String,
    val disponible: Boolean,
    val prixjournalierbase: Integer,
    val promotion: Integer,
    val agemin: Integer,
    val categorieco2: String,
    val favorite: Boolean,
    val equipements: List<Equipement>,
    val options: List<Option>
    )
