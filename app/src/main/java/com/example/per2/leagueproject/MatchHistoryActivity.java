package com.example.per2.leagueproject;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MatchHistoryActivity extends AppCompatActivity {

    public List<History> listViewHistory;
    public String icon1;
    private TextView rank;
    private String reg;
    private TextView level;
    private TextView name;
    private String rank1;
    private String gameId;
    private ListView listHistory;
    private String accountId;
    private int number = 0;
    private String id;

    public static Drawable GetImage(Context c, String ImageName) {
        return c.getResources().getDrawable(c.getResources().getIdentifier(ImageName, "drawable", c.getPackageName()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_history_adapter);
        wireWidgets();
        populateListView();

        accountId = getIntent().getStringExtra(MainActivity.EXTRA_ACCOUNTID);
        level.setText("Level " + getIntent().getStringExtra(MainActivity.EXTRA_ACCOUNTLVL));
        name.setText(getIntent().getStringExtra(MainActivity.EXTRA_ACCOUNTNAME));
        reg = getIntent().getStringExtra(MainActivity.EXTRA_REGION);
        rankSearch(getIntent().getStringExtra(MainActivity.EXTRA_REGION), getIntent().getStringExtra(MainActivity.EXTRA_RANK));
        Log.i("www", getIntent().getStringExtra(MainActivity.EXTRA_RANK));
        Log.i("www", getIntent().getStringExtra(MainActivity.EXTRA_REGION));
        Log.i("test", getIntent().getStringExtra(MainActivity.EXTRA_ACCOUNTNAME));

        //GetImage(this.getBaseContext(),"teemo");
/*    listViewHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            public*/
        //Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/9.9.1/img/champion/Zoe.png").placeholder(R.drawable.placeholder).into(test);
    }

    private void populateListView() {
        {
            listViewHistory = new ArrayList<>();
            matchHistoryAdapter adapter = new matchHistoryAdapter(
                    MatchHistoryActivity.this,
                    R.layout.activity_match_histry,
                    listViewHistory);
            listHistory.setAdapter(adapter);
//            Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/9.9.1/img/champion/Zoe.png")
//                    .placeholder(R.drawable.teemo).resize(75,75).into(icon);
        }
    }

    public void rankSearch(String region, String Id) {
        String url = "https://" + region + ".api.riotgames.com/lol/league/v4/entries/by-summoner/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RankSearch service;
        service = retrofit.create(RankSearch.class);

        Call<LeagueEntry> rankSearch = service.searchByAccId(Id);

        rankSearch.enqueue(new Callback<LeagueEntry>() {
            @Override
            public void onResponse(Call<LeagueEntry> call, Response<LeagueEntry> response) {
                if (response.body() != null && response.body().getRank() != null) {
                    rank.setText(response.body().getTier() + " " + response.body().getRank());
                }
            }

            @Override
            public void onFailure(Call<LeagueEntry> call, Throwable t) {
                Log.d("ENQUEUE", "onFailure: " + t.getMessage());
                Toast.makeText(MatchHistoryActivity.this, "FAIL2", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void wireWidgets() {
        listHistory = findViewById(R.id.listView_history);
        rank = findViewById(R.id.textView_rank);
        level = findViewById(R.id.textView_level);
        name = findViewById(R.id.textView_name);
    }

}
