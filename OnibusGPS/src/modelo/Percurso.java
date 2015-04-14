/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Note-Claudio
 */
public class Percurso {
    
    private Integer idPercurso;
    private String latitude;
    private String logitude;
    private String referencia;
    private Double tempoEstimado;
    private String endereco;
    private Integer idLinha;

    /**
     * @return the idPercurso
     */
    public Integer getIdPercurso() {
        return idPercurso;
    }

    /**
     * @param idPercurso the idPercurso to set
     */
    public void setIdPercurso(Integer idPercurso) {
        this.idPercurso = idPercurso;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the logitude
     */
    public String getLogitude() {
        return logitude;
    }

    /**
     * @param logitude the logitude to set
     */
    public void setLogitude(String logitude) {
        this.logitude = logitude;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the tempoEstimado
     */
    public Double getTempoEstimado() {
        return tempoEstimado;
    }

    /**
     * @param tempoEstimado the tempoEstimado to set
     */
    public void setTempoEstimado(Double tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the idLinha
     */
    public Integer getIdLinha() {
        return idLinha;
    }

    /**
     * @param idLinha the idLinha to set
     */
    public void setIdLinha(Integer idLinha) {
        this.idLinha = idLinha;
    }
}
