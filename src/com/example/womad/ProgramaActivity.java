package com.example.womad;

import java.util.ArrayList;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Window;

public class ProgramaActivity extends ExpandableListActivity{
	
	HorariosAdaptor mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_programa);
		
		ArrayList<String> dias = new ArrayList<String>();
		dias.add("Jueves");
		dias.add("Viernes");
		dias.add("Sabado");
				
        CargarPrograma cargador=new CargarPrograma(getApplicationContext(), R.xml.programa);
      	mAdapter = new HorariosAdaptor(getApplicationContext(), dias, cargador.parse());
		
      	setListAdapter(mAdapter);
	}
}
