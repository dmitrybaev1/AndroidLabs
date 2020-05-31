package com.example.lab6;

import com.example.lab6.entities.PlaylistsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YouTubeService {
    @GET("playlists")
    Call<PlaylistsResponse> getPlaylists(@Query("part")String part,@Query("channelId")String channelId
            ,@Query("maxResults")int maxResults,@Query("key")String key);
}
