package cm.logram.lecitoyen.boommenu.Piece;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

import cm.logram.lecitoyen.R;
import cm.logram.lecitoyen.boommenu.Util;

final class Dot extends BoomPiece {

    public Dot(Context context) {
        super(context);
    }

    @Override
    public void init(int color, float cornerRadius) {
        Drawable backgroundDrawable;
        if (cornerRadius < 0) backgroundDrawable = Util.getDrawable(this, R.drawable.piece_dot, null)
                .mutate();
        else backgroundDrawable = Util.getDrawable(this, R.drawable.piece, null)
                .mutate();
        ((GradientDrawable)backgroundDrawable).setColor(color);
        if (cornerRadius >= 0) ((GradientDrawable)backgroundDrawable).setCornerRadius(cornerRadius);
        Util.setDrawable(this, backgroundDrawable);
    }

    @Override
    public void setColor(int color) {
        ((GradientDrawable)getBackground()).setColor(color);
    }

    @Override
    public void setColorRes(int colorRes) { setColor(Util.getColor(getContext(), colorRes)); }
}
