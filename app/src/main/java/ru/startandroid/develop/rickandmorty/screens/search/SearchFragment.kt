package ru.startandroid.develop.rickandmorty.screens.search

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.startandroid.develop.rickandmorty.R
import androidx.recyclerview.widget.RecyclerView
import ru.startandroid.develop.rickandmorty.api.models.personage.InfoPersonage
import ru.startandroid.develop.rickandmorty.databinding.FragmentSearchBinding
import ru.startandroid.develop.rickandmorty.screens.personage.PersonageFragmentViewModel
import ru.startandroid.develop.rickandmorty.utils.showToast

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: SearchFragmentViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: SearchAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }


    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        setHasOptionsMenu(true)
        mAdapter = SearchAdapter()
        mRecyclerView = mBinding.recyclerView
        mRecyclerView.adapter = mAdapter

        mViewModel = ViewModelProvider(this).get(SearchFragmentViewModel::class.java)
        mViewModel.getPersonageListObserver().observe(this, Observer<InfoPersonage>{
            if (it != null){
                mBinding.progressBar.visibility = View.GONE
                mAdapter.setList(it.results)
            }else{
                showToast("Error in getting data")
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search, menu)

        val search = menu.findItem(R.id.search)
        val searchView = search.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    mViewModel.makeApiCall(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}