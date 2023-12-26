package laborator1_package.Tema1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import laborator1_package.Common.Persoana;

public class Utils {
	public static void scriere(List<Persoana> lista) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = new File("src/main/resources/laborator_1/persoane.json");
			mapper.writeValue(file, lista);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Persoana> citire() {
		try {
			File file = new File("src/main/resources/laborator_1/persoane.json");
			ObjectMapper mapper = new ObjectMapper();
			List<Persoana> persoane = mapper.readValue(file, new TypeReference<List<Persoana>>() {
			});
			return persoane;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
