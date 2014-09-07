package helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by VICTORIA on 06/09/2014.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    //el usuario no debe acceder por eso private
    //nuestr veersion lo guardamos como un valor

    private static final String LOG="DatebaseHelper";

    private static final int DATA_VERSION=1;

    private static final String DATABASE_NAME="GDGWOMEN";

   private static  final String TABLE_TODO ="usuarios";

    private static final String KEY_ID="user";
    private  static final String KEY_CREATED_AT="pass";


    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME ,null,DATA_VERSION);
    }

    //el tipo de dato de cada columna

    private static final String  CREATE_USUARIOS ="CREATE TABLE"+TABLE_TODO+"("+KEY_ID+ "TEXT,"+KEY_CREATED_AT+"TEXT"+")";

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_USUARIOS);
    }


     @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion , int newVersion){

         db.execSQL("DROP TABLE IF EXITS"+ CREATE_USUARIOS);
         onCreate(db);
     }

    public int getTODO(String user , String pass){
        SQLiteDatabase db =this.getReadableDatabase();
        String selectQuery ="SELECT * FROM "+TABLE_TODO+"WHERE"+ KEY_ID+"='"+user+"'"+"AND"+KEY_CREATED_AT+"='"+pass+"'";
        Log.e(LOG,selectQuery);
        Cursor c =db.rawQuery(selectQuery,null);
        int count=0;
        if (c!=null){
            count=c.getCount();
        }
        c.close();
        return count;
       }







}
