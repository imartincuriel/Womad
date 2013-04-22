package com.example.womad;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;

public class ArtistasActivity extends ListActivity{
	
	ArtistasAdaptor mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_artistas);
				
        CargarListadoArtistas cargador=new CargarListadoArtistas(getApplicationContext(), R.xml.listado_artistas);
      	mAdapter = new ArtistasAdaptor(getApplicationContext(), cargador.parse());
		setListAdapter(mAdapter);
		//vf.setAnimation(AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.slide_left));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent intent= new Intent();
		intent.setClass(getApplicationContext(), ArtistasDescripcionActivity.class);
		ObjetoListadoFoto objetoListado=(ObjetoListadoFoto)l.getAdapter().getItem(position);
		intent.putExtra("nombre",objetoListado.getNombre());
		intent.putExtra("horario",objetoListado.getHorario());
		intent.putExtra("lugar", objetoListado.getLugar());
		intent.putExtra("pais", objetoListado.getPais());
		intent.putExtra("descripcion", objetoListado.getDescripcionLarga());
		intent.putExtra("imagen", objetoListado.getImagen());
		objetoListado.getDescripcionLarga();
		startActivity(intent);
	}
}
