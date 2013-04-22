package com.example.womad;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HorariosAdaptor extends BaseExpandableListAdapter{
	
	private Context context;
	private ArrayList<String> groups;
	private ArrayList<ArrayList<ObjetoListadoHorario>> children;
    private LayoutInflater mInflater;
	
	public HorariosAdaptor(Context context, ArrayList<String> groups,ArrayList<ArrayList<ObjetoListadoHorario>> children) {
		mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.context = context;
		this.groups = groups;
		this.children = children;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return children.get(groupPosition).get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.layaout_programa_lista, null);
            holder = new ViewHolder();
            holder.hora = (TextView)convertView.findViewById(R.id.hora);
            holder.artista = (TextView)convertView.findViewById(R.id.artista);
            holder.lugar = (TextView)convertView.findViewById(R.id.lugar);
            holder.pais = (TextView)convertView.findViewById(R.id.pais);
            holder.fotoGrupo = (ImageView)convertView.findViewById(R.id.list_image);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
		
		ObjetoListadoHorario objetoListadoHorario = (ObjetoListadoHorario) getChild(groupPosition, childPosition);
		holder.hora.setText(objetoListadoHorario.getHora());
        holder.artista.setText(objetoListadoHorario.getNombre());
        holder.lugar.setText(objetoListadoHorario.getEscenario());
        holder.pais.setText(objetoListadoHorario.getPais());
        int imagen = context.getResources().getIdentifier(objetoListadoHorario.getImagen(),"drawable", context.getPackageName());
        holder.fotoGrupo.setImageResource(imagen);
        return convertView;

	}
	
	public static class ViewHolder {
        public TextView hora;
        public TextView artista;
        public TextView lugar;
        public TextView pais;
        public ImageView fotoGrupo;
    }

	@Override
	public int getChildrenCount(int groupPosition) {
		return children.get(groupPosition).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return groups.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return groups.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		String group = (String) getGroup(groupPosition);
		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.group_layaout, null);
		}
		TextView tv = (TextView) convertView.findViewById(R.id.tvGroup);
		tv.setText(group);
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		return true;
	}
	
	 @Override
	 public boolean areAllItemsEnabled() {
	  return true;
	 }
}

