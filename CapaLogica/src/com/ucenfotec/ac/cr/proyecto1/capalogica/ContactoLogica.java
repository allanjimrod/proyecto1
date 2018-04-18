package com.ucenfotec.ac.cr.proyecto1.capalogica;

import com.ucenfotec.ac.cr.proyecto1.capadatos.ContactoDAO;
import com.ucenfotec.ac.cr.proyecto1.entidades.Contacto;

import java.util.List;
import java.util.Set;

public class ContactoLogica {
    private ContactoDAO capaDatos;

    public ContactoLogica()
    {
        this.capaDatos=new ContactoDAO();
    }
    public Contacto getContacto(int id)
    {
        Contacto contacto=this.capaDatos.getContacto(id);
        return contacto;
    }
    public List<Contacto> getAllContactos()
    {
        List<Contacto> contactos=this.capaDatos.getAllContactos();
        return contactos;
    }
    public boolean insertarContacto(Contacto contacto)
    {
        return this.capaDatos.insertarContacto(contacto);
    }
    public Contacto actualizarContacto(Contacto contacto)
    {
        this.capaDatos.actualizarContacto(contacto);
        return this.capaDatos.getContacto(contacto.getId());
    }
    public void eliminarCliente(int id)
    {
        this.capaDatos.eliminarContacto(id);
    }
}
