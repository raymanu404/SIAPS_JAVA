package laborator1_package.Tema3;

public class _MainTema3 {

	static String filename = "src/main/resources/laborator_1/mobilier.json";
	static String outputJsonFileFormat = "_output.json";
	static String jsonExtention = ".json";

	public static void main(String[] args) {
		FurnitureUtils furniture = new FurnitureUtils(filename);
		// citire din fisier
		furniture.readFurnitureListFromJson();
		System.out.println();

		// a) Citire din fisierul mobilier.json -> afisare
		// b) Afișează elementele de mobilier din colecție şi plăcile care le compun
		// furniture.printFurnitureList();

		// c) Afișează caracteristicile plăcilor care compun o anumită piesă de
		// mobilier???
		// furniture.printFurnitureByName("dulap");

		// d) Afișează estimativ numărul colilor de pal necesare pentru realizarea unui anumit corp
		//	de mobile știind că o coală de pal are dimensiunea 2800 x 2070 mm (pentru simplitate
		//	se va ţine cont doar de arie, nu şi de posibilitatea de a realiza tăieturile) ???
		
	}

}
