package quemb.com.qmbform.fontawesomeextension.sample;

import com.joanzapata.android.iconify.IconDrawable;
import com.joanzapata.android.iconify.Iconify;
import com.quemb.qmbform.CellViewFactory;
import com.quemb.qmbform.FormManager;
import com.quemb.qmbform.OnFormRowClickListener;
import com.quemb.qmbform.descriptor.FormDescriptor;
import com.quemb.qmbform.descriptor.FormItemDescriptor;
import com.quemb.qmbform.descriptor.OnFormRowValueChangedListener;
import com.quemb.qmbform.fontawesomeextension.descriptor.RowDescriptor;
import com.quemb.qmbform.descriptor.SectionDescriptor;
import com.quemb.qmbform.descriptor.Value;
import com.quemb.qmbform.fontawesomeextension.descriptor.Image;
import com.quemb.qmbform.fontawesomeextension.view.FormFontAwesomeFieldCell;
import com.quemb.qmbform.fontawesomeextension.view.FormFontAwesomeVerticalFieldCell;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.HashMap;

import quemb.com.qmbform.fontawesomeextension.sample.R;


public class MainActivity extends ActionBarActivity implements OnFormRowValueChangedListener,
        OnFormRowClickListener {

    private ListView mListView;

    public static String TAG = "MainActivity";

    private FormManager mFormManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list);

        CellViewFactory.getInstance().setRowTypeMap(RowDescriptor.FormRowDescriptorTypeFontAwesome, FormFontAwesomeFieldCell.class);
        CellViewFactory.getInstance().setRowTypeMap(RowDescriptor.FormRowDescriptorTypeFontAwesomeVertical, FormFontAwesomeVerticalFieldCell.class);



        FormDescriptor descriptor = FormDescriptor.newInstance();
        descriptor.setOnFormRowValueChangedListener(this);

        SectionDescriptor sectionDescriptor = SectionDescriptor.newInstance("section","FontAwesome Image Cells");
        descriptor.addSection(sectionDescriptor);

        sectionDescriptor.addRow( RowDescriptor
                .newInstance("fontAwesome", RowDescriptor.FormRowDescriptorTypeFontAwesome, "FontAwesome Icon Title",
                        new Value<Image>(new Image(Iconify.IconValue.fa_arrow_circle_left, R.color.fa_color))) );

        sectionDescriptor.addRow( RowDescriptor
                .newInstance("fontAwesomeVertical", RowDescriptor.FormRowDescriptorTypeFontAwesomeVertical, "FontAwesomeVertical Icon Title",
                        new Value<Image>(new Image(Iconify.IconValue.fa_share))) );

        mFormManager = new FormManager();
        mFormManager.setup(descriptor, mListView, this);
        mFormManager.setOnFormRowClickListener(this);
    }
    public void onCreateView(){}



    @Override
    public void onFormRowClick(FormItemDescriptor itemDescriptor) {

    }

    @Override
    public void onValueChanged(com.quemb.qmbform.descriptor.RowDescriptor rowDescriptor, Value<?> oldValue, Value<?> newValue) {
        Log.d(TAG, "Value Changed: " + rowDescriptor.getTitle());
//

    }



}
