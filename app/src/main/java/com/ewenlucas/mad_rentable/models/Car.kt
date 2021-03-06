package com.ewenlucas.mad_rentable.models
import androidx.room.*


@Entity(tableName = "cars")
data class Car(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nom: String,
    val image: String,
    val disponible: Boolean,
    val prixjournalierbase: Int,
    val promotion: Int,
    val agemin: Int,
    val categorieco2: String,
    )
