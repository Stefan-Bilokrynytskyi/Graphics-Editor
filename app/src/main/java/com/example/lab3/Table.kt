package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lab3.databinding.ActivityTableBinding


class Table : AppCompatActivity() {
    lateinit var binding: ActivityTableBinding
    private val adapter = ElemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTableBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Shapes Table"
    }

    private fun init() = with(binding) {
        recyclerView.layoutManager = GridLayoutManager(this@Table, 1)
        recyclerView.adapter = adapter
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) super.onBackPressed()
        return true
    }
}