package com.quemb.qmbform.fontawesomeextension.view;

import com.quemb.qmbform.fontawesomeextension.R;
import com.quemb.qmbform.descriptor.RowDescriptor;

import android.content.Context;

/**
 * Created by tonimoeckel on 15.07.14.
 */
public class FormFontAwesomeVerticalFieldCell extends FormFontAwesomeFieldCell {

    public FormFontAwesomeVerticalFieldCell(Context context,
            RowDescriptor rowDescriptor) {
        super(context, rowDescriptor);
    }

    @Override
    protected int getResource() {
        return R.layout.fontawesome_vertical_field_cell;
    }
}
