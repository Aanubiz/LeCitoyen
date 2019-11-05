package cm.logram.lecitoyen.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.a_propos.Data;

public class AdapterAPropos extends RecyclerView.Adapter<AdapterAPropos.MyViewHolder> {

  private List<Data> List;

  public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public ImageView image;

    public MyViewHolder(View view) {
      super(view);
      image = view.findViewById(R.id.image);
      title = view.findViewById(R.id.title);
    }
  }


  public AdapterAPropos(List<Data> List) {
    this.List = List;
  }

  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_a_propos, parent, false);

    return new MyViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    Data data = List.get(position);
    holder.image.setImageResource(data.getImage());
    holder.title.setText(data.getTitle());
  }

  @Override
  public int getItemCount() {
    return List.size();
  }
}