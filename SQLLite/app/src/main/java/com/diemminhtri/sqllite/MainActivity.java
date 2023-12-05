package com.diemminhtri.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase bookDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tao moi database(Sach.db), co 1 bang Books
        bookDB = openOrCreateDatabase("Sach.db", MODE_PRIVATE, null);
        // thuc hien lenh tao bang
        String sqlTaoBang = "DROP TABLE IF EXISTS BOOKS";
        String sqlXoaBangNeuCo = "CREATE TABLE BOOKS(BookID integer PRIMARY KEY, BookName text, Page integer, Price Float, Description text);\n";
        bookDB.execSQL(sqlXoaBangNeuCo);
        bookDB.execSQL(sqlTaoBang);

        // thuc hien caca lenh chen du lieu
        String sqlThemDong = "INSERT INTO BOOK VALUES(1, 'Java', 100, 9.99, 'sách về java'),\n " +
                                                    "(2, 'Android', 320, 19.00, 'Android cơ bản'),\n";

        bookDB.execSQL(sqlThemDong);
        bookDB.close();

    }
}