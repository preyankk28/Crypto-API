package com.innovations.cryptotask;

import android.os.Parcel;
import android.os.Parcelable;

public class IntentData  implements Parcelable {
    String symbol, rank , name , changepercentinlast24;
   String id;
    public IntentData() {
    }


    protected IntentData(Parcel in) {
        name = in.readString();
        symbol = in.readString();
        rank= in.readString();
        changepercentinlast24 = in.readString();
        id = in.readString();

    }

    public static final Creator<IntentData> CREATOR = new Creator<IntentData>() {
        @Override
        public IntentData createFromParcel(Parcel in) {
            return new IntentData(in);
        }

        @Override
        public IntentData[] newArray(int size) {
            return new IntentData[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(changepercentinlast24);
        dest.writeString(symbol);
        dest.writeString(changepercentinlast24);
        dest.writeString(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getChangepercentinlast24() {
        return changepercentinlast24;
    }

    public void setChangepercentinlast24(String changepercentinlast24) {
        this.changepercentinlast24 = changepercentinlast24;
    }

    public static Creator<IntentData> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
