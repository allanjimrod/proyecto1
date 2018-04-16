package com.ucenfotec.ac.cr.proyecto1.capalogica;

import com.ucenfotec.ac.cr.proyecto1.capadatos.InstalacionDAO;
import com.ucenfotec.ac.cr.proyecto1.entidades.Instalacion;

import java.util.Set;

public class InstalacionLogica {
    private InstalacionDAO capaDatos;

    public InstalacionLogica()
    {
        this.capaDatos=new InstalacionDAO();
    }
    public Instalacion getInstalacion(int id)
    {
        Instalacion instalacion =this.capaDatos.getInstalacion(id);
        return instalacion;
    }
    public Set<Instalacion> getAllInstalacions()
    {
        Set<Instalacion> instalacion =this.capaDatos.getAllInstalaciones();
        return instalacion;
    }
    public boolean insertarInstalacion(Instalacion instalacion)
    {
        return this.capaDatos.insertarInstalacion(instalacion);
    }
    public Instalacion actualizarInstalacion(Instalacion instalacion)
    {
        this.capaDatos.actualizarInstalacion(instalacion);
        return this.capaDatos.getInstalacion(instalacion.getId());
    }
    public void eliminarCliente(int id)
    {
        this.capaDatos.eliminarInstalacion(id);
    }
}
