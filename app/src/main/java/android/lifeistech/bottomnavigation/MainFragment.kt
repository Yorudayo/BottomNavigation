package android.lifeistech.bottomnavigation

import android.content.Intent
import android.lifeistech.bottomnavigation.databinding.ActivityWriteBinding
import android.lifeistech.bottomnavigation.databinding.FragmentMainBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

//    private var binding: FragmentMainBinding? = null
//    private val binding get() = binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_main, container, false)

//        binding = FragmentMainBinding.inflate(inflater, container, false)
//        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskAdapter = TaskAdapter()
        val linearLayoutManager = LinearLayoutManager(view.context)
        RecyclerView.layoutManager = linearLayoutManager
        RecyclerView.adapter = taskAdapter

        fab.setOnClickListener{
            val intent = Intent(getActivity(),WriteActivity::class.java)
            startActivity(intent)
        }
    }
}