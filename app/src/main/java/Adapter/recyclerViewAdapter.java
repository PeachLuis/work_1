package Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.luis.work_1.Activity.RecyclerView_Activity;
import com.example.luis.work_1.R;

import java.util.ArrayList;
import java.util.List;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> data = new ArrayList<>();

    public recyclerViewAdapter(Context mContext, List<String> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item,parent,false);
        return new recyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String myData = data.get(position);
        holder.textView.setText(myData);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0:data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView ;

        MyViewHolder(View view){
            super(view);
            textView = (TextView) view.findViewById(R.id.recycler_view_text);
        }
    }

}
