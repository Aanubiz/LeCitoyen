package cm.logram.lecitoyen.favoris;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.logram.lecitoyen.MainActivity;
import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.adapter.AdapterCodeDeJusticeMilitaire.ClickListener;
import cm.logram.lecitoyen.adapter.AdapterFavorisCodeDuTravail;
import cm.logram.lecitoyen.model.Data;
import cm.logram.lecitoyen.sqlite.DBSQLiteHandlerCT;

public class FavorisCodeDuTravail extends AppCompatActivity implements ClickListener, AdapterFavorisCodeDuTravail.ClickListener {

	Toolbar toolbar;
	public List<Data> wordsListFavourite;
	AdapterFavorisCodeDuTravail mRecyclerAdapter;
	RecyclerView mRecyclerView;
	MainActivity mObject;
	SharedPreferences mSharedPreferences;
	SharedPreferences.Editor mEditor;
	DBSQLiteHandlerCT dbHandler;
	TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favoris_code_du_travail);
		
		mSharedPreferences = getSharedPreferences("spWords", 0);

		toolbar = findViewById(R.id.toolbar);
		toolbar.setTitle("");
		setSupportActionBar(toolbar);
		textView = findViewById(R.id.texte_vide);
		textView.setVisibility(View.GONE);

		dbHandler = new DBSQLiteHandlerCT(getApplicationContext());
		wordsListFavourite = dbHandler.getWords();

		if (wordsListFavourite == null) {
		  textView.setVisibility(View.VISIBLE);
		}else{
			if (wordsListFavourite.size() == 0) {
			  textView.setVisibility(View.VISIBLE);
			}

			mRecyclerView = findViewById(R.id.recyclerView);
			if (wordsListFavourite != null) {
				mRecyclerAdapter = new AdapterFavorisCodeDuTravail(getApplicationContext(), wordsListFavourite);
				
				mRecyclerView.setHasFixedSize(true);
				mRecyclerView.setItemAnimator(new DefaultItemAnimator());
				mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
				mRecyclerView.setAdapter(mRecyclerAdapter);
				mRecyclerAdapter.notifyDataSetChanged ();
				mRecyclerAdapter.setListener(this);
			}
		}		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void itemClicked(View view, final int position) {
	}	
}