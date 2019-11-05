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

public class Fragment2 extends Fragment {

  public Fragment2() {
  }

  public static Fragment2 newInstance() {
    Fragment2 fragment = new Fragment2();
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
    View rootView = inflater.inflate(R.layout.fragment2, container, false);
    FancyButton button = rootView.findViewById(R.id.frag2);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        ((Main1Activity)getActivity()).setCurrentItem (2, true);
      }
    });
    return rootView;
  }
}
