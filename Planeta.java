package javaLar;

public abstract class Planeta{
	public int coordx;
	public int coordy;
	public String nome;
	public int velocidade;
	public int bugs;
	public int devs;
	public String resumo;
	public int offset;
	public double horasPassadas;
	public double horasPorInstante;
	public int voltasCompletas;
	public boolean explodiu;

	// Method used in all other planets to give Cords based on the offset
	public void darCoordenadas(SistemaJavaLar s) {
		coordx = 7;
		coordy = 7 - offset;
		explodiu = false;
	}

	// Method used to determine the planets movement in the plan(step by step)
	public void moverUm() {
		// move left
		if (coordy == 7 - offset && coordx > 7 - offset && coordx <= 7 + offset) {
			coordx--;
			if(coordy == 7 - offset && coordx == 7)
				voltasCompletas++;
		}
		// move down
		else if (coordx == 7 - offset && coordy >= 7 - offset && coordy < 7 + offset) {
			coordy++;
		}
		// move right
		else if (coordy == 7 + offset && coordx >= 7 - offset && coordx < 7 + offset) {
			coordx++;
		}
		// move up
		else if (coordx == 7 + offset && coordy <= 7 + offset && coordy > 7 - offset) {
			coordy--;
		}
	}

	public String imprimirInformacoes() {
		String saida = "";
		saida += "Planeta " + nome + ": \n";
		saida += "velocidade: " + velocidade + "\n";
		saida += "Dias passados(em horas): " + horasPassadas + "\n";
		saida += "Voltas completas em torno de java: " + voltasCompletas+"\n\n";
		return saida;
	}
}
