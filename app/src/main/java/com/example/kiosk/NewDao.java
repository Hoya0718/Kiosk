package com.example.kiosk;

import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import static androidx.room.OnConflictStrategy.REPLACE;
@Dao
public interface NewDao {

    @Insert(onConflict = REPLACE)
    void insert(NewData newData);

    @Delete
    void reset(List<NewData> newData);
    @Delete
    void delete(NewData newData);

    @Query("UPDATE all_data SET text = :sText WHERE ID = :sID")
    void update(int sID, String sText);

    @Query("UPDATE all_data SET MD_id = :num WHERE text=:sText")
    void MD_id(int num, String sText);
    @Query("SELECT * FROM all_data")
    List<NewData>getAll();

}

