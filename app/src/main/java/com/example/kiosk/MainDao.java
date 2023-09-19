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
        @Query("UPDATE table_name SET detail = :aaa Where id = :sID")
        void update3(int sID, String aaa);
        @Query("UPDATE table_name SET credit = :aaa Where id = :sID")
        void update4(int sID, String aaa);


        @Query("DELETE FROM table_name WHERE text IS NULL")
        void deleteNullNameData();

        @Query("SELECT id FROM table_name ORDER BY id DESC LIMIT 1")
        int getLastInsertedId();

        @Query("SELECT * FROM table_name WHERE time IS NOT NULL") // "your_table_name"을 실제 테이블 이름으로 변경
        List<MainData> getAllDataWithTime_1(); // YourEntity는 실제 엔터티 클래스로 변경
        @Query("SELECT * FROM table_name WHERE detail IS NOT NULL") // "your_table_name"을 실제 테이블 이름으로 변경
        List<MainData> getAllDataWithTime_2(); // YourEntity는 실제 엔터티 클래스로 변경
        @Query("SELECT * FROM table_name WHERE credit IS NOT NULL") // "your_table_name"을 실제 테이블 이름으로 변경
        List<MainData> getAllDataWithTime_3(); // YourEntity는 실제 엔터티 클래스로 변경

    }
