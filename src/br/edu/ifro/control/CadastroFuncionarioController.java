package br.edu.ifro.control;

import br.edu.ifro.modelo.CadastrarFuncionario;
import br.eti.diegofonseca.MaskFieldUtil;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class CadastroFuncionarioController implements Initializable {

    @FXML
    private JFXTextField txtNome, txtRG, txtCPF, txtTelefone, txtRua, txtBairro, txtCidade, txtNumero, txtCep;
    @FXML
    private RadioButton Masculino, Feminino;
    @FXML
    private JFXComboBox<String> uf;
    @FXML
    private DatePicker Datanasc;
    @FXML
    private ToggleGroup genero;
    @FXML
    private JFXTextField txtFuncao;

    @FXML
    public void Salvar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hotel");
        EntityManager em = emf.createEntityManager();
        CadastrarFuncionario funcionario = new CadastrarFuncionario();
        /*cadatro do dateS*/
        LocalDate localDate = Datanasc.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);

        funcionario.setTxtNome(txtNome.getText());
        funcionario.setTxtRG(txtRG.getText());
        funcionario.setTxtCPF(txtCPF.getText());
        funcionario.setTxtTelefone(txtTelefone.getText());
        funcionario.setTxtRua(txtRua.getText());
        funcionario.setTxtBairro(txtBairro.getText());
        funcionario.setTxtCidade(txtCidade.getText());
        funcionario.setTxtNumero(txtNumero.getText());
        funcionario.setTxtCep(txtCep.getText());
        funcionario.setDatanasc(date);
        funcionario.setTxtFuncao(txtFuncao.getText());

        funcionario.setUF(uf.getSelectionModel().getSelectedItem().toString());

        em.getTransaction().begin();

        em.persist(funcionario);

        em.getTransaction().commit();

        JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!!");

        ((Node) (event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    private void Cancelar(ActionEvent event) throws IOException, Exception {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MaskFieldUtil.cpfField(txtCPF);
        MaskFieldUtil.foneField(txtTelefone);
        MaskFieldUtil.cepField(txtCep);
        MaskFieldUtil.numericField(txtRG);
        MaskFieldUtil.numericField(txtNumero);

    }

    private void limpar(ActionEvent event) {
        txtTelefone.setText("");
        txtRua.setText("");
        txtRG.setText("");
        txtNome.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtCep.setText("");

    }
}
