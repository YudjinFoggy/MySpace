package com.example.myspace.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.Gallery
import android.widget.ImageView
import com.example.myspace.MainViewModel
import com.example.myspace.R
import com.example.myspace.extensions.activityViewModelProvider
import com.example.myspace.extensions.viewModelProvider
import com.example.myspace.fragment.BaseFragment


@Suppress("DEPRECATION")
class GalleryFragment : BaseFragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    lateinit var galleryFragmentMainViewModel: MainViewModel

    @Suppress("DEPRECATION")
    lateinit var simpleGallery: Gallery
    private lateinit var customGalleryAdapter: CustomGalleryAdapter
    lateinit var selectedImageView: ImageView

    private var images = intArrayOf(
        R.drawable.gall_1,
        R.drawable.gall_2,
        R.drawable.gall_3,
        R.drawable.gall_4,
        R.drawable.gall_5,
        R.drawable.gall_6,
        R.drawable.gall_7,
        R.drawable.gall_8,
        R.drawable.gall_9,
        R.drawable.gall_10,
        R.drawable.gall_11,
        R.drawable.gall_12,
        R.drawable.gall_13,
        R.drawable.gall_14,
        R.drawable.gall_15,
        R.drawable.gall_16,
        R.drawable.gall_17,
        R.drawable.gall_18
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        galleryViewModel = viewModelProvider()
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)

        simpleGallery = root.findViewById(R.id.gallery) as Gallery
        selectedImageView = root.findViewById<ImageView>(R.id.selected_image)

        customGalleryAdapter = CustomGalleryAdapter(images, context)
        simpleGallery.adapter = customGalleryAdapter
        simpleGallery.setSpacing(10)
        simpleGallery.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            selectedImageView.setImageResource(images[position])
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        galleryFragmentMainViewModel = activityViewModelProvider()
    }
}