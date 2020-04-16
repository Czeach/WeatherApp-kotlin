package com.example.android.weatherapp.ui.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.weatherapp.R
import com.example.android.weatherapp.data.OpenWeatherMapApiService
//import com.example.android.weatherapp.databinding.CurrentFragmentBinding
import kotlinx.android.synthetic.main.current_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class CurrentFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentFragment()
    }

    private lateinit var viewModel: CurrentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.current_fragment, container, false)

        // instantiate view binding
//        val binding = CurrentFragmentBinding.inflate(inflater)


//        val futureDays = binding.futureDays
//        futureDays.setOnClickListener {
//            findNavController().navigate(R.id.futureFragment, null)
//        }


//        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(CurrentViewModel::class.java)

        val apiService = OpenWeatherMapApiService()
        GlobalScope.launch(Dispatchers.Main) {
            val currentWeather = apiService.getCurrentWeather().await()
            try{
                testing.text = currentWeather.weather.toString()
            }catch (e: Exception) {
                testing.text = "Failure: " + e.message
            }
        }
    }


}
