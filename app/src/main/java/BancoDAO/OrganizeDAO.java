package BancoDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import Modelo.Organize;

/**
 * Created by Aluno on 20/11/2017.
 */

public class OrganizeDAO {
    Context context;
    Banco dao;
    private static final String BANCONOME = "Organize";

    public OrganizeDAO(Context context) {
        this.context = context;
    }

    public void Insere(Organize organize){
        dao = new Banco(context);
        SQLiteDatabase db = dao.getWritableDatabase();
        ContentValues dados = PegaDados(organize);
    }
    private ContentValues PegaDados(Organize organize){
        ContentValues dados = new ContentValues();
        dados.put("titulo",organize.getTitulo());
        dados.put("texto",organize.getTexto());
        dados.put("Hora",organize.getHora());
        dados.put("Data",organize.getData());
        return dados;
    }
}
