package com.quemb.qmbform.fontawesomeextension.view;

import com.quemb.qmbform.R;
import com.quemb.qmbform.descriptor.RowDescriptor;
import com.quemb.qmbform.view.FormDetailTextFieldCell;

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
        return R.layout.detail_text_vertical_field_cell;
    }
}
