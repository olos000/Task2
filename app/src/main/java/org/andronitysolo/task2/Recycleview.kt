package org.andronitysolo.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.andronitysolo.task2.Adapter.RecycleViewAdapter
import org.andronitysolo.task2.Model.Movie

class Recycleview : AppCompatActivity() {
    private var rvCategory: RecyclerView? = null
    private val list = ArrayList<Movie>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycleview)
        rvCategory = findViewById(R.id.rv_category)
        rvCategory?.setHasFixedSize(true)
        list.addAll(MoviesData().listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
       rvCategory?.layoutManager = LinearLayoutManager(this)
       val cardviewAdapter = RecycleViewAdapter(list, this)
       rvCategory?.adapter = cardviewAdapter

    }
}