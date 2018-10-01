package conflitoentrereinas;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Tablero tab = new Tablero("reinas");
		tab.resolver();
		tab.guardarEnArchivo("reinas");

	}

}
