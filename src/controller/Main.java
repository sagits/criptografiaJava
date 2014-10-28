package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		String frase = "estou com fome";

		System.out.println("Frase original: " + frase);
		System.out.println("");

		ceasarComLoop(frase, "f", 100);
		System.out.println("");

		ceasar(frase, "f");
		System.out.println("");

		ceasarFt(frase, "f".toCharArray()[0]);
		System.out.println("");

		int[] aa = {3,2,5};
		discos(frase, aa);
		System.out.println("");

	}

	public static void ceasarComLoop(String msg, String c, int loop) {
		String alfabeto = "abcdefghijklmnopqrstuvxwyz ";
		int chave = alfabeto.indexOf(c);
		
		String fraseCrypt = "";
		String fraseDeCrypt = "";
		
		String other = msg;
		for (int j = 0; j < loop; j++) {
			String m = "";
			for (int i = 0; i < other.length(); i++) {
				m += (char) (other.charAt(i) + chave);
			}
			other = m;
		}
		fraseCrypt = other;
		
		for (int j = 0; j < loop; j++) {
			String m = "";
			
			for (int i = 0; i < other.length(); i++) {
				m += (char) (other.charAt(i) - chave);
			}
			other = m;
		}
		fraseDeCrypt = other;
		
		System.out.println("Criptografia de Cesar com loop");
		System.out.println("");
		System.out.println("Frase crip: " + fraseCrypt);
		System.out.println("Frase desc: " + fraseDeCrypt);
	}


	public static void ceasar(String msg, String c) {
		String alfabeto = "abcdefghijklmnopqrstuvxwyz ";
		int chave = alfabeto.indexOf(c);
		String fraseCrypt = "";
		String fraseDeCrypt = "";
		for (int i = 0; i < msg.length(); i++) {
			fraseCrypt += (char) (msg.charAt(i) + chave);
		}
		for (int i = 0; i < fraseCrypt.length(); i++) {
			fraseDeCrypt += (char) (fraseCrypt.charAt(i) - chave);
		}
		System.out.println("Criptografia de Cesar");
		System.out.println("");
		System.out.println("Frase crip: " + fraseCrypt);
		System.out.println("Frase desc: " + fraseDeCrypt);
	}

	public static void ceasarFt(String msg, char chave) {
		String fraseCrypt = "";
		String fraseDeCrypt = "";
		List<Character> hash = new ArrayList<Character>();
		String alfabeto = "abcdefghijklmnopqrstuvxwyz ";

		// criando hash fatorial
		hash.add(chave);
		for (char c : alfabeto.toCharArray()) {
			if (c != chave)
				hash.add(c);
		}
		Collections.shuffle(hash);

		for (int i = 0; i < msg.length(); i++) {
			int index = alfabeto.indexOf(msg.charAt(i));
			fraseCrypt += (char) hash.get(index);
		}
		for (int i = 0; i < fraseCrypt.length(); i++) {
			char[] aa = alfabeto.toCharArray();
			int index = hash.indexOf(fraseCrypt.charAt(i));
			fraseDeCrypt += aa[index];
		}

		System.out.println("Criptografia de Cesar com fatorial/hash");
		System.out.println("");
		System.out.println("Frase crip: " + fraseCrypt);
		System.out.println("Frase desc: " + fraseDeCrypt);
	}

	public static void discos(String msg, int[] chave) {
		String fraseCrypt = "";
		String fraseDeCrypt = "";

		String alfabeto = "abcdefghijklmnopqrstuvxwyz ";

		// discos
		HashMap<Integer, List<Character>> hashs = new HashMap<Integer, List<Character>>();

		for (int i = 0; i < 10; i++) {
			List<Character> hash = new ArrayList<Character>();
			for (char c : alfabeto.toCharArray()) {
				hash.add(c);
			}
			Collections.shuffle(hash);
			hashs.put(i, hash);

		}

		int j = 0;
		for (int i = 0; i < msg.length(); i++) {

			if (j > chave.length - 1)
				j = 0;

			int index = alfabeto.indexOf(msg.charAt(i));
			index = index > alfabeto.length() - 1 ? index - alfabeto.length()
					- 1 : index;
			fraseCrypt += (char) hashs.get(chave[j]).get(index);
		}
		j = 0;
		for (int i = 0; i < fraseCrypt.length(); i++) {
			if (j > chave.length - 1)
				j = 0;

			char[] aa = alfabeto.toCharArray();
			int index = hashs.get(chave[j]).indexOf(fraseCrypt.charAt(i));

			fraseDeCrypt += aa[index];
		}

		System.out.println("Criptografia de Cilindro de bazeres");
		System.out.println("");
		System.out.println("Frase crip: " + fraseCrypt);
		System.out.println("Frase desc: " + fraseDeCrypt);
	}

}
