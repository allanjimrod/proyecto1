package com.ucenfotec.ac.cr.proyecto1.capalogica;

import com.ucenfotec.ac.cr.proyecto1.capadatos.ClienteDAO;
import com.ucenfotec.ac.cr.proyecto1.entidades.Cliente;

import java.util.Set;

public class ClienteLogica {
    private ClienteDAO capaDatos;

    public ClienteLogica() {
        this.capaDatos = new ClienteDAO();
    }

    public Cliente getCliente(int id) {
        Cliente cliente = this.capaDatos.getCliente(id);
        return cliente;
    }

    public Set<Cliente> getAllClientes() {
        Set<Cliente> clientes = this.capaDatos.getAllClientes();
        return clientes;
    }

    public boolean insertarCliente(Cliente cliente) {
        return this.capaDatos.insertarCliente(cliente);
    }

    public Cliente actualizarCliente(Cliente cliente) {
        this.capaDatos.actualizarCliente(cliente);
        return this.capaDatos.getCliente(cliente.getId());
    }

    public void eliminarCliente(int id) {
        this.capaDatos.eliminarCliente(id);
    }
}
