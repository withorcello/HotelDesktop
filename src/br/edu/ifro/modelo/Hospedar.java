/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.modelo;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 03016487276
 */
public class Hospedar {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  txtCPF, txtCliente, Quarto;
    private Date dataEntrada, dataSaida;
    private int Quantidade;
    

    public int getQuantidade() {
        return Quantidade;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String getQuarto() {
        return Quarto;
    }

    public void setQuarto(String Quarto) {
        this.Quarto = Quarto;
    }
    private Date dateSair, dateEntrada;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTxtCPF() {
        return txtCPF;
    }

    public void setTxtCPF(String txtCPF) {
        this.txtCPF = txtCPF;
    }

    public String getTxtCliente() {
        return txtCliente;
    }

    public void setTxtCliente(String txtCliente) {
        this.txtCliente = txtCliente;
    }
}
    
