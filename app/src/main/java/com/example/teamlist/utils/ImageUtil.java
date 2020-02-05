package com.example.teamlist.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ImageUtil {

    public static Drawable returnDrawable(Context context, int drawableId) {
        Resources resources = context.getResources();
        return resources.getDrawable(drawableId);
    }
}
