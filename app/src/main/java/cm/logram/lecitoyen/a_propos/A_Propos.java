package cm.logram.lecitoyen.a_propos;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import androidx.appcompat.app.AppCompatActivity;
import cm.logram.lecitoyen.R;

public class A_Propos extends AppCompatActivity {
  private TextView textView;
  private AdView mAdView;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_apropos_main);

    textView = findViewById(R.id.text);
    String nous = getResources().getString(R.string.nous);
    textView.setText(Html.fromHtml(nous));


    // Initialize the Mobile Ads SDK
    MobileAds.initialize(this, getString(R.string.admob_banner_id));
    // Find Banner ad
    mAdView = findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    // Display Banner ad
    mAdView.loadAd(adRequest);
  }
  @Override
  public void onBackPressed() {
    startActivity(new Intent(A_Propos.this, APropos.class));
    overridePendingTransition(R.anim.anim3, R.anim.anim4);
    finish();
  }
}
