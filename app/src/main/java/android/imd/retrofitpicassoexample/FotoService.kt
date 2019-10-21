package android.imd.retrofitpicassoexample

import retrofit2.Call
import retrofit2.http.GET

interface FotoService {

    @GET("/photos")
    fun recuperarFotos(): Call<List<Foto>>
}