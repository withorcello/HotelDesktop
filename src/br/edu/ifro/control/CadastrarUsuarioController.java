/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.modelo.CadastrarFuncionario;
import br.edu.ifro.modelo.Login;
import br.eti.diegofonseca.MaskFieldUtil;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author witho
 */
public class CadastrarUsuarioController implements Initializable {

    @FXML
    private JFXTextField txtSenha;
    @FXML
    private JFXTextField txtSenha2;
    @FXML
    private JFXTextField txtCPF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MaskFieldUtil.cpfField(txtCPF);
    }

    @FXML
    private void CadastrarUser(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hotel");
        EntityManager em = emf.createEntityManager();
        Login log = new Login();

        log.setCpf(txtCPF.getText());
        log.setSenha(txtSenha.getText());

        em.getTransaction().begin();

        em.persist(log);

        em.getTransaction().commit();
    }

}
