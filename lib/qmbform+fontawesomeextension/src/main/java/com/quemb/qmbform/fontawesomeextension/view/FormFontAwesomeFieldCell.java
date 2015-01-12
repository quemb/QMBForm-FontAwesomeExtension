package com.quemb.qmbform.fontawesomeextension.view;

import com.joanzapata.android.iconify.IconDrawable;
import com.joanzapata.android.iconify.Iconify;
import com.quemb.qmbform.fontawesomeextension.R;
import com.quemb.qmbform.fontawesomeextension.descriptor.Image;
import com.quemb.qmbform.fontawesomeextension.descriptor.RowDescriptor;
import com.quemb.qmbform.descriptor.Value;
import com.quemb.qmbform.view.FormTitleFieldCell;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tonimoeckel on 15.07.14.
 */
public class FormFontAwesomeFieldCell extends FormTitleFieldCell {

    private TextView mDetailTextView;

    private ImageView mImageView;

    public FormFontAwesomeFieldCell(Context context,
            RowDescriptor rowDescriptor) {
        super(context, rowDescriptor);
    }

    @Override
    protected void init() {

        super.init();
        mDetailTextView = (TextView)findViewById(R.id.detailTextView);

        mImageView = (ImageView)findViewById(R.id.imageView);

    }

    @Override
    protected int getResource() {
        return R.layout.fontawesome_field_cell;
    }

    @Override
    protected void update() {

        super.update();

        if (getRowDescriptor().getHint(getContext())!= null){
            getDetailTextView().setHint(getRowDescriptor().getHint(getContext()));
        }

        Value<Image> value = getRowDescriptor().getValue();
        if ( value != null && value.getValue() != null ) {

            IconDrawable drawable = new IconDrawable(getContext(), value.getValue().getIcon())
                    .colorRes(value.getValue().getColor());
            getImageView().setImageDrawable(drawable);

//            if ( value.getValue() instanceof String ) {
//                getDetailTextView().setText((String) value.getValue());
//            } else {
//                getDetailTextView().setText(String.valueOf(value.getValue()));
//
//            }
        }

    }

    public TextView getDetailTextView() {
        return mDetailTextView;
    }

    public ImageView getImageView() {
        return mImageView;
    }

    public void setImageView(ImageView imageView) {
        mImageView = imageView;
    }
}
