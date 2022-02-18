package android.lifeistech.bottomnavigation

import java.util.Date
import com.google.firebase.firestore.DocumentId

data class Task(
    @DocumentId
    val id: String = "",
    val title: String = "",
    val summarytext: String = "",
    var createdAt: Date = Date(System.currentTimeMillis()),
)
