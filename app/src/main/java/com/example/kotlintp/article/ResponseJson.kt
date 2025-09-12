package com.example.kotlintp.article

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ResponseJson (var code: Int, var message: String, var data: List<Article>) {
}

@JsonClass(generateAdapter = true)
class ResponseJsonSingle (var code: Int, var message: String, var data: Article) {
}