package nobdore.com.mobileui.view.bookmarked

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import nobdore.com.mobileui.R
import nobdore.com.mobileui.model.Project
import javax.inject.Inject

/**
 * Created by AnkitSingh on 7/12/20.
 */
class BookmarkedAdapter @Inject constructor(): RecyclerView.Adapter<BookmarkedAdapter.ViewHolder>() {

    var projects: List<Project> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_bookmarked_project, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return projects.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val project = projects[position]
        holder.ownerNameText.text = project.ownerName
        holder.projectNameText.text = project.fullName

        Glide.with(holder.itemView.context)
            .load(project.ownerAvatar)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.avatarImage)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var avatarImage: ImageView = view.findViewById(R.id.image_owner_avatar)
        var ownerNameText: TextView = view.findViewById(R.id.text_owner_name)
        var projectNameText: TextView = view.findViewById(R.id.text_project_name)
    }
}