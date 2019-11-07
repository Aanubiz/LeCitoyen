package cm.logram.lecitoyen.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.speech.tts.TextToSpeech;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.crowdfire.cfalertdialog.CFAlertDialog;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.anim.AnimationUtils;
import cm.logram.lecitoyen.model.Data;
import cm.logram.lecitoyen.sqlite.DBSQLiteHandlerCPP;

@SuppressLint("NewApi")
public class AdapterFavorisCodeDeProcedurePenale extends RecyclerView.Adapter<AdapterFavorisCodeDeProcedurePenale.ItemsViewHolder>{
	private TextToSpeech textToSpeech;
	private List<Data> wordsList;
	public List<Data> favouriteData = new ArrayList<Data>();
	int mPreviousPosition = -1;
	Context context;
	static ClickListener clickListener;
	DBSQLiteHandlerCPP dbHandler;

	public AdapterFavorisCodeDeProcedurePenale(Context con, List<Data> wordsList){
		this.wordsList=wordsList;
		this.context=con;
		this.dbHandler = new DBSQLiteHandlerCPP(context);
	}
	
	@NonNull
	@Override
	public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
		return new ItemsViewHolder(view);
	}
	
	@Override
	public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {
		
		Data dataMapper = wordsList.get(position);

		holder.titre.setText(dataMapper.getTitre());
		holder.article.setText(dataMapper.getArticle());
		holder.description.setText(dataMapper.getDescription());
			
		/*If a product exists in SQLite then set filled star drawable and set a tag*/
		if(checkFavouriteItem(dataMapper)){
			Drawable starFilled = ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_star_yellow_24dp, null);
      if (starFilled != null) {
        starFilled.setBounds(0,0,24,24);
      }
      holder.imgButtonFavourite.setBackground(starFilled);
			holder.imgButtonFavourite.setTag("filled");
			
		}else{
		  Drawable starEmpty = ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_star_black_24dp,null);
      if (starEmpty != null) {
        starEmpty.setBounds(0,0,24,24);
      }
      holder.imgButtonFavourite.setBackground(starEmpty);
			holder.imgButtonFavourite.setTag("empty");			
		}

		//Animation des elements de recyclerView
		if(position>mPreviousPosition){
			AnimationUtils.animateScatter(holder, true);
		}else{
			AnimationUtils.animateScatter(holder, true);
		}
		mPreviousPosition = position;
	}
	
	@Override
	public int getItemCount() {
		return wordsList.size();
		//return (null != wordsList ? wordsList.size() : 0);
	}
	
	public class ItemsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
		
		TextView titre, article, description;
		ImageButton imgButtonFavourite;
		boolean starred = false;		
		
		public ItemsViewHolder(View itemView){
			super(itemView);
			
			titre = itemView.findViewById(R.id.titre);
			article = itemView.findViewById(R.id.article);
			description = itemView.findViewById(R.id.description);
			imgButtonFavourite = itemView.findViewById(R.id.imgButton_Favourite);
			
			itemView.setOnClickListener(this);	
			imgButtonFavourite.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View view) {
					
					String tag = imgButtonFavourite.getTag().toString();
					if (tag.equalsIgnoreCase("empty") && !starred) {
						dbHandler.addWord(wordsList.get(getAdapterPosition()));
						imgButtonFavourite.setTag("filled");
						Drawable starFilled = ResourcesCompat.getDrawable(view.getResources(), R.drawable.ic_star_yellow_24dp, null);

						if (starFilled != null) {
              starFilled.setBounds(0, 0, 24, 24);
            }
            imgButtonFavourite.setBackground(starFilled);
						
						Snackbar.make(view, "Added to Favorites", Snackbar.LENGTH_LONG).setAction("Remove",new View.OnClickListener() {
							
							@Override
							public void onClick(View view) {
								dbHandler.removeWord(wordsList.get(getAdapterPosition()));
								Drawable star = ResourcesCompat.getDrawable(view.getResources(), R.drawable.ic_star_black_24dp, null);

								if (star != null) {
                  star.setBounds(0,0,24,24);
                }
                imgButtonFavourite.setBackground(star);
							}
						}).show();
					} else {
						dbHandler.removeWord(wordsList.get(getAdapterPosition()));
						wordsList.remove(getAdapterPosition());
						notifyItemRemoved(getAdapterPosition());
						notifyItemRangeChanged(getAdapterPosition(), wordsList.size());
						
						imgButtonFavourite.setTag("empty");
						Drawable starEmpty = ResourcesCompat.getDrawable(view.getResources(), R.drawable.ic_star_black_24dp, null);

						if (starEmpty != null) {
              starEmpty.setBounds(0, 0, 24, 24);
            }
            imgButtonFavourite.setBackground(starEmpty);
					}					
					starred =! starred;				
				}	
			});
		}
		
		@Override
		public void onClick(final View view) {
			if(clickListener!=null){
				CFAlertDialog.Builder builder = new CFAlertDialog.Builder(view.getContext())
						.setDialogStyle(CFAlertDialog.CFAlertStyle.BOTTOM_SHEET)
						.addButton("Ecouter la version audio", -1, view.getResources().getColor(R.color.material_blue_400), CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.CENTER, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								textToSpeech.speak(wordsList.get(getAdapterPosition()).getDescription(), TextToSpeech.QUEUE_FLUSH, null);
								dialog.dismiss();
							}
						})
						.addButton("    Ajouter aux Favoris    ", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.CENTER, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Snackbar snackbar = Snackbar.make(view, "Existe deja dans les favoris", Snackbar.LENGTH_LONG);
								View sbView = snackbar.getView();
								sbView.setBackgroundColor(view.getResources().getColor(R.color.material_blue_grey_900));
								snackbar.show();
								dialog.dismiss();
							}
						});
				builder.show();
			}
		}
	}
	
	//Checks whether a particular product exists in SQLiteDB
	public boolean checkFavouriteItem(Data checkStarredItem){
		boolean check = false;		
		
		ArrayList<Data> itemsInDB = dbHandler.getWords();
		
		if(itemsInDB!=null){
			for(Data data : itemsInDB){
				if((data.getArticle()).equals(checkStarredItem.getArticle())) {
					check = true;
					break;
				}
			}
		}
        return check;
	}	

	public void setListener(ClickListener clicked){
		AdapterFavorisCodeDeProcedurePenale.clickListener = clicked;
	}	
	
	public interface ClickListener{
		public void itemClicked(View view, int position);
	}	
}