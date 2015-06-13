package id.co.technomotion.listviewinspection;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.*;

public class MainActivity extends ActionBarActivity {

    /**
     *=======================
     * STEP 1
     *========================
     *declare some views that will use     *
     */
    Button btnAddItem,btnClearItem;
    ListView listView;
    InspectionAdapter inspectionAdapter;
    List<String> listData=new ArrayList<String>();
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         *=======================
         * STEP 2
         *========================
         *match the view based on id
         */
        btnAddItem= (Button) findViewById(R.id.buttonAddItem);
        btnClearItem= (Button) findViewById(R.id.buttonClearItem);
        listView= (ListView) findViewById(R.id.listView);
        /**
         *=======================
         * STEP 3
         *========================
         *initiate the InspectionAdapter then set to your listview
         */
        inspectionAdapter=new InspectionAdapter(this,R.layout.item_row,listData);
        listView.setAdapter(inspectionAdapter);
        /**
         *=======================
         * STEP 4
         *========================
         *activate your button using setOnClickListener() method
         */
        counter=0;
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                listData.add("item ke-"+counter);
                inspectionAdapter.notifyDataSetChanged();
            }
        });

        btnClearItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listData.clear();
                inspectionAdapter.notifyDataSetChanged();
            }
        });
    }

}
