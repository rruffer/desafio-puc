package br.com.valid.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Arquivo {
	
	private Arquivo() {
		throw new IllegalStateException("Utility class");
	}
	
	public static List<String> lerArquivo(File arquivo){
		
		List<String> listaDeLinhas = new ArrayList<>();
		try (Scanner scanner = new Scanner(arquivo)){
				while (scanner.hasNext()) {
					listaDeLinhas.add(scanner.next());
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return listaDeLinhas;
	}
	
	public static List<String> lerArquivo(Path path){
		
		List<String> listaDeLinhas = null;
		try(Stream<String> linhas = Files.lines(path, StandardCharsets.ISO_8859_1)) {
			listaDeLinhas = linhas.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listaDeLinhas;
	}
	
	public static File gravarArquivo(List<String> lista, String nomeArquivo) {
		
		try(PrintStream out = new PrintStream(nomeArquivo)) {
			for(String dado: lista) {
				out.println(dado);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
