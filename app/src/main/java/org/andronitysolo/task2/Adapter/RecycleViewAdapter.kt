package org.andronitysolo.task2.Adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.rcy_cardview.view.*
import org.andronitysolo.task2.Model.Movie
import org.andronitysolo.task2.MovieDetail
import org.andronitysolo.task2.R

class RecycleViewAdapter(val listMovie: List<Movie>, val activity: Activity) :
    RecyclerView.Adapter<RecycleViewAdapter.CardViewViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecycleViewAdapter.CardViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rcy_cardview, parent, false)
        return CardViewViewHolder(view)
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(movie.photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(img_photo)

                txt_name.text = movie.name
                txt_name.text = movie.description
                card_view.setOnClickListener {
                    val moveWithObjectIntent = Intent(activity, MovieDetail::class.java)
                    moveWithObjectIntent.putExtra(MovieDetail.EXTRA_MOVIE, movie)
                    activity.startActivity(moveWithObjectIntent)
                }
            }
        }
    }


    override fun onBindViewHolder(holder: RecycleViewAdapter.CardViewViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    override fun getItemCount(): Int = listMovie.size
}