
package br.edu.ifro.control;

import br.edu.ifro.Parcela;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
public class ReceberParcelaController implements Initializable {

    @FXML
    private Button btnReceber;
    
    @FXML
    private Button btnEmitir;
    
    @FXML
    private Button btnCancelar;
    
    @FXML
    private TableView <Parcela>  tabela;
    
    @FXML
    private TableColumn <Parcela, String>  Status;
    
    @FXML
    private TableColumn <Parcela, Boolean> select;
    
    @FXML
    private TableColumn <Parcela, String> numero;
    
    @FXML
    private TableColumn  <Parcela, Double>valor;
    
    @FXML
    private TableColumn <Parcela, String>validade;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        select.setCellValueFactory(
                new PropertyValueFactory<>("select"));
        numero.setCellValueFactory(
                new PropertyValueFactory<>("numero"));
        valor.setCellValueFactory(
                new PropertyValueFactory<>("valor"));
        validade.setCellValueFactory(
                new PropertyValueFactory<>("validade"));
        Status.setCellValueFactory(
                new PropertyValueFactory<>("Status"));

        select.setCellFactory(
                CheckBoxTableCell.forTableColumn(select));
        
        tabela.setItems(listadeParcelas());
         
    }

    
    
    private ObservableList<Parcela> listadeParcelas() {
        return FXCollections.observableArrayList(
                         /* Status |  número | Validade | Valor */
                new Parcela("Não Pago", 1 , "23/07/2018",6986.98),
                new Parcela("Não Pago", 2 , "23/08/2018",6986.98),
                new Parcela("Não Pago", 3 , "23/09/2018",6986.98),
                new Parcela("Não Pago", 4 , "23/10/2018",6986.98),
                new Parcela("Não Pago", 5 , "23/11/2018",6986.98),
                new Parcela("Não Pago", 6 , "23/12/2018",6986.98)
        );
        
        
    } 
    
    /*BTNCANCELAR*/
    @FXML
    public void cancelar(ActionEvent event ){
        System.exit(0);
    } 
    
       
}
