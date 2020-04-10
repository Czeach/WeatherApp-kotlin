package com.example.android.weatherapp.ui.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.android.weatherapp.R
import com.example.android.weatherapp.data.OpenWeatherMapApiService
import com.example.android.weatherapp.databinding.CurrentFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher


class CurrentFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentFragment()
    }

    private lateinit var viewModel: CurrentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // instantiate view binding
        val binding = CurrentFragmentBinding.inflate(inflater)
        viewModel = ViewModelProviders.of(this).get(CurrentViewModel::class.java)

//        val futureDays = binding.futureDays
//        futureDays?.setOnClickListener {
//            findNavController().navigate(R.id.futureFragment, null)
//        }

        val apiService = OpenWeatherMapApiService()

        GlobalScope.launch(Dispatchers.Main) {
            val currentWeatherResponse = apiService.getCurrentWeather().await()
            binding.apiText.text = currentWeatherResponse.weather.toString()
        }

        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        // TODO: Use the ViewModel
//    }


}
