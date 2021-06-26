/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 03016487276
 */
@Entity
public class CadastrarQuartos {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String txtNumero,txtDescricao,txtDiaria, comboCategoria, Quantidade, Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(String Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String getComboCategoria() {
        return comboCategoria;
    }

    public void setComboCategoria(String comboCategoria) {
        this.comboCategoria = comboCategoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTxtNumero() {
        return txtNumero;
    }

    public void setTxtNumero(String txtNumero) {
        this.txtNumero = txtNumero;
    }

    public String getTxtDescricao() {
        return txtDescricao;
    }

    public void setTxtDescricao(String txtDescricao) {
        this.txtDescricao = txtDescricao;
    }

    public String getTxtDiaria() {
        return txtDiaria;
    }

    public void setTxtDiaria(String txtDiaria) {
        this.txtDiaria = txtDiaria;
    }

}
    
