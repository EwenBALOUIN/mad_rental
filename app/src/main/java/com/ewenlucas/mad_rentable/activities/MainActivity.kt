package com.ewenlucas.mad_rentable.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.ewenlucas.mad_rentable.R
import com.ewenlucas.mad_rentable.repositories.CarRepository
import com.ewenlucas.mad_rentable.viewmodels.MainViewModel
import com.ewenlucas.mad_rentable.webservices.RetrofitSingleton
import com.ewenlucas.mad_rentable.webservices.WebInterface

class MainActivity : AppCompatActivity()
{

    // Vues :
    private lateinit var textViewPlanete: TextView
    private lateinit var progressBarAttente: ProgressBar

    // ViewModel :
    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?)
    {
        // init :
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // vues :
        textViewPlanete = findViewById(R.id.texte_planete)
        progressBarAttente = findViewById(R.id.progressbar_attente)

        // view model et observer :
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.init(CarRepository())
        mainViewModel.liveDataCar.observe(this, { t ->
            textViewPlanete.text = t
            progressBarAttente.visibility = View.GONE
        })
        mainViewModel.liveDataError.observe(this, { t ->
            textViewPlanete.text = t
            progressBarAttente.visibility = View.GONE
        })
    }

    /**
     * Listener clic bouton planète.
     */
    @Suppress("UNUSED_PARAMETER")
    fun onClickBoutonPlanete(view: View?)
    {
        progressBarAttente.visibility = View.VISIBLE
        textViewPlanete.text = ""
        mainViewModel.clicBoutoCar(this)
    }

}