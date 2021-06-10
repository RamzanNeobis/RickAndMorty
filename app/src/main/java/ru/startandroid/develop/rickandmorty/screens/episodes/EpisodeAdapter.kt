package ru.startandroid.develop.rickandmorty.screens.episodes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.episode_item.view.*
import ru.startandroid.develop.rickandmorty.R
import ru.startandroid.develop.rickandmorty.api.models.episodes.EpisodesModel

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.EpisodeHolder>() {

    private var mListEpisodes = emptyList<EpisodesModel>()

    class EpisodeHolder(view: View): RecyclerView.ViewHolder(view){

        private val locationName: TextView = view.text_view_name
        private val imageLocation: ImageView = view.image_view
        private val typeLocation: TextView = view.text_type
        private val dimensions: TextView = view.text_view_dimensions

        @SuppressLint("SetTextI18n")
        fun bind(data: EpisodesModel){
            locationName.text = "Episode Name - ${data.name}"
            imageLocation.setImageResource(R.drawable.episode_two)
            typeLocation.text = "Date - ${data.date}"
            dimensions.text = "Episode - ${data.episode}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.episode_item,parent, false)
        return EpisodeHolder(view)
    }

    override fun onBindViewHolder(holder: EpisodeHolder, position: Int) {
        holder.bind(mListEpisodes.get(position))
//        holder.namePersonage.text = mListPersonage[position].name
//        holder.imagePersonage.setImageURI(mListPersonage[position].image.toUri())
//        holder.statusPersonage.text = mListPersonage[position].status
//        holder.speciesPersonage.text = mListPersonage[position].species
//        holder.genderPersonage.text = mListPersonage[position].gender


    }

    override fun getItemCount(): Int = mListEpisodes.size

    fun setList(list: List<EpisodesModel>){
        mListEpisodes = list
        notifyDataSetChanged()
    }

}