package cm.logram.lecitoyen.a_propos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import cm.logram.lecitoyen.R;
import mehdi.sakout.fancybuttons.FancyButton;

public class Contacts extends AppCompatActivity {

  private FancyButton fancyButton1, fancyButton2, fancyButton3, fancyButton4;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contacts);

    fancyButton1 = findViewById(R.id.facebook);
    fancyButton3 = findViewById(R.id.whatsapp);
    fancyButton4 = findViewById(R.id.mail);
    fancyButton1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Uri uri = Uri.parse("https://web.facebook.com/Logram-427864167770012/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
      }
    });
    fancyButton3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String number = "+237678878019";
        String url = "https://api.whatsapp.com/send?phone=" + number;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
      }
    });
    fancyButton4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        startActivity(emailIntent);
      }
    });
  }

  public void onBackPressed() {
    startActivity(new Intent(Contacts.this, APropos.class));
    overridePendingTransition(R.anim.anim3, R.anim.anim4);
    finish();
  }
}
