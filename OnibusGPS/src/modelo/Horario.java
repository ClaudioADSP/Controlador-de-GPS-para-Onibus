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
public class Horario {
    
    private Integer idHorario;
    private String horaChegada;
    private String horaSaida;
    private String tipo;
    private Integer idLinha;

    /**
     * @return the idHorario
     */
    public Integer getIdHorario() {
        return idHorario;
    }

    /**
     * @param idHorario the idHorario to set
     */
    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    /**
     * @return the horaChegada
     */
    public String getHoraChegada() {
        return horaChegada;
    }

    /**
     * @param horaChegada the horaChegada to set
     */
    public void setHoraChegada(String horaChegada) {
        this.horaChegada = horaChegada;
    }

    /**
     * @return the horaSaida
     */
    public String getHoraSaida() {
        return horaSaida;
    }

    /**
     * @param horaSaida the horaSaida to set
     */
    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
