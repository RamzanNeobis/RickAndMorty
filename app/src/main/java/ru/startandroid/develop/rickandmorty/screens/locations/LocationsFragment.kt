package ru.startandroid.develop.rickandmorty.screens.locations

import android.os.Bundle
import android.view.*
import android.view.View.GONE
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.startandroid.develop.rickandmorty.R
import ru.startandroid.develop.rickandmorty.api.models.locations.InfoLocations
import ru.startandroid.develop.rickandmorty.api.models.locations.LocationModel
import ru.startandroid.develop.rickandmorty.databinding.FragmentLocationsBinding
import ru.startandroid.develop.rickandmorty.utils.showToast
import java.util.Observer


class LocationsFragment : Fragment() {

    private var _bindging: FragmentLocationsBinding? = null
    private val mBinding get() = _bindging!!
    private lateinit var mViewModel: LocationFragmentViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: LocationsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bindging = FragmentLocationsBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_and_filter_menu, menu)
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }


    private fun initialization() {
        mAdapter = LocationsAdapter()
        mRecyclerView = mBinding.recyclerView
        mRecyclerView.adapter = mAdapter

        setHasOptionsMenu(true)
        mViewModel = ViewModelProvider(this).get(LocationFragmentViewModel::class.java)
        mViewModel.getLocationListObserver()
            .observe(this, androidx.lifecycle.Observer<InfoLocations> {
                if (it != null) {
                    mBinding.progressBar.visibility = GONE
                    mAdapter.setList(it.results)
                } else {
                    showToast("Error in getting data")
                }
            })
        mViewModel.makeApiCall()
    }
}