import dataAccess.AccesoBD;
import dataAccess.Conector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


public class ClienteDAO {
    private AccesoBD accesoDB;

    public ClienteDAO() {
        try {
            this.accesoDB = Conector.getConector("sqlserver", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Cliente getCliente(int id) {
        try {
            ResultSet rs = this.accesoDB.ejecutarSQL("SELECT * FROM cliente WHERE id=" + id, true);
            if(rs.next())
            {
                return extraerClienteDelResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Set<Cliente> getAllClientes() {
        try {
            ResultSet rs = this.accesoDB.ejecutarSQL("SELECT * FROM cliente", true);
            Set<Cliente> clientes = new HashSet<Cliente>();
            while(rs.next())
            {
                Cliente user = extraerClienteDelResultSet(rs);
                clientes.add(user);
            }
            return clientes;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean insertarCliente(Cliente cliente) {
        try {
            String sql = "INSERT INTO cliente VALUES (NULL, %s, %s, %s, %s, %s, %s, %s, %s)";
            sql = String.format(sql, cliente.getNombre(), cliente.getDescripcion(), cliente.getRazonSocial(), cliente.getCedulaJuridica(),
                    cliente.getUbicacion(), cliente.getDireccionExacta(), cliente.getLogo(), cliente.getTelefono());
            this.accesoDB.ejecutarSQL(sql);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean actualizarCliente(Cliente cliente) {
        try {
            String sql = "UPDATE cliente SET" +
                    "nombre = %s, " +
                    "descripcion = %s, " +
                    "razonSocial = %s, " +
                    "cedulaJuridica = %s, " +
                    "ubicacion = %s, " +
                    "direccionExacta = %s, " +
                    "logo = %s, " +
                    "telefono = %s " +
                    "lider = %d " +
                    "contactoTI = %d " +
                    "WHERE id = %d";
            sql = String.format(sql,
                    cliente.getNombre(),
                    cliente.getDescripcion(),
                    cliente.getRazonSocial(),
                    cliente.getCedulaJuridica(),
                    cliente.getUbicacion(),
                    cliente.getDireccionExacta(),
                    cliente.getLogo(),
                    cliente.getTelefono(),
                    cliente.getLider(),
                    cliente.getContactoTI(),
                    cliente.getId()
            );

            this.accesoDB.ejecutarSQL(sql);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean eliminarCliente(int id) {
        try {
            String sql = "DELETE FROM cliente WHERE id = " + id;
            this.accesoDB.ejecutarSQL(sql);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    private Cliente extraerClienteDelResultSet(ResultSet rs) throws SQLException {
        Cliente user = new Cliente();
        user.setId( rs.getInt("id") );
        user.setNombre( rs.getString("nombre") );
        user.setDescripcion( rs.getString("descripcion") );
        user.setRazonSocial( rs.getString("razonSocial") );
        user.setCedulaJuridica( rs.getString("cedulaJuridica") );
        user.setUbicacion( rs.getString("ubicacion") );
        user.setDireccionExacta( rs.getString("direccionExacta") );
        user.setLogo( rs.getString("logo") );
        user.setTelefono( rs.getString("telefono") );
        user.setLider( rs.getInt("lider") );
        user.setContactoTI( rs.getInt("contactoTI") );
        return user;
    }
}
