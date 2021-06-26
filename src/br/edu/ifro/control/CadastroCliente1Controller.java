/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.modelo.Cliente;
import br.eti.diegofonseca.MaskFieldUtil;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ToggleGroup;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;


public class CadastroCliente1Controller implements Initializable {

    @FXML
    private JFXRadioButton Feminino;
    @FXML
    private JFXRadioButton Masculino;
    @FXML
    private JFXTextField txtTelefone;
    @FXML
    private JFXTextField txtBairro;
    @FXML
    private JFXTextField txtCidade;
    @FXML
    private JFXTextField txtRG;
    @FXML
    private JFXTextField txtRua;
    @FXML
    private JFXTextField txtCPF;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtCep;
    @FXML
    private JFXTextField txtNumero;
    @FXML
    private JFXComboBox<?> uf;
    @FXML
    private ToggleGroup sex;
    @FXML
    private DatePicker dataNasc;
   
    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         MaskFieldUtil.cpfCnpjField(txtCPF);
         MaskFieldUtil.foneField(txtTelefone);
         MaskFieldUtil.cepField( txtCep);
         MaskFieldUtil.numericField(txtRG);
         MaskFieldUtil.numericField(txtNumero);
    }    

    @FXML
    private void Salvar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hotel");
        EntityManager em = emf.createEntityManager();
        Cliente cliente = new Cliente();
        /*cadatro do dateS*/
        LocalDate localDate = dataNasc.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);

        cliente.setTxtNome(txtNome.getText());
        cliente.setTxtRG(txtRG.getText());
        cliente.setTxtCPF(txtCPF.getText());
        cliente.setTxtTelefone(txtTelefone.getText());
        cliente.setTxtRua(txtRua.getText());
        cliente.setTxtBairro(txtBairro.getText());
        cliente.setTxtCidade(txtCidade.getText());
        cliente.setTxtNumero(txtNumero.getText());
        cliente.setTxtCep(txtCep.getText());
        cliente.setDatanasc(date);
        cliente.setTxtUF(uf.getSelectionModel().getSelectedItem().toString());

        em.getTransaction().begin();

        em.persist(cliente);

        em.getTransaction().commit();
        
        JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!!");
        
    }
}
