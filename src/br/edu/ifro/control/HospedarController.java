package br.edu.ifro.control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifro.modelo.Cliente;
import br.edu.ifro.modelo.Hospedar;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author 01453074252
 */
public class HospedarController implements Initializable {

    @FXML
    private DatePicker dateSair;
    @FXML
    private TextField txtCPF;
    @FXML
    private TextField txtCliente;
    @FXML
    private DatePicker dateEntrada;
    @FXML
    private JFXComboBox<?> comboQuarto;
    @FXML
    private JFXTextField txtQuntiPes;
    
    @FXML
    public void Salvar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hotel");
        EntityManager em = emf.createEntityManager();
        Hospedar H = new Hospedar();
        /*cadatro do dateS*/
        LocalDate localDate = dateEntrada.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        
        LocalDate localDate1 = dateSair.getValue();
        Instant instant1 = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date1 = Date.from(instant);
       
       
        H.setTxtCPF(txtCPF.getText());
        H.setTxtCliente(txtCliente.getText());
        H.setQuantidade(Integer.parseInt(txtQuntiPes.getText()));
        H.setDataEntrada(date);
        H.setDataSaida(date1);
        H.setQuarto(comboQuarto.getSelectionModel().getSelectedItem().toString());


        em.getTransaction().begin();

        em.persist(H);

        em.getTransaction().commit();
        
        JOptionPane.showMessageDialog(null, "Hospedagem feita com sucesso!!!");
    }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hotel");
        EntityManager em = emf.createEntityManager();   
        
        Query query = em.createQuery("SELECT txtNumero FROM CadastrarQuartos a WHERE Status = 'Livre'");
        
        List<Cliente> quartos = query.getResultList();
        
        ObservableList oQuartos = FXCollections.observableArrayList(quartos);
        
        comboQuarto.setItems(oQuartos);
    }    

    @FXML
    private void Cancelar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/MenuPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),594,423);
        Stage stage = new Stage();
        stage.setTitle("Menu Principal");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void BuscarCliente(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hotel");
        EntityManager em = emf.createEntityManager();   
        
        Query query = em.createQuery("SELECT txtNome FROM Cliente a WHERE txtNome = %"+txtCliente+"%");
        
        List<Cliente> clientes = query.getResultList();
        
        ObservableList oClientes = FXCollections.observableArrayList(clientes);
        
        comboQuarto.setItems(oClientes);
    }    
    
}
