package tl;

import java.util.ArrayList;

import bl.Persona;
import bl.PersonaFisica;
import bl.PersonaJuridica;
import dl.CL;


public class Gestor {

    private CL logica;

    public Gestor() {
        logica = new CL();
    }

    public void insertarPersonaFisica(String nombre, String identificacion, String apellido, String estadoCivil){
        logica.insertarPersonaFisica(nombre, identificacion, apellido, estadoCivil);
    }

    public void insertarPersonaJuridica(String nombre, String identificacion, String responsable, String industria){
        logica.insertarPersonaJuridica(nombre, identificacion, responsable, industria);
    }

    public String[] getListaFisica() {
        String[] datos;
        datos = new String[logica.getListaFisica().size()];
        int i;
        i = 0;
        for(PersonaFisica data : logica.getListaFisica()){
            datos[i] = data.toString();
            i++;
        }
        return datos;
    }

    public String[] getListaJuridica() {
        String[] datos;
        datos = new String[logica.getListaJuridica().size()];
        int i;
        i = 0;
        for(PersonaJuridica data : logica.getListaJuridica()){
            datos[i] = data.toString();
            i++;
        }
        return datos;
    }

    public String[] getListaPersonas() {
        String[] datos;
        datos = new String[logica.getListaPersonas().size()];
        int i;
        i = 0;
        for(Persona data : logica.getListaPersonas()){
            datos[i] = data.toString();
            i++;
        }
        return datos;
    }
}
