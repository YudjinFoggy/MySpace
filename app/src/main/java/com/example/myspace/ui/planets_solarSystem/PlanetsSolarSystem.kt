package com.example.myspace.ui.planets_solarSystem

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.myspace.MainViewModel
import com.example.myspace.R
import com.example.myspace.extensions.activityViewModelProvider
import com.example.myspace.extensions.viewModelProvider
import com.example.myspace.fragment.BaseFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog


class PlanetsSolarSystem : BaseFragment() {

    lateinit var solarSystemViewModel: PlanetsSolarSystemViewModel
    lateinit var solarSystemMainViewModel: MainViewModel
    lateinit var mercury: ImageButton
    lateinit var venus: ImageButton
    lateinit var earth: ImageButton
    lateinit var mars: ImageButton
    lateinit var jupiter: ImageButton
    lateinit var saturn: ImageButton
    lateinit var uranus: ImageButton
    lateinit var neptune: ImageButton
    lateinit var sun: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        solarSystemViewModel = viewModelProvider()

        val root = inflater.inflate(R.layout.fragment_planets_solar_system, container, false)
        mercury = root.findViewById(R.id.mercury)
        venus = root.findViewById(R.id.venus)
        earth = root.findViewById(R.id.earth)
        mars = root.findViewById(R.id.mars)
        jupiter = root.findViewById(R.id.jupiter)
        saturn = root.findViewById(R.id.saturn)
        uranus = root.findViewById(R.id.uranus)
        neptune = root.findViewById(R.id.neptune)
        sun = root.findViewById(R.id.sun)

        val planentsWithInfo = hashMapOf<ImageButton, Int>(
            mercury to R.drawable.mercury_info,
            venus to R.drawable.venus_info,
            earth to R.drawable.earth_info,
            mars to R.drawable.mars_info,
            jupiter to R.drawable.jupiter_info,
            saturn to R.drawable.saturn_info,
            uranus to R.drawable.uranus_info,
            neptune to R.drawable.neptune_info
        )
        scaler(sun)

        var duration = 10000L
        for (planet in (planentsWithInfo)) {
            rotater(planet.key, duration)
            duration += 1500
        }

        sun.setOnClickListener {
            getBottomSheetDialog(R.drawable.sun_info)
        }

        for (planet in planentsWithInfo) {
            planet.key.setOnClickListener {
                getBottomSheetDialog(planet.value)
            }
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        solarSystemMainViewModel = activityViewModelProvider()
    }

    @SuppressLint("InflateParams")
    private fun getBottomSheetDialog(drawable: Int) {

        val dialog = context?.let { it1 -> BottomSheetDialog(it1) }
        val view = layoutInflater.inflate(R.layout.bottom_sheet_modal, null)
        val infoSheet = view?.findViewById<ImageView>(R.id.id_planet_info_sheet)
        infoSheet?.setBackgroundResource(drawable)
        val btnClose = view.findViewById<Button>(R.id.id_btn_dismiss)

        btnClose.setOnClickListener {
            dialog?.dismiss()
        }
        BottomSheetBehavior.STATE_HALF_EXPANDED
        dialog?.setCancelable(false)
        dialog?.setContentView(view)
        dialog?.show()
    }

    private fun rotater(imageButton: ImageButton, duration: Long) {
        val animator = ObjectAnimator.ofFloat(imageButton, View.ROTATION, -360f, 0f)
        animator.duration = duration
        animator.repeatCount = 100
        animator.start()
    }

    private fun scaler(imageButton: ImageButton) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.3f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.3f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(imageButton, scaleX, scaleY)
        animator.duration = 10000
        animator.repeatCount = 100
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }
}