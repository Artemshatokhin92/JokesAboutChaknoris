package com.shatokhin.jokesaboutchaknoris.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.shatokhin.jokesaboutchaknoris.R
import com.shatokhin.jokesaboutchaknoris.presentation.adapters.RvJokesAdapter

class JokesFragment : Fragment(R.layout.fragment_jokes) {

    companion object {
        const val TAG = "JokesFragment"
    }

    private val mainViewModel: MainViewModel by activityViewModels{ MainViewModelFactory() }
    private lateinit var rvJokes: RecyclerView
    private lateinit var rvJokesAdapter: RvJokesAdapter
    private lateinit var etNumberOfJokes: EditText
    private lateinit var btnReload: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        rvJokes = view.findViewById(R.id.rvJokes)
        etNumberOfJokes = view.findViewById(R.id.etNumberOfJokes)
        btnReload = view.findViewById(R.id.btnReload)

        initRecycleView()

        mainViewModel.listJokes.observe(viewLifecycleOwner, { listJokes ->
            rvJokesAdapter.setListJokes(listJokes)
        })

        btnReload.setOnClickListener{
            val numberOfJokes = etNumberOfJokes.text.toString().toInt()
            if (numberOfJokes > 0) mainViewModel.reload(numberOfJokes)
        }
    }

    private fun initRecycleView(){
        rvJokesAdapter = RvJokesAdapter()
        rvJokes.adapter = rvJokesAdapter
    }


}