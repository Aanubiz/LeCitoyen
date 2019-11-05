package cm.logram.lecitoyen.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cm.logram.lecitoyen.mains.Main1Activity;
import cm.logram.lecitoyen.R;
import mehdi.sakout.fancybuttons.FancyButton;

public class Fragment1 extends Fragment {

  public Fragment1() {
  }
  public static Fragment1 newInstance() {
    Fragment1 fragment = new Fragment1();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootview = inflater.inflate(R.layout.fragment1, container, false);
    FancyButton button = rootview.findViewById(R.id.frag1);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        ((Main1Activity)getActivity()).setCurrentItem (1, true);
      }
    });
    return rootview;
  }
}
