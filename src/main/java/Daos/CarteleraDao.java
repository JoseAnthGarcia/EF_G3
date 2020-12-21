package Daos;

import Beans.*;

import java.sql.*;
import java.util.ArrayList;

public class CarteleraDao extends BaseDao{
    public ArrayList<Cartelera> listaCarteleras(int idCine){
        ArrayList<Cartelera> lista = new ArrayList<>();
        String sql = "select car.idCartelera,p.idpelicula,p.nombre,ci.idcine, ci.nombre,cad.nombre_comercial, car.`3d`, car.doblada, car.subtitulada, car.horario\n" +
                "from cine ci\n" +
                "inner join cadena cad on ci.idcadena=cad.idcadena\n" +
                "inner join cartelera car on car.idcine= ci.idcine\n" +
                "inner join pelicula p on p.idpelicula= car.idpelicula\n" +
                "where ci.idcine=?;";
        try (Connection conn = getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, idCine);


            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    Cartelera cartelera = new Cartelera();
                    cartelera.setIdCartelera(rs.getInt(1));
                    Pelicula pelicula = new Pelicula();
                    pelicula.setIdPelicula(rs.getInt(2));
                    pelicula.setNombre(rs.getString(3));
                    cartelera.setPelicula(pelicula);
                    Cine cine = new Cine();
                    cine.setIdCine(rs.getInt(4));
                    cine.setNombre(rs.getString(5));
                    Cadena cadena = new Cadena();
                    cadena.setNombreComercial(rs.getString(6));
                    cine.setCadena(cadena);
                    cartelera.setTresD(rs.getInt(7));
                    cartelera.setDoblada(rs.getInt(8));
                    cartelera.setSubtitulada(rs.getInt(9));
                    cartelera.setHorario(rs.getString(10));
                    lista.add(cartelera)
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public  void guardarFuncion(int idPelicula, int idCine, int tresD, int doblada, String horario){

        String sql = "";

        try (Connection conn = getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {


            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Pelicula> obtenerListaPeliculas() {
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

        String sql = "select * from pelicula;";
        try (Connection conn = this.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setIdPelicula(rs.getInt(1));
                pelicula.setNombre(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaPeliculas;
    }

    public ArrayList<Pelicula> obtenerListaCines() {
        ArrayList<Pelicula> listaCines = new ArrayList<>();
        return listaCines;
    }
}
