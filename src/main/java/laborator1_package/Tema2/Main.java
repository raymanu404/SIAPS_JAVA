package laborator1_package.Tema2;

import java.util.HashMap;

import laborator1_package.Common.Carte;

public class Main {

	public static void main(String[] args) {
		// 1 Citire carti
		HashMap<Integer, Carte> carti = Utils.citireCarti();
		System.out.println(carti);

		// 2
		Utils.stergereCarte(carti, 1);
		System.out.println(carti);
		
		// 3

		// 4
		// 5
		// 6
		// 7
	}

}
