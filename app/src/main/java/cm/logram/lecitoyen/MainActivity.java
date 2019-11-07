package cm.logram.lecitoyen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import androidx.appcompat.app.AppCompatActivity;
import cm.logram.lecitoyen.a_propos.APropos;
import cm.logram.lecitoyen.adapter.MainAdapter;
import cm.logram.lecitoyen.boommenu.BoomButtons.OnBMClickListener;
import cm.logram.lecitoyen.boommenu.BoomButtons.TextOutsideCircleButton;
import cm.logram.lecitoyen.boommenu.BoomMenuButton;
import cm.logram.lecitoyen.boommenu.ButtonEnum;
import cm.logram.lecitoyen.histoireDuCameroun.HistoireDuCameroun;
import cm.logram.lecitoyen.les_personnages.PersonnagesHistorique;
import cm.logram.lecitoyen.reglesDeDroits.RegleDeDroit;

public class MainActivity extends AppCompatActivity {

  SharedPreferences pref;
  SharedPreferences.Editor editor;
  int backButtonCount;

  private BoomMenuButton bmb;
  private SliderView sliderView;

  int[] images_gagnants = {
      R.drawable.auction,
      R.drawable.cameroon,
      R.drawable.man,
      R.drawable.african_mask,
      R.drawable.ic_settings_white_24dp};
  String[] titre_gagnants = {
      "Regles de droit au Cameroun",
      "Histoires du Cameroun",
      "Personnes Historique",
      "Patrimoine Cuturel Camerounais",
      "Autres"};
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    pref = getSharedPreferences("Pref", MODE_PRIVATE);
    editor = pref.edit();

    editor.putBoolean("isOnline", true);
    editor.apply();

    bmb = findViewById(R.id.bmb);
    assert bmb != null;
    bmb.setButtonEnum(ButtonEnum.TextOutsideCircle);
    for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
      TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder();
      builder.normalImageRes(images_gagnants[i]);
      builder.normalText(titre_gagnants[i]);
      builder.listener(new OnBMClickListener() {
        @Override
        public void onBoomButtonClick(int index) {
          if (index == 0) {
            startActivity(new Intent(MainActivity.this, RegleDeDroit.class));
            overridePendingTransition(R.anim.anim, R.anim.anim2);
            finish();
          } else if (index == 1) {
            startActivity(new Intent(MainActivity.this, HistoireDuCameroun.class));
            overridePendingTransition(R.anim.anim, R.anim.anim2);
            finish();
          }else if (index == 2){
            startActivity(new Intent(MainActivity.this, PersonnagesHistorique.class));
            overridePendingTransition(R.anim.anim, R.anim.anim2);
            finish();
          }else if (index == 3) {
            Toast.makeText(MainActivity.this,"Pas encore disponible", Toast.LENGTH_LONG).show();
          }else if (index == 4){
            startActivity(new Intent(MainActivity.this, APropos.class));
            overridePendingTransition(R.anim.anim, R.anim.anim2);
            finish();
          }
        }
      });
      bmb.addBuilder(builder);
    }

    sliderView = findViewById(R.id.imageSlider);

    final MainAdapter adapter = new MainAdapter(this);
    adapter.setCount(10);

    sliderView.setSliderAdapter(adapter);
    sliderView.setIndicatorAnimation(IndicatorAnimations.SWAP);
    sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
    sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
    sliderView.setIndicatorSelectedColor(Color.WHITE);
    sliderView.setIndicatorUnselectedColor(Color.GRAY);
    sliderView.startAutoCycle();

    sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
      @Override
      public void onIndicatorClicked(int position) {
        sliderView.setCurrentPagePosition(position);
      }
    });

  }
  public void onBackPressed() {
    if(backButtonCount >= 1){
      Intent intent = new Intent(Intent.ACTION_MAIN);
      intent.addCategory(Intent.CATEGORY_HOME);
      intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      startActivity(intent);
    } else {
      Toast.makeText(this, "Appuyez à nouveau sur le bouton Retour pour fermer l'application.", Toast.LENGTH_SHORT).show();
      backButtonCount++;
    }
  }
}
