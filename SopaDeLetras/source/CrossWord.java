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
		read.nextLine();
		for (int i = 0; i < this.size.height; i++) {
			for (int j = 0; j < this.size.width; j++) {
				letter = read.nextLine();
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
		boolean noWord = false;

		while (!endLoop) {
			// Comprobamos si la primera letra de la palabra coincide con la letra en la
			// posicion actual
			if (this.grid[x][y] == word.charAt(0)) {
				// Si coincide, comprobamos si la palabra cabe en la posición

				// West
				if (y - word.length() >= 0) {
					if (west(word,x,y)) {
						result.x = x;
						result.y = y;
						endLoop = true;
					}
				} else {
					// NorthWest
					if (x - word.length() >= 0 && y - word.length() >= 0) {
						if (west(word,x,y)) {
							result.x = x;
							result.y = y;
							endLoop = true;
						}
					}
					else {
						//North
						if (x - word.length() >= 0) {
							if (west(word,x,y)) {
								result.x = x;
								result.y = y;
								endLoop = true;
							}
						} else {
							//NorthEast
							if (x - word.length() >= 0 && y + word.length() <= this.size.width) {
								if (west(word,x,y)) {
									result.x = x;
									result.y = y;
									endLoop = true;
								}
							} else {
								//East
								if (y + word.length() <= this.size.width) {
									if (west(word,x,y)) {
										result.x = x;
										result.y = y;
										endLoop = true;
									}
								} else {
									//SouthEast
									if (x + word.length() >= this.size.height && y + word.length() <= this.size.width) {
										if (west(word,x,y)) {
											result.x = x;
											result.y = y;
											endLoop = true;
										}
									} else {
										//South
										if (x + word.length() <= this.size.height) {
											if (west(word,x,y)) {
												result.x = x;
												result.y = y;
												endLoop = true;
											}
										}
									}
								}
							}
						}
					}
				}
				
			}
			if (x < this.size.height && y < this.size.width) {
				if (y == this.size.width) {
					x++;
					y = 0;
				} else {
					y++;
				}
			} else {
				endLoop = true;
				noWord = true;
			}
		}
		if (!noWord) {
			return result;
		} else {
			result.x = -1;
			result.y = -1;
			return result;
		}
	}

	private boolean west(String word, int h, int w) {
		String aux = ""+word.charAt(0);
		
		for (int i = 0; i < word.length(); i++) {
			aux = aux + grid[h][w - 1];
		}

		if (aux.equals(word)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean northWest(String word, int h, int w) {
		String aux = ""+word.charAt(0);
		
		for (int i = 0; i < word.length(); i++) {
			aux = aux + grid[h - 1][w - 1];
		}

		if (aux.equals(word)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean north(String word, int h, int w) {
		String aux = ""+word.charAt(0);
		
		for (int i = 0; i < word.length(); i++) {
			aux = aux + grid[h - 1][w];
		}

		if (aux.equals(word)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean northEast(String word, int h, int w) {
		String aux = ""+word.charAt(0);
		
		for (int i = 0; i < word.length(); i++) {
			aux = aux + grid[h - 1][w + 1];
		}

		if (aux.equals(word)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean east(String word, int h, int w) {
		String aux = ""+word.charAt(0);
		
		for (int i = 0; i < word.length(); i++) {
			aux = aux + grid[h][w + 1];
		}

		if (aux.equals(word)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean southEast(String word, int h, int w) {
		String aux = ""+word.charAt(0);
		
		for (int i = 0; i < word.length(); i++) {
			aux = aux + grid[h + 1][w - 1];
		}

		if (aux.equals(word)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean south(String word, int h, int w) {
		String aux = ""+word.charAt(0);
		
		for (int i = 0; i < word.length(); i++) {
			aux = aux + grid[h + 1][w];
		}

		if (aux.equals(word)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean southWest(String word, int h, int w) {
		String aux = ""+word.charAt(0);
		
		for (int i = 0; i < word.length(); i++) {
			aux = aux + grid[h + 1][w + 1];
		}

		if (aux.equals(word)) {
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
