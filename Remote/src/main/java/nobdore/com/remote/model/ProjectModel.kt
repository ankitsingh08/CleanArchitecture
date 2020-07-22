package nobdore.com.remote.model

import com.google.gson.annotations.SerializedName
import nobdore.com.remote.model.OwnerModel

/**
 * Created by AnkitSingh on 7/11/20.
 */
class ProjectModel(val id: String, val name: String,
                   @SerializedName("full_name") val fullName: String,
                   @SerializedName("stargazers_count") val starCount: Int,
                   @SerializedName("created_at") val dateCreated: String,
                   val owner: OwnerModel
)