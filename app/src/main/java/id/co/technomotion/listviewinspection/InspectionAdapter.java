package id.co.technomotion.listviewinspection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by omayib on 6/13/15.
 *=======================
 * STEP 1
 *========================
 *1. create a class then extends using ArrayAdapter
 *2. create constructor
 */

 public class InspectionAdapter extends ArrayAdapter<String> {

    /**
     *=======================
     * STEP 2
     *========================
     *declare some object that will use letter
     *
     */
    Context context;
    int resource;
    LayoutInflater inflater;

    public InspectionAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     *=======================
     * STEP 3
     *========================
     *inspect getview() method
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String data=getItem(position);
        System.out.printf("position :%d , data :%s",position,data+"\n");
        Holder holder;
        if(convertView==null){
            System.out.println("inflating....");

            convertView=inflater.inflate(resource,parent,false);
            holder=new Holder();
            holder.textView= (TextView) convertView.findViewById(R.id.textView);

            convertView.setTag(holder);
        }else{
            System.out.println("get tag....");
            holder= (Holder) convertView.getTag();
        }
        System.out.println(convertView+" used by data "+data);
        System.out.println("set data to textview");
        holder.textView.setText(data);
        return convertView;
    }

    private static class Holder{
        TextView textView;
    }
}
