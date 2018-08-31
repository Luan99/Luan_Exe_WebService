package com.luan.rm78912.luan_exe_webservice.model

import com.google.gson.annotations.SerializedName

data class Usuario(

        @SerializedName("name") val nome: String,
        @SerializedName("avatar_url") val avatarurl: String
)