package com.example.teamlist.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ImageUtil {

    public static Drawable returnDrawable(Context context, String drawableString) {
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(drawableString,
                "drawable", context.getPackageName());
        return resources.getDrawable(idDrawable);
    }
}
