package br.com.valid.util;

public class Calculo {
	
	private Calculo() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * M�todo que calcula d�gito verificador.
	 * @param matricula
	 * @return
	 */
	public static String digitoVerificador(String matricula) {

		int soma = 0;
		int mult = 5;
		String result = "";

		if (Validacao.isNumber(matricula)) {
			for (int i = 0; i < matricula.length(); i++) {
				int num = Character.getNumericValue(matricula.charAt(i));
				soma += num * mult--;
			}
			result = Integer.toHexString(soma % 16).toUpperCase();
		}

		return result;
	}

}
