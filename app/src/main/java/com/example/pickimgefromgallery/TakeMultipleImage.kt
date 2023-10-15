package com.example.pickimgefromgallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pickimgefromgallery.adapter.MultipleImage
import com.example.pickimgefromgallery.databinding.ActivityTakeMultipleImageBinding
import com.example.pickimgefromgallery.model.SelectedImage

class TakeMultipleImage : AppCompatActivity() {
    private var _binding:ActivityTakeMultipleImageBinding?=null
    private val binding:ActivityTakeMultipleImageBinding
        get() = _binding!!
    private val selectedImages = mutableListOf<SelectedImage>()
    private lateinit var imageAdapter: MultipleImage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityTakeMultipleImageBinding.inflate(layoutInflater)
        setContentView(binding.root)



        imageAdapter = MultipleImage(selectedImages)
        binding.imageRecyclerView.adapter = imageAdapter
        binding.imageRecyclerView.layoutManager = LinearLayoutManager(this)

        binding.pickImagesButton.setOnClickListener {
            pickImages()
        }
    }
    private fun pickImages() {
//        ImagePi.create(this)
//            .folderMode(true)
//            .folderTitle("Select images")
//            .limit(10)
//            .showCamera(true)
//            .start()
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}