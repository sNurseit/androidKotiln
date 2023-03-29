package com.example.mediaproj

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mediaproj.databinding.ActivityContentBinding


@Suppress("DEPRECATION")
class ContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContentBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater);
        setContentView(binding.root);

        MediaPlayer.create(this, R.raw.firewall).start()

        val item = intent.getSerializableExtra("item") as? Music
        if (item != null) {
            binding.tvTitle.text = item.title
            binding.textView3.text = item.time
        }

    }

    override fun onBackPressed (){
        val intent = Intent(this, MainActivity::class.java)
    }

}





