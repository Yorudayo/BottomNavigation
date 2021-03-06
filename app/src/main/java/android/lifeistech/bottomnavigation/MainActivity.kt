package android.lifeistech.bottomnavigation

import android.content.Intent
import android.lifeistech.bottomnavigation.databinding.ActivityMainBinding
import android.lifeistech.bottomnavigation.databinding.ActivityWriteBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment)
        setupWithNavController(bottom_navigation, navController)

        val db = Firebase.firestore

        val taskAdapter = TaskAdapter()

    }
    companion object {
        private const val ADD_TAG = "add_task"
        private const val READ_TAG = "read_task"
        private const val TASKS_PATH = "tasks"
    }
}

