import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.data.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val mAllCurrencies = MutableLiveData<AllCurrenciesModel>()

    fun getAllCurrencies() {
        ApiClient.getAllCurrencies().enqueue(object : Callback<AllCurrenciesModel> {
            override fun onFailure(call: Call<AllCurrenciesModel>?, t: Throwable?) {
                print(t?.message.toString())
            }
            override fun onResponse(
                call: Call<AllCurrenciesModel>?,
                response: Response<AllCurrenciesModel>?
            ) {
                mAllCurrencies.value = response!!.body()
            }
        })
    }


}