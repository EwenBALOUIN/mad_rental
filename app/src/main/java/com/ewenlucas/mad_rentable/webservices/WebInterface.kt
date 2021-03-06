package com.ewenlucas.mad_rentable.webservices

import com.ewenlucas.mad_rentable.models.CarWithEquipementAndOption
import com.ewenlucas.mad_rentable.models.ListCars
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface WebInterface
{

    // appel get vars:
    @GET("get-vehicules.php")
    fun getCars(): Call<List<CarWithEquipementAndOption>>

}