package application;

import java.io.IOException;
import java.io.RandomAccessFile;

import fr.isika.cda18.projet1Annuaire.model.Noeud;
import fr.isika.cda18.projet1Annuaire.model.Stagiaire;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InterfaceAjoutStagiaireController {
	public static RandomAccessFile raf;
	@FXML
	private Button btnEnregistrer;

	@FXML
	private Button btnVoirListe;

	@FXML
	private TextField txtNomStagiaire;

	@FXML
	private TextField txtPrenomStagiaire;

	@FXML
	private TextField txtDepartement;

	@FXML
	private TextField txtNomPromo;

	@FXML
	private TextField txtAnneePromo;
	

	@FXML
	public Label loginMessageLabel;

	@FXML
	public Label loginMessageLabel2;

	@FXML
	private void btnVoirListe(Event e) throws IOException {
		Stage primaryStage = (Stage) btnEnregistrer.getScene().getWindow();
		AnchorPane layoutListe = (AnchorPane) FXMLLoader
				.load(getClass().getResource("InterfaceListeStagiaireAdmin.fxml"));
		Scene sceneList = new Scene(layoutListe, 1368,768);
		sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(sceneList);
	}

	@FXML
	private void btnEnregistrer(Event e) throws IOException {
		String nom = txtNomStagiaire.getText();
		String prenom = txtPrenomStagiaire.getText();
		String departement = txtDepartement.getText();
		String nomPromo = txtNomPromo.getText();
		String anneePromo = txtAnneePromo.getText();

		if ((nom.equalsIgnoreCase("") || (prenom.equalsIgnoreCase("")) || (departement.equalsIgnoreCase(""))
				|| (nomPromo.equalsIgnoreCase("")) || (anneePromo.equalsIgnoreCase("")))) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Complétion des informations");
			alert.setContentText("Veuillez saisir tous les champs *");
			alert.showAndWait();
			/// fin partie alert*/
			reinitialisationForm();
		} else {
			System.out.println("Nom : " + nom + " \nPrenom : " + prenom + " \nDepartement : " + departement
					+ " \nNom de la Promo : " + nomPromo + " \nAnnee de la Promo : " + anneePromo);

			Stagiaire stagiaire = new Stagiaire(nom, prenom, departement, nomPromo, anneePromo);
			Noeud noeud=new Noeud(null);
			raf.seek(0);
			noeud.ajouterNoeud(raf, stagiaire);
//			Main.stagiaire.add(stagiaire);

			System.out.println("******contenu de la liste*******");
			System.out.println(Main.stagiaire);
			loginMessageLabel.setText("L'enregistrement a bien été effectué...");
		}
		reinitialisationForm();
	}

	
	@FXML
	private void reinitialisationForm() {
		txtNomStagiaire.clear();
		txtPrenomStagiaire.clear();
		txtDepartement.clear();
		txtNomPromo.clear();
		txtAnneePromo.clear();

	}

}
