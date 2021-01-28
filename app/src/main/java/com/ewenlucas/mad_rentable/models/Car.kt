package com.ewenlucas.mad_rentable.models

data class Car(
    val id: Integer,
    val nom: String,
    val image: String,
    val disponible: Boolean,
    val prixjournalierbase: Integer,
    val promotion: Integer,
    val agemin: Integer,
    val categorieco2: String,
    val equipements: List<Equipement>,
    val options: List<Option>
    )
