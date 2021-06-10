package ru.startandroid.develop.rickandmorty.screens.episodes

import android.os.Bundle
import android.view.*
import android.view.View.GONE
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.startandroid.develop.rickandmorty.R
import ru.startandroid.develop.rickandmorty.api.models.episodes.InfoEpisodes
import ru.startandroid.develop.rickandmorty.databinding.FragmentEpisodesBinding
import ru.startandroid.develop.rickandmorty.utils.showToast


class EpisodesFragment : Fragment() {

    private lateinit var _bindging: FragmentEpisodesBinding
    private val mBinding get() = _bindging!!
    private lateinit var mViewModel: EpisodeFragmentViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: EpisodeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bindging = FragmentEpisodesBinding.inflate(layoutInflater, container, false)
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
        mAdapter = EpisodeAdapter()
        mRecyclerView = mBinding.recyclerView
        mRecyclerView.adapter = mAdapter

        setHasOptionsMenu(true)
        mViewModel = ViewModelProvider(this).get(EpisodeFragmentViewModel::class.java)
        mViewModel.getLocationListObserver()
            .observe(this, androidx.lifecycle.Observer<InfoEpisodes> {
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