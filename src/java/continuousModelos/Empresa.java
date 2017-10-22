/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package continuousModelos;

/**
 *
 * @author Erick
 */
public class Empresa {
 private int idempresa;
    private String nombreempresa, politicaempresa, objetivoempresa, alcanceempresa;

    public Empresa() {
    }
    
    //CONSTRUCTOR SIN ID
    public Empresa(String nombreempresa, String politicaempresa, String objetivoempresa, String alcanceempresa) {
        this.nombreempresa = nombreempresa;
        this.politicaempresa = politicaempresa;
        this.objetivoempresa = objetivoempresa;
        this.alcanceempresa = alcanceempresa;
    }
    
     //CONSTRUCTOR CON ID:
    public Empresa(int idempresa, String nombreempresa, String politicaempresa, String objetivoempresa, String alcanceempresa) {
        this.idempresa = idempresa;
        this.nombreempresa = nombreempresa;
        this.politicaempresa = politicaempresa;
        this.objetivoempresa = objetivoempresa;
        this.alcanceempresa = alcanceempresa;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public String getNombreempresa() {
        return nombreempresa;
    }

    public void setNombreempresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
    }

    public String getPoliticaempresa() {
        return politicaempresa;
    }

    public void setPoliticaempresa(String politicaempresa) {
        this.politicaempresa = politicaempresa;
    }

    public String getObjetivoempresa() {
        return objetivoempresa;
    }

    public void setObjetivoempresa(String objetivoempresa) {
        this.objetivoempresa = objetivoempresa;
    }

    public String getAlcanceempresa() {
        return alcanceempresa;
    }

    public void setAlcanceempresa(String alcanceempresa) {
        this.alcanceempresa = alcanceempresa;
    }   
}
