package com.example.advait.mycity; /**
 * Created by Advait on 4/30/2018.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME="demo";
    private static final int DB_VERSION=1;
    private static final String TABLE_NAME="user";
    private static final String ID_COL="id";
    private static final String NAME_COL="username";
    private static final String BG_COL="password";
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+TABLE_NAME+" ("+ID_COL+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME_COL+" TEXT,"+BG_COL+" TEXT)";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
// Create table again
        onCreate(db);
    }
    public void insertRecord(String name,String bg){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(NAME_COL,name);
        values.put(BG_COL,bg);
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public boolean exists(String name){
        String query="SELECT * FROM "+TABLE_NAME;
        boolean result=false;
        int count=0;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        cursor.moveToFirst();
        while(cursor.isAfterLast()==false){
            String a=cursor.getString(1);
            if(a.equals(name)) {
                count++;
            }
            cursor.moveToNext();
        }
        if(count!=0)
            result=true;
        db.close();
        return result;
    }

    public boolean getRecords(String name,String password){
        String query="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        cursor.moveToFirst();
        while(cursor.isAfterLast()==false){
            String a=cursor.getString(1);
            String b=cursor.getString(2);

            if(a.equals(name)) {
                if(b.equals(password))
                    return true;
            }
            cursor.moveToNext();
        }
        db.close();
        return false;
    }
    /*public String searchRecord(String name1) {
        String query="SELECT * FROM "+TABLE_NAME;
        String result="";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        cursor.moveToFirst();
        while(cursor.isAfterLast()==false){
            String a=cursor.getString(1);
            String b=cursor.getString(2);
            if(a.equals(name1)) {
                result += "\nName:\t" + a + "\nDepartment:\t" + b + "\n";
            }
            cursor.moveToNext();
        }
        db.close();
        return result;

    }*/
}

