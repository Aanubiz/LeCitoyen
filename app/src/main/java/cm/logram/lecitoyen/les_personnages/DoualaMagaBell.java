package cm.logram.lecitoyen.les_personnages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import cm.logram.lecitoyen.MainActivity;
import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.histoireDuCameroun.HistoireDuCameroun;

public class DoualaMagaBell extends AppCompatActivity {

  private TextView textView, textView2, textView3, textView4, textView5;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_douala_maga_bell);

    textView = findViewById(R.id.detail_bell);
    textView2 = findViewById(R.id.desc_bell);
    textView3 = findViewById(R.id.desc_bell2);
    textView4 = findViewById(R.id.desc_bell3);
    textView5 = findViewById(R.id.desc_bell4);

    String details = getResources().getString(R.string.details_bell);
    textView.setText(Html.fromHtml(details));
    String bell = getResources().getString(R.string.desc_bell);
    textView2.setText(Html.fromHtml(bell));
    String bell2 = getResources().getString(R.string.desc_bell2);
    textView3.setText(Html.fromHtml(bell2));
    String bell3 = getResources().getString(R.string.desc_bell3);
    textView4.setText(Html.fromHtml(bell3));
    String bell5 = getResources().getString(R.string.desc_bell4);
    textView5.setText(Html.fromHtml(bell5));
  }
  public void onBackPressed(){
    startActivity(new Intent(DoualaMagaBell.this, PersonnagesHistorique.class));
    overridePendingTransition(R.anim.anim3, R.anim.anim4);
    finish();
  }
}
