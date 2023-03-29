package com.example.mediaproj

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediaproj.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), MusicAdapter.Listener {
    lateinit var binding: ActivityMainBinding;
    private val adapter = MusicAdapter(this);
    val id = 0;
    var dateFormat2=""
    private val MusicList = listOf(
        "America/New_York",
        "Europe/Paris",
        "Europe/Madrid",
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init();
    }
    fun getTimeInCity(city: String): String {
        val timeZone = TimeZone.getTimeZone(city)
        val dateFormat = SimpleDateFormat("HH:mm")
        dateFormat2 = SimpleDateFormat("dd").toString()
        dateFormat.timeZone = timeZone
        val currentTime = Date()
        return dateFormat.format(currentTime)
    }

    fun getCityName(cityString: String): String {
        return cityString.substringAfter("/")
    }


    val currentDate = Date()
    val dateFormat = SimpleDateFormat("dd", Locale.getDefault())
    val dateText = dateFormat.format(currentDate)


    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity , 1)
            rcView.adapter = adapter
            for (i in 0..MusicList.size-1){
                val time = getTimeInCity(MusicList[i]);
                val name  = getCityName(MusicList[i]);
                var str ="Today"
                if(dateFormat2 == dateText){
                    str ="Tomorrow";
                }

                val music = Music(i,name, time, str);
                adapter.addMusic(music);
            }
        }
    }

    override fun onClick(music: Music) {
            startActivity(Intent(this, ContentActivity::class.java).apply{
            putExtra("item",music);
       })
    }
}

