package rahul18178.iiitd.ac.in.final_compile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME =  "Student.db";
    public static final String TABLE_NAME =  "student_table";
    public static final String COL_0 =  "ID";
    public static final String COL_1 =  "NAME";
    public static final String COL_2 =  "MARKS";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    { // creates table with id as primary key and id as auto incremental
        db.execSQL("create table "+TABLE_NAME+" ("+COL_0+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_1+" TEXT,"+COL_2+" INTEGER)");
//      db.execSQL("create table"+TABLE_NAME+" ID INTEGER");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {// Creates
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name, String marks)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, name);
        contentValues.put(COL_2, marks);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
        {
            return false ;
        }
        else
        {
            return true ;
        }

    }
    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME, null);
        return res;
    }
    public boolean updateData(String id, String name, String marks)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_0, id);
        contentValues.put(COL_1, name);
        contentValues.put(COL_2, marks);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[] {id} );
        return true;
    }
}
