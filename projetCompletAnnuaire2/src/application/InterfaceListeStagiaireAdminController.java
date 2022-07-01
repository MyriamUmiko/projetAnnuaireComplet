package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.isika.cda18.projet1Annuaire.model.Stagiaire;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InterfaceListeStagiaireAdminController implements Initializable {

	@FXML
	private TextField txtNomRecherche;
	
	@FXML
	private TextField txtPrenomRecherche;

	@FXML
	private TextField txtDepartementRecherche;

	@FXML
	private TextField txtNomPromoRecherche;

	@FXML
	private TextField txtAnneePromoRecherche;
	
	@FXML
	private TableColumn<Stagiaire, String> nom;

	@FXML
	private TableColumn<Stagiaire, String> prenom;
	
	@FXML
	private TableColumn<Stagiaire, String> departement;

	@FXML
	private TableColumn<Stagiaire, String> nomPromo;

	@FXML
	private TableColumn<Stagiaire, String> anneePromo;



	@FXML
	private TableView<Stagiaire> tblStagiaire;
	
	@FXML
	private Button btnAjouter;

	@FXML
	private Button btnSupprimer;
	
	@FXML
	private Button btnMiseAJour;
	
	@FXML
	private Button btnImpression;
	
	@FXML
	private Button btnRechercher;
	
	@FXML
	private Button btnHomePage;

	@FXML
	private void btnAjouter(Event e) throws IOException {
		Stage primaryStage = (Stage) btnAjouter.getScene().getWindow();
		AnchorPane layoutListe = (AnchorPane) FXMLLoader
				.load(getClass().getResource("InterfaceAjoutStagiaire.fxml"));
		Scene sceneList = new Scene(layoutListe, 1368,768);
		sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setScene(sceneList);

	}
	
	@FXML
	private void btnHomePage (Event e) throws IOException {
		Stage primaryStage = (Stage) btnHomePage.getScene().getWindow();
		AnchorPane layoutListe = (AnchorPane) FXMLLoader
				.load(getClass().getResource("InterfaceLogin.fxml"));
		Scene sceneList = new Scene(layoutListe, 1368,768);
		sceneList.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setScene(sceneList);	
	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("Nom"));
		prenom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("Prenom"));
		departement.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("Departement"));
		nomPromo.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("nomPromo"));
		anneePromo.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("anneePromo"));
		

		tblStagiaire.setItems(Main.stagiaire);
		
		}
	

	
	
	@FXML
	private void btnRechecher(Event e) throws IOException {
		String nomRecherche= txtNomRecherche.getText();
		String prenomRecherche = txtPrenomRecherche.getText();
		String departementRecherche = txtDepartementRecherche.getText();
		String nomPromoRecherche = txtNomPromoRecherche.getText();
		String anneePromoRecherche = txtAnneePromoRecherche.getText();
	}

	@FXML
	private void btnImpression(Event e) {
		Printer printer = Printer.getDefaultPrinter();
		PageLayout layout = printer.createPageLayout(Paper.A3, PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);
		PrinterJob job = PrinterJob.createPrinterJob();
		
		if(job!=null) {
			job.getJobSettings().setJobName("test d'impression");
			if (job.showPrintDialog((Stage) btnImpression.getScene().getWindow())) {
				ObservableList<Node> listeTable = tblStagiaire.getChildrenUnmodifiable();
				for (Node n : listeTable)
				job.printPage(layout,n);
			} else {
				System.out.println("impression annulée");
			}
			job.endJob();

		 }
	}
	}
	

	

