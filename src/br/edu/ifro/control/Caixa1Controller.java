/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.eti.diegofonseca.MaskFieldUtil;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05011440214
 */
public class Caixa1Controller implements Initializable {

    @FXML
    private JFXTextField txtFun;
    @FXML
    private JFXTextField txtCliente;
    @FXML
    private JFXTextField txtVT;
    @FXML
    private JFXTextField txtCPF;
    @FXML
    private JFXTextField txtVP;
    @FXML
    private JFXTextField txtTroco;
    @FXML
    private JFXComboBox<?> cbFormPag;
    @FXML
    private TextField txtcaixa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MaskFieldUtil.cpfCnpjField(txtCPF);
    }    

    @FXML
    private void receberParcela(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/ReceberParcela.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,376);
        Stage stage = new Stage();
        stage.setTitle("Receber Parcela");
        stage.setScene(scene);
        stage.show();
    }
    
}
