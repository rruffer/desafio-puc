package br.com.valid.util;

public class Validacao {
	
	private Validacao() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * M�todo que valida se a String � um n�mero.
	 * @param num
	 * @return
	 */
	public static boolean isNumber(String num) {

		boolean isNumber = false;

		if (num != null && num.matches("^[0-9]*$")) {
			isNumber = true;
		}

		return isNumber;
	}

}
