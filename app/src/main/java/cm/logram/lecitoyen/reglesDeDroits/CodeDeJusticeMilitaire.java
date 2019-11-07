package cm.logram.lecitoyen.reglesDeDroits;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.logram.lecitoyen.MainActivity;
import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.adapter.AdapterCodeDeJusticeMilitaire;
import cm.logram.lecitoyen.adapter.AdapterCodeDeJusticeMilitaire.ClickListener;
import cm.logram.lecitoyen.favoris.FavorisCodeDeJusticeMilitaire;
import cm.logram.lecitoyen.model.Data;

@SuppressLint("NewApi")
public class CodeDeJusticeMilitaire extends AppCompatActivity implements ClickListener,View.OnClickListener, SearchView.OnQueryTextListener {

  private Toolbar toolbar;
  private FloatingActionButton floatingActionButton;
  private RecyclerView mRecyclerView;
  private AdapterCodeDeJusticeMilitaire mRecyclerAdapter;
  private List<Data> list;
  private SharedPreferences mSharedPreferences;
  private String searchString = "";
  private SearchView searchView;
  private TextView textView;
  private AdView mAdView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_code_de_justice_militaire);

    mSharedPreferences = getSharedPreferences("spWords", 0);

    toolbar = findViewById(R.id.toolbar);
    toolbar.setTitle("");
    setSupportActionBar(toolbar);

    textView = findViewById(R.id.en_tête);
    floatingActionButton = findViewById(R.id.fab);
    floatingActionButton.setOnClickListener(this);

    list = new ArrayList<>();
    mRecyclerView = findViewById(R.id.recyclerViewMain);
    mRecyclerAdapter = new AdapterCodeDeJusticeMilitaire(getApplicationContext(), list);
    mRecyclerView.setHasFixedSize(true);
    mRecyclerAdapter.setListener(this);
    mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    mRecyclerView.setAdapter(mRecyclerAdapter);

    /*Cache le bouton flottant lors du scroll*/
    mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
      @Override
      public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        if (dy > 0 && floatingActionButton.isShown()) {
          floatingActionButton.hide();
        } else if (dy < 0 && floatingActionButton.getVisibility() != View.VISIBLE) {
          floatingActionButton.show();
        }
      }
    });
    prepareWordsList();

    MobileAds.initialize(this, getString(R.string.admob_banner_id));
    mAdView = findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.fab:
        Intent favList = new Intent(this, FavorisCodeDeJusticeMilitaire.class);
        startActivity(favList);
        break;
    }
  }

  @Override
  public void itemClicked(View view, int position) {
  }

  private void prepareWordsList() {

    String titre1cjm = getText(R.string.titre1cjm).toString();
    String titre2cjm = getText(R.string.titre2cjm).toString();
    String titre3cjm = getText(R.string.titre3cjm).toString();
    String titre4cjm = getText(R.string.titre4cjm).toString();
    String titre5cjm = getText(R.string.titre5cjm).toString();
    String titre6cjm = getText(R.string.titre6cjm).toString();
    String titre7cjm = getText(R.string.titre7cjm).toString();
    String titre8cjm = getText(R.string.titre8cjm).toString();
    String titre9cjm = getText(R.string.titre9cjm).toString();
    String titre10cjm = getText(R.string.titre10cjm).toString();
    String titre11cjm = getText(R.string.titre11cjm).toString();
    String titre12cjm = getText(R.string.titre12cjm).toString();
    String titre13cjm = getText(R.string.titre13cjm).toString();
    String titre14cjm = getText(R.string.titre14cjm).toString();
    String titre15cjm = getText(R.string.titre15cjm).toString();
    String titre16cjm = getText(R.string.titre16cjm).toString();

    final String article1 = getText(R.string.article1cjm).toString();
    final String article2 = getText(R.string.article2cjm).toString();
    final String article3 = getText(R.string.article3cjm).toString();
    String article4 = getText(R.string.article4cjm).toString();
    String article5 = getText(R.string.article5cjm).toString();
    String article6 = getText(R.string.article6cjm).toString();
    String article7 = getText(R.string.article7cjm).toString();
    String article8 = getText(R.string.article8cjm).toString();
    String article9 = getText(R.string.article9cjm).toString();
    String article10 = getText(R.string.article10cjm).toString();
    String article11 = getText(R.string.article11cjm).toString();
    String article12 = getText(R.string.article12cjm).toString();
    String article13 = getText(R.string.article13cjm).toString();
    String article14 = getText(R.string.article14cjm).toString();
    String article15 = getText(R.string.article15cjm).toString();
    String article16 = getText(R.string.article16cjm).toString();
    String article17 = getText(R.string.article17cjm).toString();
    String article18 = getText(R.string.article18cjm).toString();
    String article19 = getText(R.string.article19cjm).toString();
    String article20 = getText(R.string.article20cjm).toString();
    String article21 = getText(R.string.article21cjm).toString();
    String article22 = getText(R.string.article22cjm).toString();
    String article23 = getText(R.string.article23cjm).toString();
    String article24 = getText(R.string.article24cjm).toString();
    String article25 = getText(R.string.article25cjm).toString();
    String article26 = getText(R.string.article26cjm).toString();
    String article27 = getText(R.string.article27cjm).toString();
    String article28 = getText(R.string.article28cjm).toString();
    String article29 = getText(R.string.article29cjm).toString();
    String article30 = getText(R.string.article30cjm).toString();
    String article31 = getText(R.string.article31cjm).toString();
    String article32 = getText(R.string.article32cjm).toString();
    String article33 = getText(R.string.article33cjm).toString();
    String article34 = getText(R.string.article34cjm).toString();
    String article35 = getText(R.string.article35cjm).toString();
    String article36 = getText(R.string.article36cjm).toString();
    String article37 = getText(R.string.article37cjm).toString();
    String article38 = getText(R.string.article38cjm).toString();
    String article39 = getText(R.string.article39cjm).toString();
    String article40 = getText(R.string.article40cjm).toString();
    String article41 = getText(R.string.article41cjm).toString();
    String article42 = getText(R.string.article42cjm).toString();
    String article43 = getText(R.string.article43cjm).toString();
    String article44 = getText(R.string.article44cjm).toString();
    String article45 = getText(R.string.article45cjm).toString();
    String article46 = getText(R.string.article46cjm).toString();
    String article47 = getText(R.string.article47cjm).toString();
    String article48 = getText(R.string.article48cjm).toString();
    String article49 = getText(R.string.article49cjm).toString();
    String article50 = getText(R.string.article50cjm).toString();
    String article51 = getText(R.string.article51cjm).toString();
    String article52 = getText(R.string.article52cjm).toString();
    String article53 = getText(R.string.article53cjm).toString();
    String article54 = getText(R.string.article54cjm).toString();
    String article55 = getText(R.string.article55cjm).toString();
    String article56 = getText(R.string.article56cjm).toString();
    String article57 = getText(R.string.article57cjm).toString();
    String article58 = getText(R.string.article58cjm).toString();
    String article59 = getText(R.string.article59cjm).toString();
    String article60 = getText(R.string.article60cjm).toString();
    String article61 = getText(R.string.article61cjm).toString();
    String article62 = getText(R.string.article62cjm).toString();
    String article63 = getText(R.string.article63cjm).toString();
    String article64 = getText(R.string.article64cjm).toString();
    String article65 = getText(R.string.article65cjm).toString();
    String article66 = getText(R.string.article66cjm).toString();
    String article67 = getText(R.string.article67cjm).toString();
    String article68 = getText(R.string.article68cjm).toString();
    String article69 = getText(R.string.article69cjm).toString();
    String article70 = getText(R.string.article70cjm).toString();
    String article71 = getText(R.string.article71cjm).toString();

    Data data = new Data(titre1cjm, "Article 1", article1);
    list.add(data);
    data = new Data("", "Article 2", article2);
    list.add(data);
    data = new Data(titre2cjm, "Article 3", article3);
    list.add(data);
    data = new Data("", "Article 4", article4);
    list.add(data);
    data = new Data("", "Article 5", article5);
    list.add(data);
    data = new Data("", "Article 6", article6);
    list.add(data);
    data = new Data("", "Article 7", article7);
    list.add(data);
    data = new Data(titre3cjm, "Article 8", article8);
    list.add(data);
    data = new Data("", "Article 9", article9);
    list.add(data);
    data = new Data("", "Article 10", article10);
    list.add(data);
    data = new Data(titre4cjm, "Article 11", article11);
    list.add(data);
    data = new Data("", "Article 12", article12);
    list.add(data);
    data = new Data(titre5cjm, "Article 13", article13);
    list.add(data);
    data = new Data("", "Article 14", article14);
    list.add(data);
    data = new Data(titre6cjm, "Article 15", article15);
    list.add(data);
    data = new Data("", "Article 16", article16);
    list.add(data);
    data = new Data("", "Article 17", article17);
    list.add(data);
    data = new Data("", "Article 18", article18);
    list.add(data);
    data = new Data(titre7cjm, "Article 19", article19);
    list.add(data);
    data = new Data("", "Article 20", article20);
    list.add(data);
    data = new Data("", "Article 21", article21);
    list.add(data);
    data = new Data("", "Article 22", article22);
    list.add(data);
    data = new Data("", "Article 23", article23);
    list.add(data);
    data = new Data("", "Article 24", article24);
    list.add(data);
    data = new Data("", "Article 25", article25);
    list.add(data);
    data = new Data("", "Article 26", article26);
    list.add(data);
    data = new Data(titre8cjm, "Article 27", article27);
    list.add(data);
    data = new Data(titre9cjm, "Article 28", article28);
    list.add(data);
    data = new Data("", "Article 29", article29);
    list.add(data);
    data = new Data(titre10cjm, "Article 30", article30);
    list.add(data);
    data = new Data("", "Article 31", article31);
    list.add(data);
    data = new Data(titre11cjm, "Article 32", article32);
    list.add(data);
    data = new Data("", "Article 33", article33);
    list.add(data);
    data = new Data("", "Article 34", article34);
    list.add(data);
    data = new Data("", "Article 35", article35);
    list.add(data);
    data = new Data("", "Article 36", article36);
    list.add(data);
    data = new Data("", "Article 37", article37);
    list.add(data);
    data = new Data(titre12cjm, "Article 38", article38);
    list.add(data);
    data = new Data("", "Article 39", article39);
    list.add(data);
    data = new Data("", "Article 40", article40);
    list.add(data);
    data = new Data("", "Article 41", article41);
    list.add(data);
    data = new Data("", "Article 42", article42);
    list.add(data);
    data = new Data("", "Article 43", article43);
    list.add(data);
    data = new Data("", "Article 44", article44);
    list.add(data);
    data = new Data(titre13cjm, "Article 45", article45);
    list.add(data);
    data = new Data("", "Article 46", article46);
    list.add(data);
    data = new Data("", "Article 47", article47);
    list.add(data);
    data = new Data("", "Article 48", article48);
    list.add(data);
    data = new Data("", "Article 49", article49);
    list.add(data);
    data = new Data("", "Article 50", article50);
    list.add(data);
    data = new Data(titre14cjm, "Article 51", article51);
    list.add(data);
    data = new Data("", "Article 52", article52);
    list.add(data);
    data = new Data("", "Article 53", article53);
    list.add(data);
    data = new Data("", "Article 54", article54);
    list.add(data);
    data = new Data("", "Article 55", article55);
    list.add(data);
    data = new Data("", "Article 56", article56);
    list.add(data);
    data = new Data("", "Article 57", article57);
    list.add(data);
    data = new Data("", "Article 58", article58);
    list.add(data);
    data = new Data("", "Article 59", article59);
    list.add(data);
    data = new Data("", "Article 60", article60);
    list.add(data);
    data = new Data(titre15cjm, "Article 61", article61);
    list.add(data);
    data = new Data("", "Article 62", article62);
    list.add(data);
    data = new Data("", "Article 63", article63);
    list.add(data);
    data = new Data("", "Article 64", article64);
    list.add(data);
    data = new Data("", "Article 65", article65);
    list.add(data);
    data = new Data("", "Article 66", article66);
    list.add(data);
    data = new Data("", "Article 67", article67);
    list.add(data);
    data = new Data(titre16cjm, "Article 68", article68);
    list.add(data);
    data = new Data("", "Article 69", article69);
    list.add(data);
    data = new Data("", "Article 70", article70);
    list.add(data);
    data = new Data("", "Article 71", article71);
    list.add(data);
  }

  @Override
  public void onResume() {
    super.onResume();
    mRecyclerAdapter.setListener(this);
    mRecyclerView.setAdapter(mRecyclerAdapter);
  }

  @Override
  public boolean onQueryTextSubmit(String s) {
    return false;
  }

  @Override
  public boolean onQueryTextChange(String newText) {
    final List<Data> filteredModelList = filter(list, newText);
    if (filteredModelList.size() > 0) {
      mRecyclerAdapter.setFilter(filteredModelList);
      mRecyclerAdapter.updateList(filteredModelList, newText);
      return true;
    } else {
      Toast.makeText(CodeDeJusticeMilitaire.this, "Aucun Résultat", Toast.LENGTH_SHORT).show();
      return false;
    }
  }

  // Search Method
  private List<Data> filter(List<Data> models, String query) {
    query = query.toLowerCase();
    this.searchString = query;

    final List<Data> filteredModelList = new ArrayList<>();
    for (Data model : models) {
      final String text = model.getArticle().toLowerCase();
      final String text2 = model.getDescription().toLowerCase();
      if (text.contains(query)) {
        filteredModelList.add(model);
      } else if (text2.contains(query)) {
        filteredModelList.add(model);
      }
    }

    mRecyclerAdapter = new AdapterCodeDeJusticeMilitaire(getApplicationContext(), list);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(CodeDeJusticeMilitaire.this));
    mRecyclerView.setAdapter(mRecyclerAdapter);
    mRecyclerAdapter.notifyDataSetChanged();

    return filteredModelList;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_code_penale, menu);

    MenuItem searchitem = menu.findItem(R.id.action_search);

    searchView = (SearchView) MenuItemCompat.getActionView(searchitem);
    SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

    TextView searchText = searchView.findViewById(R.id.search_src_text);

    searchText.setTextColor(Color.parseColor("#FFFFFF"));
    searchText.setHintTextColor(Color.parseColor("#FFFFFF"));
    searchText.setHint("Recherche...");
    if (searchText.isShown()){
      textView.setVisibility(View.GONE);
    }
    searchView.setOnQueryTextListener(this);

    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onBackPressed() {
    View view = this.getCurrentFocus();
    if (view != null) {
      InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
      imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    if (!searchView.isIconified()) {
      searchView.setIconified(true);
    } else {
      startActivity(new Intent(CodeDeJusticeMilitaire.this, RegleDeDroit.class));
      overridePendingTransition(R.anim.anim3, R.anim.anim4);
      finish();
    }
  }
}