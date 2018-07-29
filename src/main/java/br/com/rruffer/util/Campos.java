package br.com.rruffer.util;

import com.jfoenix.controls.JFXTextField;

import javafx.beans.value.ChangeListener;

/**
 * 
 * @author rodolfo.ruffer
 *
 */
public class Campos {

	private Campos() {
		throw new IllegalStateException("Utility class");
	}

	public static ChangeListener<String> somenteNumeros(JFXTextField txCampo) {
		return (observable, oldValue, newValue) -> {
			if (!newValue.matches("\\d*")) {
				txCampo.setText(newValue.replaceAll("[^\\d]", ""));
			}
		};

	}
}
