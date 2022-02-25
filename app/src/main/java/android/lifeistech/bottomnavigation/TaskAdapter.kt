package android.lifeistech.bottomnavigation

import android.lifeistech.bottomnavigation.databinding.TaskListItemBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class TaskAdapter : ListAdapter<Task, TaskViewHolder>(diffUtilItemCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = TaskListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class TaskViewHolder(
    private val binding: TaskListItemBinding
) : RecyclerView.ViewHolder(binding.root){
    fun bind(task: Task) {
        binding.titleText.text = task.title
        binding.summaryText.text = task.summarytext
        binding.timeText.text =
            SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.JAPANESE).format(task.createdAt)
    }
}

private val diffUtilItemCallback = object : DiffUtil.ItemCallback<Task>() {
    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id == newItem.id
    }
}