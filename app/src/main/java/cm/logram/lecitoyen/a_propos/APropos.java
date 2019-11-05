package cm.logram.lecitoyen.a_propos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.chootdev.recycleclick.RecycleClick;
import com.kobakei.ratethisapp.RateThisApp;

import java.util.ArrayList;
import java.util.List;

import cm.logram.lecitoyen.MainActivity;
import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.adapter.AdapterAPropos;

public class APropos extends AppCompatActivity {
  private List<Data> list = new ArrayList<>();
  private RecyclerView recyclerView;
  private AdapterAPropos mAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_apropos);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    recyclerView = findViewById(R.id.recycler);

    mAdapter = new AdapterAPropos(list);
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setAdapter(mAdapter);
    Data();

    RecycleClick.addTo(recyclerView).setOnItemClickListener(new RecycleClick.OnItemClickListener() {
      @Override
      public void onItemClicked(RecyclerView recyclerView, int position, View v) {
      if (position==0){
        startActivity(new Intent(APropos.this, A_Propos.class));
        finish();
      }else if (position==1){
        startActivity(new Intent(APropos.this, Contacts.class));
        finish();
      }else if (position==3){
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        //sharingIntent.setType("text/plain");
        String shareBodyText = "Deviens dès aujourd'hui un citoyen en téléchargeant l'Application \"Le Citoyen\" sur playstore\n";
        sharingIntent.setData(Uri.parse("https://play.google.com/store/apps/details?id=cm.logram.lecitoyen"));
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT,"Objet");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
        startActivity(Intent.createChooser(sharingIntent, "Selectionnez un canal"));
        finish();
      }else if (position==4){
        RateThisApp.showRateDialog(APropos.this, R.style.MyAlertDialogStyle2);
      }else if (position==5){
        startActivity(new Intent(APropos.this, Faq.class));
        finish();
      }
      }
    });
    RateThisApp.init(new RateThisApp.Config(3, 5));
    RateThisApp.setCallback(new RateThisApp.Callback() {
      @Override
      public void onYesClicked() {
        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
        try {
          startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
          finish();
        } catch (android.content.ActivityNotFoundException anfe) {
          startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
          finish();
        }
      }

      @Override
      public void onNoClicked() {
      }
      @Override
      public void onCancelClicked() {
      }
    });
    RateThisApp.showRateDialogIfNeeded(this);
  }

  private void Data() {
    Data data = new Data(R.drawable.ic_help_outline_black_24dp, "Qui Sommes nous");
    list.add(data);
    data = new Data(R.drawable.ic_phone_black_24dp, "Contacts");
    list.add(data);
    data = new Data(R.drawable.ic_settings_black_24dp, "Paramètres");
    list.add(data);
    data = new Data(R.drawable.ic_share_black_24dp, "Partager");
    list.add(data);
    data = new Data(R.drawable.ic_star_gray_24dp, "Nous noter");
    list.add(data);
    data = new Data(R.drawable.ic_mode_comment_black_24dp, "FAQ");
    list.add(data);

    mAdapter.notifyDataSetChanged();
  }
  public void onBackPressed() {
    startActivity(new Intent(APropos.this, MainActivity.class));
    finish();
  }
}
