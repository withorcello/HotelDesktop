/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.modelo.CadastrarProduto;
import br.edu.ifro.modelo.Cliente;
import br.eti.diegofonseca.MaskFieldUtil;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class CadastrarProdutoController implements Initializable {

    @FXML
    private Label lblNome;
    @FXML
    private Label lblFornecedor;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXComboBox<?> comboFornecedor;
    @FXML
    private JFXTextField txtValor;

    @FXML
    public void Salvar(ActionEvent event) {
        if(txtNome != null && txtValor != null && comboFornecedor != null ){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hotel");
        EntityManager em = emf.createEntityManager();
        CadastrarProduto P = new CadastrarProduto();

        P.setTxtNome(txtNome.getText());
        P.setTxtValor(txtValor.getText());

        P.setComboFornecedor(comboFornecedor.getSelectionModel().getSelectedItem().toString());

        em.getTransaction().begin();

        em.persist(P);

        em.getTransaction().commit();

        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        }
        if("".equals(comboFornecedor) && "".equals(txtValor) && "".equals(txtNome)){
            JOptionPane.showMessageDialog(null,"Preencha os campos antes de salvar!");
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hotel");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT a FROM Fornecedor a");

        List<Cliente> clientes = query.getResultList();

        ObservableList oClientes = FXCollections.observableArrayList(clientes);

        comboFornecedor.setItems(oClientes);
        
        MaskFieldUtil.monetaryField(txtValor);
        
    }

    @FXML
    private void Cancelar(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
