package cm.logram.lecitoyen.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cm.logram.lecitoyen.R;

public class GridViewAdapter extends ArrayAdapter<ImageItem> {

  private Context context;
  private int layoutResourceId;
  private ArrayList<ImageItem> data = new ArrayList<>();

  public GridViewAdapter(Context context, int layoutResourceId, ArrayList<ImageItem> data) {
    super(context, layoutResourceId, data);
    this.layoutResourceId = layoutResourceId;
    this.context = context;
    this.data = data;
  }

  @Override
  public View getView(int position, View convertView, @NonNull ViewGroup parent) {
    View row = convertView;
    ViewHolder holder;

    if (row == null) {
      LayoutInflater inflater = ((Activity) context).getLayoutInflater();
      row = inflater.inflate(layoutResourceId, parent, false);
      holder = new ViewHolder();
      holder.imageTitle = row.findViewById(R.id.text);
      holder.image = row.findViewById(R.id.image);
      row.setTag(holder);
    } else {
      holder = (ViewHolder) row.getTag();
    }

    ImageItem item = data.get(position);
    holder.imageTitle.setText(item.getTitle());
    holder.image.setImageBitmap(item.getImage());
    return row;
  }

  static class ViewHolder {
    TextView imageTitle;
    ImageView image;
  }
}