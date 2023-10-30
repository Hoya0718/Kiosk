    package com.example.kiosk;

    import static androidx.room.OnConflictStrategy.REPLACE;

    import androidx.room.Dao;
    import androidx.room.Delete;
    import androidx.room.Insert;
    import androidx.room.Query;

    import java.util.List;
    @Dao
    public interface MainDao {
        @Insert(onConflict = REPLACE)
        long insert(MainData mainData);

        @Delete
        void delete(MainData mainData);

        @Query("DELETE FROM table_name WHERE text = :text")
        void deleteName(String text);


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
        @Query("UPDATE table_name SET userdate = :aaa Where id = :sID")
        void update5(int sID, String aaa);
        @Query("SELECT * FROM table_name WHERE text = :text")
        MainData getDataByText(String text);

        @Query("DELETE FROM table_name WHERE text IS NULL")
        void deleteNullNameData();

        @Query("SELECT id FROM table_name ORDER BY id DESC LIMIT 1")
        int getLastInsertedId();

        @Query("SELECT * FROM table_name WHERE time IS NOT NULL") // "your_table_name"을 실제 테이블 이름으로 변경
        List<MainData> getAllDataWithTime_1(); // YourEntity는 실제 엔터티 클래스로 변경
//        @Query("SELECT * FROM table_name WHERE detail IS NOT NULL") // "your_table_name"을 실제 테이블 이름으로 변경
//        List<MainData> getAllDataWithTime_2(); // YourEntity는 실제 엔터티 클래스로 변경
//        @Query("SELECT * FROM table_name WHERE credit IS NOT NULL") // "your_table_name"을 실제 테이블 이름으로 변경
//        List<MainData> getAllDataWithTime_3(); // YourEntity는 실제 엔터티 클래스로 변경

        @Query("SELECT * FROM table_name WHERE id = :id")
        MainData getMainDataById(int id);

        @Query("SELECT * FROM table_name")
        List<MainData> getAllMainData();

        @Query("SELECT DISTINCT text FROM table_name")
        List<String> getUserNames();

        @Query("SELECT id FROM table_name WHERE text = :text")
        int search_name(String text);

        @Query("SELECT userdate FROM table_name WHERE id = :id")
        String search_is(int id);

        @Query("SELECT * FROM table_name WHERE text = :searchText")
        List<MainData> getMatchingItems(String searchText);
    }
