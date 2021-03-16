package com.ewenlucas.mad_rentable.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.ewenlucas.mad_rentable.R
import com.ewenlucas.mad_rentable.models.CarWithEquipementAndOption
import com.ewenlucas.mad_rentable.models.Equipement
import com.ewenlucas.mad_rentable.models.Option
import com.ewenlucas.mad_rentable.fragments.DetailFragment
import com.google.gson.Gson

class DetailActivity : AppCompatActivity()
{

    companion object
    {
        // Constantes :
        const val EXTRA_CAR = "EXTRA_CAR"
    }


    override fun onCreate(savedInstanceState: Bundle?)
    {
        // init :
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        // récupération de l'argument depuis l'adapter :
        val jsonCar: String = intent.getStringExtra("EXTRA_CAR")

        // fragment :
        val fragment = DetailFragment()
        val bundle = Bundle()
        bundle.putString(DetailFragment.EXTRA_CAR, jsonCar)
        fragment.arguments = bundle

        // transaction :
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.conteneur_fragment, fragment)
        transaction.commit()
    }

}