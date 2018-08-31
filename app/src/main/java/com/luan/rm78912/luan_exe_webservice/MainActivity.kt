package com.luan.rm78912.luan_exe_webservice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import com.luan.rm78912.luan_exe_webservice.api.GitHubService
import com.luan.rm78912.luan_exe_webservice.model.Usuario
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_login.setOnClickListener {
            val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            val service: GitHubService = retrofit.create(GitHubService::class.java)
            service.buscarUsuario(et_Login.text.toString())
                    .enqueue(object : Callback<Usuario> {
                        override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                            Toast.makeText(this@MainActivity,
                                    "Deum Ruim", Toast.LENGTH_SHORT).show()
                        }

                        override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {
                            val usuario: Usuario? = response?.body()

                            Picasso.get()
                                    .load(usuario?.avatarurl)
                                    .into(iv_imgUser)
                            tv_Nome.text = usuario?.nome


                        }
                    })


        }


    }
}
