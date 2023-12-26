package laborator1_package.Tema2;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import static java.util.stream.Collectors.*;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import laborator1_package.Common.Carte;

public class LibraryUtils {

	
	private File _jsonFile;
	private HashMap<Integer, Carte> books;

	public LibraryUtils(String fileName) {
		books = new HashMap<Integer, Carte>();
		_jsonFile = new File(fileName);
	}

	public void readBooksFromJson() {		
		ObjectMapper mapper = new ObjectMapper();

		try {
			var localData = (HashMap<Integer, Carte>) mapper.readValue(_jsonFile,
					new TypeReference<HashMap<Integer, Carte>>() {
					});

			for (Map.Entry<Integer, Carte> entry : localData.entrySet()) {
				books.putIfAbsent(entry.getKey(), entry.getValue());
			}

		} catch (

		StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void removeBook(Integer id) {

		try {
			if (books.containsKey(id)) {
				books.remove(id);
				System.out.println("Am sters cartea cu id-ul: " + id);
			} else {
				System.out.println("Cartea nu exista!");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addBook(Carte carte) {
		Random random = new Random();
		int randomId = Math.abs(random.nextInt());
		books.putIfAbsent(randomId, carte);
		
		System.out.println("Carte adaugata");
	}
	
	public void saveInJsonFile(String filename, HashMap<Integer, Carte> carti) {
		ObjectMapper mapper = new ObjectMapper();
		File jsonOutput = new File(filename);
		try {
			mapper.writeValue(jsonOutput, carti);
			System.out.println("Salvat in fisierul --> " + filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Set<Carte> getBooksByAuthor(String author) {
		var output = books.values().stream().filter(x -> x.autorul().contains(author)).collect(toSet());
		return output;
	}
	
	public List<Carte> sortByTitle() {
		System.out.println("Ordonare crescatoare dupa titlu:\n");
		return books.values().stream().sorted(Comparator.comparing(Carte::titlul)).collect(toList());
	}
	
	public Optional<Carte> getOldestBook() {
		System.out.print("Cea mai veche carte: ");
		return books.values().stream().sorted(Comparator.comparing(Carte::anul)).findFirst();
	}

	public HashMap<Integer, Carte> getBooks() {
		return books;
	}
}
