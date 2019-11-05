package cm.logram.lecitoyen.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cm.logram.lecitoyen.MainActivity;
import cm.logram.lecitoyen.R;
import mehdi.sakout.fancybuttons.FancyButton;

public class Fragment4 extends Fragment {
  public Fragment4() {
  }

  public static Fragment4 newInstance() {
    Fragment4 fragment = new Fragment4();
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
    View rootview = inflater.inflate(R.layout.fragment4, container, false);
    FancyButton button = rootview.findViewById(R.id.frag4);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);      }
    });
    return rootview;
  }
}
