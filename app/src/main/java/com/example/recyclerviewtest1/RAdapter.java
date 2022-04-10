package com.example.recyclerviewtest1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RAdapter extends RecyclerView.Adapter<RAdapter.ViewHolder>{

    //so I think this i gonna be the data that's gonna be attached to viewHolders
    private String[] localDataSet;


    //THE VIEW HOLDER CLASS
    //this is the intermediary between xml layout for each item, and the java code
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView textView;

        //this runs when the view holder is created,
        //basically just grabs the element with id "textview" of whatever view is passed to it.
        public ViewHolder(View view) {
            super(view);

            //grabs text view
            textView = (TextView) view.findViewById(R.id.textView);

            //puts an onClickListener to it, so that whenever the element is tapped,
            //it will call the onClick method in this object
            textView.setOnClickListener(this);
        }

        //a method that returns the text view it grabbed earlier.
        public TextView getTextView() {
            return textView;
        }

        public void onClick(View v){
         int pos = getAdapterPosition();
         Toast.makeText(v.getContext(), "" + pos,Toast.LENGTH_SHORT).show();
        }


    }

    //this runs when the adapter is created
    //it takes in the data that's gonna populate the recyclerView and stores it in 'localDataSet'
    //in this case the data is an array of strings
    public RAdapter(String[] dataSet) {
        localDataSet = dataSet;
    }

    //this method is called by the layout manager whenever a new view needs to be created
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //layout inflators instantiate a view from an xml file.
        //this method creates an inflator with the context of this app
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        //the inflate method takes the takes an element (refenced through R.layout... which is
        //an abstract class that keeps track of all the resources in the project... I don't really get it)
        //and instantiates it into a view
        View view = inflater.inflate(R.layout.text_row_item, parent, false);

        //we now take the view just created and pack it in a new viewholder object, which will then do its thing to it
        return new ViewHolder(view);
    }

    //this method is called by the layout manager to change the contents of a view (via that view's viewHolder)
    public void onBindViewHolder(ViewHolder viewHolder, final int position){

        //retrieves the textview of the given view using the method we made in the viewHolder class
        TextView textView = viewHolder.getTextView();

        //sets the text of that viewHolder to the data in the given position of the dataSet
        textView.setText(localDataSet[position]);

    }

    //DON'T FORGET  returns the length of the dataset (array)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }

}
