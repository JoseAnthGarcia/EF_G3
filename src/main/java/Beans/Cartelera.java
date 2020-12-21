package Beans;

public class Cartelera {
    private int idCartelera;
    private Pelicula pelicula;
    private Cine cine;
    private int tresD;
    private int doblada;
    private int subtitulada;
    private String horario;

    /**
     * @return the idCartelera
     */
    public int getIdCartelera() {
        return idCartelera;
    }

    /**
     * @param idCartelera the idCartelera to set
     */
    public void setIdCartelera(int idCartelera) {
        this.idCartelera = idCartelera;
    }

    /**
     * @return the pelicula
     */
    public Pelicula getPelicula() {
        return pelicula;
    }

    /**
     * @param pelicula the pelicula to set
     */
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    /**
     * @return the cine
     */
    public Cine getCine() {
        return cine;
    }

    /**
     * @param cine the cine to set
     */
    public void setCine(Cine cine) {
        this.cine = cine;
    }

    /**
     * @return the tresD
     */
    public int getTresD() {
        return tresD;
    }

    /**
     * @param tresD the tresD to set
     */
    public void setTresD(int tresD) {
        this.tresD = tresD;
    }

    /**
     * @return the doblada
     */
    public int getDoblada() {
        return doblada;
    }

    /**
     * @param doblada the doblada to set
     */
    public void setDoblada(int doblada) {
        this.doblada = doblada;
    }

    /**
     * @return the subtitulada
     */
    public int getSubtitulada() {
        return subtitulada;
    }

    /**
     * @param subtitulada the subtitulada to set
     */
    public void setSubtitulada(int subtitulada) {
        this.subtitulada = subtitulada;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }
}
