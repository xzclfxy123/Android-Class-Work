package com.example.compose.volley_demo

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


fun volleyRequest(context: Context, cardNum: MutableState<String>, cardExp: MutableState<String>) {
    val queue = Volley.newRequestQueue(context)
    val url = "http://192.168.31.67:2434/credit_cards"
    var response: JSONObject
    val stringRequest = StringRequest(
        Request.Method.GET, url,
        {
            Log.d("Succes", "simpleRequest:${it}")
            response = JSONObject(it)

            cardNum.value = response.getString("credit_card_number")
            cardExp.value = response.getString("credit_card_expiry_date")
        }, {
            cardNum.apply { "0000-0000-0000-0000" }
            cardExp.apply { "9999-12-31" }
            Log.d("Error", "simpleRequest:${it}")
        }
    )
    queue.add(stringRequest)
}