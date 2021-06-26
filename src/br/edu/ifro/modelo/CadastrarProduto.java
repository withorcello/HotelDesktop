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
public class CadastrarProduto {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String txtNome,comboFornecedor, txtValor;

    public String getTxtValor() {
        return txtValor;
    }

    public void setTxtValor(String txtValor) {
        this.txtValor = txtValor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTxtNome() {
        return txtNome;
    }

    public void setTxtNome(String txtNome) {
        this.txtNome = txtNome;
    }

    public String getComboFornecedor() {
        return comboFornecedor;
    }

    public void setComboFornecedor(String comboFornecedor) {
        this.comboFornecedor = comboFornecedor;
    }

}
