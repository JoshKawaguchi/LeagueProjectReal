package com.example.per2.leagueproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MatchSearch {
    @GET("{gameId}?api_key=RGAPI-d111bafd-cc17-4242-abaf-ca15f06f284e")
    Call<Match> searchByMatch(@Path("gameId") String gameId);
}