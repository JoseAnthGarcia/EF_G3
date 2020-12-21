package Servlets;

import Beans.Cartelera;
import Beans.Empleado;
import Beans.Pelicula;
import Daos.CarteleraDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

@WebServlet(name = "CarteleraServlet", urlPatterns = {"/CarteleraServlet"})
public class CarteleraServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");

        RequestDispatcher view;
        Cartelera cartelera = new Cartelera();
        String rol = (String) request.getSession().getAttribute("rol");


        switch (action){
            case "agregarFuncion":

                String idPelicula = request.getParameter("idPelicula");
                String idCine = request.getParameter("idCine");
                String tresD = request.getParameter("3d");
                String doblada = request.getParameter("doblada");
                String horario = request.getParameter("horario");

                CarteleraDao carteleraDao = new CarteleraDao();
                carteleraDao.guardarFuncion(Integer.parseInt(idPelicula), Integer.parseInt(idCine),
                        Integer.parseInt(tresD), Integer.parseInt(doblada), horario);
                response.sendRedirect(""); //TODO: agregar sendredirect

                break;
        }


        break;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");

        RequestDispatcher view;
        String rol = (String) request.getSession().getAttribute("rol");

        CarteleraDao carteleraDao = new CarteleraDao();

        switch (action) {
            case "lista":
                request.setAttribute("listaCartelera", carteleraDao.listaCarteleras());
                view = request.getRequestDispatcher("employees/lista.jsp");
                view.forward(request, response);
                break;
            case "agregarNuevaFuncion":
                request.setAttribute("listaPeliculas", carteleraDao.obtenerListaPeliculas());
                request.setAttribute("listaCines", carteleraDao.obtenerListaCines());
                view = request.getRequestDispatcher("nuevaFuncion.jsp");
                view.forward(request, response);
                break;
        }
    }
}
