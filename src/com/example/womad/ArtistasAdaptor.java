
package com.example.womad;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ArtistasAdaptor extends BaseAdapter{
	
	private ArrayList<ObjetoListadoFoto> mData = new ArrayList<ObjetoListadoFoto>();
    private LayoutInflater mInflater;
    private Context context;
    
    public ArtistasAdaptor(Context context, ArrayList<ObjetoListadoFoto> mData) {
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context=context;
        this.mData=mData;
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public ObjetoListadoFoto getItem(int position) {
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	public void addItem(final ObjetoListadoFoto item){
		mData.add(item);
		notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		System.out.println("getView " + position + " " + convertView);
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.layaout_artistas_lista, null);
            holder = new ViewHolder();
            holder.nombre = (TextView)convertView.findViewById(R.id.artista);
            holder.descripcion = (TextView)convertView.findViewById(R.id.descripcion);
            holder.pais = (TextView)convertView.findViewById(R.id.pais);
            holder.fotoGrupo = (ImageView)convertView.findViewById(R.id.list_image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        ObjetoListadoFoto objetoListadoFoto = getItem(position);
        holder.nombre.setText(objetoListadoFoto.getNombre());
        holder.descripcion.setText(objetoListadoFoto.getComentario());
        holder.pais.setText(objetoListadoFoto.getPais());
        int imagen = context.getResources().getIdentifier(objetoListadoFoto.getImagen(),"drawable", context.getPackageName());
        holder.fotoGrupo.setImageResource(imagen);
        return convertView;
	}
	
    public static class ViewHolder {
        public TextView nombre;
        public TextView descripcion;
        public TextView pais;
        public ImageView fotoGrupo;
    }

}
