package org.andronitysolo.task2

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list_view.*
import org.andronitysolo.task2.Adapter.ListAdapter
import org.andronitysolo.task2.Model.Makanan

class ListView : AppCompatActivity() {
    val listMakanan = ArrayList<Makanan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        listMakanan.add(
            Makanan(
                "lontong",
                "Lontong adalah makanan khas Indonesia yang berkembang di masyarakat Jawa, terbuat dari beras yang dibungkus dalam daun pisang dan dikukus di atas air mendidih selama beberapa jam dan jika air hampir habis dituangkan air lagi demikian berulang sampai beberapa kali",
                R.drawable.lontong
            )
        )
        listMakanan.add(
            Makanan(
                "Bubur ayam",
                "Bubur ayam adalah salah satu jenis makanan bubur dari Indonesia. Bubur nasi adalah beras yang dimasak dengan air yang banyak sehingga memiliki tekstur yang lembut dan berair. Bubur biasanya disajikan dalam suhu panas atau hangat",
                R.drawable.bubur
            )
        )
        listMakanan.add(
            Makanan(
                "Nasi liwet",
                "Terdapat 2 Jenis Nasi Liwet yaitu Nasi Liwet Solo dan Nasi Liwet Sunda. Nasi liwet Solo makanan khas kota Solo dan merupakan kuliner asli daerah Baki, Kabupaten Sukoharjo. Nasi liwet adalah nasi gurih mirip nasi uduk, yang disajikan dengan sayur labu siam, suwiran ayam dan areh",
                R.drawable.nasiliwet
            )
        )
        listMakanan.add(
            Makanan(
                "Nasi Padang",
                "Nasi Padang adalah nasi putih yang disajikan dengan berbagai macam lauk pauk khas Indonesia. Padang merujuk pada ibu kota provinsi Sumatra Barat, kampung halaman orang Minangkabau.",
                R.drawable.nasipadeng
            )
        )
        listMakanan.add(
            Makanan(
                "Nasi kebuli",
                "Nasi kebuli adalah hidangan nasi berbumbu yang bercitarasa gurih yang ditemukan di Indonesia. Nasi ini dimasak bersama kaldu daging kambing, susu kambing, dan minyak samin, disajikan dengan daging kambing goreng dan kadang ditaburi dengan irisan kurma atau kismis",
                R.drawable.kebuli
            )
        )

        val adapter = ListAdapter(this, listMakanan)
        list.adapter = adapter

        list.setOnItemClickListener { _, _, position, _ ->
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(true)
                setContentView(R.layout.activity_detaillist)

                val image = this.findViewById<ImageView>(R.id.img_photo)
                val nama = this.findViewById<TextView>(R.id.txt_name)
                val nohp = this.findViewById<TextView>(R.id.txt_deskripsi)


                val item = listMakanan.get(position)

                image.setImageResource(item.photo)
                nama.text = "Nama : ${item.name}"
                nohp.text = "No Hp : ${item.description}"


            }.show()

        }
    }
}