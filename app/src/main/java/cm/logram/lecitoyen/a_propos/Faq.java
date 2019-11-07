package cm.logram.lecitoyen.a_propos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import cm.logram.lecitoyen.R;

public class Faq extends AppCompatActivity {
  private ExpandableRelativeLayout
      expandableLayout1,
      expandableLayout2,
      expandableLayout3,
      expandableLayout4,
      expandableLayout5,
      expandableLayout6,
      expandableLayout7,
      expandableLayout8;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_faq);
  }
  public void expandableButton1(View view) {
    expandableLayout1 = findViewById(R.id.expandableLayout1);
    expandableLayout1.toggle();
  }
  public void expandableButton2(View view) {
    expandableLayout2 = findViewById(R.id.expandableLayout2);
    expandableLayout2.toggle();
  }
  public void expandableButton3(View view) {
    expandableLayout3 = findViewById(R.id.expandableLayout3);
    expandableLayout3.toggle();
  }
  public void expandableButton4(View view) {
    expandableLayout4 = findViewById(R.id.expandableLayout4);
    expandableLayout4.toggle();
  }
  public void expandableButton5(View view) {
    expandableLayout5 = findViewById(R.id.expandableLayout5);
    expandableLayout5.toggle();
  }
  public void expandableButton6(View view) {
    expandableLayout6 = findViewById(R.id.expandableLayout6);
    expandableLayout6.toggle();
  }
  public void expandableButton7(View view) {
    expandableLayout7 = findViewById(R.id.expandableLayout7);
    expandableLayout7.toggle();
  }public void expandableButton8(View view) {
    expandableLayout8 = findViewById(R.id.expandableLayout8);
    expandableLayout8.toggle();
  }
  public void onBackPressed() {
    startActivity(new Intent(Faq.this, APropos.class));
    overridePendingTransition(R.anim.anim3, R.anim.anim4);
    finish();
  }
}
