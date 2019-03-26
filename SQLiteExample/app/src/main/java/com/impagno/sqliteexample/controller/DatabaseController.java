package com.impagno.sqliteexample.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.impagno.sqliteexample.DatabaseCreation;

public class DatabaseController {

    private SQLiteDatabase db;
    private DatabaseCreation banco;

    public DatabaseController(Context context){
        banco = new DatabaseCreation(context, null, null, 1);
    }

    public String insert(String titulo, String autor, String editora){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(DatabaseCreation.TITULO, titulo);
        valores.put(DatabaseCreation.AUTOR, autor);
        valores.put(DatabaseCreation.EDITORA, editora);

        resultado = db.insert(DatabaseCreation.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    public Cursor list(){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.TITULO};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
