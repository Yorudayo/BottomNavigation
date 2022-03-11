package android.lifeistech.bottomnavigation

import android.content.Intent
import android.lifeistech.bottomnavigation.databinding.ActivityMainBinding
import android.lifeistech.bottomnavigation.databinding.ActivityWriteBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_write.*

class WriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        //setContentView(R.layout.activity_write)

        val db = Firebase.firestore

        val taskAdapter = TaskAdapter()
        //binding.RecyclerView.adapter = taskAdapter
        //binding.RecyclerView.layoutManager =
        //    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        db.collection(TASKS_PATH)
            .get()
            .addOnSuccessListener { tasks ->
                val taskList = ArrayList<Task>()
                tasks.forEach { taskList.add(it.toObject(Task::class.java)) }
                taskAdapter.submitList(taskList)
            }
            .addOnFailureListener { exception ->
                Log.d(READ_TAG, "Error getting documents:", exception)
            }

        binding.saveButton.setOnClickListener{
            val task = Task(
                title = binding.titleEditText.text.toString(),
                summarytext = binding.summaryEditText.text.toString(),
            )

            db.collection(TASKS_PATH)
                .add(task)
                .addOnSuccessListener { documentReference ->
                    Log.d(ADD_TAG,"DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener{ e ->
                    Log.w(ADD_TAG, "Error adding document", e)
                }
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
    companion object {
        private const val ADD_TAG = "add_task"
        private const val READ_TAG = "read_task"
        private const val TASKS_PATH = "tasks"
    }
}