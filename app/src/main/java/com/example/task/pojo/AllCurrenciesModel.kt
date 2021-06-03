
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AllCurrenciesModel {
    @SerializedName("success")
    @Expose
    var success: Boolean? = null

    @SerializedName("timestamp")
    @Expose
    var timestamp: Int? = null

    @SerializedName("base")
    @Expose
    var base: String? = null

    @SerializedName("date")
    @Expose
    var date: String? = null

    @SerializedName("rates")
    @Expose
    var rates: Map<String,String>?=null

}