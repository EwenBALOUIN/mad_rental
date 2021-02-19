package com.ewenlucas.mad_rentable.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ewenlucas.mad_rentable.repositories.CarRepository

class MainViewModel : ViewModel()
{

    // Repository :
    private lateinit var carRepository: CarRepository

    // LiveDatas :
    val liveDataCar: MutableLiveData<String> = MutableLiveData()
    val liveDataError: MutableLiveData<String> = MutableLiveData()


    /**
     * Initialisation.
     */
    fun init(carRepository: CarRepository)
    {
        // vérification que l'initialisation n'a pas déjà été faite :
        if (this::carRepository.isInitialized) return

        // initialisation et premier chargement :
        this.carRepository = carRepository
    }

    /**
     * Listener clic bouton chargement.
     */
    fun clicBoutoCar(context: Context)
    {
        carRepository.getLiveDataCar(liveDataCar, liveDataError, context)
    }

}