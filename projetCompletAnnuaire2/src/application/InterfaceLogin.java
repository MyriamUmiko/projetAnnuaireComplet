package application;

import java.io.IOException;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InterfaceLogin {

	@FXML
	private Button btnConnection;

	@FXML
	private TextField txtLogin;

	@FXML
	private TextField txtPassword;
	
	@FXML
	public Label loginMessageLabel;
	
	@FXML
	private ImageView image;

	@FXML
	private void btnConnection(Event e) throws IOException {
		//String login = "admin";
		String login = txtLogin.getText();

		//String password = "password";
		String password = txtPassword.getText();

		if (login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("password")) {
			Stage primaryStage = (Stage) btnConnection.getScene().getWindow();
			AnchorPane layoutListe = (AnchorPane) FXMLLoader
					.load(getClass().getResource("InterfaceListeStagiaireAdmin.fxml"));
			Scene sceneList = new Scene(layoutListe, 1368,768);
			sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(sceneList);

			System.out.println(login + password);
			
		}  
		else if (login.equalsIgnoreCase("personnel") && password.equalsIgnoreCase("password")) {
			Stage primaryStage = (Stage) btnConnection.getScene().getWindow();
			AnchorPane layoutListe = (AnchorPane) FXMLLoader
					.load(getClass().getResource("InterfaceListeStagiairePersonnel.fxml"));
			Scene sceneList = new Scene(layoutListe, 1368,768);
			sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(sceneList);

			System.out.println(login + password);
		}
		
		else {
			loginMessageLabel.setText("Le login ou le mode de passe est incorrect.\n Veuillez réessayez.");
			
		}

		reinitialisationForm();

	}
	
	
	

	private void reinitialisationForm() {
		txtLogin.clear();
		txtPassword.clear();

	}
	
//	https://projet-isika.com/
	
	
}
