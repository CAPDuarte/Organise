package BancoDAO;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aluno on 20/11/2017.
 */

public class Banco extends SQLiteOpenHelper {

    private static final String NOMEBANCO = "Organize";
    private static final int VERSAOBANCO = 1;
    private static final String TABLEORGANIZE =
            "CREATE TABLE organize(id INTEGER primary key," +
            "titulo TEXT," +
            "texto TEXT," +
            "data TEXT," +
            "hora TEXT))";

    public Banco(Context context){
        super(context, NOMEBANCO, null, VERSAOBANCO);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(TABLEORGANIZE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion){
        db.execSQL("DROP TABLE IF EXISTS organize;");

    }
}
