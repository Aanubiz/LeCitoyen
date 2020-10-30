package cm.logram.lecitoyen.adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdView;

import java.util.List;

import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.items.MenuRegle;
import cm.logram.lecitoyen.reglesDeDroits.RegleDeDroit;


public class AdapterRegleDeDroit extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int MENU_ITEM_VIEW_TYPE = 0;
    private static final int BANNER_AD_VIEW_TYPE = 1;
    private final Context context;
    private final List<Object> recyclerViewItems;



    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private List<String> mValues;
    private int[] mMaterialColors;
    private int mType;


    /**
     * For this example app, the recyclerViewItems list contains only
     * {@link MenuRegle} and {@link AdView} types.
     */
    public AdapterRegleDeDroit(Context context, List<Object> recyclerViewItems) {
        this.context = context;
        this.recyclerViewItems = recyclerViewItems;
    }

    /**
     * The {@link MenuItemViewHolder} class.
     * Provides a reference to each view in the menu item view.
     */
    public static class MenuItemViewHolder extends RecyclerView.ViewHolder {
        private TextView titre;
        private ImageView image;

        MenuItemViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.img1);
            titre = view.findViewById(R.id.title);

        }
    }

    /**
     * The {@link AdViewHolder} class.
     */
    public static class AdViewHolder extends RecyclerView.ViewHolder {
        AdViewHolder(View view) {
            super(view);
        }
    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }

    /**
     * Determines the view type for the given position.
     */
    @Override
    public int getItemViewType(int position) {
        return (position % RegleDeDroit.ITEMS_PER_AD == 0) ? BANNER_AD_VIEW_TYPE : MENU_ITEM_VIEW_TYPE;
    }

    /**
     * Creates a new view for a menu item view or a banner ad view
     * based on the viewType. This method is invoked by the layout manager.
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case MENU_ITEM_VIEW_TYPE:
                View menuItemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                        R.layout.recycler_item, viewGroup, false);
                return new MenuItemViewHolder(menuItemLayoutView);
            case BANNER_AD_VIEW_TYPE:
                // fall through
            default:
                View bannerLayoutView = LayoutInflater.from(
                        viewGroup.getContext()).inflate(R.layout.banner_ad_container,
                        viewGroup, false);
                return new AdViewHolder(bannerLayoutView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case MENU_ITEM_VIEW_TYPE:
                MenuItemViewHolder menuItemHolder = (MenuItemViewHolder) holder;
                MenuRegle menuItem = (MenuRegle) recyclerViewItems.get(position);

                // Get the menu item image resource ID.
                String imageName = menuItem.getImageName();
                int imageResID = context.getResources().getIdentifier(imageName, "drawable",
                        context.getPackageName());

                // Add the menu item details to the menu item view.
                menuItemHolder.image.setImageResource(imageResID);
                menuItemHolder.titre.setText(menuItem.getTitre());

                break;
            case BANNER_AD_VIEW_TYPE:
                // fall through
            default:
                AdViewHolder bannerHolder = (AdViewHolder) holder;
                AdView adView = (AdView) recyclerViewItems.get(position);
                ViewGroup adCardView = (ViewGroup) bannerHolder.itemView;
                if (adCardView.getChildCount() > 0) {
                    adCardView.removeAllViews();
                }
                if (adView.getParent() != null) {
                    ((ViewGroup) adView.getParent()).removeView(adView);
                }

                // Add the banner ad to the ad view.
                adCardView.addView(adView);
        }
    }








}
