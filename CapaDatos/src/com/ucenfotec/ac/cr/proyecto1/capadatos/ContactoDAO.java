package com.ucenfotec.ac.cr.proyecto1.capadatos;

import com.ucenfotec.ac.cr.proyecto1.entidades.Contacto;
import dataAccess.AccesoBD;
import dataAccess.Conector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


public class ContactoDAO {
    private AccesoBD accesoDB;

    public ContactoDAO() {
        try {
            this.accesoDB = Conector.getConector("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://;database=proyecto_progra;integratedSecurity=true;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Contacto getContacto(int id) {
        try {
            ResultSet rs = this.accesoDB.ejecutarSQL("SELECT * FROM Contacto WHERE id=" + id, true);
            if(rs.next())
            {
                return extraerContactoDelResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Set<Contacto> getAllContactos() {
        try {
            ResultSet rs = this.accesoDB.ejecutarSQL("SELECT * FROM Contacto", true);
            Set<Contacto> contactos = new HashSet<>();
            while(rs.next())
            {
                Contacto user = extraerContactoDelResultSet(rs);
                contactos.add(user);
            }
            return contactos;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean insertarContacto(Contacto contacto) {
        try {
            String sql = "INSERT INTO Contacto VALUES (NULL, %s, %s, %s, %s, %s)";
            sql = String.format(sql, contacto.getCedula(), contacto.getNombre(), contacto.getPuesto(), contacto.getTelefono(),
             contacto.getCorreo());
            this.accesoDB.ejecutarSQL(sql);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean actualizarContacto(Contacto contacto) {
        try {
            String sql = "UPDATE Contacto SET" +
                    "cedula = %s, " +
                    "nombre = %s, " +
                    "puesto = %s, " +
                    "telefono = %s, " +
                    "correo = %s, " +
                    "WHERE id = %d";
            sql = String.format(sql,
                    contacto.getCedula(),
                    contacto.getNombre(),
                    contacto.getPuesto(),
                    contacto.getTelefono(),
                    contacto.getCorreo(),
                    contacto.getId()
            );

            this.accesoDB.ejecutarSQL(sql);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean eliminarContacto(int id) {
        try {
            String sql = "DELETE FROM Contacto WHERE id = " + id;
            this.accesoDB.ejecutarSQL(sql);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    private Contacto extraerContactoDelResultSet(ResultSet rs) throws SQLException {
        Contacto contacto = new Contacto();
        contacto.setId( rs.getInt("id") );
        contacto.setCedula( rs.getString("cedula") );
        contacto.setNombre( rs.getString("nombre") );
        contacto.setTelefono( rs.getString("telefono") );
        contacto.setCorreo( rs.getString("correo") );
        return contacto;
    }
}
