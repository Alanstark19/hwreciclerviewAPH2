package com.example.hwreciclerviewaph;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    //variables
    private List<ListElement> mData; //lista que contendra todos los datos de tipo listElement
    private LayoutInflater mInflater;//layout inflater para describir el tipo de layout
    private Context context;//contexto, clase de la que se llama el adaptador

    /**
     * Constructor
     * @param itemList
     * @param context
     */
    public ListAdapter(List<ListElement> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
    //creando una vista               //referencia de como se mostrara en el recycler
        View view = mInflater.inflate(R.layout.list_element, null);
        //se le asigna la vista al adapter
        return  new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }

    /**
     * método que crea un listado nuevo
     * se definen los item de la lista
     * @param items
     */
    public void setItems(List<ListElement> items){
        mData = items;
    }

    /**
     *
     * declaramos cada elemento del listElemet
     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView name, city, status;

        ViewHolder(View itemView){
            super(itemView);
            //uniendo la parte lógica con la grafica con find..
            iconImage = itemView.findViewById(R.id.iconImageView);
            name = itemView.findViewById(R.id.nameTextView);
            city = itemView.findViewById(R.id.cityTextView);
            status = itemView.findViewById(R.id.statusTextView);
        }

        void bindData(final ListElement item){
            //cambios de cada etiqueta
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(item.getName());
            city.setText(item.getCity());
            status.setText(item.getStatus());
        }


    }
}
