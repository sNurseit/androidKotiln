package com.example.mediaproj
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mediaproj.databinding.MusicItemBinding

class MusicAdapter(val listener: Listener): RecyclerView.Adapter<MusicAdapter.MusicHolder>(){
    val musicList = ArrayList<Music>();
    class MusicHolder(item: View): RecyclerView.ViewHolder (item){
        val binding = MusicItemBinding.bind(item);
        fun bind(music: Music, listener: Listener) = with (binding){
            textView.text = music.inform
            tvTitle.text = music.title
            textView2.text = music.time
            itemView.setOnClickListener {
                listener.onClick(music)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.music_item, parent, false)
        return MusicHolder(view)
    }

    override fun getItemCount(): Int {
        return musicList.size
    }

    override fun onBindViewHolder(holder: MusicHolder, position: Int) {
        holder.bind(musicList[position], listener);
    }

    fun addMusic(music: Music){
        musicList.add(music);
        notifyDataSetChanged()
    }

    interface Listener{
        fun onClick(music: Music){

        }
    }
}