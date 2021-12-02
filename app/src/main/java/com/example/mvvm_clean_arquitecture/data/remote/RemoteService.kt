package com.example.mvvm_clean_arquitecture.data.remote

import com.example.mvvm_clean_arquitecture.data.coresources.RetrofitHelper
import com.example.mvvm_clean_arquitecture.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/*Here is where RetrofitHelper and ApiClient make their work to realize the network calling*/

class RemoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getItems(): List<Item> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getAllItems()
            response.body() ?: emptyList()
        }
    }
}