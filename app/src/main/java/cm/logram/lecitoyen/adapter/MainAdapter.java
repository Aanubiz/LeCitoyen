package cm.logram.lecitoyen.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import cm.logram.lecitoyen.Gallerie;
import cm.logram.lecitoyen.R;

public class MainAdapter extends SliderViewAdapter<MainAdapter.AdapterViewHolder> {

  private Context context;
  private int mCount;

  public MainAdapter(Context context) {
    this.context = context;
  }

  public void setCount(int count) {
    this.mCount = count;
  }

  @Override
  public AdapterViewHolder onCreateViewHolder(ViewGroup parent) {
    @SuppressLint("InflateParams") View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list, null);
    return new AdapterViewHolder(inflate);
  }

  @Override
  public void onBindViewHolder(AdapterViewHolder viewHolder, final int position) {


    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //context.startActivity(new Intent(context, Gallerie.class));
      }
    });
    switch (position) {
      case 0:
        viewHolder.textViewDescription.setText("");
        viewHolder.textViewDescription.setTextSize(16);
        viewHolder.textViewDescription.setTextColor(Color.WHITE);
        viewHolder.imageGifContainer.setVisibility(View.GONE);
        Glide.with(viewHolder.itemView)
            .load(R.drawable.tsf)
            .into(viewHolder.imageViewBackground);
        break;
      case 1:
        viewHolder.textViewDescription.setText("Andre Marie Mbida");
        viewHolder.textViewDescription.setTextSize(16);
        viewHolder.textViewDescription.setTextColor(Color.WHITE);
        viewHolder.imageGifContainer.setVisibility(View.GONE);
        Glide.with(viewHolder.itemView)
            .load(R.drawable.andre1)
            .into(viewHolder.imageViewBackground);
        break;
      case 2:
        viewHolder.textViewDescription.setText("Douala Manga Bell et son épouse");
        viewHolder.textViewDescription.setTextSize(16);
        viewHolder.textViewDescription.setTextColor(Color.WHITE);
        viewHolder.imageGifContainer.setVisibility(View.GONE);
        Glide.with(viewHolder.itemView)
            .load(R.drawable.bell2)
            .into(viewHolder.imageViewBackground);
        break;
      case 3:
        viewHolder.textViewDescription.setText("Hopital construit par les Allemands");
        viewHolder.textViewDescription.setTextSize(16);
        viewHolder.textViewDescription.setTextColor(Color.WHITE);
        viewHolder.imageGifContainer.setVisibility(View.GONE);
        Glide.with(viewHolder.itemView)
            .load(R.drawable.hopitaux)
            .into(viewHolder.imageViewBackground);
        break;
      case 4:
        viewHolder.textViewDescription.setText("Port de Bimbia");
        viewHolder.textViewDescription.setTextSize(16);
        viewHolder.textViewDescription.setTextColor(Color.WHITE);
        viewHolder.imageGifContainer.setVisibility(View.GONE);
        Glide.with(viewHolder.itemView)
            .load(R.drawable.bimbia)
            .into(viewHolder.imageViewBackground);
        break;
      case 5:
        viewHolder.textViewDescription.setText("Sultan Njoya");
        viewHolder.textViewDescription.setTextSize(16);
        viewHolder.textViewDescription.setTextColor(Color.WHITE);
        viewHolder.imageGifContainer.setVisibility(View.GONE);
        Glide.with(viewHolder.itemView)
            .load(R.drawable.njoya)
            .into(viewHolder.imageViewBackground);
        break;
      case 6:
        viewHolder.textViewDescription.setText("Ruben Um Nyobe");
        viewHolder.textViewDescription.setTextSize(16);
        viewHolder.textViewDescription.setTextColor(Color.WHITE);
        viewHolder.imageGifContainer.setVisibility(View.GONE);
        Glide.with(viewHolder.itemView)
            .load(R.drawable.um)
            .into(viewHolder.imageViewBackground);
        break;
      case 7:
        viewHolder.textViewDescription.setText("Martin Paul Samba");
        viewHolder.textViewDescription.setTextSize(16);
        viewHolder.textViewDescription.setTextColor(Color.WHITE);
        viewHolder.imageGifContainer.setVisibility(View.GONE);
        Glide.with(viewHolder.itemView)
            .load(R.drawable.martin)
            .into(viewHolder.imageViewBackground);
        break;
      case 8:
        viewHolder.textViewDescription.setText("Felix Roland Moumie");
        viewHolder.textViewDescription.setTextSize(16);
        viewHolder.textViewDescription.setTextColor(Color.WHITE);
        viewHolder.imageGifContainer.setVisibility(View.GONE);
        Glide.with(viewHolder.itemView)
            .load(R.drawable.moumie)
            .into(viewHolder.imageViewBackground);
        break;
      case 9:
        viewHolder.textViewDescription.setText("Ahmadou Ahidjo");
        viewHolder.textViewDescription.setTextSize(16);
        viewHolder.textViewDescription.setTextColor(Color.WHITE);
        viewHolder.imageGifContainer.setVisibility(View.GONE);
        Glide.with(viewHolder.itemView)
            .load(R.drawable.ahidjo)
            .into(viewHolder.imageViewBackground);
        break;
      default:
        viewHolder.textViewDescription.setTextSize(29);
        viewHolder.textViewDescription.setTextColor(Color.WHITE);
        viewHolder.textViewDescription.setText("Ohhhh!");
        viewHolder.imageGifContainer.setVisibility(View.VISIBLE);
        Glide.with(viewHolder.itemView)
            .load(R.drawable.ahidjo)
            .into(viewHolder.imageViewBackground);
        Glide.with(viewHolder.itemView)
            .asGif()
            .load(R.drawable.ahidjo1)
            .into(viewHolder.imageGifContainer);
        break;
    }
  }

  @Override
  public int getCount() {
    return mCount;
  }
  class AdapterViewHolder extends SliderViewAdapter.ViewHolder {

    View itemView;
    ImageView imageViewBackground;
    ImageView imageGifContainer;
    TextView textViewDescription;

    public AdapterViewHolder(View itemView) {
      super(itemView);
      imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
      imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
      textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
      this.itemView = itemView;
    }
  }
}