package android.lifeistech.bottomnavigation

import android.content.Intent
import android.lifeistech.bottomnavigation.databinding.ActivityMainBinding
import android.lifeistech.bottomnavigation.databinding.ActivityWriteBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_write.*

class WriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_write)
        setContentView(binding.root)

        val db = Firebase.firestore
        saveButton.setOnClickListener{
            val task = Task(
                title = binding.titleEditText.text.toString(),
                summarytext = binding.summaryEditText.toString(),
            )

            db.collection("tasks")
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
    }
}