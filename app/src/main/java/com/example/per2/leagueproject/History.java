package com.example.per2.leagueproject;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;


public class History implements Parcelable {
    @SuppressWarnings("unused")
    public static final Creator<History> CREATOR = new Creator<History>() {
        @Override
        public History createFromParcel(Parcel in) {
            return new History(in);
        }

        @Override
        public History[] newArray(int size) {
            return new History[size];
        }
    };
    public String outcome;
    public String kda;
    public Image spell1;
    public Image mainchamp;
    public Image spell2;
    public Image team1;
    public Image team2;
    public Image team3;
    public Image team4;
    public Image team5;
    public Image enemy1;
    public Image enemy2;
    public Image enemy3;
    public Image enemy4;
    public Image enemy5;

    public History() {
    }

    public History(String time, String outcome, String kda, Image mainchamp, Image spell1, Image spell2,
                   Image item1, Image item2, Image item3, Image item4, Image item5,
                   Image item6, Image trinket, Image team1, Image team2, Image team3,
                   Image team4, Image team5, Image enemy1, Image enemy2, Image enemy3,
                   Image enemy4, Image enemy5) {
        this.outcome = outcome;
        this.kda = kda;
        this.mainchamp = mainchamp;
        this.spell1 = spell1;
        this.spell2 = spell2;
        this.enemy1 = enemy1;
        this.enemy2 = enemy2;
        this.enemy3 = enemy3;
        this.enemy4 = enemy4;
        this.enemy5 = enemy5;
        this.team1 = team1;
        this.team2 = team2;
        this.team3 = team3;
        this.team4 = team4;
        this.team5 = team5;

    }

    protected History(Parcel in) {
        outcome = in.readString();
        kda = in.readString();
        mainchamp = (Image) in.readValue(Image.class.getClassLoader());
        spell1 = (Image) in.readValue(Image.class.getClassLoader());
        spell2 = (Image) in.readValue(Image.class.getClassLoader());
        team1 = (Image) in.readValue(Image.class.getClassLoader());
        team2 = (Image) in.readValue(Image.class.getClassLoader());
        team3 = (Image) in.readValue(Image.class.getClassLoader());
        team4 = (Image) in.readValue(Image.class.getClassLoader());
        team5 = (Image) in.readValue(Image.class.getClassLoader());
        enemy1 = (Image) in.readValue(Image.class.getClassLoader());
        enemy2 = (Image) in.readValue(Image.class.getClassLoader());
        enemy3 = (Image) in.readValue(Image.class.getClassLoader());
        enemy4 = (Image) in.readValue(Image.class.getClassLoader());
        enemy5 = (Image) in.readValue(Image.class.getClassLoader());
    }


    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getKda() {
        return kda;
    }

    public void setKda(String kda) {
        this.kda = kda;
    }

    public Image getMainchamp() {
        return mainchamp;
    }

    public void setMainchamp(Image mainchamp) {
        this.mainchamp = mainchamp;
    }

    public Image getSpell1() {
        return spell1;
    }

    public void setSpell1(Image spell1) {
        this.spell1 = spell1;
    }

    public Image getSpell2() {
        return spell2;
    }

    public void setSpell2(Image spell2) {
        this.spell2 = spell2;
    }


    public Image getTeam1() {
        return team1;
    }

    public void setTeam1(Image team1) {
        this.team1 = team1;
    }

    public Image getTeam2() {
        return team2;
    }

    public void setTeam2(Image team2) {
        this.team2 = team2;
    }

    public Image getTeam3() {
        return team3;
    }

    public void setTeam3(Image team3) {
        this.team3 = team3;
    }

    public Image getTeam4() {
        return team4;
    }

    public void setTeam4(Image team4) {
        this.team4 = team4;
    }

    public Image getTeam5() {
        return team5;
    }

    public void setTeam5(Image team5) {
        this.team5 = team5;
    }

    public Image getEnemy1() {
        return enemy1;
    }

    public void setEnemy1(Image enemy1) {
        this.enemy1 = enemy1;
    }

    public Image getEnemy2() {
        return enemy2;
    }

    public void setEnemy2(Image enemy2) {
        this.enemy2 = enemy2;
    }

    public Image getEnemy3() {
        return enemy3;
    }

    public void setEnemy3(Image enemy3) {
        this.enemy3 = enemy3;
    }

    public Image getEnemy4() {
        return enemy4;
    }

    public void setEnemy4(Image enemy4) {
        this.enemy4 = enemy4;
    }

    public Image getEnemy5() {
        return enemy5;
    }

    public void setEnemy5(Image enemy5) {
        this.enemy5 = enemy5;
    }

    @Override
    public String toString() {
        return "History{" +
                ", outcome='" + outcome + '\'' +
                ", kda='" + kda + '\'' +
                ", mainchamp='" + mainchamp + '\'' +
                ", spell1=" + spell1 +
                ", spell2=" + spell2 +
                ", team1=" + team1 +
                ", team2=" + team2 +
                ", team3=" + team3 +
                ", team4=" + team4 +
                ", team5=" + team5 +
                ", enemy1=" + enemy1 +
                ", enemy2=" + enemy2 +
                ", enemy3=" + enemy3 +
                ", enemy4=" + enemy4 +
                ", enemy5=" + enemy5 +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(outcome);
        dest.writeString(kda);
        dest.writeValue(mainchamp);
        dest.writeValue(spell1);
        dest.writeValue(spell2);
        dest.writeValue(team1);
        dest.writeValue(team2);
        dest.writeValue(team3);
        dest.writeValue(team4);
        dest.writeValue(team5);
        dest.writeValue(enemy1);
        dest.writeValue(enemy2);
        dest.writeValue(enemy3);
        dest.writeValue(enemy4);
        dest.writeValue(enemy5);
    }
}