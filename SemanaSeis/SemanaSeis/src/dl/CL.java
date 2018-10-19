package dl;

import bl.Persona;
import bl.PersonaFisica;
import bl.PersonaJuridica;

import java.util.ArrayList;

public class CL {

    private ArrayList<PersonaFisica> listaFisica;
    private ArrayList<PersonaJuridica> listaJuridica;

    public CL() {
        listaFisica = new ArrayList<>();
        listaJuridica = new ArrayList<>();
    }

    public ArrayList<PersonaFisica> getListaFisica() {
        cargarFisico();
        return this.listaFisica;
    }

    public ArrayList<PersonaJuridica> getListaJuridica() {
        ArrayList<PersonaJuridica>lista;
        lista = new ArrayList<>(listaJuridica);
        return lista;
    }

    public ArrayList<Persona> getListaPersonas(){
        ArrayList<Persona>lista;
        lista = new ArrayList<>();
        lista.addAll(listaFisica);
        lista.addAll(listaJuridica);
        return lista;
    }
    public void insertarPersonaFisica(String nombre, String identificacion, String apellido, String estadoCivil){
        PersonaFisica pfisica = new PersonaFisica(nombre, identificacion, apellido, estadoCivil);
        guardarFisico(pfisica.outData());
    }

    public void insertarPersonaJuridica(String nombre, String identificacion, String responsable, String industria){
        PersonaJuridica pjuridica = new PersonaJuridica(nombre, identificacion, responsable, industria);
        guardarJuridica(pjuridica.outData());
    }

    // este metodo recibe un string del objeto para luego meterlo en el archivo de texto
    public void guardarFisico(String pfisico){}

    //este metodo hace que traiga la informacion del archivo de texto y se la va metiendo al arraylist
    public void cargarFisico(){}

    public void guardarJuridica(String pfisico){}

    public void cargarJuridico(){}
}
