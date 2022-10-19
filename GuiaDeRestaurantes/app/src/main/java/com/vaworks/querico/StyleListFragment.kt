package com.vaworks.querico

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vaworks.querico.R
import com.vaworks.querico.databinding.FragmentStyleListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [StyleListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StyleListFragment : Fragment() {
    private var _binding: FragmentStyleListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStyleListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager( context)
        recyclerView.adapter = StyleAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}