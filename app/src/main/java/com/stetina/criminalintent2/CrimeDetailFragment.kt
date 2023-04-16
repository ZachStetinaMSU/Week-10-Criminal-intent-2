package com.stetina.criminalintent2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.stetina.criminalintent2.databinding.FragmentCrimeDetailBinding
import java.util.*

class CrimeDetailFragment :Fragment() {

    private lateinit var crime:Crime
    private var _binding: FragmentCrimeDetailBinding? = null

    private val binding
        get() = checkNotNull(_binding){

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        crime = Crime(
            UUID.randomUUID(),
            title = "",
            date = Date(),
            isSolved = false

        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCrimeDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
        

}


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.apply { crimeTitle.doOnTextChanged {text,_,_,_ ->
                crime = crime.copy(title = text.toString())
        }

            crimeDate.apply {
                text = crimeDate.toString()
                isEnabled = false
            }
    }}

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

}
