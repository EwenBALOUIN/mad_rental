package com.ewenlucas.mad_rentable.repositories

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.ewenlucas.mad_rentable.R
import com.ewenlucas.mad_rentable.helpers.NetworkHelper
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
    fun getLiveDataCar(liveDataCar: MutableLiveData<String>, liveDataErreur: MutableLiveData<String>, context: Context)
    {
        // vérification de l'état de la connexion internet :
        if (!NetworkHelper.isConnected(context))
        {
            liveDataErreur.value = context.getString(R.string.no_network)
            return
        }

        // appel au webservice :
        val call = serviceRetrofit.getCars()
        call.enqueue(object : Callback<ListCars> {
            override fun onResponse(call: Call<ListCars>, response: Response<ListCars>) {
                if (response.isSuccessful) {
                    val listCars = response.body()
                    listCars?.results?.let { list ->

                        for (car in list) {
                            //TODO make saving data for api car list and get image
                        }

                    }
                }
            }

            override fun onFailure(call: Call<ListCars>, t: Throwable) {
                liveDataErreur.value = t.message
            }

        })
    }
}