package br.com.valid.util;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * @author rodolfo.ruffer
 *
 */
public class EfeitosDeTela {
	
	private static double xOffset = 0;
	private static double yOffset = 0;
	
	/**
	 * Método que retira a borda, botões e funções originais da janela.
	 * @param root
	 * @param stage
	 * @param scene
	 */
	public static void tirarBordas(Parent root, Stage stage, Scene scene) {
		stage.initStyle(StageStyle.TRANSPARENT);
		scene.setFill(Color.TRANSPARENT);
		
		//clicar na janela
		root.setOnMousePressed(event -> {
			xOffset = event.getSceneX();
			yOffset = event.getSceneY();
		});
		
		//arrastar a janela
		root.setOnMouseDragged(event -> {
			stage.setX(event.getScreenX() - xOffset);
			stage.setY(event.getScreenY() - yOffset);
		});
	}

}
