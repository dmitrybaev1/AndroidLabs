package com.example.lab6

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.entities.PlaylistsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Playlist1: Fragment() {
    lateinit var service: YouTubeService
    lateinit var recyclerView: RecyclerView
    lateinit var listAdapter: ListAdapter
    lateinit var progressBar: ProgressBar
    val playlistsNames: ArrayList<String> = ArrayList()
    val playlistsThumbnails: ArrayList<String> = ArrayList()
    val playlistsIds: ArrayList<String> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.playlist1,container,false)
        recyclerView = view.findViewById(R.id.recyclerview)
        progressBar = view.findViewById(R.id.progressBar)
        listAdapter = ListAdapter(playlistsNames,playlistsThumbnails,playlistsIds,activity as MainActivity)
        recyclerView.adapter = listAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        val retrofit = NetworkHandler.getRetrofit()
        service = retrofit.create(YouTubeService::class.java)
        service.getPlaylists("snippet",getString(R.string.channelid1),50,getString(R.string.key)).enqueue(object: Callback<PlaylistsResponse>{
            override fun onFailure(call: Call<PlaylistsResponse>, t: Throwable) {
                Toast.makeText(activity,t.message,Toast.LENGTH_LONG).show()
                Log.e("e",t.message)
            }

            override fun onResponse(
                call: Call<PlaylistsResponse>,
                response: Response<PlaylistsResponse>
            ) {
                val resp = response.body()
                val playlists = resp!!.items
                for (name in playlists) {
                    playlistsNames.add(name.snippet.title)
                    name.snippet.thumbnails.standard?.url?.let {
                        playlistsThumbnails.add(name.snippet.thumbnails.standard.url)
                    } ?: run {
                        playlistsThumbnails.add(name.snippet.thumbnails.high.url)
                    }
                    playlistsIds.add(name.id)
                }
                listAdapter.notifyDataSetChanged()
                progressBar.visibility = View.GONE
            }
        })
        return view
    }
    /*inner class MyTask: AsyncTask<String?, Unit, String?>() {
        override fun doInBackground(vararg params: String?): String? {
            var token = params[0]
            while (token != null) {
                val tokenResp = service.getPlaylistsWithPageToken(
                    "snippet",
                    getString(R.string.channelid1),
                    token,
                    getString(R.string.key)
                ).execute().body()
                val tokenPlaylists = tokenResp!!.items
                for (name in tokenPlaylists) {
                    playlistsNames.add(name.snippet.title)
                    name.snippet.thumbnails.standard?.url?.let {
                        playlistsThumbnails.add(name.snippet.thumbnails.standard.url)
                    } ?: run {
                        playlistsThumbnails.add(name.snippet.thumbnails.high.url)
                    }
                    playlistsIds.add(name.id)
                }
                listAdapter.notifyDataSetChanged()
                tokenResp.nextPageToken?.let {
                    token = it
                } ?: run {
                    token = null
                }
            }
            return token
        }

        override fun onPreExecute() {
            super.onPreExecute()
            // ...
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            listAdapter.notifyDataSetChanged()
        }
    }*/

}