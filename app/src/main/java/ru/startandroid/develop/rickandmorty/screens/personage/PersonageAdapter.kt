package ru.startandroid.develop.rickandmorty.screens.personage

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.personage_item.view.*
import ru.startandroid.develop.rickandmorty.R
import ru.startandroid.develop.rickandmorty.api.models.personage.PersonageModel


class PersonageAdapter: RecyclerView.Adapter<PersonageAdapter.PersonageHolder>() {

    private var mListPersonage = emptyList<PersonageModel>()

    class PersonageHolder(view: View): RecyclerView.ViewHolder(view){
        private val namePersonage: TextView = view.text_view_name
        private val imagePersonage: ImageView = view.image_view
        private val statusPersonage: TextView = view.text_view_status
        private val speciesPersonage: TextView = view.text_view_species
        private val genderPersonage: TextView = view.text_view_gender

        @SuppressLint("SetTextI18n")
        fun bind(data: PersonageModel){
            namePersonage.text = "Name - ${data.name} "
            statusPersonage.text = "Status - ${data.status}"
            speciesPersonage.text = "Species - ${data.species}"
            genderPersonage.text = "Gender - ${ data.gender}"

            val url = data.image

            Picasso.get()
                .load(url)
                .into(imagePersonage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.personage_item,parent, false)
        return PersonageHolder(view)
    }

    override fun onBindViewHolder(holder: PersonageHolder, position: Int) {
        holder.bind(mListPersonage.get(position))
//        holder.namePersonage.text = mListPersonage[position].name
//        holder.imagePersonage.setImageURI(mListPersonage[position].image.toUri())
//        holder.statusPersonage.text = mListPersonage[position].status
//        holder.speciesPersonage.text = mListPersonage[position].species
//        holder.genderPersonage.text = mListPersonage[position].gender


    }

    override fun getItemCount(): Int = mListPersonage.size

    fun setList(list: List<PersonageModel>){
        mListPersonage = list
        notifyDataSetChanged()
    }


}