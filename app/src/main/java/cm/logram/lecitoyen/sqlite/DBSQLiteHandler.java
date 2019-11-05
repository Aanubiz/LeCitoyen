package cm.logram.lecitoyen.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import cm.logram.lecitoyen.model.Data;

public class DBSQLiteHandler extends SQLiteOpenHelper {

	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "easyPronounce";
	private static final String TABLE_WORD = "words";
	private static final String KEY_ID = "id";
	private static final String TITRE = "titre";
	private static final String KEY_WORD = "word";
	private static final String KEY_POS = "partofspeech";
	Context context;

	public DBSQLiteHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;
	}

	//create table
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TABLE = "CREATE TABLE " + TABLE_WORD + "("
				+ KEY_ID + " INTEGER PRIMARY KEY,"
				+ TITRE + " TEXT,"
				+ KEY_WORD + " TEXT,"
				+ KEY_POS + " TEXT" + ")";
		db.execSQL(CREATE_TABLE);
	}

	//update table
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_WORD);
		onCreate(db);
	}
	
	//add data
	public void addWord(Data data){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues contentValues = new ContentValues();
		contentValues.put(TITRE, data.getTitre());
		contentValues.put(KEY_WORD, data.getArticle());
		contentValues.put(KEY_POS, data.getDescription());
		
		db.insert(TABLE_WORD,null,contentValues);
		db.close();		
	}
	
	//remove data
	public void removeWord(Data data){
		SQLiteDatabase db = this.getWritableDatabase();
		
		db.delete(TABLE_WORD, KEY_WORD + " = ?", new String[]{String.valueOf(data.getArticle())});
		db.close();
	}
	
	//getWord
	public Data getWord(Data data){
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor cursor = db.query(TABLE_WORD, new String[]{KEY_ID,TITRE,KEY_WORD,KEY_POS},KEY_ID + " = ?",
				new String[]{String.valueOf(data.getId())}, null,null,null,null);
		if(cursor!=null) 
			cursor.moveToFirst();
		
		Data dataFound = new Data(cursor.getString(1), cursor.getString(2), cursor.getString(3));
		
		return dataFound;
	}
	
	//getAllWords
	public ArrayList<Data> getWords(){
		List<Data> wordsList = new ArrayList<Data>();
		String query = "SELECT * FROM " + TABLE_WORD;
		
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		
		if(cursor.moveToFirst()){
			do{
				Data data = new Data(cursor.getString(1), cursor.getString(2), cursor.getString(3));
				wordsList.add(data);
			}while(cursor.moveToNext());
		}
		
		return (ArrayList<Data>) wordsList;
	}

}
