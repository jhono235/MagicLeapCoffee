
package com.example.magicleapcoffee.data;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Coffee implements Parcelable {



    @SerializedName("last_updated_at")
    @Expose
    private String lastUpdatedAt="";
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    public static final Creator<Coffee> CREATOR = new Creator<Coffee>() {


        public Coffee createFromParcel(Parcel in) {
            return new Coffee(in);
        }


        public Coffee[] newArray(int size) {
            return new Coffee[size];
        }
    };

    protected Coffee(Parcel in) {
        this.lastUpdatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.desc = ((String) in.readValue((String.class.getClassLoader())));
        this.imageUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Coffee(){

    }

    public Coffee(String lastUpdatedAt, String desc, String imageUrl, String id, String name) {
        super();
        this.lastUpdatedAt = lastUpdatedAt;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.id = id;
        this.name = name;
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(lastUpdatedAt);
        parcel.writeString(desc);
        parcel.writeString(id);
        parcel.writeString(imageUrl);
        parcel.writeString(name);
    }


    public int describeContents() {
        return 0;
    }


}
