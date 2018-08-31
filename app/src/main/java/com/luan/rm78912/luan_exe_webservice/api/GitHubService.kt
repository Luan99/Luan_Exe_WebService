package com.luan.rm78912.luan_exe_webservice.api

import com.luan.rm78912.luan_exe_webservice.model.Usuario
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("/users/{username}")
    fun buscarUsuario(@Path("username") username:String): Call<Usuario>

}