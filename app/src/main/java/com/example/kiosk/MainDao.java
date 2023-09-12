package com.example.kiosk;

import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;
@Dao
public interface MainDao {
    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);

    @Delete
    void delete(MainData mainData);

    @Delete
    void reset(List<MainData> mainData);

    @Query("UPDATE table_name SET text = :sText WHERE ID = :sID")
    void update(int sID, String sText);

    @Query("SELECT * FROM table_name")
    List<MainData> getAll();

    @Query("UPDATE table_name SET time = :aaa Where id = :sID")
    void update2(int sID, String aaa);


    @Query("DELETE FROM table_name WHERE text IS NULL")
    void deleteNullNameData();

    @Query("SELECT id FROM table_name ORDER BY id DESC LIMIT 1")
    int getLastInsertedId();
}
