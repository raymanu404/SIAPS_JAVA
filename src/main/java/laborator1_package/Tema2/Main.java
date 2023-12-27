package laborator1_package.Tema2;

import java.util.HashMap;

public class Main {

	static String filename = "src/main/resources/laborator_1/carti.json";
	static String outputJsonFileFormat = "_output.json";
	static String jsonExtention = ".json";
	
	public static void main(String[] args) {
		LibraryUtils library = new LibraryUtils(filename);	
		
		// a) Citire carti
		library.readBooksFromJson();
		System.out.println(library.getBooks());

		// b) Sa se stearga o carte din colectia Map
		//library.removeBook(1);
		
		// c) adaugare carte cu putIfAbsent
		//library.addBook(new Carte("Codu lui Da Vinci", "Dan Brown", 2003));

		// d) De salvat modificarile de mai sus in fisier JSON
		//String jsonFileNameOutput = filename.replace(jsonExtention, outputJsonFileFormat);		
		//library.saveInJsonFile(jsonFileNameOutput, library.getBooks());

		// e) Extrage lista de carti de catre autorul Yual Noah Harari
		library.getBooksByAuthor("Harari").forEach(x ->{
			System.out.println("Titlu: " + x.titlul() + " --- autorul: " + x.autorul() + ", anul aparitiei: " + x.anul());
		});
		
		System.out.println();
		// f) Sa se afiseze ordonat dupa titlul cartii
		var sortedByNameOfBook = library.sortByTitle();
		sortedByNameOfBook.forEach(x -> {
			System.out.println(x.titlul());
		});
				
		// g) Afisare cea mai veche carte
		System.out.println(library.getOldestBook().get());
		
	}

}
