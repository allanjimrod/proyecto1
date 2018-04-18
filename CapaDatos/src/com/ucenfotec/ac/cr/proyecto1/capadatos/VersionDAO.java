package com.ucenfotec.ac.cr.proyecto1.capadatos;

import com.ucenfotec.ac.cr.proyecto1.entidades.Version;
import dataAccess.AccesoBD;
import dataAccess.Conector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VersionDAO {
    private AccesoBD accesoDB;

    public VersionDAO() {
        try {
            this.accesoDB = Conector.getConector("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://;database=proyecto_progra;integratedSecurity=true;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Version getVersion(int id) {
        try {
            ResultSet rs = this.accesoDB.ejecutarSQL("SELECT * FROM Versiones WHERE id=" + id, true);
            if(rs.next())
            {
                return extraerVersionDelResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Version> getAllVersions() {
        try {
            ResultSet rs = this.accesoDB.ejecutarSQL("SELECT * FROM Versiones", true);
            List<Version> versions = new ArrayList<>();
            while(rs.next())
            {
                Version user = extraerVersionDelResultSet(rs);
                versions.add(user);
            }
            return versions;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean insertarVersion(Version version) {
        try {
            String sql = "INSERT INTO Versiones VALUES (NULL, %s, %s, %s, %s, %s)";
            sql = String.format(sql, version.getNombre(), version.getIdProducto(), version.getDescripcion(), version.getLanzamiento());
            this.accesoDB.ejecutarSQL(sql);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean actualizarTarea(Version version) {
        try {
            String sql = "UPDATE Versiones SET" +
                    "nombre = %s, " +
                    "idProducto = %s, " +
                    "descripcion = %s, " +
                    "lanzamiento = %s, " +
                    "WHERE id = %d";
            sql = String.format(sql,
                    version.getNombre(),
                    version.getIdProducto(),
                    version.getDescripcion(),
                    version.getLanzamiento(),
                    version.getId()
            );

            this.accesoDB.ejecutarSQL(sql);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean eliminarVersion(int id) {
        try {
            String sql = "DELETE FROM Versiones WHERE id = " + id;
            this.accesoDB.ejecutarSQL(sql);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    private Version extraerVersionDelResultSet(ResultSet rs) throws SQLException {
        Version version = new Version();
        version.setId( rs.getInt("nombre") );
        version.setIdProducto( rs.getInt("idProducto") );
        version.setDescripcion( rs.getString("descripcion") );
        version.setLanzamiento( rs.getDate("lanzamiento") );
        return version;
    }
}
