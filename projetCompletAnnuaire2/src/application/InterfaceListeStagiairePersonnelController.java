package application;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import fr.isika.cda18.projet1Annuaire.model.Stagiaire;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InterfaceListeStagiairePersonnelController {
	@FXML
	private Button btnAjouter;

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
	private void btnListeHandler(Event e) throws IOException {
		//System.out.println("Vers l'interface Liste des stagiaires");
		
		// 1) On cherche le grand père du bouton[le bouton a comme pere la scène et la scène a comme père le Stage]
		Stage primaryStage = (Stage)btnVoirListe.getScene().getWindow();
		// 2) Chargement de layout (design) depuis le fichier ListeStagiaires.fxml
		AnchorPane layoutListe = (AnchorPane)FXMLLoader.load(getClass().getResource("ListeStagiaire.fxml"));
		
		// 3) On créer une scène
		Scene sceneList = new Scene(layoutListe,700,400);
		sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		// 4) On demande à notre stage(théatre) d'affiche la nouvelle scène : sceneList
		primaryStage.setScene(sceneList);
		
//		try {
//			// INITIALISATION DU FICHIER BIN AVEC NEW RANDOM
//			raf = new RandomAccessFile("src/mesFichiers/listeStagiaire.bin", "rw");
//			raf.setLength(0);
//			ListeStagiaireRecup lb = new ListeStagiaireRecup();
//
//			List<Stagiaire> listeStagiaire = lb.recupListStagiaires();
//		
////			Noeud noeud = new Noeud(null);
//
//		//	ArbreBinaire arbreBinaire = new ArbreBinaire();
//			Noeud noeud = new Noeud(null); // put a intern in a node - pour chaque stagiaire
//			for (Stagiaire stagiaire : listeStagiaire) {
//				
//				noeud.ajouterNoeud(raf, stagiaire);
//			}
//			raf.seek(0); // comparaison de la taille du stagiaire e tla taille du noeud staigiare.
//
//			for (int j = 0; j < raf.length() / Noeud.TAILLE_NOEUD; j++) {
//				Noeud stagiaire = Noeud.lireNoeud(raf); // j'appelle mon objet stagiaire. comme appelé dans
//														// "NOEUD", je dois l'appeler dans noeud.lireNoeud
//				System.out.println(stagiaire);
//			}
//			raf.seek(0);
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}	
	}
	@FXML
	public void btnInscriptionHandler(Event e) {
		String nom= txtNomStagiaire.getText();
		System.out.println("Nom: "+nom);
		String prenom= txtPrenomStagiaire.getText();
		System.out.println("Prenom: "+prenom);
		String departement=txtDepartement.getText();
		System.out.println("Departement: "+departement);
		String nomPromo=txtNomPromo.getText();
		System.out.println("Nom de la Promo: "+nomPromo);
		String anneePromo=txtAnneePromo.getText();
		System.out.println("Annee de la Promo: "+anneePromo);
		
		
		// Construction d'un objet de type objet avec le constructeur avec paramètre
		Stagiaire stagiaire=new Stagiaire(nom, prenom, departement, nomPromo, anneePromo);
		//Ajouter cet objet dans la liste
		Main.stagiaire.add(stagiaire);
		System.out.println(Main.stagiaire);
		
		
	}
	public void reinitialiserFom(){
		txtNomStagiaire.clear();
		txtPrenomStagiaire.clear();
		txtDepartement.clear();
		txtNomPromo.clear();
		txtAnneePromo.clear();
	}

//	@FXML
//	private void btnAjouter(Event e) {
//		String nom = txtNomStagiaire.getText();
//		String prenom = txtPrenomStagiaire.getText();
//		String nomPromo = txtNomPromo.getText();
//		String anneePromo = txtAnneePromo.getText();
//	}
//
//	@FXML
//	private void btnEffacer(Event e) {
//		txtNomStagiaire.clear();
//		txtPrenomStagiaire.clear();
//		txtNomPromo.clear();
//		txtAnneePromo.clear();

//	}

}
