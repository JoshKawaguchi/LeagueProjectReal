package com.example.per2.leagueproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private Button search;
    private Spinner region;
    private String regionArray[];
    private ImageView test;
    public String reg;
    public String accId;
    public String gameId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regionArray = getResources().getStringArray(R.array.regions);
        wireWidgets();
        InputStream JSONFileInputStream = getResources().openRawResource(R.raw.champion);
        String sJSON = readTextFile(JSONFileInputStream);
        Gson gson = new Gson();
        // read your json file into an array of questions
        Champion champs = gson.fromJson(sJSON, Champion.class);
//        // convert your array to a list using the Arrays utility class
        List<Champ> champList = champs.getData();
        reg = champList.size() + "";
//        Test = new Quiz(questionList);
//
//        textViewQuestionNumber.setText(getString(R.string.quiz_QuizNumberQuestion) + Test.getCurrentQuestionDisplay() + getString(R.string.quiz_outOfTen));
//        textViewQuestion.setText(Test.getQuestions().get(0).getQuestion());
//        textViewScore.setText(Test.getScore() + " points out of " + Test.getQuestNum());
        //use
        //Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/9.9.1/img/champion/Zoe.png").placeholder(R.drawable.placeholder).into(test);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reg = regionArray[region.getSelectedItemPosition()].toLowerCase();
                //search(regionArray[region.getSelectedItemPosition()].toLowerCase(), "summoner",
                //        "summoners", "by-name", "getAccountId");
                searchMatchHistory("NA1", "snrqhdN_pW_jg3699jC-8yXX9VKB2PqYjJZV6ZNGuiDs_Q");
                searchIndMatch("NA1", gameId);
            }
        });
    }

    public void search(String region, String what, String type, String how, String WhatToGet) {
        String url = "https://" + region + ".api.riotgames.com/lol/" + what + "/v4/" + type + "/" + how + "/";
        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SummonerSearch service = retrofit2.create(SummonerSearch.class);

        Call<Summoner> summonerResponseCall = service.searchByName(name.getText().toString());

        summonerResponseCall.enqueue(new Callback<Summoner>() {
            @Override
            public void onResponse(Call<Summoner> call, Response<Summoner> response) {
                if (response.body() != null && !response.body().getAccountId().isEmpty()) {
                    accId = response.body().getAccountId();

                    //Toast.makeText(MainActivity.this, response.body().getAccountId(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "That name doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Summoner> call, Throwable t) {
                Log.d("ENQUEUE", "onFailure: " + t.getMessage());
                Toast.makeText(MainActivity.this, "FAIL1", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void searchMatchHistory(String region, String accId) {
        String url = "https://" + region + ".api.riotgames.com/lol/match/v4/matchlists/by-account/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MatchHistorySearch service = retrofit.create(MatchHistorySearch.class);

        Call<MatchHistory> matchHistoryResponseCall = service.searchById(accId);

        matchHistoryResponseCall.enqueue(new Callback<MatchHistory>() {
            @Override
            public void onResponse(Call<MatchHistory> call, Response<MatchHistory> response) {
                if (response.body() != null && response.body().getEndIndex() != 0) {
                    gameId = response.body().getMatches().get(0).getGameId() + "";
//                    Toast.makeText(MainActivity.this, gameId, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MatchHistory> call, Throwable t) {
                Log.d("ENQUEUE", "onFailure: " + t.getMessage());
                Toast.makeText(MainActivity.this, "FAIL2", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void searchIndMatch(String region, String gameId) {
        String url = "https://" + region + ".api.riotgames.com/lol/match/v4/matches/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MatchSearch service = retrofit.create(MatchSearch.class);

        Call<Match> MatchResponse = service.searchByMatch(gameId);

        MatchResponse.enqueue(new Callback<Match>() {
            @Override
            public void onResponse(Call<Match> call, Response<Match> response) {
                if(response.body().getQueueId() == 325 || response.body().getQueueId()== 400 || response.body().getQueueId() == 430 || response.body().getQueueId() == 420
                        || response.body().getQueueId() == 440 || response.body().getQueueId() == 450 || response.body().getQueueId() == 600
                        || response.body().getQueueId() == 700 || response.body().getQueueId() == 830 || response.body().getQueueId() == 840
                        || response.body().getQueueId() == 850) {
                    for(int i = 0;i<response.body().getParticipants().size();i++) {
                         String test = "" + response.body().getParticipants().get(i).getChampionId();
                         response.body().getParticipants().get(i).getTeamId();
                        Toast.makeText(MainActivity.this, test, Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Match> call, Throwable t) {
                Log.d("ENQUEUE", "onFailure: " + t.getMessage());
                Toast.makeText(MainActivity.this, "FAILdsfa", Toast.LENGTH_SHORT).show();
            }
        });
    }




    private void wireWidgets() {
        region = findViewById(R.id.spinner_MainActivity_region);
        name = findViewById(R.id.editText_MainActivity_Summoner);
        search = findViewById(R.id.button_MainActivity_Search);
        test = findViewById(R.id.imageView2);
    }

    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }
}
