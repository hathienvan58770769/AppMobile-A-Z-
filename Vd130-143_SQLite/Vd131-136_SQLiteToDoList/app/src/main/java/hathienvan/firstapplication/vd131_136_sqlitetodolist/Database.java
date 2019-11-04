package hathienvan.firstapplication.vd131_136_sqlitetodolist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {

        super(context, name, factory, version);

    }
    //truy van khong tra ket qua : Create, insert, update, delete,..;
    public  void  QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();//doc va viet dl
        database.execSQL(sql);


    }
    //truy van co tra ket qua : select
    public Cursor GetDatabase(String sql){
        SQLiteDatabase database = getReadableDatabase();//doc dl chu ko viet dc dl
        return  database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
