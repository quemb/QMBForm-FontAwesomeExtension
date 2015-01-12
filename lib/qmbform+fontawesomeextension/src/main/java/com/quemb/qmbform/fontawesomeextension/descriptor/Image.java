package com.quemb.qmbform.fontawesomeextension.descriptor;

import com.joanzapata.android.iconify.IconDrawable;
import com.joanzapata.android.iconify.Iconify;
import com.quemb.qmbform.descriptor.OnValueChangeListener;
import com.quemb.qmbform.fontawesomeextension.R;

import android.graphics.Color;

/**
 * Created by tonimoeckel on 14.07.14.
 */
public class Image {


    private Iconify.IconValue mIcon;
    private int mColor = 17170446 ;

    private OnValueChangeListener mOnValueChangeListener;


    public Image() { }

    public Image(Iconify.IconValue icon, int color){
        mIcon = icon;
        mColor = color;
    }
    public Image(Iconify.IconValue icon){
        mIcon = icon;
    }

    public Iconify.IconValue getIcon(){
        return mIcon;
    }

    public int getColor(){
        return mColor;
    }


    public void setImage(Iconify.IconValue icon, int color){
        mIcon = icon;
        mColor = color;
        if (mOnValueChangeListener != null){
            mOnValueChangeListener.onChange(icon);
        }
    }


    public void setOnValueChangeListener(OnValueChangeListener listener) {
        this.mOnValueChangeListener = listener;
    }
}
