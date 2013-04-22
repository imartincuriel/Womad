package com.example.womad;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException; 
import android.content.Context;
import android.content.res.XmlResourceParser;
 
public class CargarListadoArtistas
{
    private int direccionXml;
    private ObjetoListadoFoto objetoListadoFoto;
    private Context context;
 
    public CargarListadoArtistas(Context context, int direccionXml)
    {
    	this.direccionXml=direccionXml;
    	this.context=context;
    }
 
    public ArrayList<ObjetoListadoFoto> parse()
    {
        ArrayList<ObjetoListadoFoto> listado = new ArrayList<ObjetoListadoFoto>();
  
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
                	 
                    listado = new ArrayList<ObjetoListadoFoto>();
                    break;
                    
            	case XmlPullParser.START_TAG:
            	 
            		etiqueta = parser.getName();
            		if (etiqueta.equals("artista"))
                    {
                        objetoListadoFoto = new ObjetoListadoFoto();
                    }
            		else if (objetoListadoFoto != null)
                    {
            			if (etiqueta.equals("nombre"))
                        {
                            try {
								objetoListadoFoto.setNombre(parser.nextText());
							} catch (IOException e) {
								e.printStackTrace();
							}
                        }
            			else if (etiqueta.equals("descripcion"))
                        {
                            try {
								objetoListadoFoto.setComentario(parser.nextText());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                        }else if (etiqueta.equals("descripcionLarga"))
                        {
                            try {
								objetoListadoFoto.setDescripcionLarga(parser.nextText());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                        }else if (etiqueta.equals("horario"))
                        {
                            try {
								objetoListadoFoto.setHorario(parser.nextText());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                        }
            			else if (etiqueta.equals("pais"))
                        {
                            try {
								objetoListadoFoto.setPais(parser.nextText());
							} catch (IOException e) {
								e.printStackTrace();
							}
                        }
            			else if (etiqueta.equals("imagen"))
                        {
                            try {
								objetoListadoFoto.setImagen(parser.nextText());
							} catch (IOException e) {
								e.printStackTrace();
							}
                        }
                    } 
            		break;
            		
            case XmlPullParser.END_TAG:
            	 
                etiqueta = parser.getName();

                if (etiqueta.equals("artista") && objetoListadoFoto != null)
                {
                    listado.add(objetoListadoFoto);
                }
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