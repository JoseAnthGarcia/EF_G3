package Daos;

import Beans.Cine;
import Beans.Empleado;
import Beans.Rol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoDao extends BaseDao {

    public Empleado validarEmpleado(String username, String password) {

        Empleado empleado = null;

        String sql = "select * from empleado e\n" +
                "left join rolempleado re on re.idempleado=e.idempleado\n" +
                "left join rol r on re.idrol=r.idrol\n" +
                "where dni = ? and (dni-salario)=?;";

        try (Connection conn = getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    empleado = new Empleado();
                    empleado.setIdEmpleado(rs.getInt(1));
                    empleado.setNombre(rs.getString(2));
                    empleado.setApellido(rs.getString(3));
                    empleado.setDni(rs.getString(4));
                    empleado.setSalario(rs.getBigDecimal(5));
                    empleado.setFechaContrato(rs.getString(6));
                    empleado.setNombreUsuario(rs.getString(7));
                    empleado.setEdad(rs.getInt(8));
                    empleado.setActivo(rs.getBoolean(9)); //TODO: cuidado aqui

                    Cine cine = new Cine();
                    cine.setIdCine(rs.getInt(10));
                    empleado.setCine(cine);

                    Empleado jefe = new Empleado();
                    jefe.setIdEmpleado(rs.getInt(11));
                    empleado.setJefe(jefe);

                    Rol rol = new Rol();
                    rol.setIdRol(rs.getInt("r.idrol"));
                    rol.setNombre(rs.getString("r.nombre"));

                    ArrayList<Rol> roles = new ArrayList<>();
                    roles.add(rol);

                    empleado.setRoles(roles);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        String sq2 = "select * from empleado where dni = ? and (dni-salario)=?;";
        return empleado;
    }



}
