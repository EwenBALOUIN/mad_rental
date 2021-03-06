package com.ewenlucas.mad_rentable.repositories

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.ewenlucas.mad_rentable.R
import com.ewenlucas.mad_rentable.helpers.NetworkHelper
import com.ewenlucas.mad_rentable.models.CarWithEquipementAndOption
import com.ewenlucas.mad_rentable.models.ListCars
import com.ewenlucas.mad_rentable.webservices.RetrofitSingleton
import com.ewenlucas.mad_rentable.webservices.WebInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarRepository
{
    private val serviceRetrofit = RetrofitSingleton.retrofit.create(WebInterface::class.java)

    /**
     * Récupère les informations des véhicules.
     */
    fun getLiveDataCar(liveDataCar: MutableLiveData<String>, liveDataErreur: MutableLiveData<String>)
    {

        // appel au webservice :
        val call: Call<List<CarWithEquipementAndOption>> = serviceRetrofit.getCars()
        call.enqueue(object : Callback<List<CarWithEquipementAndOption>> {
            override fun onResponse(call: Call<List<CarWithEquipementAndOption>>, response: Response<List<CarWithEquipementAndOption>>) {
                if (response.isSuccessful) {
                    val listCars = response.body()

                }
            }

            override fun onFailure(call: Call<List<CarWithEquipementAndOption>>, t: Throwable) {
                liveDataErreur.value = t.message
                println(liveDataErreur.value)
            }

        })
    }

}