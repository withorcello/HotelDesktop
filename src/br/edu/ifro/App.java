/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;


import br.edu.ifro.modelo.Login;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author 01453074252
 */
public class App extends Application {
   
     @Override
    public void start(Stage stage) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hotel");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT Cpf FROM Login Cpf");

        List<Login> l = query.getResultList();
        
        if (query != null ){
    
        Parent root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }
        else{
    
        Parent root = FXMLLoader.load(getClass().getResource("view/CadastrarUsuario.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
