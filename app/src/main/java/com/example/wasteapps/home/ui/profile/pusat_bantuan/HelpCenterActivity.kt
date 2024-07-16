package com.example.wasteapps.home.ui.profile.pusat_bantuan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.SimpleExpandableListAdapter
import com.example.wasteapps.R

class HelpCenterActivity : AppCompatActivity() {

    private lateinit var expandableListView: ExpandableListView
    private lateinit var expandableListDetail: HashMap<String, List<String>>
    private lateinit var expandableListTitle: List<String>
    private lateinit var expandableListAdapter: ExpandableListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_center)

        expandableListView = findViewById(R.id.expandableListView)
        expandableListDetail = getData()
        expandableListTitle = ArrayList(expandableListDetail.keys)
        expandableListAdapter = SimpleExpandableListAdapter(
            this,
            expandableListTitle.map { mapOf("TITLE" to it) } as List<Map<String, String>>,
            android.R.layout.simple_expandable_list_item_1,
            arrayOf("TITLE"),
            intArrayOf(android.R.id.text1),
            expandableListDetail.map { mapOf("CONTENT" to it.value.joinToString("\n")) } as List<List<Map<String, String>>>,
            android.R.layout.simple_list_item_1,
            arrayOf("CONTENT"),
            intArrayOf(android.R.id.text1)
        )
        expandableListView.setAdapter(expandableListAdapter)
    }

    private fun getData(): HashMap<String, List<String>> {
        val expandableListDetail = HashMap<String, List<String>>()

        expandableListDetail["Apa saja jenis-jenis sampah organik"] = listOf("Jenis sampah organik meliputi...")
        expandableListDetail["Bagaimana saya melacak penjemputan"] = listOf("Anda dapat melacak penjemputan melalui...")
        expandableListDetail["Bagaimana saya melakukan penarikan"] = listOf("Untuk melakukan penarikan, Anda harus...")
        expandableListDetail["Bagaimana saya melakukan pengubahan"] = listOf("Untuk melakukan pengubahan data, Anda perlu...")
        expandableListDetail["Bagaimana saya menghubungi bantuan"] = listOf("Anda bisa menghubungi bantuan dengan cara...")

        return expandableListDetail
    }
}