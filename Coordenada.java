package javaLar;

public class Coordenada {
	public int coordx;
	public int coordy;
	public boolean ocupada;
	public boolean developer;
	public boolean bug;
	public Planeta planeta;
	public String NS;

	public Coordenada() {
		developer = false;
		bug = false;
		planeta = null;
		ocupada = false;
	}

	public Coordenada(int x, int y) {
		coordx = x;
		coordy = y;
		developer = false;
		bug = false;
		planeta = null;
	}

	public boolean colocarBug() {
		// if there's no bug or developer and isn't in the middle it will place a bug or
		// a dev
		if (!ocupada && (coordx != 7 && coordy != 7)) {
			this.bug = true;
			System.out.println("Bug em " + coordx + " " + coordy);
			ocupada = true;
			return true;
		} else
			return false;
	}

	public boolean colocarDesenvolvedor() {
		if (!ocupada && (coordx != 7 && coordy != 7)) {
			this.developer = true;
			System.out.println("Dev em " + coordx + " " + coordy);
			ocupada = true;
			return true;
		} else
			return false;
	}

	public void NorteOuSul() {
		if(coordy < 7) {
			NS = "Norte";
		}
		else if(coordy > 7) {
			NS = "Sul";
		}
	}
}
