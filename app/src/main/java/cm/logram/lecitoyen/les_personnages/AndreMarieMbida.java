package cm.logram.lecitoyen.les_personnages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import cm.logram.lecitoyen.MainActivity;
import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.histoireDuCameroun.HistoireDuCameroun;

public class AndreMarieMbida extends AppCompatActivity {

  private TextView textView, textView2;

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
  }
  public void onBackPressed(){
    startActivity(new Intent(AndreMarieMbida.this, PersonnagesHistorique.class));
    overridePendingTransition(R.anim.anim3, R.anim.anim4);
    finish();
  }
}
