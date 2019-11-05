package cm.logram.lecitoyen.a_propos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import cm.logram.lecitoyen.R;

public class A_Propos extends AppCompatActivity {
  private TextView textView;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_apropos_main);

    textView = findViewById(R.id.text);
    String nous = getResources().getString(R.string.nous);
    textView.setText(Html.fromHtml(nous));
  }
  @Override
  public void onBackPressed() {
    startActivity(new Intent(A_Propos.this, APropos.class));
    overridePendingTransition(R.anim.anim3, R.anim.anim4);
    finish();
  }
}
