package com.example.per2.leagueproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class matchHistoryAdapter extends ArrayAdapter<History> {

    public String mainchamp;
    public String spell1;
    public String spell2;
    public String item1;
    public String item2;
    public String item3;
    public String item4;
    public String item5;
    public String item6;
    public String trinket;
    public String team1;
    public String team2;
    public String team3;
    public String team4;
    public String team5;
    public String enemy1;
    public String enemy2;
    public String enemy3;
    public String enemy4;
    public String enemy5;
    private Context context;
    private int resource;
    private List<History> listViewHistory;

    public matchHistoryAdapter(@NonNull Context context, int resource, @NonNull List<History> listViewHistory) {
        super(context, resource, listViewHistory);
        this.context = context;
        this.resource = resource;
        this.listViewHistory = listViewHistory;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_match_histry, parent, false);
        }
        TextView textViewOutcome = convertView.findViewById(R.id.textView_outcome);
        TextView textViewKDA = convertView.findViewById(R.id.textView_kda);
        ImageView imageViewMainChamp = convertView.findViewById(R.id.imageView_mainchamp);
        ImageView imageViewSpell1 = convertView.findViewById(R.id.imageView_spell1);
        ImageView imageViewSpell2 = convertView.findViewById(R.id.imageView_spell2);
        ImageView imageViewteam1 = convertView.findViewById(R.id.imageView_team1);
        ImageView imageViewteam2 = convertView.findViewById(R.id.imageView_team2);
        ImageView imageViewteam3 = convertView.findViewById(R.id.imageView_team3);
        ImageView imageViewteam4 = convertView.findViewById(R.id.imageView_team4);
        ImageView imageViewteam5 = convertView.findViewById(R.id.imageView_team5);
        ImageView imageViewenemy1 = convertView.findViewById(R.id.imageView_enemy1);
        ImageView imageViewenemy2 = convertView.findViewById(R.id.imageView_enemy2);
        ImageView imageViewenemy3 = convertView.findViewById(R.id.imageView_enemy3);
        ImageView imageViewenemy4 = convertView.findViewById(R.id.imageView_enemy4);
        ImageView imageViewenemy5 = convertView.findViewById(R.id.imageView_enemy5);

        History currentHistory = listViewHistory.get(position);
        textViewOutcome.setText(currentHistory.getOutcome());
        textViewKDA.setText(currentHistory.getKda());
        Picasso.get().load(mainchamp).into(imageViewMainChamp);
        Picasso.get().load(spell1).into(imageViewSpell1);
        Picasso.get().load(spell2).into(imageViewSpell2);
        Picasso.get().load(team1).into(imageViewteam1);
        Picasso.get().load(team2).into(imageViewteam2);
        Picasso.get().load(team3).into(imageViewteam3);
        Picasso.get().load(team4).into(imageViewteam4);
        Picasso.get().load(team5).into(imageViewteam5);
        Picasso.get().load(enemy1).into(imageViewenemy1);
        Picasso.get().load(enemy2).into(imageViewenemy2);
        Picasso.get().load(enemy3).into(imageViewenemy3);
        Picasso.get().load(enemy4).into(imageViewenemy4);
        Picasso.get().load(enemy5).into(imageViewenemy5);

        return convertView;
    }
}
