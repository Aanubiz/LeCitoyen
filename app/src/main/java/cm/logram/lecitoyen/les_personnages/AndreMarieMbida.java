package cm.logram.lecitoyen.les_personnages;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import androidx.appcompat.app.AppCompatActivity;
import cm.logram.lecitoyen.MainActivity;
import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.histoireDuCameroun.HistoireDuCameroun;

public class AndreMarieMbida extends AppCompatActivity {

  private TextView textView, textView2;
  private AdView mAdView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_andre_marie_mbida);

    textView = findViewById(R.id.details);
    textView2 = findViewById(R.id.desc_mbida);

    String details = getResources().getString(R.string.details_amm);
    textView.setText(Html.fromHtml(details));

    String desc_ahidjo = getResources().getString(R.string.desc_mbida);
    textView2.setText(Html.fromHtml(desc_ahidjo));

    // Initialize the Mobile Ads SDK
    MobileAds.initialize(this, getString(R.string.admob_banner_id));
    // Find Banner ad
    mAdView = findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    // Display Banner ad
    mAdView.loadAd(adRequest);
  }
  public void onBackPressed(){
    startActivity(new Intent(AndreMarieMbida.this, PersonnagesHistorique.class));
    overridePendingTransition(R.anim.anim3, R.anim.anim4);
    finish();
  }
}
