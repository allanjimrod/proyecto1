package com.ucenfotec.ac.cr.proyecto1.capadatos;

import com.ucenfotec.ac.cr.proyecto1.entidades.Producto;
import dataAccess.AccesoBD;
import dataAccess.Conector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductoDAO {
    private AccesoBD accesoDB;

    public ProductoDAO() {
        try {
            this.accesoDB = Conector.getConector("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://;database=proyecto_progra;integratedSecurity=true;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Producto getProducto(int id) {
        try {
            ResultSet rs = this.accesoDB.ejecutarSQL("SELECT * FROM Producto WHERE id=" + id, true);
            if(rs.next())
            {
                return extraerProductoDelResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Producto> getAllProductos() {
        try {
            ResultSet rs = this.accesoDB.ejecutarSQL("SELECT * FROM Producto", true);
            List<Producto> productos = new ArrayList<>();
            while(rs.next())
            {
                Producto user = extraerProductoDelResultSet(rs);
                productos.add(user);
            }
            return productos;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean insertarProducto(Producto producto) {
        try {
            String sql = "INSERT INTO Producto VALUES (NULL, %s, %s, %s)";
            sql = String.format(sql, producto.getNombre(), producto.getLogo(), producto.getDescripcion());
            this.accesoDB.ejecutarSQL(sql);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean actualizarProducto(Producto producto) {
        try {
            String sql = "UPDATE Producto SET" +
                    "cedula = %s, " +
                    "nombre = %s, " +
                    "puesto = %s, " +
                    "WHERE id = %d";
            sql = String.format(sql,
                    producto.getNombre(),
                    producto.getLogo(),
                    producto.getDescripcion(),
                    producto.getId()
            );

            this.accesoDB.ejecutarSQL(sql);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean eliminarProducto(int id) {
        try {
            String sql = "DELETE FROM Producto WHERE id = " + id;
            this.accesoDB.ejecutarSQL(sql);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    private Producto extraerProductoDelResultSet(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        producto.setId( rs.getInt("id") );
        producto.setNombre( rs.getString("nombre") );
        producto.setLogo( rs.getString("logo") );
        producto.setDescripcion( rs.getString("descripcion"));
        return producto;
    }
}

