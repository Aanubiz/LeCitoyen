package cm.logram.lecitoyen.histoireDuCameroun;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import androidx.appcompat.app.AppCompatActivity;
import cm.logram.lecitoyen.MainActivity;
import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.reglesDeDroits.RegleDeDroit;

public class CamerounPrecoloniale extends AppCompatActivity {

  private ExpandableRelativeLayout expandableLayout1, expandableLayout2;
  private TextView textView, textView1, textView2;
  private AdView mAdView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cameroun_precoloniale);

    textView = findViewById(R.id.cpc);
    textView1 = findViewById(R.id.cpc1);
    textView2 = findViewById(R.id.cpc2);

    String cpc = getResources().getString(R.string.details_cpc);
    textView.setText(Html.fromHtml(cpc));
    String cpc1 = getResources().getString(R.string.cpc2);
    textView1.setText(Html.fromHtml(cpc1));
    String cpc2 = getResources().getString(R.string.details_cpc2);
    textView2.setText(Html.fromHtml(cpc2));

    MobileAds.initialize(this, getString(R.string.admob_banner_id));
    mAdView = findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);
  }
  public void expandableButton1(View view) {
    expandableLayout1 = findViewById(R.id.expandableLayout1);
    expandableLayout1.toggle(); // toggle expand and collapse
  }
  public void expandableButton2(View view) {
    expandableLayout2 = findViewById(R.id.expandableLayout2);
    expandableLayout2.toggle(); // toggle expand and collapse
  }
  public void onBackPressed(){
    startActivity(new Intent(CamerounPrecoloniale.this, HistoireDuCameroun.class));
    overridePendingTransition(R.anim.anim3, R.anim.anim4);
    finish();
  }
}
