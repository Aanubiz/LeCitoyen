package cm.logram.lecitoyen.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.crowdfire.cfalertdialog.CFAlertDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.anim.AnimationUtils;
import cm.logram.lecitoyen.model.Data;
import cm.logram.lecitoyen.reglesDeDroits.CodeDeProcedurePenale;
import cm.logram.lecitoyen.sqlite.DBSQLiteHandlerCPP;

@SuppressLint("NewApi")
public class AdapterCodeDeProcedurePenale extends RecyclerView.Adapter<AdapterCodeDeProcedurePenale.ItemsViewHolder>{
  private TextToSpeech textToSpeech;
	private List<Data> wordsList;
	public List<Data> favouriteData = new ArrayList<Data>();
	private Context context;
	static CodeDeProcedurePenale clickListener;
	DBSQLiteHandlerCPP dbHandler;
  int mPreviousPosition = -1;
  public ArrayList<Data> wordsListDB;
  private String searchString="";

  public AdapterCodeDeProcedurePenale(Context context, List<Data> wordsList){
		this.wordsList=wordsList;
		this.context=context;
		this.dbHandler = new DBSQLiteHandlerCPP(context);
		this.wordsListDB = (ArrayList<Data>) wordsList;
	}
	
	@NonNull
  @Override
	public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
		return new ItemsViewHolder(view);
  }
	
	@Override
	public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {
		Data data = wordsList.get(position);

    holder.titre.setText(data.getTitre());
		holder.article.setText(data.getArticle());
		holder.description.setText(data.getDescription());


		/*Permet de mettre en surbrillance les mot recherchés*/
    String art = wordsList.get(position).getArticle().toLowerCase(Locale.getDefault());
    String desc = wordsList.get(position).getDescription().toLowerCase(Locale.getDefault());
    holder.article.setText(wordsList.get(position).getArticle());
    holder.description.setText(wordsList.get(position).getDescription());

    if (art.contains(searchString)) {
      int startPos = art.indexOf(searchString);
      int endPos = startPos + searchString.length();
      Spannable spanString = Spannable.Factory.getInstance().newSpannable(holder.article.getText());
      spanString.setSpan(new ForegroundColorSpan(Color.WHITE), startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
      spanString.setSpan(new BackgroundColorSpan(Color.parseColor("#00574B")), startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
      holder.article.setText(spanString);
    }else if (desc.contains(searchString)) {
      int startPos2 = desc.indexOf(searchString);
      int endPos2 = startPos2 + searchString.length();
      Spannable spanString2 = Spannable.Factory.getInstance().newSpannable(holder.description.getText());
      spanString2.setSpan(new ForegroundColorSpan(Color.WHITE), startPos2, endPos2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
      spanString2.setSpan(new BackgroundColorSpan(Color.parseColor("#00574B")), startPos2, endPos2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
      holder.description.setText(spanString2);
    }

		/*Si l'article existe deja dans la base de données*/
		if(checkFavouriteItem(data)){
      //Drawable starFilled = VectorDrawableCompat.create(context.getResources(), R.drawable.ic_star_yellow_24dp, null);
			Drawable starFilled = ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_star_yellow_24dp, null);

      assert starFilled != null;
      starFilled.setBounds(0,0,24,24);
			holder.imgButtonFavourite.setBackground(starFilled);
			holder.imgButtonFavourite.setTag("filled");
			
		}else{
      Drawable starEmpty = ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_star_black_24dp, null);

			assert starEmpty != null;
			starEmpty.setBounds(0,0,24,24);
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

  public void updateList(List<Data> list, String newText) {
    wordsList = new ArrayList<>();
    wordsList.addAll(list);
    this.searchString = newText;
    notifyDataSetChanged();
  }

	@Override
	public int getItemCount() {
		return wordsList.size();
		//return (null != wordsList ? wordsList.size() : 0);
	}



  public class ItemsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
		TextView titre,article,description;
		ImageButton imgButtonFavourite;
		boolean starred = false;		
		
		public ItemsViewHolder(View itemView){
			super(itemView);

      titre = itemView.findViewById(R.id.titre);
			article = itemView.findViewById(R.id.article);
			description = itemView.findViewById(R.id.description);
			imgButtonFavourite = itemView.findViewById(R.id.imgButton_Favourite);

			//Initialisation du speech
      textToSpeech = new TextToSpeech(context.getApplicationContext(), new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
          if(status != TextToSpeech.ERROR) {
            textToSpeech.setLanguage(Locale.FRANCE);
          }
        }
      });

			itemView.setOnClickListener(this);	
			imgButtonFavourite.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View view) {
					
					String tag = imgButtonFavourite.getTag().toString();
					if (tag.equalsIgnoreCase("empty") && !starred) {
						dbHandler.addWord(wordsList.get(getAdapterPosition()));

						imgButtonFavourite.setTag("filled");
            Drawable starFilled = ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_star_yellow_24dp, null);
            if (starFilled != null) {
              starFilled.setBounds(0, 0, 24, 24);
            }
            imgButtonFavourite.setBackground(starFilled);
						
						Snackbar.make(view, "Added to Favorites", Snackbar.LENGTH_LONG).setAction("Remove",new View.OnClickListener() {
							
							@Override
							public void onClick(View view) {
								dbHandler.removeWord(wordsList.get(getAdapterPosition()));
                Drawable star = ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_star_black_24dp, null);

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
						//*******//	
						
						imgButtonFavourite.setTag("empty");
            Drawable starEmpty = ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_star_black_24dp, null);
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
                dbHandler.addWord(wordsList.get(getAdapterPosition()));

                imgButtonFavourite.setTag("filled");
                Drawable starFilled = ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_star_yellow_24dp, null);

                if (starFilled != null) {
                  starFilled.setBounds(0, 0, 24, 24);
                }
                imgButtonFavourite.setBackground(starFilled);
                Snackbar snackbar = Snackbar.make(view, "Ajouté aux Favoris", Snackbar.LENGTH_LONG)
                    .setAction("Annuler", new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                        dbHandler.removeWord(wordsList.get(getAdapterPosition()));
                        Drawable star = ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_star_black_24dp, null);
                        if (star != null) {
                          star.setBounds(0,0,24,24);
                        }
                        imgButtonFavourite.setBackground(star);
                      }
                    });
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

	public void setListener(CodeDeProcedurePenale clicked){
		AdapterCodeDeProcedurePenale.clickListener = clicked;
	}

	public interface ClickListener{
		public void itemClicked(View view, int position);
	}

  public void setFilter(List<Data> list) {
    wordsList = new ArrayList<>();
    wordsList.addAll(list);
    notifyDataSetChanged();
  }
}
