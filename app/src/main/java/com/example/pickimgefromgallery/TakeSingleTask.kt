package com.example.pickimgefromgallery

import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.pickimgefromgallery.databinding.ActivityMainBinding

class TakeSingleTask : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding:ActivityMainBinding
        get() = _binding!!
    private val imageContracts = registerForActivityResult(ActivityResultContracts.GetContent()) {
        if (it == null && binding.actionImage.drawable == null)
            Toast.makeText(this, "Select Image", Toast.LENGTH_SHORT).show()
        else if ((it!=null && binding.actionImage.drawable==null) || (it!=null && binding.actionImage.drawable!=null))
            binding.actionImage.setImageURI(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pickImage.setOnClickListener{
            imageContracts.launch("image/*")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}