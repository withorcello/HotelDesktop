
package br.edu.ifro.modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CadastrarFuncionario {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
     private Integer id;
     private String txtNome, txtRG, txtCPF, txtTelefone, txtRua, txtBairro, txtCidade, txtNumero, txtCep, UF, txtFuncao;
     private Date datanasc;

    public String getTxtFuncao() {
        return txtFuncao;
    }

    public void setTxtFuncao(String txtFuncao) {
        this.txtFuncao = txtFuncao;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }
    
    public String getTxtRG() {
        return txtRG;
    }

    public void setTxtRG(String txtRG) {
        this.txtRG = txtRG;
    }

    public String getTxtCPF() {
        return txtCPF;
    }

    public void setTxtCPF(String txtCPF) {
        this.txtCPF = txtCPF;
    }

    public String getTxtTelefone() {
        return txtTelefone;
    }

    public void setTxtTelefone(String txtTelefone) {
        this.txtTelefone = txtTelefone;
    }

    public String getTxtRua() {
        return txtRua;
    }

    public void setTxtRua(String txtRua) {
        this.txtRua = txtRua;
    }

    public String getTxtBairro() {
        return txtBairro;
    }

    public void setTxtBairro(String txtBairro) {
        this.txtBairro = txtBairro;
    }

    public String getTxtCidade() {
        return txtCidade;
    }

    public void setTxtCidade(String txtCidade) {
        this.txtCidade = txtCidade;
    }

    public String getTxtNumero() {
        return txtNumero;
    }

    public void setTxtNumero(String txtNumero) {
        this.txtNumero = txtNumero;
    }

    public String getTxtCep() {
        return txtCep;
    }

    public void setTxtCep(String txtCep) {
        this.txtCep = txtCep;
    }

    public String getTxtNome() {
        return txtNome;
    }

    public void setTxtNome(String txtNome) {
        this.txtNome = txtNome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}