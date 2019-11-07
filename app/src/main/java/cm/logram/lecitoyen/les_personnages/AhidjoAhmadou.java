package cm.logram.lecitoyen.les_personnages;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import androidx.appcompat.app.AppCompatActivity;
import cm.logram.lecitoyen.R;

public class AhidjoAhmadou extends AppCompatActivity {
  private TextView textView, textView2;
  private AdView mAdView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ahidjo_ahmadou);

    textView = findViewById(R.id.details);
    textView2 = findViewById(R.id.desc_ahidjo);

    String details = getResources().getString(R.string.details);
    textView.setText(Html.fromHtml(details));
    String desc_ahidjo = getResources().getString(R.string.desc_ahidjo);
    textView2.setText(Html.fromHtml(desc_ahidjo));

    MobileAds.initialize(this, getString(R.string.admob_banner_id));
    mAdView = findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);
  }
  public void onBackPressed(){
    startActivity(new Intent(AhidjoAhmadou.this, PersonnagesHistorique.class));
    overridePendingTransition(R.anim.anim3, R.anim.anim4);
    finish();
  }
}
