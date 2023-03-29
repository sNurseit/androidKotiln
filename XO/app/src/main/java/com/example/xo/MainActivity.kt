package com.example.xo

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    var butName = "";
    var pValue = 0;
    fun onClickButKamen (view:View){
        var photo = findViewById<ImageView>(R.id.imageView)

        photo.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.kamen)
        )
        butName = "Rock";
        pValue = 0;
        calculate();
    }

    fun onClickButNozh (view:View){
        var photo = findViewById<ImageView>(R.id.imageView)

        photo.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.nozhnica)
        )
        butName = "Scissors";
        pValue = 1;
        calculate();
    }
    fun onClickButBumaga (view:View){
        var photo = findViewById<ImageView>(R.id.imageView)
        photo.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.bumaga)
        )
        butName = "Paper";
        pValue = 2;
        calculate();
    }

    fun calculate (){



        var comp =  Random.nextInt(0, 3);
        var photoS = findViewById<ImageView>(R.id.imageView2)
        var compPredict = findViewById<TextView>(R.id.textView5);
        var cScore1 = findViewById<TextView>(R.id.textView8)
        var pScore1 = findViewById<TextView>(R.id.textView7)

        var pScore = pScore1.text.toString().toInt()
        var cScore = cScore1.text.toString().toInt()

        if (comp == 0){
            compPredict.text = "Rock";
            photoS.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.kamen)
            )
        }
        else if (comp==1){
            compPredict.text = "Scissors";
            photoS.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.nozhnica)
            )
        }
        else if (comp==2){
            compPredict.text = "Paper";
            photoS.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.bumaga)
            )
        }

        if ((pValue == 0 && comp==1) || (pValue == 1 && comp==2) || (pValue == 2 && comp==0)){
            pScore+=1;
            pScore1.text = pScore.toString()
            MediaPlayer.create(this, R.raw.win).start()
        }
        else if ((comp == 0 && pValue==1) || (comp == 1 && pValue==2) || (comp == 2 && pValue==0)){
            cScore+=1;
            cScore1.text = cScore.toString()
            MediaPlayer.create(this, R.raw.lose).start()
        }
        else {
            MediaPlayer.create(this, R.raw.a670e35ba8da982).start()
        }
    }
    fun resetBut (view: View){
        var cScore1 = findViewById<TextView>(R.id.textView8)
        var pScore1 = findViewById<TextView>(R.id.textView7)
        cScore1.text = "0"
        pScore1.text = "0"
    }
}