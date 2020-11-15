package org.andronitysolo.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_movie_detail.*
import org.andronitysolo.task2.Model.Movie

class MovieDetail : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = " extra_movie"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        val secelItem = intent.getParcelableExtra<Movie>(MovieDetail.EXTRA_MOVIE)

        if (secelItem != null) {
            Glide.with(this)
                .load(secelItem.photo)
                .apply(RequestOptions().override(350, 550))
                .into(img_photo)

            val txtjudul = txt_name
            txtjudul.setText(secelItem.name)

            val txtDeskripsi = txt_deskripsi
            txtDeskripsi.setText(secelItem.description)
        }
    }
}