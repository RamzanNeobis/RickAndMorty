package ru.startandroid.develop.rickandmorty.screens.locations

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.location_item.view.*
import org.w3c.dom.Text
import ru.startandroid.develop.rickandmorty.R
import ru.startandroid.develop.rickandmorty.api.models.locations.LocationModel

class LocationsAdapter : RecyclerView.Adapter<LocationsAdapter.LocationHolder>() {

    private var mListLocation = emptyList<LocationModel>()

    class LocationHolder(view: View): RecyclerView.ViewHolder(view){

        private val locationName: TextView = view.text_view_name
        private val imageLocation: ImageView = view.image_view
        private val typeLocation: TextView = view.text_type
        private val dimensions: TextView = view.text_view_dimensions

        @SuppressLint("SetTextI18n")
        fun bind(data: LocationModel){
            locationName.text = "Loc-Name - ${data.name}"
            imageLocation.setImageResource(R.drawable.loc_three)
            typeLocation.text = "Type-Loc - ${data.type}"
            dimensions.text = "Dimens - ${data.dimensions}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.location_item,parent, false)
        return LocationHolder(view)
    }

    override fun onBindViewHolder(holder: LocationHolder, position: Int) {
        holder.bind(mListLocation.get(position))
//        holder.namePersonage.text = mListPersonage[position].name
//        holder.imagePersonage.setImageURI(mListPersonage[position].image.toUri())
//        holder.statusPersonage.text = mListPersonage[position].status
//        holder.speciesPersonage.text = mListPersonage[position].species
//        holder.genderPersonage.text = mListPersonage[position].gender


    }

    override fun getItemCount(): Int = mListLocation.size

    fun setList(list: List<LocationModel>){
        mListLocation = list
        notifyDataSetChanged()
    }


}