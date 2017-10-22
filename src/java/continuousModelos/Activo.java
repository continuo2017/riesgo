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
public class Activo {
  private int idactivo, idempresa,idtratamineto,idtipoactivo;
    private String nombreactivo, descripcionactivo;

    public Activo() {
    }
    
    //CONSTRUCTOR SIN ID
    public Activo(int idempresa, int idtratamineto, int idtipoactivo, String nombreactivo, String descripcionactivo) {
        this.idempresa = idempresa;
        this.idtratamineto = idtratamineto;
        this.idtipoactivo = idtipoactivo;
        this.nombreactivo = nombreactivo;
        this.descripcionactivo = descripcionactivo;
    }
    
    //CONSTRUCTOR CON ID:
    public Activo(int idactivo, int idempresa, int idtratamineto, int idtipoactivo, String nombreactivo, String descripcionactivo) {
        this.idactivo = idactivo;
        this.idempresa = idempresa;
        this.idtratamineto = idtratamineto;
        this.idtipoactivo = idtipoactivo;
        this.nombreactivo = nombreactivo;
        this.descripcionactivo = descripcionactivo;
    }
    
    //CONSTRUCTOR PARA EL REPORTE DE RIESGO:
    public Activo(int idactivo, String nombreactivo, String descripcionactivo) {
        this.idactivo = idactivo;
        this.nombreactivo = nombreactivo;
        this.descripcionactivo = descripcionactivo;
    }
    

    public int getIdactivo() {
        return idactivo;
    }

    public void setIdactivo(int idactivo) {
        this.idactivo = idactivo;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdtratamineto() {
        return idtratamineto;
    }

    public void setIdtratamineto(int idtratamineto) {
        this.idtratamineto = idtratamineto;
    }

    public int getIdtipoactivo() {
        return idtipoactivo;
    }

    public void setIdtipoactivo(int idtipoactivo) {
        this.idtipoactivo = idtipoactivo;
    }

    public String getNombreactivo() {
        return nombreactivo;
    }

    public void setNombreactivo(String nombreactivo) {
        this.nombreactivo = nombreactivo;
    }

    public String getDescripcionactivo() {
        return descripcionactivo;
    }

    public void setDescripcionactivo(String descripcionactivo) {
        this.descripcionactivo = descripcionactivo;
    }
      
}
