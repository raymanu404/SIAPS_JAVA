package laborator1_package.Tema1;

import java.util.List;

import laborator1_package.Common.Persoana;

public class Main {
	public static void main(String[] args) {
		Persoana p1 = new Persoana("Oana", 23);
		Persoana p2 = new Persoana("Oana", 23);

		System.out.println(p1);
		System.out.println("Persoana cu numele " + p1.name() + " are varsta " + p1.age());
		System.out.println(p1.equals(p2));

		List<Persoana> persoane = Utils.citire();
		for (Persoana p : persoane) {
			System.out.println(p);
		}
		persoane.add(new Persoana("Maria", 33));
		Utils.scriere(persoane);

	}

}
