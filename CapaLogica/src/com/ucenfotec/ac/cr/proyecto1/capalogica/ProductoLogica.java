package com.ucenfotec.ac.cr.proyecto1.capalogica;


import com.ucenfotec.ac.cr.proyecto1.capadatos.ProductoDAO;
import com.ucenfotec.ac.cr.proyecto1.entidades.Producto;

import java.util.Set;

public class ProductoLogica {
    private ProductoDAO capadatos;
    public ProductoLogica()
    {
        this.capadatos=new ProductoDAO();
    }

    public Producto getProducto(int id)
    {
        return this.capadatos.getProducto(id);
    }
    public Set getAllProductos()
    {
        Set<Producto>producto=this.capadatos.getAllProductos();
        return producto;
    }
    public boolean insertarProducto(Producto producto)
    {
        return this.capadatos.insertarProducto(producto);
    }
    public Producto actualizarProduucto(Producto producto)
    {
        this.capadatos.actualizarProducto(producto);
        return this.capadatos.getProducto(producto.getId());
    }
    public void eliminarProducto(int id){
        this.capadatos.eliminarProducto(id);
    }
}
