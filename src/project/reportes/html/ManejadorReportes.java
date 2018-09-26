package project.reportes.html;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import project.caso.backend.HorasDinero;

/**
 *
 * @author fabricio
 */
public class ManejadorReportes {

    public ManejadorReportes() {
    }
    
    public void exportarHtmlCasosDesarr(File file, List Casos){
        ReporteHTML rhtml = new ReporteHTML();
        File direccion = new File(file.getAbsolutePath() + "/CasosDesarrollador.html");
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(direccion);
            pw = new PrintWriter(fichero);
            String titulo = "Reporte de Casos de Desarrollador";
            pw.println(rhtml.casosVarios(Casos, titulo));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != fichero){
                    fichero.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void exportarHtmlCasosProyecto(File file, List Casos){
        ReporteHTML rhtml = new ReporteHTML();
        File direccion = new File(file.getAbsolutePath() + "/CasosProyecto.html");
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(direccion);
            pw = new PrintWriter(fichero);
            String titulo = "Reporte de Casos de Proyectos";
            pw.println(rhtml.casosVarios(Casos, titulo));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != fichero){
                    fichero.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void exportarHtmlCasosTipoCaso(File file, List Casos){
        ReporteHTML rhtml = new ReporteHTML();
        File direccion = new File(file.getAbsolutePath() + "/TipoCaso.html");
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(direccion);
            pw = new PrintWriter(fichero);
            String titulo = "Reporte de Casos de Tipo de Caso";
            pw.println(rhtml.casosVarios(Casos, titulo));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != fichero){
                    fichero.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void exportarHtmlDesarrolladores(File file, List desarrolladores){
        ReporteHTML rhtml = new ReporteHTML();
        File direccion = new File(file.getAbsolutePath() + "/Desarrolladores.html");
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(direccion);
            pw = new PrintWriter(fichero);
            String titulo = "Reporte de Desarrolladores";
            pw.println(rhtml.desarrolladores(desarrolladores, titulo));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(null != fichero){
                    fichero.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void exportarHtmlCantidadCasos(File file, List desarrolladores){
        ReporteHTML rhtml = new ReporteHTML();
        File direccion = new File(file.getAbsolutePath() + "/CantidadCasos.html");
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(direccion);
            pw = new PrintWriter(fichero);
            String titulo = "Reporte de Cantidad de Casos";
            pw.println(rhtml.cantidadCasos(desarrolladores, titulo));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(null != fichero){
                    fichero.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void exportarHtmlProyectos(File file, List desarrolladores){
        ReporteHTML rhtml = new ReporteHTML();
        File direccion = new File(file.getAbsolutePath() + "/Proyectos.html");
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(direccion);
            pw = new PrintWriter(fichero);
            String titulo = "Reporte de Proyectos";
            pw.println(rhtml.proyectos(desarrolladores, titulo));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(null != fichero){
                    fichero.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void exportarHtmlHorasDineroInvertido(File file, HorasDinero hoDi, String tipo){
        ReporteHTML rhtml = new ReporteHTML();
        File direccion = new File(file.getAbsolutePath() + "/" + tipo + ".html");
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(direccion);
            pw = new PrintWriter(fichero);
            String titulo = "Reporte de " + tipo;
            pw.println(rhtml.HorasInvertidas(titulo, hoDi));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(null != fichero){
                    fichero.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
