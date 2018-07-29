package br.com.rruffer.control;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import br.com.rruffer.util.Arquivo;
import br.com.rruffer.util.Calculo;
import br.com.rruffer.util.Mensagem;
import br.com.rruffer.util.Tela;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * 
 * @author rodolfo.ruffer
 *
 */
public class MainController implements Initializable{

	@FXML
	private Pane idPane;
	
    @FXML
    private JFXTextField txfArquivo;

    @FXML
    private JFXButton pegarArquivo;
    
    @FXML
    private JFXListView<String> listaMatriculas;

	@FXML
	private JFXButton btnMinimize;

	@FXML
	private JFXButton btnClose;
	
	File file;

	private final Logger log = LogManager.getLogger(MainController.class);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	
	@FXML
	void buscarArquivo() {
		
		final FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Buscar arquivo...");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + File.separator + "Documents"));
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Arquivos TXT", "*.txt"));
		
		File file = fileChooser.showOpenDialog(new Stage());
		
		if (file != null) {
			txfArquivo.setText(file.getName());
			this.file = file;
			listaMatriculas.getItems().clear();
			
			List<String> listaMatr = Arquivo.lerArquivo(file.toPath());
			List<String> listaResult = new ArrayList<>();
			
			if(file.getName().equals("matriculasSemDV.txt")) {
				for(String matricula: listaMatr) {
					String matriculaComDV = String.format("%s-%s", matricula, Calculo.digitoVerificador(matricula));
					listaResult.add(matriculaComDV);
					listaMatriculas.getItems().add(matriculaComDV);
				}
				
				Arquivo.gravarArquivo(listaResult, "matriculasComDV.txt");
				
			}else if(file.getName().equals("matriculasParaVerificar.txt")) {

				for(String matricula: listaMatr) {
					
					String val = "";
					
					if(matricula.endsWith(Calculo.digitoVerificador(matricula.split("-")[0]))) {
						val = "verdadeiro";
					}else {
						val = "falso";				
					}
					
					String result = String.format("%s %s", matricula, val);
					
					listaResult.add(result);
					listaMatriculas.getItems().add(result);
				}
				
				Arquivo.gravarArquivo(listaResult, "matriculasVerificadas.txt");
				
			}else {
				Mensagem.alerta("Este arquivo não é  válido!");
			}
			
		}
		
	}

	
	@FXML
	void close(ActionEvent event) {
		Platform.runLater(() -> Tela.close());
	}

	@FXML
	void minimize(ActionEvent event) {
		Platform.runLater(() -> Tela.minimize(MainApp.LOGIN_STAGE));
	}


/*	private void desabilitarNodes(boolean status) {

		try {
			ObservableList<Node> listaNodes = idPane.getChildren();

			for (Node node : listaNodes) {
				if (!(node instanceof JFXSpinner) && !(node instanceof Label) && !(node instanceof HBox)) {
					node.setDisable(status);
				}
			}

			progressSpinner.setVisible(status);
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}*/

}
