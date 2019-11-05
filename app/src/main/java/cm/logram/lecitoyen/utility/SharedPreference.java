package cm.logram.lecitoyen.utility;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cm.logram.lecitoyen.model.Data;

public class SharedPreference {
	
    public static final String PREFS_NAME = "WORD_APP";
    public static final String FAVORITES = "Words_Favorite";

    public SharedPreference() {
        super();
    }
    
    // This four methods are used for maintaining favorites.
    
    //save to sharedPreference
    public void saveFavorites(Context context, List<Data> favorites) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);
        editor.apply();
    }
    
    //add to sharedPreference
    public void addFavorite(Context context, Data data) {
        List<Data> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<Data>();
        favorites.add(data);
        saveFavorites(context, favorites);
    }

    //remove from sharedPreference
    public void removeFavorite(Context context, Data data) {
        ArrayList<Data> favorites = getFavorites(context);
        if (favorites != null) {
            favorites.remove(data);
            saveFavorites(context, favorites);
        }
    }

    //get all words from sharedPreference
    public ArrayList<Data> getFavorites(Context context) {
        SharedPreferences settings;
        List<Data> favorites;

        settings = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);

        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            Data[] favoriteItems = gson.fromJson(jsonFavorites,	Data[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<Data>(favorites);
        } else
            return null;

        return (ArrayList<Data>) favorites;
    }
}
