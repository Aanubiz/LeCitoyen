package cm.logram.lecitoyen.reglesDeDroits;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cm.logram.lecitoyen.recyclerClick.RecycleClick;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.logram.lecitoyen.MainActivity;
import cm.logram.lecitoyen.R;

public class RegleDeDroit extends AppCompatActivity {
  private static final String[] codes = {
      "Lois portant Code de Procédure Pénale",
      "Lois portant Code Pénale",
      "Lois portant Code Electoral",
      "Lois portant Code De Juststice Militaire",
      "Lois portant Regime Général des Armes et Munitions",
      "Lois portant Code du Travail"
  };
  private static final int CONTACTS = 0;
  private static final Random RANDOM = new Random();

  private RecyclerView recyclerView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_regle_de_droit);

    recyclerView = findViewById(R.id.recycler);
    setupRecyclerView();

    RecycleClick.addTo(recyclerView).setOnItemClickListener(new RecycleClick.OnItemClickListener() {
      @Override
      public void onItemClicked(RecyclerView recyclerView, int position, View v) {
        if (position==0){
          startActivity(new Intent(RegleDeDroit.this, CodeDeProcedurePenale.class));
          overridePendingTransition(R.anim.anim, R.anim.anim2);
        }else if (position==1){
          startActivity(new Intent(RegleDeDroit.this, CodePenale.class));
          overridePendingTransition(R.anim.anim, R.anim.anim2);
        }else if (position==2){
          startActivity(new Intent(RegleDeDroit.this, CodeElectoral.class));
          overridePendingTransition(R.anim.anim, R.anim.anim2);
        }else if (position==3){
          startActivity(new Intent(RegleDeDroit.this, CodeDeJusticeMilitaire.class));
          overridePendingTransition(R.anim.anim, R.anim.anim2);
        }else if (position==4){
          startActivity(new Intent(RegleDeDroit.this, CodeRelatifAuxArmes.class));
          overridePendingTransition(R.anim.anim, R.anim.anim2);
        }else if (position==5){
          startActivity(new Intent(RegleDeDroit.this, CodeDuTravail.class));
          overridePendingTransition(R.anim.anim, R.anim.anim2);
        }
      }
    });
  }

  private void setupRecyclerView() {
    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    setContactsAdapter(codes);
  }

  private void setContactsAdapter(String[] array) {
    recyclerView.setAdapter(
        new SimpleStringRecyclerViewAdapter(this, Arrays.asList(array), CONTACTS));
  }

  public class SimpleStringRecyclerViewAdapter
      extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private List<String> mValues;
    private int[] mMaterialColors;
    private int mType;

    public class ViewHolder extends RecyclerView.ViewHolder {
      public String mBoundString;

      public final View mView;
      public final MaterialLetterIcon mIcon;
      public final TextView mTextView;

      public ViewHolder(View view) {
        super(view);
        mView = view;
        mIcon = view.findViewById(R.id.icon);
        mTextView = view.findViewById(R.id.text1);
      }

      @NonNull
      @Override public String toString() {
        return super.toString() + " '" + mTextView.getText();
      }
    }

    public SimpleStringRecyclerViewAdapter(Context context, List<String> items, int type) {
      context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
      mMaterialColors = context.getResources().getIntArray(R.array.colors);
      mBackground = mTypedValue.resourceId;
      mValues = items;
      mType = type;
    }

    @NonNull
    @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view =
          LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
      view.setBackgroundResource(mBackground);
      return new ViewHolder(view);
    }

    @Override public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
      switch (mType) {
        case CONTACTS:
          holder.mIcon.setInitials(true);
          holder.mIcon.setShapeType(MaterialLetterIcon.Shape.ROUND_RECT);
          holder.mIcon.setLetterSize(30);
          holder.mIcon.setInitialsNumber(2);
          Typeface face = Typeface.createFromAsset(getAssets(), "fonts/gugi.ttf");
          holder.mIcon.setLetterTypeface(face);
          break;
      }
      holder.mBoundString = mValues.get(position);
      holder.mIcon.setShapeColor(mMaterialColors[RANDOM.nextInt(mMaterialColors.length)]);
      holder.mTextView.setText(mValues.get(position));
      holder.mIcon.setLetter(mValues.get(position));
    }

    @Override public int getItemCount() {
      return mValues.size();
    }
  }
  public void onBackPressed() {
    startActivity(new Intent(RegleDeDroit.this, MainActivity.class));
    finish();
  }
}

