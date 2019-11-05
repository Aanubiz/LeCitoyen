package cm.logram.lecitoyen.reglesDeDroits;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.adapter.AdapterCodeDeJusticeMilitaire.ClickListener;
import cm.logram.lecitoyen.adapter.AdapterCodeDuTravail;
import cm.logram.lecitoyen.favoris.FavorisCodeDuTravail;
import cm.logram.lecitoyen.model.Data;

@SuppressLint("NewApi")
public class CodeDuTravail extends AppCompatActivity implements ClickListener,View.OnClickListener, SearchView.OnQueryTextListener {

  private Toolbar toolbar;
  private FloatingActionButton floatingActionButton;
  private RecyclerView mRecyclerView;
  private AdapterCodeDuTravail mRecyclerAdapter;
  private List<Data> list;
  private SharedPreferences mSharedPreferences;
  private String searchString = "";
  private SearchView searchView;
  private TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_code_du_travail);

    mSharedPreferences = getSharedPreferences("spWords", 0);

    toolbar = findViewById(R.id.toolbar);
    toolbar.setTitle("");
    setSupportActionBar(toolbar);

    textView = findViewById(R.id.en_tête);
    floatingActionButton = findViewById(R.id.fab);
    floatingActionButton.setOnClickListener(this);

    list = new ArrayList<>();
    mRecyclerView = findViewById(R.id.recyclerViewMain);
    mRecyclerAdapter = new AdapterCodeDuTravail(getApplicationContext(), list);
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
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.fab:
        Intent favList = new Intent(this, FavorisCodeDuTravail.class);
        startActivity(favList);
        break;
    }
  }

  @Override
  public void itemClicked(View view, int position) {
  }

  private void prepareWordsList() {

    String titre1ct = getText(R.string.titre1ct).toString();
    String titre2ct = getText(R.string.titre2ct).toString();
    String titre3ct = getText(R.string.titre3ct).toString();
    String titre4ct = getText(R.string.titre4ct).toString();
    String titre5ct = getText(R.string.titre5ct).toString();
    String titre6ct = getText(R.string.titre6ct).toString();
    String titre7ct = getText(R.string.titre7ct).toString();
    String titre8ct = getText(R.string.titre8ct).toString();
    String titre9ct = getText(R.string.titre9ct).toString();
    String titre10ct = getText(R.string.titre10ct).toString();
    String titre11ct = getText(R.string.titre11ct).toString();
    String titre12ct = getText(R.string.titre12ct).toString();
    String titre13ct = getText(R.string.titre13ct).toString();
    String titre14ct = getText(R.string.titre14ct).toString();
    String titre15ct = getText(R.string.titre15ct).toString();
    String titre16ct = getText(R.string.titre16ct).toString();
    String titre17ct = getText(R.string.titre17ct).toString();
    String titre18ct = getText(R.string.titre18ct).toString();
    String titre19ct = getText(R.string.titre19ct).toString();
    String titre20ct = getText(R.string.titre20ct).toString();
    String titre21ct = getText(R.string.titre21ct).toString();
    String titre22ct = getText(R.string.titre22ct).toString();
    String titre23ct = getText(R.string.titre23ct).toString();
    String titre24ct = getText(R.string.titre24ct).toString();
    String titre25ct = getText(R.string.titre25ct).toString();
    String titre26ct = getText(R.string.titre26ct).toString();
    String titre27ct = getText(R.string.titre27ct).toString();
    String titre28ct = getText(R.string.titre28ct).toString();
    String titre29ct = getText(R.string.titre29ct).toString();
    String titre30ct = getText(R.string.titre30ct).toString();
    String titre31ct = getText(R.string.titre31ct).toString();
    String titre32ct = getText(R.string.titre32ct).toString();
    String titre33ct = getText(R.string.titre33ct).toString();
    String titre34ct = getText(R.string.titre34ct).toString();
    String titre35ct = getText(R.string.titre35ct).toString();
    String titre36ct = getText(R.string.titre36ct).toString();
    String titre37ct = getText(R.string.titre37ct).toString();
    String titre38ct = getText(R.string.titre38ct).toString();
    String titre39ct = getText(R.string.titre39ct).toString();
    String titre40ct = getText(R.string.titre40ct).toString();


    String article1 = getText(R.string.article1ct).toString();
    String article2 = getText(R.string.article2ct).toString();
    String article3 = getText(R.string.article3ct).toString();
    String article4 = getText(R.string.article4ct).toString();
    String article5 = getText(R.string.article5ct).toString();
    String article6 = getText(R.string.article6ct).toString();
    String article7 = getText(R.string.article7ct).toString();
    String article8 = getText(R.string.article8ct).toString();
    String article9 = getText(R.string.article9ct).toString();
    String article10 = getText(R.string.article10ct).toString();
    String article11 = getText(R.string.article11ct).toString();
    String article12 = getText(R.string.article12ct).toString();
    String article13 = getText(R.string.article13ct).toString();
    String article14 = getText(R.string.article14ct).toString();
    String article15 = getText(R.string.article15ct).toString();
    String article16 = getText(R.string.article16ct).toString();
    String article17 = getText(R.string.article17ct).toString();
    String article18 = getText(R.string.article18ct).toString();
    String article19 = getText(R.string.article19ct).toString();
    String article20 = getText(R.string.article20ct).toString();
    String article21 = getText(R.string.article21ct).toString();
    String article22 = getText(R.string.article22ct).toString();
    String article23 = getText(R.string.article23ct).toString();
    String article24 = getText(R.string.article24ct).toString();
    String article25 = getText(R.string.article25ct).toString();
    String article26 = getText(R.string.article26ct).toString();
    String article27 = getText(R.string.article27ct).toString();
    String article28 = getText(R.string.article28ct).toString();
    String article29 = getText(R.string.article29ct).toString();
    String article30 = getText(R.string.article30ct).toString();
    String article31 = getText(R.string.article31ct).toString();
    String article32 = getText(R.string.article32ct).toString();
    String article33 = getText(R.string.article33ct).toString();
    String article34 = getText(R.string.article34ct).toString();
    String article35 = getText(R.string.article35ct).toString();
    String article36 = getText(R.string.article36ct).toString();
    String article37 = getText(R.string.article37ct).toString();
    String article38 = getText(R.string.article38ct).toString();
    String article39 = getText(R.string.article39ct).toString();
    String article40 = getText(R.string.article40ct).toString();
    String article41 = getText(R.string.article41ct).toString();
    String article42 = getText(R.string.article42ct).toString();
    String article43 = getText(R.string.article43ct).toString();
    String article44 = getText(R.string.article44ct).toString();
    String article45 = getText(R.string.article45ct).toString();
    String article46 = getText(R.string.article46ct).toString();
    String article47 = getText(R.string.article47ct).toString();
    String article48 = getText(R.string.article48ct).toString();
    String article49 = getText(R.string.article49ct).toString();
    String article50 = getText(R.string.article50ct).toString();
    String article51 = getText(R.string.article51ct).toString();
    String article52 = getText(R.string.article52ct).toString();
    String article53 = getText(R.string.article53ct).toString();
    String article54 = getText(R.string.article54ct).toString();
    String article55 = getText(R.string.article55ct).toString();
    String article56 = getText(R.string.article56ct).toString();
    String article57 = getText(R.string.article57ct).toString();
    String article58 = getText(R.string.article58ct).toString();
    String article59 = getText(R.string.article59ct).toString();
    String article60 = getText(R.string.article60ct).toString();
    String article61 = getText(R.string.article61ct).toString();
    String article62 = getText(R.string.article62ct).toString();
    String article63 = getText(R.string.article63ct).toString();
    String article64 = getText(R.string.article64ct).toString();
    String article65 = getText(R.string.article65ct).toString();
    String article66 = getText(R.string.article66ct).toString();
    String article67 = getText(R.string.article67ct).toString();
    String article68 = getText(R.string.article68ct).toString();
    String article69 = getText(R.string.article69ct).toString();
    String article70 = getText(R.string.article70ct).toString();
    String article71 = getText(R.string.article71ct).toString();
    String article72 = getText(R.string.article72ct).toString();
    String article73 = getText(R.string.article73ct).toString();
    String article74 = getText(R.string.article74ct).toString();
    String article75 = getText(R.string.article75ct).toString();
    String article76 = getText(R.string.article76ct).toString();
    String article77 = getText(R.string.article77ct).toString();
    String article78 = getText(R.string.article78ct).toString();
    String article79 = getText(R.string.article79ct).toString();
    String article80 = getText(R.string.article80ct).toString();
    String article81 = getText(R.string.article81ct).toString();
    String article82 = getText(R.string.article82ct).toString();
    String article83 = getText(R.string.article83ct).toString();
    String article84 = getText(R.string.article84ct).toString();
    String article85 = getText(R.string.article85ct).toString();
    String article86 = getText(R.string.article86ct).toString();
    String article87 = getText(R.string.article87ct).toString();
    String article88 = getText(R.string.article88ct).toString();
    String article89 = getText(R.string.article89ct).toString();
    String article90 = getText(R.string.article90ct).toString();
    String article91 = getText(R.string.article91ct).toString();
    String article92 = getText(R.string.article92ct).toString();
    String article93 = getText(R.string.article93ct).toString();
    String article94 = getText(R.string.article94ct).toString();
    String article95 = getText(R.string.article95ct).toString();
    String article96 = getText(R.string.article96ct).toString();
    String article97 = getText(R.string.article97ct).toString();
    String article98 = getText(R.string.article98ct).toString();
    String article99 = getText(R.string.article99ct).toString();
    String article100 = getText(R.string.article100ct).toString();
    String article101 = getText(R.string.article101ct).toString();
    String article102 = getText(R.string.article102ct).toString();
    String article103 = getText(R.string.article103ct).toString();
    String article104 = getText(R.string.article104ct).toString();
    String article105 = getText(R.string.article105ct).toString();
    String article106 = getText(R.string.article106ct).toString();
    String article107 = getText(R.string.article107ct).toString();
    String article108 = getText(R.string.article108ct).toString();
    String article109 = getText(R.string.article109ct).toString();
    String article110 = getText(R.string.article110ct).toString();
    String article111 = getText(R.string.article111ct).toString();
    String article112 = getText(R.string.article112ct).toString();
    String article113 = getText(R.string.article113ct).toString();
    String article114 = getText(R.string.article114ct).toString();
    String article115 = getText(R.string.article115ct).toString();
    String article116 = getText(R.string.article116ct).toString();
    String article117 = getText(R.string.article117ct).toString();
    String article118 = getText(R.string.article118ct).toString();
    String article119 = getText(R.string.article119ct).toString();
    String article120 = getText(R.string.article120ct).toString();
    String article121 = getText(R.string.article121ct).toString();
    String article122 = getText(R.string.article122ct).toString();
    String article123 = getText(R.string.article123ct).toString();
    String article124 = getText(R.string.article124ct).toString();
    String article125 = getText(R.string.article125ct).toString();
    String article126 = getText(R.string.article126ct).toString();
    String article127 = getText(R.string.article127ct).toString();
    String article128 = getText(R.string.article128ct).toString();
    String article129 = getText(R.string.article129ct).toString();
    String article130 = getText(R.string.article130ct).toString();
    String article131 = getText(R.string.article131ct).toString();
    String article132 = getText(R.string.article132ct).toString();
    String article133 = getText(R.string.article133ct).toString();
    String article134 = getText(R.string.article134ct).toString();
    String article135 = getText(R.string.article135ct).toString();
    String article136 = getText(R.string.article136ct).toString();
    String article137 = getText(R.string.article137ct).toString();
    String article138 = getText(R.string.article138ct).toString();
    String article139 = getText(R.string.article139ct).toString();
    String article140 = getText(R.string.article140ct).toString();
    String article141 = getText(R.string.article141ct).toString();
    String article142 = getText(R.string.article142ct).toString();
    String article143 = getText(R.string.article143ct).toString();
    String article144 = getText(R.string.article144ct).toString();
    String article145 = getText(R.string.article145ct).toString();
    String article146 = getText(R.string.article146ct).toString();
    String article147 = getText(R.string.article147ct).toString();
    String article148 = getText(R.string.article148ct).toString();
    String article149 = getText(R.string.article149ct).toString();
    String article150 = getText(R.string.article150ct).toString();
    String article151 = getText(R.string.article151ct).toString();
    String article152 = getText(R.string.article152ct).toString();
    String article153 = getText(R.string.article153ct).toString();
    String article154 = getText(R.string.article154ct).toString();
    String article155 = getText(R.string.article155ct).toString();
    String article156 = getText(R.string.article156ct).toString();
    String article157 = getText(R.string.article157ct).toString();
    String article158 = getText(R.string.article158ct).toString();
    String article159 = getText(R.string.article159ct).toString();
    String article160 = getText(R.string.article160ct).toString();
    String article161 = getText(R.string.article161ct).toString();
    String article162 = getText(R.string.article162ct).toString();
    String article163 = getText(R.string.article163ct).toString();
    String article164 = getText(R.string.article164ct).toString();
    String article165 = getText(R.string.article165ct).toString();
    String article166 = getText(R.string.article166ct).toString();
    String article167 = getText(R.string.article167ct).toString();
    String article168 = getText(R.string.article168ct).toString();
    String article169 = getText(R.string.article169ct).toString();
    String article170 = getText(R.string.article170ct).toString();
    String article171 = getText(R.string.article171ct).toString();
    String article172 = getText(R.string.article172ct).toString();
    String article173 = getText(R.string.article173ct).toString();
    String article174 = getText(R.string.article174ct).toString();
    String article175 = getText(R.string.article175ct).toString();
    String article176 = getText(R.string.article176ct).toString();
    String article177 = getText(R.string.article177ct).toString();

    Data data = new Data(titre1ct, "Article 1", article1);
    list.add(data);
    data = new Data("", "Article 2", article2);
    list.add(data);
    data = new Data(titre2ct, "Article 3", article3);
    list.add(data);
    data = new Data("", "Article 4", article4);
    list.add(data);
    data = new Data("", "Article 5", article5);
    list.add(data);
    data = new Data("", "Article 6", article6);
    list.add(data);
    data = new Data("", "Article 7", article7);
    list.add(data);
    data = new Data("", "Article 8", article8);
    list.add(data);
    data = new Data("", "Article 9", article9);
    list.add(data);
    data = new Data(titre3ct, "Article 10", article10);
    list.add(data);
    data = new Data("", "Article 11", article11);
    list.add(data);
    data = new Data("", "Article 12", article12);
    list.add(data);
    data = new Data("", "Article 13", article13);
    list.add(data);
    data = new Data("", "Article 14", article14);
    list.add(data);
    data = new Data("", "Article 15", article15);
    list.add(data);
    data = new Data(titre4ct, "Article 16", article16);
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
    data = new Data(titre5ct, "Article 22", article22);
    list.add(data);
    data = new Data(titre6ct, "Article 23", article23);
    list.add(data);
    data = new Data("", "Article 24", article24);
    list.add(data);
    data = new Data(titre7ct, "Article 25", article25);
    list.add(data);
    data = new Data("", "Article 26", article26);
    list.add(data);
    data = new Data("", "Article 27", article27);
    list.add(data);
    data = new Data("", "Article 28", article28);
    list.add(data);
    data = new Data("", "Article 29", article29);
    list.add(data);
    data = new Data("", "Article 30", article30);
    list.add(data);
    data = new Data("", "Article 31", article31);
    list.add(data);
    data = new Data(titre8ct, "Article 32", article32);
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
    data = new Data("", "Article 38", article38);
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
    data = new Data(titre9ct, "Article 45", article45);
    list.add(data);
    data = new Data("", "Article 46", article46);
    list.add(data);
    data = new Data("", "Article 47", article47);
    list.add(data);
    data = new Data(titre10ct, "Article 48", article48);
    list.add(data);
    data = new Data("", "Article 49", article49);
    list.add(data);
    data = new Data("", "Article 50", article50);
    list.add(data);
    data = new Data("", "Article 51", article51);
    list.add(data);
    data = new Data(titre11ct, "Article 52", article52);
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
    data = new Data(titre12ct, "Article 61", article61);
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
    data = new Data(titre13ct, "Article 67", article67);
    list.add(data);
    data = new Data("", "Article 68", article68);
    list.add(data);
    data = new Data("", "Article 69", article69);
    list.add(data);
    data = new Data(titre14ct, "Article 70", article70);
    list.add(data);
    data = new Data("", "Article 71", article71);
    list.add(data);
    data = new Data("", "Article 72", article72);
    list.add(data);
    data = new Data("", "Article 73", article73);
    list.add(data);
    data = new Data(titre15ct, "Article 74", article74);
    list.add(data);
    data = new Data(titre16ct, "Article 75", article75);
    list.add(data);
    data = new Data("", "Article 76", article76);
    list.add(data);
    data = new Data("", "Article 77", article77);
    list.add(data);
    data = new Data(titre17ct, "Article 78", article78);
    list.add(data);
    data = new Data("", "Article 79", article79);
    list.add(data);
    data = new Data(titre18ct, "Article 80", article80);
    list.add(data);
    data = new Data(titre19ct, "Article 81", article81);
    list.add(data);
    data = new Data("", "Article 82", article82);
    list.add(data);
    data = new Data(titre20ct, "Article 83", article83);
    list.add(data);
    data = new Data("", "Article 84", article84);
    list.add(data);
    data = new Data("", "Article 85", article85);
    list.add(data);
    data = new Data("", "Article 86", article86);
    list.add(data);
    data = new Data("", "Article 87", article87);
    list.add(data);
    data = new Data(titre21ct, "Article 88", article88);
    list.add(data);
    data = new Data(titre22ct, "Article 89", article89);
    list.add(data);
    data = new Data("", "Article 90", article90);
    list.add(data);
    data = new Data("", "Article 91", article91);
    list.add(data);
    data = new Data("", "Article 92", article92);
    list.add(data);
    data = new Data("", "Article 93", article93);
    list.add(data);
    data = new Data("", "Article 94", article94);
    list.add(data);
    data = new Data(titre23ct, "Article 95", article95);
    list.add(data);
    data = new Data(titre24ct, "Article 96", article96);
    list.add(data);
    data = new Data("", "Article 97", article97);
    list.add(data);
    data = new Data(titre25ct, "Article 98", article98);
    list.add(data);
    data = new Data("", "Article 99", article99);
    list.add(data);
    data = new Data("", "Article 100", article100);
    list.add(data);
    data = new Data("", "Article 101", article101);
    list.add(data);
    data = new Data("", "Article 102", article102);
    list.add(data);
    data = new Data("", "Article 103", article103);
    list.add(data);
    data = new Data(titre26ct, "Article 104", article104);
    list.add(data);
    data = new Data(titre27ct, "Article 105", article105);
    list.add(data);
    data = new Data("", "Article 106", article106);
    list.add(data);
    data = new Data("", "Article 107", article107);
    list.add(data);
    data = new Data("", "Article 108", article108);
    list.add(data);
    data = new Data("", "Article 109", article109);
    list.add(data);
    data = new Data("", "Article 110", article110);
    list.add(data);
    data = new Data("", "Article 111", article111);
    list.add(data);
    data = new Data(titre28ct, "Article 112", article112);
    list.add(data);
    data = new Data("", "Article 113", article113);
    list.add(data);
    data = new Data(titre29ct, "Article 114", article114);
    list.add(data);
    data = new Data("", "Article 115", article115);
    list.add(data);
    data = new Data("", "Article 116", article116);
    list.add(data);
    data = new Data(titre30ct, "Article 117", article117);
    list.add(data);
    data = new Data("", "Article 118", article118);
    list.add(data);
    data = new Data("", "Article 119", article119);
    list.add(data);
    data = new Data(titre31ct, "Article 120", article120);
    list.add(data);
    data = new Data("", "Article 121", article121);
    list.add(data);
    data = new Data(titre32ct, "Article 122", article122);
    list.add(data);
    data = new Data("", "Article 123", article123);
    list.add(data);
    data = new Data("", "Article 124", article124);
    list.add(data);
    data = new Data("", "Article 125", article125);
    list.add(data);
    data = new Data("", "Article 126", article126);
    list.add(data);
    data = new Data("", "Article 127", article127);
    list.add(data);
    data = new Data("", "Article 128", article128);
    list.add(data);
    data = new Data("", "Article 129", article129);
    list.add(data);
    data = new Data("", "Article 130", article130);
    list.add(data);
    data = new Data(titre33ct, "Article 131", article131);
    list.add(data);
    data = new Data("", "Article 132", article132);
    list.add(data);
    data = new Data(titre34ct, "Article 133", article133);
    list.add(data);
    data = new Data("", "Article 134", article134);
    list.add(data);
    data = new Data("", "Article 135", article135);
    list.add(data);
    data = new Data("", "Article 136", article136);
    list.add(data);
    data = new Data("", "Article 137", article137);
    list.add(data);
    data = new Data(titre35ct, "Article 138", article138);
    list.add(data);
    data = new Data("", "Article 139", article139);
    list.add(data);
    data = new Data("", "Article 140", article140);
    list.add(data);
    data = new Data("", "Article 141", article141);
    list.add(data);
    data = new Data("", "Article 142", article142);
    list.add(data);
    data = new Data("", "Article 143", article143);
    list.add(data);
    data = new Data("", "Article 144", article144);
    list.add(data);
    data = new Data("", "Article 145", article145);
    list.add(data);
    data = new Data("", "Article 146", article146);
    list.add(data);
    data = new Data("", "Article 147", article147);
    list.add(data);
    data = new Data("", "Article 148", article148);
    list.add(data);
    data = new Data("", "Article 149", article149);
    list.add(data);
    data = new Data("", "Article 150", article150);
    list.add(data);
    data = new Data("", "Article 151", article151);
    list.add(data);
    data = new Data("", "Article 152", article152);
    list.add(data);
    data = new Data("", "Article 153", article153);
    list.add(data);
    data = new Data("", "Article 154", article154);
    list.add(data);
    data = new Data("", "Article 155", article155);
    list.add(data);
    data = new Data("", "Article 156", article156);
    list.add(data);
    data = new Data(titre36ct, "Article 157", article157);
    list.add(data);
    data = new Data(titre37ct, "Article 158", article158);
    list.add(data);
    data = new Data("", "Article 159", article159);
    list.add(data);
    data = new Data("", "Article 160", article160);
    list.add(data);
    data = new Data(titre38ct, "Article 161", article161);
    list.add(data);
    data = new Data("", "Article 162", article162);
    list.add(data);
    data = new Data("", "Article 163", article163);
    list.add(data);
    data = new Data("", "Article 164", article164);
    list.add(data);
    data = new Data("", "Article 165", article165);
    list.add(data);
    data = new Data(titre39ct, "Article 166", article166);
    list.add(data);
    data = new Data("", "Article 167", article167);
    list.add(data);
    data = new Data("", "Article 168", article168);
    list.add(data);
    data = new Data("", "Article 169", article169);
    list.add(data);
    data = new Data("", "Article 170", article170);
    list.add(data);
    data = new Data("", "Article 171", article171);
    list.add(data);
    data = new Data("", "Article 172", article172);
    list.add(data);
    data = new Data("", "Article 173", article173);
    list.add(data);
    data = new Data(titre40ct, "Article 174", article174);
    list.add(data);
    data = new Data("", "Article 175", article175);
    list.add(data);
    data = new Data("", "Article 176", article176);
    list.add(data);
    data = new Data("", "Article 177", article177);
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
      Toast.makeText(CodeDuTravail.this, "Aucun Résultat", Toast.LENGTH_SHORT).show();
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

    mRecyclerAdapter = new AdapterCodeDuTravail(getApplicationContext(), list);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(CodeDuTravail.this));
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

    TextView searchText = searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);

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
      startActivity(new Intent(CodeDuTravail.this, RegleDeDroit.class));
      overridePendingTransition(R.anim.anim3, R.anim.anim4);
      finish();
    }
  }
}