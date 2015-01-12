package com.quemb.qmbform.fontawesomeextension;

import com.quemb.qmbform.descriptor.FormItemDescriptor;
import com.quemb.qmbform.fontawesomeextension.descriptor.RowDescriptor;
import com.quemb.qmbform.descriptor.SectionDescriptor;
import com.quemb.qmbform.view.Cell;
import com.quemb.qmbform.view.FormBaseCell;
import com.quemb.qmbform.view.SectionCell;

import android.content.Context;
import android.os.Build;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Created by tonimoeckel on 14.07.14.
 */
public class CellViewFactory {

    private static CellViewFactory instance = null;
    private HashMap<String, Class <? extends FormBaseCell>> mViewRowTypeMap;

    public static CellViewFactory getInstance() {
        if (instance == null) {
            instance = new CellViewFactory();
        }
        return instance;
    }

    public CellViewFactory(){

        int currentapiVersion = Build.VERSION.SDK_INT;

        mViewRowTypeMap = new HashMap<String, Class<? extends FormBaseCell>>();
        mViewRowTypeMap.put(RowDescriptor.FormRowDescriptorTypeFontAwesome, FormFontAwesomeFieldCell.class);
        mViewRowTypeMap.put(RowDescriptor.FormRowDescriptorTypeFontAwesomeVertical, FormFontAwesomeVerticalFieldCell.class);

    }

    public Cell createViewForFormItemDescriptor(Context context, FormItemDescriptor descriptor){

        Cell rowView = null;

        if (descriptor instanceof SectionDescriptor){

            SectionCell sectionCell = new SectionCell(context, (SectionDescriptor) descriptor);
            rowView = sectionCell;

        } else if (descriptor instanceof RowDescriptor){
            RowDescriptor row = (RowDescriptor) descriptor;
            try {
                FormBaseCell formBaseCell;

                formBaseCell = mViewRowTypeMap.get(row.getRowType()).getConstructor(Context.class, RowDescriptor.class).newInstance(
                        context, row);
                rowView = formBaseCell;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        }

        return rowView;

    }

    public void setRowTypeMap(String descriptorType, Class<? extends FormBaseCell> clazz){
        mViewRowTypeMap.put(descriptorType, clazz);
    }

}
