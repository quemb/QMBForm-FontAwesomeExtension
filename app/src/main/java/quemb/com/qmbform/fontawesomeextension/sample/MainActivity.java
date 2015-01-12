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

    private MenuItem mSaveMenuItem;
    public static String TAG = "SampleFormActivity";

    private FormManager mFormManager;

    private HashMap<String, Value<?>> mChangesMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list);
        mChangesMap = new HashMap<String, Value<?>>();

        CellViewFactory.getInstance().setRowTypeMap(RowDescriptor.FormRowDescriptorTypeFontAwesome, FormFontAwesomeFieldCell.class);
        CellViewFactory.getInstance().setRowTypeMap(RowDescriptor.FormRowDescriptorTypeFontAwesomeVertical, FormFontAwesomeVerticalFieldCell.class);



        FormDescriptor descriptor = FormDescriptor.newInstance();
        descriptor.setOnFormRowValueChangedListener(this);

        SectionDescriptor sectionDescriptor = SectionDescriptor.newInstance("section","FontAwesome Image Cells");
        descriptor.addSection(sectionDescriptor);

        sectionDescriptor.addRow(RowDescriptor
                .newInstance("detail", RowDescriptor.FormRowDescriptorTypeName, "Title",
                        new Value<String>("Detail")));

        sectionDescriptor.addRow( RowDescriptor
                .newInstance("fontAwesome", RowDescriptor.FormRowDescriptorTypeFontAwesome, "Title",
                        new Value<Image>(new Image(Iconify.IconValue.fa_share))) );

        mFormManager = new FormManager();
        mFormManager.setup(descriptor, mListView, this);
        mFormManager.setOnFormRowClickListener(this);
    }
    public void onCreateView(){}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFormRowClick(FormItemDescriptor itemDescriptor) {

    }

    @Override
    public void onValueChanged(com.quemb.qmbform.descriptor.RowDescriptor rowDescriptor, Value<?> oldValue, Value<?> newValue) {
        Log.d(TAG, "Value Changed: " + rowDescriptor.getTitle());
//
        mChangesMap.put(rowDescriptor.getTag(), newValue);
        updateSaveItem();
    }
    private void updateSaveItem() {
        if (mSaveMenuItem != null){
            mSaveMenuItem.setVisible(mChangesMap.size()>0);
        }
    }


}
