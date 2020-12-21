<%@ page import="Beans.Pelicula" %>
<%@ page import="Beans.Cine" %>
<jsp:useBean id="listaPeliculas" type="java.util.ArrayList<Beans.Pelicula>" scope="request"/>
<jsp:useBean id="listaCines" type="java.util.ArrayList<Beans.Cine>" scope="request"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='resources/css/bootstrap.min.css'/>
    <title>Añadir nueva función</title>
</head>
<body>
<div class='container'>
    <jsp:include page="includes/navbar.jsp"/>
    <div class="row mb-4">
        <div class="col"></div>
        <div class="col-md-6">
            <h1 class='mb-3'>Nueva funcion</h1>
            <hr>
            <form method="POST" action="<%=request.getContextPath()%>/CarteleraServlet?action=agregarFuncion">

                <div class="form-group">
                    <label for="exampleFormControlSelect1">Selecciona pelicula</label>
                    <select class="form-control" id="exampleFormControlSelect1" name="idPelicula">
                        <%for(Pelicula pelicula : listaPeliculas){%>
                        <option value="<%=pelicula.getIdPelicula()%>"><%=pelicula.getNombre()%></option>
                        <%}%>
                    </select>
                </div>

                <div class="form-group">
                    <label for="exampleFormControlSelect1">Selecciona cine</label>
                    <select class="form-control" id="exampleFormControlSelect2" name="idCine">
                        <%for(Cine cine : listaCines){%>
                        <option value="<%=cine.getIdCine()%>"><%=cine.getNombre()%></option>
                        <%}%>
                    </select>
                </div>

                <div class="form-group">
                    <label for="3d">¿3D?</label>
                    <input type="text" class="form-control form-control-sm" id="3d" name="3d">
                    <small id="Help1" class="form-text text-muted">Ingrese 1 si es 3D y 0 si no es 3D</small>
                </div>

                <div class="form-group">
                    <label for="doblada">¿doblada o subtitulada?</label>
                    <input type="text" class="form-control form-control-sm" id="doblada" name="doblada">
                    <small id="Help2" class="form-text text-muted">Ingrese 1 si es doblada y 0 si es subtitulada</small>
                </div>

                <div class="form-group">
                    <label for="horario">Horario</label>
                    <input type="text" class="form-control form-control-sm" id="horario" name="horario">
                </div>

                <a href="#" class="btn btn-danger">Cancelar</a>
                <button type="submit" value="Guardar" class="btn btn-primary"/>
            </form>
        </div>
        <div class="col"></div>
    </div>
</div>
</body>
</html>
