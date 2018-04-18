package com.ucenfotec.ac.cr.proyecto1.capadatos;

import com.ucenfotec.ac.cr.proyecto1.entidades.Instalacion;
import dataAccess.AccesoBD;
import dataAccess.Conector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InstalacionDAO {
    private AccesoBD accesoDB;

    public InstalacionDAO() {
        try {
            this.accesoDB = Conector.getConector("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://;database=proyecto_progra;integratedSecurity=true;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Instalacion getInstalacion(int id) {
        try {
            ResultSet rs = this.accesoDB.ejecutarSQL("SELECT * FROM Instalacion WHERE id=" + id, true);
            if(rs.next())
            {
                return extraerInstalacionDelResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Instalacion> getAllInstalaciones() {
        try {
            ResultSet rs = this.accesoDB.ejecutarSQL("SELECT * FROM Instalacion", true);
            List<Instalacion> instalacion = new ArrayList<>();
            while(rs.next())
            {
                Instalacion user = extraerInstalacionDelResultSet(rs);
                instalacion.add(user);
            }
            return instalacion;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean insertarInstalacion(Instalacion instalacion) {
        try {
            String sql = "INSERT INTO Instalacion VALUES (NULL, %s, %s, %s, %s, %s)";
            sql = String.format(sql, instalacion.getIdCliente(), instalacion.getIdVersion(), instalacion.getFechaInstalacion(), instalacion.getEstado(),
                    instalacion.getNotas());
            this.accesoDB.ejecutarSQL(sql);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean actualizarInstalacion(Instalacion instalacion) {
        try {
            String sql = "UPDATE Instalacion SET" +
                    "idCliente = %s, " +
                    "idVersion = %s, " +
                    "fechaInstalacion = %s, " +
                    "estado = %s, " +
                    "notas = %s, " +
                    "WHERE id = %d";
            sql = String.format(sql,
                    instalacion.getIdCliente(),
                    instalacion.getIdVersion(),
                    instalacion.getFechaInstalacion(),
                    instalacion.getEstado(),
                    instalacion.getNotas(),
                    instalacion.getId()
            );

            this.accesoDB.ejecutarSQL(sql);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean eliminarInstalacion(int id) {
        try {
            String sql = "DELETE FROM Instalacion WHERE id = " + id;
            this.accesoDB.ejecutarSQL(sql);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    private Instalacion extraerInstalacionDelResultSet(ResultSet rs) throws SQLException {
        Instalacion instalacion = new Instalacion();
        instalacion.setId( rs.getInt("id") );
        instalacion.setIdCliente( rs.getInt("idCliente") );
        instalacion.setIdVersion( rs.getString("idVersion") );
        instalacion.setFechaInstalacion( rs.getDate("fechaInstalacion") );
        instalacion.setEstado( rs.getString("estado") );
        instalacion.setNotas( rs.getString("notas") );
        return instalacion;
    }
}

