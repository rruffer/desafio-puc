package br.com.rruffer.control;
	
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.rruffer.util.Mensagem;
import br.com.rruffer.util.Router;
import br.com.rruffer.util.Tela;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * 
 * @author rodolfo.ruffer
 *
 */
public class MainApp extends Application {
	
	private final Logger log = LogManager.getLogger(MainApp.class);
	
	public static Stage LOGIN_STAGE; 
	
	@Override
	public void start(Stage stage) {
		
		log.info("Iniciando aplicação.");
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource(Router.TELA_MAIN));
			LOGIN_STAGE = new Tela().exibirTela(root);
		} catch(Throwable e) {
			Mensagem.exeption("Erro ao iniciar a aplicação: ", e);
			log.error("Erro ao iniciar aplicação: ", e);
//			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
