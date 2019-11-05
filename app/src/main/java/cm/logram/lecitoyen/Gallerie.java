package cm.logram.lecitoyen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import cm.logram.lecitoyen.adapter.GridViewAdapter;
import cm.logram.lecitoyen.adapter.ImageItem;

public class Gallerie extends AppCompatActivity {

  private GridView gridView;
  private GridViewAdapter gridAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_gallerie);

    gridView = findViewById(R.id.gridView);
    gridAdapter = new GridViewAdapter(this, R.layout.grid_item, getData());
    gridView.setAdapter(gridAdapter);

    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        ImageItem item = (ImageItem) parent.getItemAtPosition(position);

        //Create intent
        Intent intent = new Intent(Gallerie.this, Details_activity.class);
        intent.putExtra("title", item.getTitle());
        intent.putExtra("image", item.getImage());

        //Start details activity
        startActivity(intent);
      }
    });
  }

  /**
   * Prepare some dummy data for gridview
   */
  private ArrayList<ImageItem> getData() {
    final ArrayList<ImageItem> imageItems = new ArrayList<>();
    @SuppressLint("Recycle") TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
    for (int i = 0; i < imgs.length(); i++) {
      Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
      imageItems.add(new ImageItem(bitmap, "Image#" + i));
    }
    return imageItems;
  }
}
