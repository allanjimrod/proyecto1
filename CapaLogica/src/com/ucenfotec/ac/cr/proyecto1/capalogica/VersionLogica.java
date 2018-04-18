package com.ucenfotec.ac.cr.proyecto1.capalogica;

import com.ucenfotec.ac.cr.proyecto1.capadatos.VersionDAO;
import com.ucenfotec.ac.cr.proyecto1.entidades.Version;

import java.util.List;
import java.util.Set;

public class VersionLogica {
    private VersionDAO capaDatos;
    public VersionLogica(){
        this.capaDatos=new VersionDAO();
    }
    public Version getVersion(int id)
    {
        return this.capaDatos.getVersion(id);
    }
    public List<Version> getAllVersiones()
    {
        List<Version> version=this.capaDatos.getAllVersions();
        return version;
    }
    public boolean insertarVersion(Version version)
    {
        return this.capaDatos.insertarVersion(version);
    }
    public Version actualizarVersion(Version version)
    {
        this.capaDatos.actualizarTarea(version);
        return this.capaDatos.getVersion(version.getId());
    }
    public void eliminarTarea(int id)
    {
        this.capaDatos.eliminarVersion(id);
    }
}
