package com.quemb.qmbform.fontawesomeextension.view;

import com.joanzapata.android.iconify.IconDrawable;
import com.joanzapata.android.iconify.Iconify;
import com.quemb.qmbform.fontawesomeextension.R;
import com.quemb.qmbform.fontawesomeextension.descriptor.Image;
import com.quemb.qmbform.descriptor.RowDescriptor;
import com.quemb.qmbform.descriptor.Value;
import com.quemb.qmbform.view.FormTitleFieldCell;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by tonimoeckel on 15.07.14.
 */
public class FormFontAwesomeFieldCell extends FormTitleFieldCell {

    private ImageView mImageView;

    public FormFontAwesomeFieldCell(Context context,
            RowDescriptor rowDescriptor) {
        super(context, rowDescriptor);
    }

    @Override
    protected void init() {

        super.init();

        mImageView = (ImageView)findViewById(R.id.imageView);

    }

    @Override
    protected int getResource() {
        return R.layout.fontawesome_field_cell;
    }

    @Override
    protected void update() {

        super.update();

        Value<Image> value = getRowDescriptor().getValue();
        if ( value != null && value.getValue() != null ) {


            IconDrawable drawable = new IconDrawable(getContext(), Iconify.IconValue.fa_adjust)
                    .actionBarSize();
            getImageView().setImageDrawable(drawable);
        }

    }

    public ImageView getImageView() {
        return mImageView;
    }

    public void setImageView(ImageView imageView) {
        mImageView = imageView;
    }
}
