package cm.logram.lecitoyen.les_personnages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import cm.logram.lecitoyen.MainActivity;
import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.histoireDuCameroun.HistoireDuCameroun;

public class RubenUmNyobe extends AppCompatActivity {

  private ExpandableRelativeLayout expandableLayout1;
  private TextView textView, textView2, textView3, textView4,textView5;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ruben_um_nyobe);

    textView = findViewById(R.id.details_um);
    textView2 = findViewById(R.id.desc_um);
    textView3 = findViewById(R.id.desc_um2);
    textView4 = findViewById(R.id.desc_um3);
    textView5 = findViewById(R.id.desc_um1);

    String details = getResources().getString(R.string.details_um);
    textView.setText(Html.fromHtml(details));
    String desc_um = getResources().getString(R.string.desc_um);
    textView2.setText(Html.fromHtml(desc_um));
    String desc_um2 = getResources().getString(R.string.desc_um2);
    textView3.setText(Html.fromHtml(desc_um2));
    String desc_um3 = getResources().getString(R.string.desc_um3);
    textView4.setText(Html.fromHtml(desc_um3));
    String desc_um1 = getResources().getString(R.string.desc_um1);
    textView5.setText(Html.fromHtml(desc_um1));
  }
  public void expandableButton1(View view) {
    expandableLayout1 = findViewById(R.id.expandableLayout1);
    expandableLayout1.toggle(); // toggle expand and collapse
  }
  public void onBackPressed(){
    startActivity(new Intent(RubenUmNyobe.this, PersonnagesHistorique.class));
    overridePendingTransition(R.anim.anim3, R.anim.anim4);
    finish();
  }
}
