package com.example.mad255_weatherapp.api
import android.util.Log
import java.net.URL

class WeatherApi {
    private lateinit var response: String
    //api key stuff: this should be kept secret.
    private val apiKeyWeather = "1db914c623ec2e5caba5ddfe8e12b0de"

    fun callWeatherAPI(lat: String, lon: String): String? {
        Log.i("API_debug", "app: calling weatherApi from class.")

        //api call
        val apiUrl = "https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&units=imperial&appid=${apiKeyWeather}"
        val result = getResultFromAPI(apiUrl)
        return result
    }

    private fun getResultFromAPI(apiUrl:String): String? {
        Log.i("API_debug", "app: getting result from api")
        try {
            response = URL(apiUrl).readText(Charsets.UTF_8)
        } catch (error: java.lang.Exception) {
            Log.e("api error", "api error: $error")
            return null
        }
        Log.i("API_debug", "app: result success: $response")
        return response
    }
}