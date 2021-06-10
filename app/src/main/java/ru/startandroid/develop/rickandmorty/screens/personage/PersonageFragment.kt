package ru.startandroid.develop.rickandmorty.screens.personage

import android.os.Bundle
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_personage.*
import ru.startandroid.develop.rickandmorty.R
import ru.startandroid.develop.rickandmorty.api.models.personage.InfoPersonage
import ru.startandroid.develop.rickandmorty.api.models.personage.PersonageModel
import ru.startandroid.develop.rickandmorty.databinding.FragmentPersonageBinding
import ru.startandroid.develop.rickandmorty.utils.showToast

class PersonageFragment : Fragment() {

    private var _binding: FragmentPersonageBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: PersonageFragmentViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: PersonageAdapter
    private lateinit var mObserverList: Observer<List<PersonageModel>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPersonageBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    private fun initialization(){
        mAdapter = PersonageAdapter()
        mRecyclerView = mBinding.recyclerView
        mRecyclerView.adapter = mAdapter

        setHasOptionsMenu(true)
        mViewModel = ViewModelProvider(this).get(PersonageFragmentViewModel::class.java)
        mViewModel.getPersonageListObserver().observe(this, Observer<InfoPersonage> {
            if (it != null){
                mBinding.progressBar.visibility = GONE
                mAdapter.setList(it.results)
            }else{
                showToast("Error in getting data")
            }
        })
        mViewModel.makeApiCall()


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_and_filter_menu, menu)
        val searchItem: MenuItem? = menu?.findItem(R.id.btn_search)

    }

    override fun onStart() {
        super.onStart()
        initialization()

    }


}