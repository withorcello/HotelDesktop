
package br.edu.ifro;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;



public class Parcela {
    
    private  SimpleBooleanProperty select;
    private  SimpleStringProperty status;
    private  SimpleIntegerProperty numero;
    private  SimpleDoubleProperty valor;
    private  SimpleStringProperty validade;


    public Parcela(String status, Integer numero, String validade,Double valor) {
        this.select = new SimpleBooleanProperty(false);
        this.status = new SimpleStringProperty(status);
        this.numero = new SimpleIntegerProperty(numero);
        this.valor = new SimpleDoubleProperty(valor);
        this.validade = new SimpleStringProperty(validade);

    }

    
    /*-- Select --*/
    public boolean isSelect() {
        return select.get();
    }

    public SimpleBooleanProperty selectProperty() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select.set(select);
    }

    
    /*-- Status --*/
    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    
    /*-- Numero --*/
    public int getNumero() {
        return numero.get();
    }

    public SimpleIntegerProperty numeroProperty() {
        return numero;
    }

    public void setnumero(int numero) {
        this.numero.set(numero);
    }
    
    
    /*-- Validade --*/
    public String getvalidade() {
        return validade.get();
    }

    public SimpleStringProperty validadeProperty() {
        return validade;
    }

    public void setvalidade(String validade) {
        this.validade.set(validade);
    }
    
    /*-- Valor --*/
    public Double getvalor() {
        return valor.get();
    }

    public SimpleDoubleProperty valorProperty() {
        return valor;
    }

    public void setvalor(Double valor) {
        this.valor.set(valor);
    }
}