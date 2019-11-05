package cm.logram.lecitoyen.mains;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cm.logram.lecitoyen.MainActivity;
import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.fragments.Fragment1;
import cm.logram.lecitoyen.fragments.Fragment2;
import cm.logram.lecitoyen.fragments.Fragment3;
import cm.logram.lecitoyen.fragments.Fragment4;

public class Main1Activity extends AppCompatActivity {
  private SectionsPagerAdapter mSectionsPagerAdapter;
  private ViewPager mViewPager;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main1);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

    mViewPager = findViewById(R.id.container);
    mViewPager.setAdapter(mSectionsPagerAdapter);

    SharedPreferences settings = getSharedPreferences("MyPrefs", 0);

    //Verifie si le main est lancé pour la première fois
    if (settings.getBoolean("is_first_time", true)) {
      settings.edit().putBoolean("is_first_time", false).apply();
    }else{
      startActivity(new Intent(Main1Activity.this, MainActivity.class));
    }

  }

  public static class PlaceholderFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    public PlaceholderFragment() {
    }

    public static PlaceholderFragment newInstance(int sectionNumber) {
      PlaceholderFragment fragment = new PlaceholderFragment();
      Bundle args = new Bundle();
      args.putInt(ARG_SECTION_NUMBER, sectionNumber);
      fragment.setArguments(args);
      return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      return inflater.inflate(R.layout.fragment_main, container, false);
    }
  }

  public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      switch (position) {
        case 0:
          return Fragment1.newInstance();
        case 1:
          return Fragment2.newInstance();
        case 2:
          return Fragment3.newInstance();
        case 3:
          return Fragment4.newInstance();
      }
      return null;
    }

    @Override
    public int getCount() {
      return 4;
    }
  }
  public void setCurrentItem (int item, boolean smoothScroll) {
    mViewPager.setCurrentItem(item, smoothScroll);
  }
}
