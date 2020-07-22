package nobdore.com.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by AnkitSingh on 7/11/20.
 */
class OwnerModel(@SerializedName("login") val ownerName: String,
                 @SerializedName("avatar_url") val ownerAvatar: String)