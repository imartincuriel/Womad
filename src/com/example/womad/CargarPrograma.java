package com.example.womad;

import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.res.XmlResourceParser;

public class CargarPrograma {
    private int direccionXml;
    private ObjetoListadoHorario objetoListadoHorario;
    private Context context;
    
    public CargarPrograma() {
	}
    
    public CargarPrograma(Context context, int direccionXML){
    	this.context=context;
    	this.direccionXml=direccionXML;
    }
    
    public ArrayList<ArrayList<ObjetoListadoHorario>> parse()
    {
        ArrayList<ArrayList<ObjetoListadoHorario>> listado=null;
        ArrayList<ObjetoListadoHorario> jueves;
        ArrayList<ObjetoListadoHorario> viernes;
        ArrayList<ObjetoListadoHorario> sabado;
        ArrayList<ObjetoListadoHorario> auxiliar=null;
  
      //Obtenemos un parser XmlPull asociado a nuestro XML
        XmlResourceParser parser = context.getResources().getXml(this.direccionXml);
        
        try {
			int evento = parser.getEventType();
			
			while (evento != XmlPullParser.END_DOCUMENT)
            {
				String etiqueta = null;
				 
                switch (evento)
                {
                case XmlPullParser.START_DOCUMENT:
                	 
                    listado = new ArrayList<ArrayList<ObjetoListadoHorario>>();
                    break;
                    
            	case XmlPullParser.START_TAG:
            	 
            		etiqueta = parser.getName();
            		
            		if(etiqueta.equals("jueves")){
            			jueves=new ArrayList<ObjetoListadoHorario>();
            			auxiliar=jueves;
            		}else if(etiqueta.equals("viernes")){
            			viernes=new ArrayList<ObjetoListadoHorario>();
            			auxiliar=viernes;
            		}else if(etiqueta.equals("sabado")){
            			sabado=new ArrayList<ObjetoListadoHorario>();
            			auxiliar=sabado;
            		}else if (etiqueta.equals("actuacion"))
                    {
                        objetoListadoHorario = new ObjetoListadoHorario();
                    }
            		else if (objetoListadoHorario != null)
                    {
            			if (etiqueta.equals("hora"))
                        {
                            try {
								objetoListadoHorario.setHora(parser.nextText());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                        }
            			else if (etiqueta.equals("artista"))
                        {
                            try {
								objetoListadoHorario.setNombre(parser.nextText());
							} catch (IOException e) {
								e.printStackTrace();
							}
                        }
            			else if (etiqueta.equals("pais"))
                        {
                            try {
								objetoListadoHorario.setPais(parser.nextText());
							} catch (IOException e) {
								e.printStackTrace();
							}
                        }
            			else if (etiqueta.equals("lugar"))
                        {
                            try {
								objetoListadoHorario.setEscenario(parser.nextText());
							} catch (IOException e) {
								e.printStackTrace();
							}
                        }
            			else if (etiqueta.equals("imagen"))
                        {
                            try {
								objetoListadoHorario.setImagen(parser.nextText());
							} catch (IOException e) {
								e.printStackTrace();
							}
                        }
                    } 
            		break;
            		
            case XmlPullParser.END_TAG:
            	 
                etiqueta = parser.getName();

                if (etiqueta.equals("actuacion") && objetoListadoHorario != null)
                {
                    auxiliar.add(objetoListadoHorario);
                }                
                if (etiqueta.equals("jueves") ||etiqueta.equals("viernes")||etiqueta.equals("sabado"))
                	listado.add(auxiliar);
                break;	

            }
            try {
				evento = parser.next();
			} catch (IOException e) {
				e.printStackTrace();
			}
            }
			
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}
 
        return listado;
    }
}
