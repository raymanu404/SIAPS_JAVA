package laborator1_package.Tema3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import laborator1_package.Tema2.Carte;
import laborator1_package.Tema3.Records.Mobilier;

public class FurnitureUtils {

	private File _jsonFile;
	private List<Mobilier> _furnitureList;

	public FurnitureUtils(String fileName) {
		_furnitureList = new ArrayList<Mobilier>();
		_jsonFile = new File(fileName);
	}

	public void readFurnitureListFromJson() {
		ObjectMapper mapper = new ObjectMapper();

		try {
			var localData = (List<Mobilier>) mapper.readValue(_jsonFile, new TypeReference<List<Mobilier>>() {
			});

			_furnitureList.addAll(localData);
			System.out.println("Date citite cu succes!");

		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printFurnitureList() {
		printFurnitureData(_furnitureList);
	}

	public void printFurnitureByName(String name) {
		System.out.println();
		var result = _furnitureList.stream().filter(x -> x.nume().contains(name)).findFirst();
		if(result.isPresent()) {
			printFurnitureData(result.get());
		}else {
			System.out.println("Nu exista mobilier cu acest nume: " + name);
		}
		
	}

	private void printFurnitureData(List<Mobilier> list) {
		list.forEach(x -> {
			System.out.println("Nume mobilier: " + x.nume());

			x.placi().forEach(p -> {
				System.out
						.print("Descriere: " + p.descriere() + " \t\t\t Nr.Bucati: " + p.nr_bucati() + "\t Orientare: "
								+ p.orientare() + "\t Lungime/Latime: " + p.lungime() + "/" + p.latime() + " (mm)");
				System.out.print("\t Canturi: ");
				for (var cant : p.canturi()) {
					System.out.print(cant + " ");
				}
				System.out.println();
			});

			System.out.println("-----------------------");
		});
	}

	private void printFurnitureData(Mobilier furniture) {

		System.out.println("Nume mobilier: " + furniture.nume());

		furniture.placi().forEach(p -> {
			System.out.print("Descriere: " + p.descriere() + " \t\t\t Nr.Bucati: " + p.nr_bucati() + "\t Orientare: "
					+ p.orientare() + "\t Lungime/Latime: " + p.lungime() + "/" + p.latime() + " (mm)");
			System.out.print("\t Canturi: ");
			for (var cant : p.canturi()) {
				System.out.print(cant + " ");
			}
			System.out.println();
		});

		System.out.println("-----------------------");

	}

	public List<Mobilier> get_furnitureList() {
		return _furnitureList;
	}
}
