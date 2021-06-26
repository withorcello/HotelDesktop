/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.modelo.Cliente;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author 01453074252
 */
public class RelatoriodespesasController implements Initializable {

   @FXML
    private TableView<?> TableDespesas;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hotel");
        EntityManager em = emf.createEntityManager();   
        
        Query query = em.createQuery("SELECT a FROM Despesas a");
        
        List<Cliente> clientes = query.getResultList();
        
        ObservableList oClientes = FXCollections.observableArrayList(clientes);
        
        TableDespesas.setItems(oClientes);
    }    
    
}
