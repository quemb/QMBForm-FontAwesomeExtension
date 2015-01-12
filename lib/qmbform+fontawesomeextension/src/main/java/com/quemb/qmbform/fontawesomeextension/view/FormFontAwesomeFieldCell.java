package com.quemb.qmbform.fontawesomeextension.view;

import com.joanzapata.android.iconify.IconDrawable;
import com.joanzapata.android.iconify.Iconify;
import com.quemb.qmbform.R;
import com.quemb.qmbform.descriptor.RowDescriptor;
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

    }

    @Override
    protected int getResource() {
        return R.layout.detail_text_field_cell;
    }

    @Override
    protected void update() {

        super.update();

        if (getRowDescriptor().getHint(getContext())!= null){
            getDetailTextView().setHint(getRowDescriptor().getHint(getContext()));
        }

        Value<?> value = getRowDescriptor().getValue();
        if ( value != null && value.getValue() != null ) {

            IconDrawable drawable = new IconDrawable(getContext(), Iconify.IconValue.fa_share)
                    .colorRes(R.color.abc_search_url_text_normal);
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
