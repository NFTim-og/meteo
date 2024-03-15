package meteoproject;

public class Estacio {
    private String nomEstacio;
    private String nomMunicipi;
    private int codiComarca;
    private int codiProvincia;
    private int codiEstacio;
    private String nomEstat;
    private String dataAlta;
    private String dataBaixa;

    public Estacio(int codiEstacio, String nomEstacio, String nomMunicipi, int codiComarca, int codiProvincia, String nomEstat, String dataAlta, String dataBaixa) {
        this.codiEstacio = codiEstacio;
        this.nomEstacio = nomEstacio;
        this.nomMunicipi = nomMunicipi;
        this.codiComarca = codiComarca;
        this.codiProvincia = codiProvincia;
        this.nomEstat = nomEstat;
        this.dataAlta = dataAlta;
        this.dataBaixa = dataBaixa;
    }

    public int getCodiEstacio() {
        return codiEstacio;
    }

    public String getNomEstacio() {
        return nomEstacio;
    }

    public String getNomMunicipi() {
        return nomMunicipi;
    }

    public int getCodiComarca() {
        return codiComarca;
    }

    public int getCodiProvincia() {
        return codiProvincia;
    }

    public String getNomEstat() {
        return nomEstat;
    }

    public String getDataAlta() {
        return dataAlta;
    }

    public String getDataBaixa() {
        return dataBaixa;
    }
}
