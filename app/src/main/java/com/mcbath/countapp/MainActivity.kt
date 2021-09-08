package com.mcbath.countapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var addBtn: Button
    private lateinit var minusBtn: Button
    private lateinit var resetBtn: Button

    /*create a ViewModel to handle counting data*/
    private lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView=findViewById(R.id.count_tv)
        addBtn=findViewById(R.id.add_btn)
        minusBtn=findViewById(R.id.minus_btn)
        resetBtn=findViewById(R.id.reset_btn)

        viewModel= ViewModelProvider(this).get(MainViewModel::class.java)

        /*View model provides a Live Data object with initial counting value is equal to zero at
        the beginning of the app.After getting that object we need to observe LiveData counting
        value changes.That is the use of count instance here.Text Field auto update its observed
        value. Initial count must be called once.*/

        var count: LiveData<Int> = viewModel.getInitialCount()
        count.observe(this, Observer {
            textView.setText("Count is $it")
        })

        addBtn.setOnClickListener {
            viewModel.incrementCount()
        }

        minusBtn.setOnClickListener {
            viewModel.decrementCount()
        }

        resetBtn.setOnClickListener {
            viewModel.resetCount()
        }
    }
}