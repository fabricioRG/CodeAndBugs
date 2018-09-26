package project.caso.backend;

/**
 *
 * @author fabricio
 */
public class HorasDinero {

    private double horasInvertidas;
    private double dineroInvertido;

    public HorasDinero(double horasInvertidas, double dineroInvertido) {
        this.horasInvertidas = horasInvertidas;
        this.dineroInvertido = dineroInvertido;
    }

    public double getHorasInvertidas() {
        return horasInvertidas;
    }

    public void setHorasInvertidas(double horasInvertidas) {
        this.horasInvertidas = horasInvertidas;
    }

    public double getDineroInvertido() {
        return dineroInvertido;
    }

    public void setDineroInvertido(double dineroInvertido) {
        this.dineroInvertido = dineroInvertido;
    }
}
