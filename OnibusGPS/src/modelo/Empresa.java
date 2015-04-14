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
public class Empresa {
    
    private Integer idEmpresa;
    private String nome;
    private Integer idLinha;

    /**
     * @return the idEmpresa
     */
    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * @param idEmpresa the idEmpresa to set
     */
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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