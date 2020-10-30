package cm.logram.lecitoyen.favoris;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.logram.lecitoyen.MainActivity;
import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.adapter.AdapterCodeDeJusticeMilitaire.ClickListener;
import cm.logram.lecitoyen.adapter.AdapterFavorisCodeDeProcedurePenale;
import cm.logram.lecitoyen.model.Data;
import cm.logram.lecitoyen.reglesDeDroits.CodePenale;
import cm.logram.lecitoyen.sqlite.DBSQLiteHandlerCPP;

public class FavorisCodeDeProcedurePenale extends AppCompatActivity implements ClickListener, AdapterFavorisCodeDeProcedurePenale.ClickListener {

  private InterstitialAd interstitial;
	Toolbar toolbar;
	public List<Data> wordsListFavourite;
	AdapterFavorisCodeDeProcedurePenale mRecyclerAdapter;
	RecyclerView mRecyclerView;
	MainActivity mObject;
	SharedPreferences mSharedPreferences;
	SharedPreferences.Editor mEditor;
	DBSQLiteHandlerCPP dbHandler;
	TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favoris_code_de_procedure_penale);
		
		mSharedPreferences = getSharedPreferences("spWords", 0);
    AdRequest adRequest = new AdRequest.Builder().build();


    toolbar = findViewById(R.id.toolbar);
		toolbar.setTitle("");
		setSupportActionBar(toolbar);
		textView = findViewById(R.id.texte_vide);
		textView.setVisibility(View.GONE);

		dbHandler = new DBSQLiteHandlerCPP(getApplicationContext());
		wordsListFavourite = dbHandler.getWords();

		if (wordsListFavourite == null) {
		  textView.setVisibility(View.VISIBLE);
		}else{
			if (wordsListFavourite.size() == 0) {
			  textView.setVisibility(View.VISIBLE);
			}

			mRecyclerView = findViewById(R.id.recyclerView);
			if (wordsListFavourite != null) {
				mRecyclerAdapter = new AdapterFavorisCodeDeProcedurePenale(getApplicationContext(), wordsListFavourite);
				
				mRecyclerView.setHasFixedSize(true);
				mRecyclerView.setItemAnimator(new DefaultItemAnimator());
				mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
				mRecyclerView.setAdapter(mRecyclerAdapter);
				mRecyclerAdapter.notifyDataSetChanged ();
				mRecyclerAdapter.setListener(this);
			}
		}

		// Annonce intertitielle
		interstitial = new InterstitialAd(FavorisCodeDeProcedurePenale.this);
		interstitial.setAdUnitId(getString(R.string.ad_unit_id));

		interstitial.loadAd(adRequest);
		interstitial.setAdListener(new AdListener() {
			public void onAdLoaded() {
				displayInterstitial();
			}
		});
	}
  public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
    if (interstitial.isLoaded()) {
      interstitial.show();
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