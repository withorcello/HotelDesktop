package br.edu.ifro.control;

import br.edu.ifro.modelo.Login;
import br.eti.diegofonseca.MaskFieldUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class LoginController implements Initializable {

    @FXML
    private JFXButton BTNentrar;
    @FXML
    private JFXTextField txtcpf;
    @FXML
    private JFXPasswordField txtSenha2;

    @FXML
    public void entrar(ActionEvent event) throws IOException, Throwable {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hotel");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT senha FROM Login as senha WHERE senha.cpf = :cpf");

        query.setParameter("cpf", txtcpf.getText());

        List<Login> l = query.getResultList();

        if (!l.isEmpty()) {

            Login login = l.get(0);
            String senha = txtSenha2.getText();

            if (login.getSenha().equals(senha)) {
                JOptionPane.showMessageDialog(null, "Login efetuado com sucesso");
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/MenuPrincipal.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Menu Principal");
                stage.setScene(scene);
                stage.show();
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuário incorreto");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MaskFieldUtil.cpfCnpjField(txtcpf);
    }

    private void CadastrarUsuario(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/CadastrarUsuario.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Menu Principal");
        stage.setScene(scene);
        stage.show();
    }

}
