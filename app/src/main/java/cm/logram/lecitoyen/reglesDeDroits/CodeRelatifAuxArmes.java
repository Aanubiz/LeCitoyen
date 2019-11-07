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
import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.adapter.AdapterCodeDeJusticeMilitaire.ClickListener;
import cm.logram.lecitoyen.adapter.AdapterCodeRelatifAuxArmes;
import cm.logram.lecitoyen.favoris.FavorisCodeRelatifAuxArmes;
import cm.logram.lecitoyen.model.Data;

@SuppressLint("NewApi")
public class CodeRelatifAuxArmes extends AppCompatActivity implements ClickListener,View.OnClickListener, SearchView.OnQueryTextListener {

  private Toolbar toolbar;
  private FloatingActionButton floatingActionButton;
  private RecyclerView mRecyclerView;
  private AdapterCodeRelatifAuxArmes mRecyclerAdapter;
  private List<Data> list;
  private SharedPreferences mSharedPreferences;
  private String searchString = "";
  private SearchView searchView;
  private TextView textView;
  private AdView mAdView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_code_relatif_aux_armes);

    mSharedPreferences = getSharedPreferences("spWords", 0);

    toolbar = findViewById(R.id.toolbar);
    toolbar.setTitle("");
    setSupportActionBar(toolbar);

    textView = findViewById(R.id.en_tête);
    floatingActionButton = findViewById(R.id.fab);
    floatingActionButton.setOnClickListener(this);

    list = new ArrayList<>();
    mRecyclerView = findViewById(R.id.recyclerViewMain);
    mRecyclerAdapter = new AdapterCodeRelatifAuxArmes(getApplicationContext(), list);
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
        Intent favList = new Intent(this, FavorisCodeRelatifAuxArmes.class);
        startActivity(favList);
        break;
    }
  }

  @Override
  public void itemClicked(View view, int position) {
  }

  private void prepareWordsList() {

    String titre1cra = getText(R.string.titre1cra).toString();
    String titre2cra = getText(R.string.titre2cra).toString();
    String titre3cra = getText(R.string.titre3cra).toString();
    String titre4cra = getText(R.string.titre4cra).toString();
    String titre5cra = getText(R.string.titre5cra).toString();
    String titre6cra = getText(R.string.titre6cra).toString();
    String titre7cra = getText(R.string.titre7cra).toString();
    String titre8cra = getText(R.string.titre8cra).toString();
    String titre9cra = getText(R.string.titre9cra).toString();
    String titre10cra = getText(R.string.titre10cra).toString();
    String titre11cra = getText(R.string.titre11cra).toString();
    String titre12cra = getText(R.string.titre12cra).toString();
    String titre13cra = getText(R.string.titre13cra).toString();
    String titre14cra = getText(R.string.titre14cra).toString();
    String titre15cra = getText(R.string.titre15cra).toString();
    String titre16cra = getText(R.string.titre16cra).toString();
    String titre17cra = getText(R.string.titre17cra).toString();
    String titre18cra = getText(R.string.titre18cra).toString();
    String titre19cra = getText(R.string.titre19cra).toString();


    String article1 = getText(R.string.article1cra).toString();
    String article2 = getText(R.string.article2cra).toString();
    String article3 = getText(R.string.article3cra).toString();
    String article4 = getText(R.string.article4cra).toString();
    String article5 = getText(R.string.article5cra).toString();
    String article6 = getText(R.string.article6cra).toString();
    String article7 = getText(R.string.article7cra).toString();
    String article8 = getText(R.string.article8cra).toString();
    String article9 = getText(R.string.article9cra).toString();
    String article10 = getText(R.string.article10cra).toString();
    String article11 = getText(R.string.article11cra).toString();
    String article12 = getText(R.string.article12cra).toString();
    String article13 = getText(R.string.article13cra).toString();
    String article14 = getText(R.string.article14cra).toString();
    String article15 = getText(R.string.article15cra).toString();
    String article16 = getText(R.string.article16cra).toString();
    String article17 = getText(R.string.article17cra).toString();
    String article18 = getText(R.string.article18cra).toString();
    String article19 = getText(R.string.article19cra).toString();
    String article20 = getText(R.string.article20cra).toString();
    String article21 = getText(R.string.article21cra).toString();
    String article22 = getText(R.string.article22cra).toString();
    String article23 = getText(R.string.article23cra).toString();
    String article24 = getText(R.string.article24cra).toString();
    String article25 = getText(R.string.article25cra).toString();
    String article26 = getText(R.string.article26cra).toString();
    String article27 = getText(R.string.article27cra).toString();
    String article28 = getText(R.string.article28cra).toString();
    String article29 = getText(R.string.article29cra).toString();
    String article30 = getText(R.string.article30cra).toString();
    String article31 = getText(R.string.article31cra).toString();
    String article32 = getText(R.string.article32cra).toString();
    String article33 = getText(R.string.article33cra).toString();
    String article34 = getText(R.string.article34cra).toString();
    String article35 = getText(R.string.article35cra).toString();
    String article36 = getText(R.string.article36cra).toString();
    String article37 = getText(R.string.article37cra).toString();
    String article38 = getText(R.string.article38cra).toString();
    String article39 = getText(R.string.article39cra).toString();
    String article40 = getText(R.string.article40cra).toString();
    String article41 = getText(R.string.article41cra).toString();
    String article42 = getText(R.string.article42cra).toString();
    String article43 = getText(R.string.article43cra).toString();
    String article44 = getText(R.string.article44cra).toString();
    String article45 = getText(R.string.article45cra).toString();
    String article46 = getText(R.string.article46cra).toString();
    String article47 = getText(R.string.article47cra).toString();
    String article48 = getText(R.string.article48cra).toString();
    String article49 = getText(R.string.article49cra).toString();
    String article50 = getText(R.string.article50cra).toString();
    String article51 = getText(R.string.article51cra).toString();
    String article52 = getText(R.string.article52cra).toString();
    String article53 = getText(R.string.article53cra).toString();
    String article54 = getText(R.string.article54cra).toString();
    String article55 = getText(R.string.article55cra).toString();
    String article56 = getText(R.string.article56cra).toString();
    String article57 = getText(R.string.article57cra).toString();
    String article58 = getText(R.string.article58cra).toString();
    String article59 = getText(R.string.article59cra).toString();
    String article60 = getText(R.string.article60cra).toString();
    String article61 = getText(R.string.article61cra).toString();
    String article62 = getText(R.string.article62cra).toString();
    String article63 = getText(R.string.article63cra).toString();
    String article64 = getText(R.string.article64cra).toString();
    String article65 = getText(R.string.article65cra).toString();
    String article66 = getText(R.string.article66cra).toString();
    String article67 = getText(R.string.article67cra).toString();
    String article68 = getText(R.string.article68cra).toString();
    String article69 = getText(R.string.article69cra).toString();
    String article70 = getText(R.string.article70cra).toString();
    String article71 = getText(R.string.article71cra).toString();
    String article72 = getText(R.string.article72cra).toString();
    String article73 = getText(R.string.article73cra).toString();
    String article74 = getText(R.string.article74cra).toString();
    String article75 = getText(R.string.article75cra).toString();
    String article76 = getText(R.string.article76cra).toString();
    String article77 = getText(R.string.article77cra).toString();
    String article78 = getText(R.string.article78cra).toString();
    String article79 = getText(R.string.article79cra).toString();
    String article80 = getText(R.string.article80cra).toString();
    String article81 = getText(R.string.article81cra).toString();
    String article82 = getText(R.string.article82cra).toString();
    String article83 = getText(R.string.article83cra).toString();


    Data data = new Data(titre1cra, "Article 1", article1);
    list.add(data);
    data = new Data(titre2cra, "Article 2", article2);
    list.add(data);
    data = new Data(titre3cra, "Article 3", article3);
    list.add(data);
    data = new Data("", "Article 4", article4);
    list.add(data);
    data = new Data("", "Article 5", article5);
    list.add(data);
    data = new Data(titre4cra, "Article 6", article6);
    list.add(data);
    data = new Data(titre5cra, "Article 7", article7);
    list.add(data);
    data = new Data("", "Article 8", article8);
    list.add(data);
    data = new Data("", "Article 9", article9);
    list.add(data);
    data = new Data(titre6cra, "Article 10", article10);
    list.add(data);
    data = new Data("", "Article 11", article11);
    list.add(data);
    data = new Data("", "Article 12", article12);
    list.add(data);
    data = new Data("", "Article 13", article13);
    list.add(data);
    data = new Data("", "Article 14", article14);
    list.add(data);
    data = new Data(titre7cra, "Article 15", article15);
    list.add(data);
    data = new Data(titre8cra, "Article 16", article16);
    list.add(data);
    data = new Data("", "Article 17", article17);
    list.add(data);
    data = new Data("", "Article 18", article18);
    list.add(data);
    data = new Data("", "Article 19", article19);
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
    data = new Data("", "Article 27", article27);
    list.add(data);
    data = new Data(titre9cra, "Article 28", article28);
    list.add(data);
    data = new Data("", "Article 29", article29);
    list.add(data);
    data = new Data("", "Article 30", article30);
    list.add(data);
    data = new Data(titre10cra, "Article 31", article31);
    list.add(data);
    data = new Data("", "Article 32", article32);
    list.add(data);
    data = new Data("", "Article 33", article33);
    list.add(data);
    data = new Data(titre11cra, "Article 34", article34);
    list.add(data);
    data = new Data("", "Article 35", article35);
    list.add(data);
    data = new Data("", "Article 36", article36);
    list.add(data);
    data = new Data("", "Article 37", article37);
    list.add(data);
    data = new Data("", "Article 38", article38);
    list.add(data);
    data = new Data(titre12cra, "Article 39", article39);
    list.add(data);
    data = new Data("", "Article 40", article40);
    list.add(data);
    data = new Data("", "Article 41", article41);
    list.add(data);
    data = new Data(titre13cra, "Article 42", article42);
    list.add(data);
    data = new Data("", "Article 43", article43);
    list.add(data);
    data = new Data("", "Article 44", article44);
    list.add(data);
    data = new Data("", "Article 45", article45);
    list.add(data);
    data = new Data("", "Article 46", article46);
    list.add(data);
    data = new Data("", "Article 47", article47);
    list.add(data);
    data = new Data("", "Article 48", article48);
    list.add(data);
    data = new Data(titre14cra, "Article 49", article49);
    list.add(data);
    data = new Data("", "Article 50", article50);
    list.add(data);
    data = new Data("", "Article 51", article51);
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
    data = new Data(titre15cra, "Article 58", article58);
    list.add(data);
    data = new Data("", "Article 59", article59);
    list.add(data);
    data = new Data("", "Article 60", article60);
    list.add(data);
    data = new Data("", "Article 61", article61);
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
    data = new Data("", "Article 68", article68);
    list.add(data);
    data = new Data(titre16cra, "Article 69", article69);
    list.add(data);
    data = new Data("", "Article 70", article70);
    list.add(data);
    data = new Data("", "Article 71", article71);
    list.add(data);
    data = new Data("", "Article 72", article72);
    list.add(data);
    data = new Data(titre17cra, "Article 73", article73);
    list.add(data);
    data = new Data("", "Article 74", article74);
    list.add(data);
    data = new Data("", "Article 75", article75);
    list.add(data);
    data = new Data("", "Article 76", article76);
    list.add(data);
    data = new Data(titre18cra, "Article 77", article77);
    list.add(data);
    data = new Data("", "Article 78", article78);
    list.add(data);
    data = new Data("", "Article 79", article79);
    list.add(data);
    data = new Data("", "Article 80", article80);
    list.add(data);
    data = new Data(titre19cra, "Article 81", article81);
    list.add(data);
    data = new Data("", "Article 82", article82);
    list.add(data);
    data = new Data("", "Article 83", article83);
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
      Toast.makeText(CodeRelatifAuxArmes.this, "Aucun Résultat", Toast.LENGTH_SHORT).show();
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

    mRecyclerAdapter = new AdapterCodeRelatifAuxArmes(getApplicationContext(), list);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(CodeRelatifAuxArmes.this));
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
      startActivity(new Intent(CodeRelatifAuxArmes.this, RegleDeDroit.class));
      overridePendingTransition(R.anim.anim3, R.anim.anim4);
      finish();
    }
  }
}