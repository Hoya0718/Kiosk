package com.example.kiosk;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "all_data")
public class NewData {

    @PrimaryKey(autoGenerate = true)
    private int id =0;
    private String text;
    private int MD_id;
    private int imageResId;
    private boolean isImageSelected;
    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public boolean isImageSelected() {
        return isImageSelected;
    }

    public void setImageSelected(boolean imageSelected) {
        isImageSelected = imageSelected;
    }

    public int getMD_id() {
        return MD_id;
    }

    public void setMD_id(int MD_id) {
        this.MD_id = MD_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}

