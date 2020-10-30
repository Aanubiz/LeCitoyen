package cm.logram.lecitoyen.reglesDeDroits;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cm.logram.lecitoyen.adapter.AdapterRegleDeDroit;
import cm.logram.lecitoyen.items.MenuRegle;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cm.logram.lecitoyen.MainActivity;
import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.recyclerClick.RecycleClick;

public class RegleDeDroit extends AppCompatActivity {

  public static final int ITEMS_PER_AD = 5;
  private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/4177191030";
  private static final int CONTACTS = 0;
  private static final Random RANDOM = new Random();
  private List<Object> recyclerViewItems = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_regle_de_droit);

    RecyclerView recyclerView = findViewById(R.id.recycler);

    recyclerView.setHasFixedSize(true);

    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);

    addMenuItemsFromJson();
    addBannerAds();
    loadBannerAds();

    RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = new AdapterRegleDeDroit(this, recyclerViewItems);
    recyclerView.setAdapter(adapter);

    RecycleClick . addTo (recyclerView) . setOnItemClickListener ( new  RecycleClick. OnItemClickListener () {
      @Override
      public  void  onItemClicked ( RecyclerView  recyclerView , int  position , View v ) {
        if (position == 1) {
          startActivity(new Intent(RegleDeDroit.this, CodePenale.class));
        }else if (position==2){
          startActivity(new Intent(RegleDeDroit.this, CodeDeProcedurePenale.class));
        }else if (position==3){
          startActivity(new Intent(RegleDeDroit.this, CodeDuTravail.class));
        }else if (position==4){
          startActivity(new Intent(RegleDeDroit.this, CodeElectoral.class));
        }else if (position==6){
          startActivity(new Intent(RegleDeDroit.this, CodeDeJusticeMilitaire.class));
        }else if (position==7){
          startActivity(new Intent(RegleDeDroit.this, CodeRelatifAuxArmes.class));
        }
      }
    });
  }

  @Override
  protected void onResume() {
    for (Object item : recyclerViewItems) {
      if (item instanceof AdView) {
        AdView adView = (AdView) item;
        adView.resume();
      }
    }
    super.onResume();
  }

  @Override
  protected void onPause() {
    for (Object item : recyclerViewItems) {
      if (item instanceof AdView) {
        AdView adView = (AdView) item;
        adView.pause();
      }
    }
    super.onPause();
  }

  @Override
  protected void onDestroy() {
    for (Object item : recyclerViewItems) {
      if (item instanceof AdView) {
        AdView adView = (AdView) item;
        adView.destroy();
      }
    }
    super.onDestroy();
  }

  /**
   * Adds banner ads to the items list.
   */
  private void addBannerAds() {
    // Loop through the items array and place a new banner ad in every ith position in
    // the items List.
    for (int i = 0; i <= recyclerViewItems.size(); i += ITEMS_PER_AD) {
      final AdView adView = new AdView(RegleDeDroit.this);
      adView.setAdSize(AdSize.BANNER);
      adView.setAdUnitId(AD_UNIT_ID);
      recyclerViewItems.add(i, adView);
    }
  }

  /**
   * Sets up and loads the banner ads.
   */
  private void loadBannerAds() {
    // Load the first banner ad in the items list (subsequent ads will be loaded automatically
    // in sequence).
    loadBannerAd(0);
  }

  /**
   * Loads the banner ads in the items list.
   */
  private void loadBannerAd(final int index) {

    if (index >= recyclerViewItems.size()) {
      return;
    }

    Object item = recyclerViewItems.get(index);
    if (!(item instanceof AdView)) {
      throw new ClassCastException("Expected item at index " + index + " to be a banner ad"
              + " ad.");
    }

    final AdView adView = (AdView) item;

    // Set an AdListener on the AdView to wait for the previous banner ad
    // to finish loading before loading the next ad in the items list.
    adView.setAdListener(
            new AdListener() {
              @Override
              public void onAdLoaded() {
                super.onAdLoaded();
                // The previous banner ad loaded successfully, call this method again to
                // load the next ad in the items list.
                loadBannerAd(index + ITEMS_PER_AD);
              }

              @Override
              public void onAdFailedToLoad(LoadAdError loadAdError) {
                // The previous banner ad failed to load. Call this method again to load
                // the next ad in the items list.
                String error =
                        String.format(
                                "domain: %s, code: %d, message: %s",
                                loadAdError.getDomain(), loadAdError.getCode(), loadAdError.getMessage());
                Log.e(
                        "MainActivity",
                        "The previous banner ad failed to load with error: "
                                + error
                                + ". Attempting to"
                                + " load the next banner ad in the items list.");
                loadBannerAd(index + ITEMS_PER_AD);
              }
            });

    // Load the banner ad.
    adView.loadAd(new AdRequest.Builder().build());
  }

  /**
   * Adds {@link MenuRegle}'s from a JSON file.
   */
  private void addMenuItemsFromJson() {
    try {
      String jsonDataString = readJsonDataFromFile();
      JSONArray menuItemsJsonArray = new JSONArray(jsonDataString);

      for (int i = 0; i < menuItemsJsonArray.length(); ++i) {

        JSONObject menuItemObject = menuItemsJsonArray.getJSONObject(i);

        String titre = menuItemObject.getString("name");
        String image = menuItemObject.getString("photo");

        MenuRegle menuItem = new MenuRegle(titre, image);
        recyclerViewItems.add(menuItem);
      }
    } catch (IOException | JSONException exception) {
      Log.e(MainActivity.class.getName(), "Unable to parse JSON file.", exception);
    }
  }

  private String readJsonDataFromFile() throws IOException {

    InputStream inputStream = null;
    StringBuilder builder = new StringBuilder();

    try {
      String jsonDataString = null;
      inputStream = getResources().openRawResource(R.raw.menu_items_json);
      BufferedReader bufferedReader = new BufferedReader(
              new InputStreamReader(inputStream, "UTF-8"));
      while ((jsonDataString = bufferedReader.readLine()) != null) {
        builder.append(jsonDataString);
      }
    } finally {
      if (inputStream != null) {
        inputStream.close();
      }
    }

    return new String(builder);
  }
  public void onBackPressed() {
    startActivity(new Intent(RegleDeDroit.this, MainActivity.class));
    finish();
  }
}

