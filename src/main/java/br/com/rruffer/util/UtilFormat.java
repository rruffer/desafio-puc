package br.com.rruffer.util;

/**
 * 
 * @author Rodolfo.ruffer
 *
 */
public class UtilFormat {
	
	/**
	 * M�todo que <b><i>expande</i></b> um valor.
	 * @param valor - dado a ser expandido.
	 * @param tamanho - tamaho m�ximo que o valor deve expandir.
	 * @param expandirCom - dado que ser� concatenado ao valor para ser expandido.
	 * @param expandirPara - <i><b>true</b></i> expande para direita e <i><b>false</b></i> para esquerda.
	 * @return String  - valor formatado.
	 */
	public static String expandirValor(String valor, int tamanho, String expandirCom, boolean expandirPara) {
		
		if(valor == null) {
			valor = "Null";
		}
		
		StringBuffer aux = new StringBuffer(valor);
		if(expandirPara){
			while (aux.length() < tamanho) 
				aux.append(expandirCom);
		}else{
			while (aux.length() < tamanho)
				aux.insert(0, expandirCom);
		}

		return aux.toString();
	}

}
