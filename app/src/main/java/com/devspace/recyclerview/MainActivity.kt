package com.devspace.recyclerview

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter= ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)
        }

        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }

        adapter.SetOnClickListener { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)
        }
    }
}

private val contacts = listOf(
    Contact(
        "Marco",
        "(55)11 98647-0932",
        R.drawable.sample12
    ),
    Contact(
        "Bruna",
        "(55)11 99032-7584",
        R.drawable.sample3
    ),
    Contact(
        "Erick",
        "(55)11 98749-0321",
        R.drawable.sample10
    ),
    Contact(
        "Francisco",
        "(55)11 98647-0932",
        R.drawable.sample14
    ),
    Contact(
        "Brenda",
        "(55)11 98572-0944",
        R.drawable.sample7
    ),
    Contact(
        "Helena",
        "(55)11 99904-4320",
        R.drawable.sample11
    ),
    Contact(
        "Roque",
        "(55)11 97640-9983",
        R.drawable.sample8
    ),
    Contact(
        "David",
        "(55)11 98209-7200",
        R.drawable.sample2
    ),
    Contact(
        "Camila",
        "(55)11 99309-3289",
        R.drawable.sample5
    ),
    Contact(
        "Joao",
        "(55)11 97894-3547",
        R.drawable.sample9
    ),
    Contact(
        "Julia",
        "(55)11 99983-2000",
        R.drawable.sample1
    ),
    Contact(
        "Tatiane",
        "(55)11 99457-6557",
        R.drawable.sample16
    ),
    Contact(
        "Thiago",
        "(55)11 97850-9904",
        R.drawable.sample12
    ),
    Contact(
        "Laura",
        "(55)11 99800-7854",
        R.drawable.sample15
    ),
    Contact(
        "Maria",
        "(55)11 99432-8599",
        R.drawable.sample16
    ),
    Contact(
        "Carol",
        "(55)11 99090-8600",
        R.drawable.sample16
    ),

)