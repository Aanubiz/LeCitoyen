package cm.logram.lecitoyen.histoireDuCameroun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableLayout;

import cm.logram.lecitoyen.MainActivity;
import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.reglesDeDroits.RegleDeDroit;

public class CamerounColoniale extends AppCompatActivity {

  private ExpandableLayout expandableLayout1;
  private TextView
      textView,
      textView2,
      textView3,
      textView4,
      textView5,
      textView6,
      textView7,
      textView8,
      textView9;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cameroun_coloniale);

    textView = findViewById(R.id.cpc);
    textView2 = findViewById(R.id.cc2);
    textView3 = findViewById(R.id.cc3);
    textView4 = findViewById(R.id.cc4);
    textView5 = findViewById(R.id.cc5);
    textView6 = findViewById(R.id.cc6);
    textView7 = findViewById(R.id.cc7);
    textView8 = findViewById(R.id.cc8);
    textView9 = findViewById(R.id.cc9);

    String cpc = getResources().getString(R.string.details_cc);
    textView.setText(Html.fromHtml(cpc));
    String cc2 = getResources().getString(R.string.cc2);
    textView2.setText(Html.fromHtml(cc2));
    String cc3 = getResources().getString(R.string.cc3);
    textView3.setText(Html.fromHtml(cc3));
    String cc4 = getResources().getString(R.string.cc4);
    textView4.setText(Html.fromHtml(cc4));
    String cc5 = getResources().getString(R.string.cc5);
    textView5.setText(Html.fromHtml(cc5));
    String cc6 = getResources().getString(R.string.cc6);
    textView6.setText(Html.fromHtml(cc6));
    String cc7 = getResources().getString(R.string.cc7);
    textView7.setText(Html.fromHtml(cc7));
    String cc8 = getResources().getString(R.string.cc8);
    textView8.setText(Html.fromHtml(cc8));
    String cc9 = getResources().getString(R.string.cc9);
    textView9.setText(Html.fromHtml(cc9));
  }
  public void expandableButton1(View view) {
    expandableLayout1 = findViewById(R.id.expandableLayout1);
    expandableLayout1.toggle(); // toggle expand and collapse
  }
  public void onBackPressed(){
    startActivity(new Intent(CamerounColoniale.this, HistoireDuCameroun.class));
    overridePendingTransition(R.anim.anim3, R.anim.anim4);
    finish();
  }
}
