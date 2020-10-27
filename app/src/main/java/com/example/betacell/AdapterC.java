package com.example.betacell;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterC
extends RecyclerView.Adapter<AdapterC.ConsejosViewHolder>
implements View.OnClickListener{

    private  View.OnClickListener listener;

    List<ConsejosLista> consejos;
    Context context;

    AdapterC(List<ConsejosLista> consejos, Context context){
        this.consejos = consejos;
        this.context = context;
    }



    @NonNull
    @Override
    public ConsejosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.lista, parent, false);
        view.setOnClickListener(this);
        ConsejosViewHolder cvh= new ConsejosViewHolder(view);

        return cvh;
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull ConsejosViewHolder holder, int position) {
        final int pos = position;
        holder.nombreConsejo.setText(consejos.get(position).nombre);
        holder.descripcion.setText(consejos.get(position).descripcion);


        Drawable original = context
                .getResources()
                .getDrawable(consejos.get(position).imagen
                        ,null);

        Bitmap originalBitmap = ((BitmapDrawable) original).getBitmap();

        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(context.getResources()
                        , originalBitmap);

        roundedDrawable.setCornerRadius(originalBitmap.getHeight());

        holder.imagen.setImageDrawable(roundedDrawable);
    }

    @Override
    public int getItemCount() {
        return consejos.size();
    }

    public  void setOncCickListener(View.OnClickListener listener){
       this.listener = listener;
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onClick(View v) {

        if( listener != null ){
            listener.onClick(v);
        }
    }


    public static class ConsejosViewHolder extends RecyclerView.ViewHolder {

            CardView cv;
            TextView nombreConsejo;
            TextView descripcion;
            ImageView imagen;

            ConsejosViewHolder(View itemView){
            super(itemView);
            cv =(CardView)itemView.findViewById(R.id.cv);
            nombreConsejo = (TextView)itemView.findViewById(R.id.nombreConsejo);
            descripcion = (TextView)itemView.findViewById(R.id.descripcion);
            imagen = (ImageView)itemView.findViewById(R.id.imagen);

}
    }
}
