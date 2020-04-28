package com.example.android.weatherapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android.weatherapp.R
import com.example.android.weatherapp.databinding.CurrentFragmentBinding
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

    // One way to delay creation of the viewModel until an appropriate lifecycle method is to use lazy.
    // This requires that viewModel not be referenced before onActivityCreated, which we do in this Fragment.
    private val viewModel: CurrentViewModel by lazy {
        ViewModelProvider(this, CurrentViewModel.Factory(activity!!.application))
            .get(CurrentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // instantiate view binding
        val binding: CurrentFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.current_fragment, container, false
        )

        binding.setLifecycleOwner(viewLifecycleOwner)

        binding.currentFragmentViewModel = viewModel
//        val futureDays = binding.futureDays
//        futureDays.setOnClickListener {
//            findNavController().navigate(R.id.futureFragment, null)
//        }



        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        Network.data.getWeather().enqueue(object : Callback<CurrentData?> {
//            override fun onFailure(call: Call<CurrentData?>, t: Throwable) {
//                testing.text = t.localizedMessage
//            }
//
//            override fun onResponse(
//                call: Call<CurrentData?>,
//                response: Response<CurrentData?>
//            ) {
//                testing.text = response.body().toString()
//            }
//        })

    }




}
