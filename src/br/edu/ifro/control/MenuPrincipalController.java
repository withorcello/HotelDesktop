/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 01453074252
 */
public class MenuPrincipalController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void cadastroCliente(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/CadastroCliente.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Clientes");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void cadastroQuartos(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/CadastrarQuartos.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Quartos");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void cadastroFuncionario(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/CadastroFuncionario.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Funcionarios");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void cadastroProdutos(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/CadastrarProduto.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Produtos");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void cadastroFornecedor(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/CadastrarFornecedor.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Fornecedores");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Hospedar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/Hospedar.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Hospedar");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void CadastrarUsuario(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/CadastrarUsuario.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Usuários");
        stage.setScene(scene);
        stage.show();
    }

    private void TrocarUser(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void RelatorioClientes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/RelatorioClientes.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Relatorio de Clientes");
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
