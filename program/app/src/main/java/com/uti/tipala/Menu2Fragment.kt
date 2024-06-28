package com.uti.tipala

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

//Fragment yang menampilkan menu kedua
class Menu2Fragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    // Metode untuk menginflasi layout fragment dan menginisialisasi view
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Menginflasi layout untuk fragment ini
        val view = inflater.inflate(R.layout.fragment_menu2, container, false)

        // Inisialisasi RecyclerView dan data
        recylerView = view.findViewById(R.id.recyclerView)
        searchView = view.findViewById(R.id.search)
        recylerView.layoutManager = LinearLayoutManager(context)
        recylerView.setHasFixedSize(true)

        // Inisialisasi daftar gambar dan judul
        imageList = arrayOf(
            R.drawable.sebalang,
            R.drawable.sariringgung,
            R.drawable.kelagian,
            R.drawable.klara,
            R.drawable.hantu,
            R.drawable.hiu,
            R.drawable.putih,
            R.drawable.mahitam,
            R.drawable.pahawang,
            R.drawable.mutun
        )

        titleList = arrayOf(
            "Pantai Sebalang",
            "Pantai Sari Ringgung",
            "Pantai Pulau Kelagian",
            "Pantai Klara",
            "Pantai Teluk Hantu",
            "Pantai Gigi Hiu",
            "Pantai Pasir Putih",
            "Pantai Mahitam",
            "Pantai Pulau Pahawang",
            "Pantai Mutun"
        )

        // Inisialisasi daftar data
        dataList = arrayListOf<DataClass>()
        searchList = arrayListOf<DataClass>()
        getData()

        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                searchList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    dataList.forEach{
                        if (it.dataTitle.toLowerCase(Locale.getDefault()).contains(searchText)) {
                            searchList.add(it)
                        }
                    }
                    recylerView.adapter!!.notifyDataSetChanged()
                } else {
                    searchList.clear()
                    searchList.addAll(dataList)
                    recylerView.adapter!!.notifyDataSetChanged()
                }
                return false
            }
        })

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Menu2Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    // Deklarasi variabel untuk RecyclerView dan data
    private lateinit var recylerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList: Array<Int>
    lateinit var titleList: Array<String>
    private lateinit var searchView: androidx.appcompat.widget.SearchView
    private lateinit var searchList: ArrayList<DataClass>

    // Metode untuk mendapatkan data dan menambahkannya ke dataList
    private fun getData() {
        for (i in imageList.indices) {
            val dataClass = DataClass(imageList[i], titleList[i])
            dataList.add(dataClass)
        }
        // Mengatur adapter untuk RecyclerView
        searchList.addAll(dataList)
        recylerView.adapter = AdapterClass(searchList)
    }
}