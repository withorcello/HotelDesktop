/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;


import br.edu.ifro.modelo.Fornecedor;
import br.eti.diegofonseca.MaskFieldUtil;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author 04262487245
 */
public class CadastrarFornecedorController implements Initializable {

    @FXML
    private JFXTextField txtCep;
    @FXML
    private JFXTextField txtRua;
    @FXML
    private JFXTextField txtCidade;
    @FXML
    private JFXTextField txtBairro;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtRazao;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtCNPJ;
    @FXML
    private JFXTextField txtTelefone;
    @FXML
    private JFXTextField Numero;
    @FXML
    private JFXComboBox<?> comboUf;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MaskFieldUtil.cnpjField(txtCNPJ);
        MaskFieldUtil.cepField(txtCep);
        MaskFieldUtil.foneField(txtTelefone);
        MaskFieldUtil.numericField(Numero);

    }    

    @FXML
    private void Cancelar(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    

    @FXML
    private void Salvar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hotel");
        EntityManager em = emf.createEntityManager();
        Fornecedor FOR = new Fornecedor();
        
        FOR.setTxtNome(txtNome.getText());
        FOR.setTxtEmail(txtCNPJ.getText());
        FOR.setTxtTelefone(txtTelefone.getText());
        FOR.setTxtRua(txtRua.getText());
        FOR.setTxtBairro(txtBairro.getText());
        FOR.setTxtCidade(txtCidade.getText());
        FOR.setTxtNumero(Numero.getText());
        FOR.setTxtCep(txtCep.getText());
        FOR.setTxtCep(txtEmail.getText());
        FOR.setTxtRazao(txtRazao.getText());
        
        
        FOR.setUF(comboUf.getSelectionModel().getSelectedItem().toString());

        em.getTransaction().begin();

        em.persist(FOR);

        em.getTransaction().commit();
        
        JOptionPane.showMessageDialog(null, "Fornecedor salvo com sucesso!!");
    }
    
}




























