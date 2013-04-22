package com.example.womad;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class ArtistasDescripcionActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_artistas_descripcion);
        
        Bundle extra = this.getIntent().getExtras();
        
        TextView nombre=(TextView) findViewById(R.id.nombreArtistasDescripcion);
        TextView pais=(TextView) findViewById(R.id.paisArtistasDescripcion);
        TextView descripcion=(TextView) findViewById(R.id.descripcionArtistasDescripcion);
        TextView horario=(TextView) findViewById(R.id.horarioArtistasDescripcion);
        ImageView imagen=(ImageView) findViewById(R.id.imagenArtistasDescripcion);
      
		nombre.setText(extra.getString("nombre"));
		pais.setText(extra.getString("pais"));
		descripcion.setText(extra.getString("descripcion"));
		horario.setText(extra.getString("horario"));
		String imagenNombre=extra.getString("imagen")+"_grande";
		int id = getResources().getIdentifier(imagenNombre, "drawable", getPackageName());
		imagen.setImageResource(id);
		//imagen.setImageResource(R.drawable.los_alienigenas_grande)
		//setImageDrawable(extra.getString("horario")+"Grande")
	}
}
