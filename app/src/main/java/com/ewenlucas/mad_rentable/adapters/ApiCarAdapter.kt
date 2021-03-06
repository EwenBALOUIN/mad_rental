package com.ewenlucas.mad_rentable.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ewenlucas.mad_rentable.R
import com.ewenlucas.mad_rentable.models.CarWithEquipementAndOption
import com.squareup.picasso.Picasso

class ApiCarAdapter(private var listeCars: MutableList<CarWithEquipementAndOption>) : RecyclerView.Adapter<ApiCarAdapter.ApiCarViewHolder>()
{
    var onItemClick: ((CarWithEquipementAndOption) -> Unit)? = null
    // Crée chaque vue item à afficher :
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiCarViewHolder      {
        val viewCourse = LayoutInflater.from(parent.context).inflate(R.layout.item_api_car, parent, false)
        return ApiCarViewHolder(viewCourse)
    }
// Renseigne le contenu de chaque vue item :
    override fun onBindViewHolder(holder: ApiCarViewHolder, position: Int)      {

    holder.textViewNameCar.text = listeCars[position].nom
    holder.textViewRentValueCar.text = listeCars[position].prixjournalierbase.toString()
    holder.textViewCategorieCo2Car.text = listeCars[position].categorieco2

    val url : String = "http://s519716619.onlinehome.fr/exchange/madrental/images/"+ listeCars[position].image;
    Picasso.get().load(url).resize(160, 80).centerCrop().into(holder.imageViewCar)
    }
    override fun getItemCount(): Int = listeCars.size

// ViewHolder :
    inner class ApiCarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)      {

        val imageViewCar: ImageView = itemView.findViewById(R.id.car_img)
        val textViewNameCar: TextView = itemView.findViewById(R.id.car_name)
        val textViewRentValueCar: TextView = itemView.findViewById(R.id.value_prixjournalierbase)
        val textViewCategorieCo2Car: TextView = itemView.findViewById(R.id.value_categorieco2)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listeCars[adapterPosition])
            }
        }
    }


}