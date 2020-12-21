package Servlets;

import Beans.Empleado;
import Beans.Rol;
import Daos.EmpleadoDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "login" : request.getParameter("action");


        switch (action) {
            case "login":
                String inputUsuario = request.getParameter("inputEmail");
                String inputPassword = request.getParameter("inputPassword");
                EmpleadoDao empleadoDao= new EmpleadoDao();
                Empleado empleado = empleadoDao.validarEmpleado(inputUsuario, inputPassword);

                if(empleado!=null){
                    HttpSession session =request.getSession();
                    session.setAttribute("empleadoSession", empleado);

                    String rol = empleado.getRoles().get(0).getNombre();


                    if ("vendedor".equals(rol)) {
                        response.sendRedirect(request.getContextPath() + "/");
                    } else if ("gestor".equals(rol)) {
                        response.sendRedirect(request.getContextPath() + "/");
                    } else if ("admin".equals(rol)) {
                        response.sendRedirect(request.getContextPath() + "/");
                    }
                }else{
                    response.sendRedirect(request.getContextPath()+"/LoginServlet?error");
                }
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion")!=null?
                request.getParameter("accion"): "login";
        HttpSession session = request.getSession();
        switch (accion){
            case "login":
                Empleado empleado = (Empleado) session.getAttribute("empleado");
                if(empleado!= null){
                    response.sendRedirect(request.getContextPath()+"/EmpleadoServlet");
                }
                request.setAttribute("employeeSession", empleado);
                request.setAttribute("rol", session.getAttribute("rol"));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request,response);
                break;
            case "logout":

                session.invalidate();
                response.sendRedirect(request.getContextPath()+"/EmployeeServlet");
                break;


        }
    }
}
