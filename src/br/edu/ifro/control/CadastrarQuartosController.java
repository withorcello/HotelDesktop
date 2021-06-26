/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.modelo.CadastrarQuartos;
import br.eti.diegofonseca.MaskFieldUtil;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
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
public class CadastrarQuartosController implements Initializable {

    @FXML
    private JFXComboBox<?> comboCategoria;
    @FXML
    private JFXTextField txtDiaria;
    @FXML
    private JFXTextField QuantOspedes;
    @FXML
    private JFXTextArea txtDescricao;
    @FXML
    private JFXTextField txtNumero;
    
    private String Status = "Livre";

    @FXML
    public void salvar(ActionEvent event) {
        if (Integer.parseInt(QuantOspedes.getText()) > 4) {
            JOptionPane.showMessageDialog(null, "Não há quarto que suporte essa quantidade de ospedes.");
        }
        else{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hotel");
        EntityManager em = emf.createEntityManager();
        CadastrarQuartos Q = new CadastrarQuartos();

        Q.setTxtNumero(txtNumero.getText());
        Q.setTxtDescricao(txtDescricao.getText());
        Q.setTxtDiaria(txtDiaria.getText());
        Q.setQuantidade(QuantOspedes.getText());
        Q.setStatus(Status);
        Q.setComboCategoria(comboCategoria.getSelectionModel().getSelectedItem().toString());

        em.getTransaction().begin();

        em.persist(Q);

        em.getTransaction().commit();

        JOptionPane.showMessageDialog(null, "Quarto salvo com sucesso!");

        ((Node) (event.getSource())).getScene().getWindow().hide();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MaskFieldUtil.monetaryField(txtDiaria);
        MaskFieldUtil.numericField(QuantOspedes);
        MaskFieldUtil.numericField(txtNumero);

    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
