package cm.logram.lecitoyen.les_personnages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import cm.logram.lecitoyen.MainActivity;
import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.histoireDuCameroun.HistoireDuCameroun;

public class FelixMoumie extends AppCompatActivity {

  private TextView textView, textView2;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_felix_moumie);

    textView = findViewById(R.id.details_moumie);
    textView2 = findViewById(R.id.desc_moumie);

    String details = getResources().getString(R.string.details_moumie);
    textView.setText(Html.fromHtml(details));

    String desc_moumie = getResources().getString(R.string.desc_moumie);
    textView2.setText(Html.fromHtml(desc_moumie));
  }
  public void onBackPressed(){
    startActivity(new Intent(FelixMoumie.this, PersonnagesHistorique.class));
    overridePendingTransition(R.anim.anim3, R.anim.anim4);
    finish();
  }
}
