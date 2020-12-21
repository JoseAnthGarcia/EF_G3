package Daos;

import Beans.Cartelera;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CarteleraDao {
    public ArrayList<Cartelera> listaCarteleras(idCine){
        ArrayList<Cartelera> lista = new ArrayList<>();
        String sql = "select department_name,max(e.salary) as 'maxSalary', min(e.salary) as'minSalary',\n" +
                "((max(e.salary)+min(e.salary))/2) as 'promedio'\n" +
                "from employees e\n" +
                "inner join departments d on e.department_id = d.department_id\n" +
                "group by e.department_id;";
        try(Connection connection = getConection();
            Statement statement = connection.createStatement();
            ResultSet rs= statement.executeQuery(sql);) {
            while (rs.next()){
                SalarioPorDepartamentoDto salarioPorDepartamentoDto = new SalarioPorDepartamentoDto();
                salarioPorDepartamentoDto.setNombreDepartamento(rs.getString(1));
                salarioPorDepartamentoDto.setSalarioMaximo(rs.getBigDecimal(2));
                salarioPorDepartamentoDto.setSalarioMinimo(rs.getBigDecimal(3));
                salarioPorDepartamentoDto.setSalarioPromedio(rs.getBigDecimal(4));
                lista.add(salarioPorDepartamentoDto);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lista;
    }
}
