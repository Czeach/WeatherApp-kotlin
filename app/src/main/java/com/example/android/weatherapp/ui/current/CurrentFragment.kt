package com.example.android.weatherapp.ui.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.android.weatherapp.R
import com.example.android.weatherapp.data.response.ConnectionInterceptorImpl
import com.example.android.weatherapp.data.response.network.OpenWeatherMapApiService
import com.example.android.weatherapp.data.response.network.WeatherNetworkDataSourceImpl
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

        val apiService = OpenWeatherMapApiService(ConnectionInterceptorImpl(this.context!!))
        val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiService)

        weatherNetworkDataSource.downloadedCurrentWeather.observe(viewLifecycleOwner, Observer {
            testing.text = it.weather.toString()
        })

        GlobalScope.launch(Dispatchers.Main) {
            weatherNetworkDataSource.fetchCurrentWeather()
        }
    }


}
