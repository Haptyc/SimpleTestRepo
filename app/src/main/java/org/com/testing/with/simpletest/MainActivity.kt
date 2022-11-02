package org.com.testing.with.simpletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.com.testing.with.simpletest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val adapter:RVCustomAdapter = RVCustomAdapter()
    private lateinit var binding: ActivityMainBinding

    private val vm = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.mRecyclerView.adapter = adapter
        binding.mRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, true)

        vm.data.observe(
            this
        ) {
            adapter.updateData(it)
        }
    }
}