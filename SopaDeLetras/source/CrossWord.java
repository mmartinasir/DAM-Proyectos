package source;

import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CrossWord {

	// Attributes
	private Dimension size;
	private char[][] grid;

	// Builders
	public CrossWord() throws IOException {
		fillSoup();
	}

	// Getters and Setters

	// Methods
	private void fillSoup() throws IOException {
		String letter = "";

		// Abrimos el fichero y lo leemos con un Scanner
		File file = new File("./SopaDeLetras/source/CrossFile/CrossWords.txt");
		Scanner read = new Scanner(file);

		// Declaramos la altura y anchura con los primeros numeros que sacamos del
		// fichero.
		this.size = new Dimension();
		this.size.height = read.nextInt();
		this.size.width = read.nextInt();
		this.grid = new char[this.size.height][this.size.width];

		// Empezamos a reyenar el grid
		for (int i = 0; i < this.size.height; i++) {
			for (int j = 0; j < this.size.width; j++) {
				letter = read.next();
				this.grid[i][j] = letter.charAt(0);
			}
		}
		read.close();
	}

	public Point search(String word) {
		Point result = new Point();
		int x = 0;
		int y = 0;
		boolean endLoop = false;

		while (!endLoop) {
			// Comprobamos si la primera letra de la palabra coincide con la letra en la
			// posicion actual
			if (this.grid[x][y] == word.charAt(0)) {
				// Si coincide, comprobamos si la palabra cabe en la posición

				// West
				if (y - word.length() >= 0) {
					
				} else {
					// NorthWest

				}
			}
		}
	}

	private boolean west(String word, int h, int w) {
		String aux = "";
		aux = aux + grid[h][w - 1];

		if (aux == word) {
			return true;
		} else {
			return false;
		}
	}

	private boolean northWest(String word, int h, int w) {
		String aux = "";
		aux = aux + grid[h][w - 1];

		if (aux == word) {
			return true;
		} else {
			return false;
		}
	}

	private boolean north(String word, int h, int w) {
		String aux = "";
		aux = aux + grid[h][w - 1];

		if (aux == word) {
			return true;
		} else {
			return false;
		}
	}

	private boolean northEast(String word, int h, int w) {
		String aux = "";
		aux = aux + grid[h][w - 1];

		if (aux == word) {
			return true;
		} else {
			return false;
		}
	}

	private boolean east(String word, int h, int w) {
		String aux = "";
		aux = aux + grid[h][w - 1];

		if (aux == word) {
			return true;
		} else {
			return false;
		}
	}

	private boolean southEast(String word, int h, int w) {
		String aux = "";
		aux = aux + grid[h][w - 1];

		if (aux == word) {
			return true;
		} else {
			return false;
		}
	}

	private boolean south(String word, int h, int w) {
		String aux = "";
		aux = aux + grid[h][w - 1];

		if (aux == word) {
			return true;
		} else {
			return false;
		}
	}

	private boolean southWest(String word, int h, int w) {
		String aux = "";
		aux = aux + grid[h][w - 1];

		if (aux == word) {
			return true;
		} else {
			return false;
		}
	}

	// ToString
	public String toString() {
		String result = "";

		for (int i = 0; i < this.size.height; i++) {
			for (int j = 0; j < this.size.width; j++) {
				result = result + grid[i][j] + " ";
			}
			result = result + "\n";
		}

		return result;
	}

}
