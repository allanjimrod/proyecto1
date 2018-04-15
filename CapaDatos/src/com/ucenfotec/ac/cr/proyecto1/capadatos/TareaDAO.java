package com.ucenfotec.ac.cr.proyecto1.capadatos;

import com.ucenfotec.ac.cr.proyecto1.entidades.Tarea;
import dataAccess.AccesoBD;
import dataAccess.Conector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class TareaDAO {
    private AccesoBD accesoDB;

    public TareaDAO() {
        try {
            this.accesoDB = Conector.getConector("sqlserver", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Tarea getTarea(int id) {
        try {
            ResultSet rs = this.accesoDB.ejecutarSQL("SELECT * FROM Tarea WHERE id=" + id, true);
            if(rs.next())
            {
                return extraerTareaDelResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Set<Tarea> getAllTareas() {
        try {
            ResultSet rs = this.accesoDB.ejecutarSQL("SELECT * FROM Tarea", true);
            Set<Tarea> tareas = new HashSet<>();
            while(rs.next())
            {
                Tarea user = extraerTareaDelResultSet(rs);
                tareas.add(user);
            }
            return tareas;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean insertarTarea(Tarea tarea) {
        try {
            String sql = "INSERT INTO Tarea VALUES (NULL, %s, %s, %s, %s, %s, %s)";
            sql = String.format(sql, tarea.getIdInstalacion(), tarea.getCodigo(), tarea.getDescripcion(), tarea.getEstado(),
                    tarea.getTipo(), tarea.getResponsable());
            this.accesoDB.ejecutarSQL(sql);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean actualizarTarea(Tarea tarea) {
        try {
            String sql = "UPDATE Tarea SET" +
                    "idInstalacion = %s, " +
                    "codigo = %s, " +
                    "descripcion = %s, " +
                    "estado = %s, " +
                    "tipo = %s, " +
                    "responsable = %s, " +
                    "WHERE id = %d";
            sql = String.format(sql,
                    tarea.getIdInstalacion(),
                    tarea.getCodigo(),
                    tarea.getDescripcion(),
                    tarea.getEstado(),
                    tarea.getTipo(),
                    tarea.getResponsable(),
                    tarea.getId()
            );

            this.accesoDB.ejecutarSQL(sql);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean eliminarTarea(int id) {
        try {
            String sql = "DELETE FROM Tarea WHERE id = " + id;
            this.accesoDB.ejecutarSQL(sql);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    private Tarea extraerTareaDelResultSet(ResultSet rs) throws SQLException {
        Tarea tarea = new Tarea();
        tarea.setId( rs.getInt("id") );
        tarea.setIdInstalacion( rs.getInt("idInstalacion") );
        tarea.setCodigo( rs.getString("codigo") );
        tarea.setDescripcion( rs.getString("descripcion") );
        tarea.setEstado( rs.getString("estado") );
        tarea.setTipo( rs.getString("tipo") );
        tarea.setResponsable( rs.getString("responsable") );
        return tarea;
    }
}
