package laborator1_package.Tema2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import laborator1_package.Common.Carte;

public class Utils {

	private static String fileName = "src/main/resources/laborator_1/carti.json";
	private static File jsonFile = new File(fileName);
	public static HashMap<Integer, Carte> carti;

	public static HashMap<Integer, Carte> citireCarti() {

		HashMap<Integer, Carte> carti = new HashMap<Integer, Carte>();
		ObjectMapper mapper = new ObjectMapper();

		try {
			var localData = (HashMap<Integer, Carte>) mapper.readValue(jsonFile,
					new TypeReference<HashMap<Integer, Carte>>() {
					});

			for (Map.Entry<Integer, Carte> entry : localData.entrySet()) {

				carti.putIfAbsent(entry.getKey(), entry.getValue());
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

		return carti;
	}

	public static void stergereCarte(HashMap<Integer, Carte> carti, Integer id) {

		try {
			if (carti.containsKey(id)) {
				carti.remove(id);
				System.out.println("Am sters cartea cu id-ul: " + id);
			} else {
				System.out.println("Cartea nu exista!");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void adaugareCarte(Carte carte) {
		carti.putIfAbsent(10, carte);
	}
}
