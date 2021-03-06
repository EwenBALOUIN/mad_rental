package com.ewenlucas.mad_rentable.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ewenlucas.mad_rentable.R
import com.ewenlucas.mad_rentable.adapters.ApiCarAdapter
import com.ewenlucas.mad_rentable.models.CarWithEquipementAndOption
import com.ewenlucas.mad_rentable.models.Equipement
import com.ewenlucas.mad_rentable.models.Option
import com.ewenlucas.mad_rentable.repositories.CarRepository
import com.ewenlucas.mad_rentable.webservices.RetrofitSingleton
import com.ewenlucas.mad_rentable.webservices.WebInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var carRepository = CarRepository()
    val liveDataCars: MutableLiveData<String> = MutableLiveData()
    val liveDataErreur: MutableLiveData<String> = MutableLiveData()
    private val serviceRetrofit = RetrofitSingleton.retrofit.create(WebInterface::class.java)

    var listeCars = ArrayList<CarWithEquipementAndOption>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter:ApiCarAdapter


    override fun onCreate(savedInstanceState: Bundle?)
    {
        // init :
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.cars_list)
        recyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        var equipement = listOf(Equipement(2,"perpito"))
        var option = listOf(Option(3, "pepepe", 12))
//        var car = CarWithEquipementAndOption(1,
//            "oui",
//            "zoom-buggy.jpg",
//            1,
//            27,
//            2,
//            2,
//            "A",
//            equipement,
//            option
//            )

        val apiCarAdapter = ApiCarAdapter(listeCars)
        recyclerView.adapter = apiCarAdapter
        getLiveDataCar()
    }

    /**
     * Listener clic bouton planète.
     */
    @Suppress("UNUSED_PARAMETER")
    fun onClickBoutonPlanete(view: View?)
    {
        carRepository.getLiveDataCar(liveDataCars, liveDataErreur)
    }

    /**
     * Récupère les informations des véhicules.
     */
    fun getLiveDataCar()
    {

        // appel au webservice :
        val call: Call<List<CarWithEquipementAndOption>> = serviceRetrofit.getCars()
        call.enqueue(object : Callback<List<CarWithEquipementAndOption>> {
            override fun onResponse(call: Call<List<CarWithEquipementAndOption>>, response: Response<List<CarWithEquipementAndOption>>) {
                if (response.isSuccessful) {
                    listeCars.addAll(response!!.body()!!)
                    recyclerView.adapter?.notifyDataSetChanged()

                }
            }

            override fun onFailure(call: Call<List<CarWithEquipementAndOption>>, t: Throwable) {
            }

        })
    }
}