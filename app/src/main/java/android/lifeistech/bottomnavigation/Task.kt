package android.lifeistech.bottomnavigation

import java.util.Date


data class Task(
    @DocumentId
    val id: String = "",
    val title: String = "",
    val text: String = "",
    var createdAt: Date = Date(System.currentTimeMillis()),
)