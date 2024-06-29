package com.uti.tipala

import android.content.Intent
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

// Fragment yang menampilkan menu kedua
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

        descList = arrayOf(
            getString(R.string.text5),
            getString(R.string.text6),
            getString(R.string.text8),
            getString(R.string.text7),
            getString(R.string.text9),
            getString(R.string.text10),
            getString(R.string.text11),
            getString(R.string.text12),
            getString(R.string.text4),
            getString(R.string.text3)
        )

        detailImageList = arrayOf(
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

        // Inisialisasi daftar data
        dataList = arrayListOf<DataClass>()
        searchList = arrayListOf<DataClass>()
        getData()

        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()) {
                    dataList.forEach {
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
        myAdapter = AdapterClass(searchList)
        recylerView.adapter = myAdapter

        myAdapter.onItemClick = {
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }
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
    lateinit var descList: Array<String>
    lateinit var detailImageList: Array<Int>
    private lateinit var myAdapter: AdapterClass
    private lateinit var searchView: androidx.appcompat.widget.SearchView
    private lateinit var searchList: ArrayList<DataClass>

    // Metode untuk mendapatkan data dan menambahkannya ke dataList
    private fun getData() {
        dataList.add(DataClass(R.drawable.sebalang, "Pantai Sebalang", getString(R.string.text5), R.drawable.sebalang, -5.569986,105.3413022))
        dataList.add(DataClass(R.drawable.sariringgung, "Pantai Sari Ringgung", getString(R.string.text6), R.drawable.sariringgung, -5.5528, 105.2922))
        dataList.add(DataClass(R.drawable.kelagian, "Pantai Pulau Kelagian", getString(R.string.text8), R.drawable.kelagian, -5.8372, 105.2277))
        dataList.add(DataClass(R.drawable.klara, "Pantai Klara", getString(R.string.text7), R.drawable.klara, -5.7224, 105.2287))
        dataList.add(DataClass(R.drawable.hantu, "Pantai Teluk Hantu", getString(R.string.text9), R.drawable.hantu, -5.7023, 105.2321))
        dataList.add(DataClass(R.drawable.hiu, "Pantai Gigi Hiu", getString(R.string.text10), R.drawable.hiu, -5.7681, 105.2561))
        dataList.add(DataClass(R.drawable.putih, "Pantai Pasir Putih", getString(R.string.text11), R.drawable.putih, -5.7226, 105.2329))
        dataList.add(DataClass(R.drawable.mahitam, "Pantai Mahitam", getString(R.string.text12), R.drawable.mahitam, -5.7227, 105.2331))
        dataList.add(DataClass(R.drawable.pahawang, "Pantai Pulau Pahawang", getString(R.string.text4), R.drawable.pahawang, -5.8392, 105.2279))
        dataList.add(DataClass(R.drawable.mutun, "Pantai Mutun", getString(R.string.text3), R.drawable.mutun, -5.8401, 105.2283))

        searchList.addAll(dataList)
        recylerView.adapter = AdapterClass(searchList)
    }
}
