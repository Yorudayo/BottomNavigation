package android.lifeistech.bottomnavigation

import android.app.PendingIntent.getActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_write.*

class WriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        saveButton.setOnClickListener{
            val intent = Intent(this,fragment_main::class.java)
            startActivity(intent)
        }
    }
}