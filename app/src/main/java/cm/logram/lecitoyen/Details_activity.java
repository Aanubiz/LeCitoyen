package cm.logram.lecitoyen;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Details_activity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_details_activity);

    String title = getIntent().getStringExtra("title");
    Bitmap bitmap = getIntent().getParcelableExtra("image");

    TextView titleTextView = findViewById(R.id.title);
    titleTextView.setText(title);

    ImageView imageView = findViewById(R.id.image);
    imageView.setImageBitmap(bitmap);
  }
}