package br.com.rruffer.util;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Tela {

	private final String ARQUIVO_CSS = "/styles/styles.css";

	public Stage exibirTela(Parent root) {
		
		Stage stage = new Stage();

		try {
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(ARQUIVO_CSS).toExternalForm());

			EfeitosDeTela.tirarBordas(root, stage, scene);

			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			Platform.runLater(() -> Mensagem.exeption("Erro ao tentar exibir p�gina: ", e));
//			e.printStackTrace();
		}
		
		return stage;
	}

/*	public void btnMenu(JFXDrawer drawer, JFXHamburger btHamburger) {

		try {
			Parent root = FXMLLoader.load(getClass().getResource(Router.TELA_DRAWER));
//			root.setStyle(value);
			drawer.setSidePane(root);
		} catch (Exception e) {
			Mensagem.exeption("Erro ao gerar menu da aplica��o!", e);
			e.printStackTrace();
		}

		HamburgerBackArrowBasicTransition burgerTask = new HamburgerBackArrowBasicTransition(btHamburger);
		burgerTask.setRate(-1);
		btHamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {

			burgerTask.setRate(burgerTask.getRate() * -1);
			burgerTask.play();

			if (drawer.isShown()) {
				drawer.close();
			} else {
				drawer.open();
			}

		});

	}*/

	public static void close() {
		Platform.exit();
		System.exit(0);
	}

	public static void minimize(Stage stage) {
		stage.setIconified(true);
	}

}
