package com.shatokhin.jokesaboutchaknoris.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shatokhin.jokesaboutchaknoris.R
import com.shatokhin.jokesaboutchaknoris.domain.models.Joke

class RvJokesAdapter: RecyclerView.Adapter<RvJokesAdapter.JokeHolder>() {

    companion object{
        private val listJokes: MutableList<Joke> = mutableListOf()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeHolder {
        return JokeHolder(LayoutInflater.from(parent.context).inflate(R.layout.joke_holder, parent, false))
    }

    override fun onBindViewHolder(holder: JokeHolder, position: Int) {
        val joke = listJokes[position]
        holder.bind(joke, position)
    }

    override fun getItemCount(): Int {
        return listJokes.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListJokes(newListJokes: List<Joke>){
        listJokes.clear()
        listJokes.addAll(newListJokes)
        notifyDataSetChanged()
    }


    class JokeHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val numberJoke = itemView.findViewById<TextView>(R.id.tvNumberJoke)
        private val textJoke = itemView.findViewById<TextView>(R.id.tvTextJoke)

        fun bind(joke: Joke, position: Int){
            val pos = position + 1
            numberJoke.text = pos.toString()
            textJoke.text = joke.text
        }
    }
}