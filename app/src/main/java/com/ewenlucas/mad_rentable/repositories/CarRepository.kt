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
import kotlin.random.Random

class CarRepository
{
    private val serviceRetrofit = RetrofitSingleton.retrofit.create(WebInterface::class.java)

    /**
     * Récupère les informations des véhicules.
     */
    fun getLiveDataCar(liveDataCar: MutableLiveData<String>, liveDataError: MutableLiveData<String>, context: Context)
    {
        // vérification de l'état de la connexion internet :
        if (!NetworkHelper.isConnected(context))
        {
            liveDataError.value = context.getString(R.string.no_network)
            return
        }

        // appel au webservice :
        val call = serviceRetrofit.getCars()
        call.enqueue(object : Callback<ListCars> {
            override fun onResponse(call: Call<ListCars>, response: Response<ListCars>) {
                if (response.isSuccessful) {
                    val listCars = response.body()
                    listCars?.results?.let { list ->
                        val car = list[Random.nextInt(0, list.size)]

                        // création du texte :
                        val stringBuilder = StringBuilder()
                        stringBuilder.append(context.getString(R.string.main_car_nom, car.nom))

                        // affichage final :
                        liveDataCar.value = stringBuilder.toString()

                    }
                }
            }

            override fun onFailure(call: Call<ListCars>, t: Throwable) {
                liveDataError.value = t.message
            }

        })
    }
}