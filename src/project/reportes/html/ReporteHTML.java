package project.reportes.html;

import java.util.LinkedList;
import java.util.List;
import project.caso.backend.CantidadCasos;
import project.caso.backend.Caso;
import project.caso.backend.HorasDinero;
import project.proyecto.backend.Proyecto;
import project.usuario.Usuario;

/**
 *
 * @author fabricio
 */
public class ReporteHTML {

    public ReporteHTML() {
    }

    public String casosVarios(List casos, String titulo) {
        boolean ultimoCaso = false;
        List<Caso> listadoCasos = new LinkedList<>();
        listadoCasos.addAll(casos);
        String reporteCasosDesarrollador = " ";
        reporteCasosDesarrollador = encabezadoTablaCasos(titulo);
        for (int i = 0; i < listadoCasos.size(); i++) {
            if (i == listadoCasos.size() - 1) {
                ultimoCaso = true;
            }
            reporteCasosDesarrollador += elementosTablaCasos(listadoCasos.get(i), ultimoCaso);
        }
        return reporteCasosDesarrollador;
    }

    private String encabezadoTablaCasos(String titulos) {
        String titulo = "<html>\n"
                + "     <h1>" + titulos + "</h1>\n"
                + "	<table style=\"border-collapse: collapse;\">\n"
                + "	  <tr>"
                + "	    <th style=\"border: 1px solid #000000;\">ID CASO</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">FECHA INICIO</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">FECHA LIMITE</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">FECHA ENTREGA</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">AVANCE</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">MOTIVO CANCELACION</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">TIPO</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">ID PROYECTO</th>\n"
                + "	  </tr>\n";
        return titulo;
    }

    private String elementosTablaCasos(Caso caso, boolean ultimoCaso) {
        String elementos = "	  <tr>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + caso.getID() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + caso.getFechaInicio() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + caso.getFechaLimite() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + caso.getFechaEntrega() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + caso.getAvance() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + caso.getMotivoCancelacion() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + caso.getTipoCaso() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + caso.getIdProyecto() + "</td>\n"
                + "	  </tr>\n";
        if (ultimoCaso) {
            elementos += "	</table>\n"
                    + "</html>";
        }
        return elementos;
    }

    public String desarrolladores(List desarrolladores, String titulo) {
        boolean ultimoDesarr = false;
        List<Usuario> listadoDesarr = new LinkedList<>();
        listadoDesarr.addAll(desarrolladores);
        String reporteCasosDesarrollador = " ";
        reporteCasosDesarrollador = encabezadoTablaDesarr(titulo);
        for (int i = 0; i < listadoDesarr.size(); i++) {
            if (i == listadoDesarr.size() - 1) {
                ultimoDesarr = true;
            }
            reporteCasosDesarrollador += elementosTablaDesarr(listadoDesarr.get(i), ultimoDesarr);
        }
        return reporteCasosDesarrollador;
    }

    private String encabezadoTablaDesarr(String titulos) {
        String titulo = "<html>\n"
                + "     <h1>" + titulos + "</h1>\n"
                + "	<table style=\"border-collapse: collapse;\">\n"
                + "	  <tr>"
                + "	    <th style=\"border: 1px solid #000000;\">DPI DESARROLLADOR</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">APELLIDO</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">TIPO</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">NOMBRE USUARIO</th>\n"
                + "	  </tr>\n";
        return titulo;
    }

    private String elementosTablaDesarr(Usuario usuario, boolean ultimoCaso) {
        String elementos = "	  <tr>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + usuario.getDPI() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + usuario.getNombre() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + usuario.getApellido()+ "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + usuario.getTipo() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + usuario.getUsuario() + "</td>\n"
                + "	  </tr>\n";
        if (ultimoCaso) {
            elementos += "	</table>\n"
                    + "</html>";
        }
        return elementos;
    }

    public String cantidadCasos(List listaCantCasos, String titulo) {
        boolean ultimoDesarr = false;
        List<CantidadCasos> listadoDesarr = new LinkedList<>();
        listadoDesarr.addAll(listaCantCasos);
        String reporteCasosDesarrollador = " ";
        reporteCasosDesarrollador = encabezadoTablaCantidadCas(titulo);
        for (int i = 0; i < listadoDesarr.size(); i++) {
            if (i == listadoDesarr.size() - 1) {
                ultimoDesarr = true;
            }
            reporteCasosDesarrollador += elementosTablaCantidadCas(listadoDesarr.get(i), ultimoDesarr);
        }
        return reporteCasosDesarrollador;
    }
    
    private String encabezadoTablaCantidadCas(String titulos) {
        String titulo = "<html>\n"
                + "     <h1>" + titulos + "</h1>\n"
                + "	<table style=\"border-collapse: collapse;\">\n"
                + "	  <tr>"
                + "	    <th style=\"border: 1px solid #000000;\">ID PROYECTO</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">CANTIDAD CASOS</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">ESTADO</th>\n"
                + "	  </tr>\n";
        return titulo;
    }

    private String elementosTablaCantidadCas(CantidadCasos cc, boolean ultimoCaso) {
        String elementos = "	  <tr>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + cc.getIdProyecto() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + cc.getNombreProyecto() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + cc.getCantidadCasos()+ "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + cc.getEstado() + "</td>\n"
                + "	  </tr>\n";
        if (ultimoCaso) {
            elementos += "	</table>\n"
                    + "</html>";
        }
        return elementos;
    }
    
    public String proyectos(List listaProyectos, String titulo) {
        boolean ultimoDesarr = false;
        List<Proyecto> listadoDesarr = new LinkedList<>();
        listadoDesarr.addAll(listaProyectos);
        String reporteCasosDesarrollador = " ";
        reporteCasosDesarrollador = encabezadoTablaProyecto(titulo);
        for (int i = 0; i < listadoDesarr.size(); i++) {
            if (i == listadoDesarr.size() - 1) {
                ultimoDesarr = true;
            }
            reporteCasosDesarrollador += elementosTablaProyecto(listadoDesarr.get(i), ultimoDesarr);
        }
        return reporteCasosDesarrollador;
    }
    
    private String encabezadoTablaProyecto(String titulos) {
        String titulo = "<html>\n"
                + "     <h1>" + titulos + "</h1>\n"
                + "	<table style=\"border-collapse: collapse;\">\n"
                + "	  <tr>"
                + "	    <th style=\"border: 1px solid #000000;\">ID PROYECTO</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">ESTADO</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">DPI ADMINISTRADOR</th>\n"
                + "	  </tr>\n";
        return titulo;
    }

    private String elementosTablaProyecto(Proyecto pry, boolean ultimoCaso) {
        String elementos = "	  <tr>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + pry.getID() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + pry.getNombre() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + pry.getEstado()+ "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + pry.getDPIAdministrador() + "</td>\n"
                + "	  </tr>\n";
        if (ultimoCaso) {
            elementos += "	</table>\n"
                    + "</html>";
        }
        return elementos;
    }
    
    public String HorasInvertidas(String titulo, HorasDinero horasDinero){
        String elementos = "<html>\n"
                + "     <h1>" + titulo + "</h1>\n"
                + "	<table style=\"border-collapse: collapse;\">\n"
                + "	  <tr>"
                + "	    <th style=\"border: 1px solid #000000;\">HORAS</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">DINERO</th>\n"
                + "	  </tr>\n"
                + "	  <tr>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + horasDinero.getHorasInvertidas() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + horasDinero.getDineroInvertido() + "</td>\n"
                + "	  </tr>\n"
                + "	</table>\n"
                + "</html>";
        return elementos;
    }
    
}
