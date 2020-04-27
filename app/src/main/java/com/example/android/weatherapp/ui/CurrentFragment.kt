package com.example.android.weatherapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.android.weatherapp.R
import com.example.android.weatherapp.db.CurrentWeather
import com.example.android.weatherapp.network.Network
import com.example.android.weatherapp.viewModel.CurrentViewModel
import kotlinx.android.synthetic.main.current_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CurrentFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentFragment()
    }

    private val viewModel: CurrentViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProvider(this, CurrentViewModel.Factory(activity.application))
            .get(CurrentViewModel::class.java)
    }

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

        Network.weather.getWeather().enqueue(object : Callback<CurrentWeather?> {
            override fun onFailure(call: Call<CurrentWeather?>, t: Throwable) {
                testing.text = t.localizedMessage
            }

            override fun onResponse(
                call: Call<CurrentWeather?>,
                response: Response<CurrentWeather?>
            ) {
                testing.text = response.body().toString()
            }
        })

    }




}
