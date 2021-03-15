package com.ewenlucas.mad_rentable.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ewenlucas.mad_rentable.R
import com.ewenlucas.mad_rentable.models.CarWithEquipementAndOption
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment()
{

    companion object
    {
        // Constantes :
        const val EXTRA_CAR = "EXTRA_CAR"
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // fait le lien entre le xml du fragment et la classe kotlin du fragment :
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        // init :
        super.onActivityCreated(savedInstanceState)

        // récupération de l'argument depuis DetailActivity :
        val arguments = requireArguments()
        val car = arguments.getString(EXTRA_CAR)
        car_name.text = "intitule"
        // affichage de l'intitulé s'il a bien été passé en argument :
//        car?.let {
//            car_name.text = big_car.nom
//            value_prixjournalierbase.text = big_car.prixjournalierbase.toString()
//            value_categorieco2.text = big_car.categorieco2
//        }
    }

}