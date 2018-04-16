package com.ucenfotec.ac.cr.proyecto1.capalogica;

import com.ucenfotec.ac.cr.proyecto1.capadatos.TareaDAO;
import com.ucenfotec.ac.cr.proyecto1.entidades.Tarea;

import java.util.Set;

public class TareaLogica {
    private TareaDAO capaDatos;

    public TareaLogica() {
        this.capaDatos=new TareaDAO();
    }

    public Tarea getAllTarea(int id)
    {
        return this.capaDatos.getTarea(id);
    }
    public Set getAllTareas()
    {
        Set<Tarea>tarea=this.capaDatos.getAllTareas();
        return tarea;
    }
    public boolean insertarTarea(Tarea tarea)
    {
        return this.capaDatos.insertarTarea(tarea);
    }
    public Tarea actualizarTarea(Tarea tarea)
    {
        this.capaDatos.actualizarTarea(tarea);
        return this.capaDatos.getTarea(tarea.getId());
    }
    public void eliminarTarea(int id)
    {
        this.capaDatos.eliminarTarea(id);
    }
}
