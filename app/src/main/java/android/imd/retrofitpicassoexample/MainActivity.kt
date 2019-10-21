package android.imd.retrofitpicassoexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var retrofit: Retrofit? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        acessarFotos()
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun acessarFotos() {
        val service = retrofit?.create(FotoService::class.java)
        val call = service?.recuperarFotos()

        call?.enqueue(object : Callback<List<Foto>>{
            override fun onFailure(call: Call<List<Foto>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<Foto>>, response: Response<List<Foto>>) {
                var listaFotos: List<Foto>? = null

                if(response.isSuccessful){
                    listaFotos = response.body()
                    val adapter = FotoAdapter(listaFotos!!)
                    recyclerView.adapter = adapter
                }
            }

        })
    }
}
