
package br.edu.ifro.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornecedor {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
     private Integer id;
     private String txtEmail, txtCNPJ, txtTelefone, txtRua, txtBairro, txtCidade, txtNumero, txtCep, UF,txtRazao,txtNome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String toString(){
        return txtNome;
    }
    
    public String getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail = txtEmail;
    }

    public String getTxtCNPJ() {
        return txtCNPJ;
    }

    public void setTxtCNPJ(String txtCNPJ) {
        this.txtCNPJ = txtCNPJ;
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

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getTxtRazao() {
        return txtRazao;
    }

    public void setTxtRazao(String txtRazao) {
        this.txtRazao = txtRazao;
    }

    public String getTxtNome() {
        return txtNome;
    }

    public void setTxtNome(String txtNome) {
        this.txtNome = txtNome;
    }

}