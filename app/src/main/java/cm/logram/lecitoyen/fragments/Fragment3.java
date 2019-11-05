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

public class Fragment3 extends Fragment {
  public Fragment3() {
  }

  public static Fragment3 newInstance() {
    Fragment3 fragment = new Fragment3();
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
    View rootView = inflater.inflate(R.layout.fragment3, container, false);
    FancyButton button = rootView.findViewById(R.id.frag3);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        ((Main1Activity) getActivity()).setCurrentItem(3, true);
      }
    });
    return rootView;
  }
}
