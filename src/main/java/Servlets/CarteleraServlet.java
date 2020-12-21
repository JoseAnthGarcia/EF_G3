package Servlets;

import Beans.Cartelera;
import Beans.Empleado;
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

        CarteleraDao carteleraDao = new CarteleraDao();

        switch (action) {
            case "lista":
                request.setAttribute("listaCartelera", carteleraDao.listaCarteleras());
                view = request.getRequestDispatcher("listaCartelera.jsp");
                view.forward(request, response);
                break;
            case "agregarNuevaFuncion":

                view = request.getRequestDispatcher("nuevaFuncion.jsp");
                view.forward(request, response);
                break;

            case "editar":
                if (rol.equals("Top 1") || rol.equals("Top 3")) {
                    if (request.getParameter("id") != null) {
                        String employeeIdString = request.getParameter("id");
                        int employeeId = 0;
                        try {
                            employeeId = Integer.parseInt(employeeIdString);
                        } catch (NumberFormatException ex) {
                            response.sendRedirect("EmployeeServlet");
                        }

                        Employee emp = employeeDao.obtenerEmpleado(employeeId);

                        if (emp != null) {
                            request.setAttribute("empleado", emp);
                            JobHistoryDao jobHistoryDao = new JobHistoryDao();
                            ArrayList<JobHistory> listaJobHistory=jobHistoryDao.listarJobHistories(employeeId);
                            request.setAttribute("listaJobHistory",listaJobHistory);
                            view = request.getRequestDispatcher("employees/formularioEditar.jsp");
                            view.forward(request, response);
                        } else {
                            response.sendRedirect("EmployeeServlet");
                        }

                    } else {
                        response.sendRedirect("EmployeeServlet");
                    }
                } else {
                    response.sendRedirect(request.getContextPath() + "/EmployeeServlet");
                }

                break;
            case "borrar":
                if (rol.equals("Top 1") || rol.equals("Top 2")) {
                    if (request.getParameter("id") != null) {
                        String employeeIdString = request.getParameter("id");
                        int employeeId = 0;
                        try {
                            employeeId = Integer.parseInt(employeeIdString);
                        } catch (NumberFormatException ex) {
                            response.sendRedirect("EmployeeServlet");
                        }

                        Employee emp = employeeDao.obtenerEmpleado(employeeId);

                        if (emp != null) {
                            employeeDao.borrarEmpleado(employeeId);
                        }
                    }

                    response.sendRedirect("EmployeeServlet");
                } else {
                    response.sendRedirect(request.getContextPath() + "/EmployeeServlet");
                }

                break;
            case "est":
                request.setAttribute("listaEmpRegion", employeeDao.listaEmpleadosPorRegion());
                request.setAttribute("listaSalario", employeeDao.listaSalarioPorDepartamento());
                view = request.getRequestDispatcher("employees/estadisticas.jsp");
                view.forward(request, response);
                break;
        }
    }
}
