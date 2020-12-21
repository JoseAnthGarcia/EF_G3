<%@ page import="Beans.Employee" %>
<% String currentPage = request.getParameter("currentPage"); %>

<nav class="navbar navbar-expand-md navbar-light bg-light">
    <a class="navbar-brand" href="#">Gesti�n HR</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
        <ul class="navbar-nav">
            <li class="nav-item <%=currentPage.equals("emp") ? "active" : ""%>" >                
                <a class="nav-link" href="<%=request.getContextPath()%>/EmployeeServlet">Employees</a>
            </li>
            <li class="nav-item <%=currentPage.equals("job") ? "active" : ""%>">
                <a class="nav-link" href="<%=request.getContextPath()%>/JobServlet">Jobs</a>
            </li>
            <div class="form-inline font-italic my-2 my-lg-0">
                <%HttpSession session1 = request.getSession();
                if(session1.getAttribute("usuaio")==null){%>
                <a class="nav-link" style="color: #007bff;" href="<%=request.getContextPath()%>/LoginServlet">(Iniciar Sesión)</a>
                <%}else{
                    Employee usuario = (Employee) session1.getAttribute("usuaio");
                %>
                Bienvenido <%=usuario.getFirstName()+" "+usuario.getLastName()%>
                <a class="nav-link" style="color: #007bff;" href="<%=request.getContextPath()%>/LoginServlet?action=cerrarSesion">(Cerrar Sesión)</a>
                <%}%>
            </div>
        </ul>
    </div>
</nav>
