package javaLar;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class SistemaJavaLar {

	public ArrayList<Planeta> Planetas;
	public Coordenada[][] plano;
	public int instantesvezes = 0;
	public int instantes = 0;

	public SistemaJavaLar(Coordenada[][] plano) {
		Planetas = new ArrayList<Planeta>();
		this.plano = plano;
	}

	public int Diferenca(int a, int b) {
		int saida;
		if (a > b)
			saida = a - b;
		else
			saida = b - a;
		return saida;
	}

	public void colocarBugAleatorio(int b) {
		for (int i = 0; i < b; i++) {
			Random Rand = new Random();
			boolean colocou = plano[Rand.nextInt(15)][Rand.nextInt(15)].colocarBug();
			while (!colocou) {
				colocou = plano[Rand.nextInt(15)][Rand.nextInt(15)].colocarBug();
			}
		}
	}

	public void colocarDesenvolvedorAleatorio(int d) {
		for (int i = 0; i < d; i++) {
			Random Rand = new Random();
			boolean colocou = plano[Rand.nextInt(15)][Rand.nextInt(15)].colocarDesenvolvedor();
			while (!colocou) {
				colocou = plano[Rand.nextInt(15)][Rand.nextInt(15)].colocarDesenvolvedor();
			}
		}
	}

	public void AlocarPlanetasNoPlano() {
		for (Planeta p : Planetas) {
			plano[p.coordx][p.coordy].planeta = p;
			plano[p.coordx][p.coordy].ocupada = true;
		}
	}

	public String NorteSul() {
		String saida = "";
		int Sul = 0;
		int Norte = 0;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (plano[i][j].NS == "Norte" && plano[i][j].planeta != null) {
					Norte++;
				}
				if (plano[i][j].NS == "Sul" && plano[i][j].planeta != null) {
					Sul++;
				}
			}
		}
		saida += "Planetas ao Sul: " + Sul + "\nPlanetas ao Norte: " + Norte + "\n";

		return saida;
	}

	public String Alinhados() {
		String saida = "";
		for (Planeta p : Planetas) {
			if ((p.coordx == 7 || p.coordx == p.coordy || p.coordx == p.coordy - (2 * p.offset)
					|| p.coordx == p.coordy + (2 * p.offset)) && p.nome != "java")
				saida += "O Planeta " + p.nome + " está alinhado a Java.\n";
		}
		return saida;
	}

	public void verificarParada(Coordenada[][] plano) {
		for (Planeta p : Planetas) {
			if (!p.explodiu) {
				if (plano[p.coordx][p.coordy].bug) {
					p.velocidade--;
					plano[p.coordx][p.coordy].bug = false;
					p.bugs++;
					if (p.velocidade == 0) {
						p.explodiu = true;
					}
				} else if (plano[p.coordx][p.coordy].developer) {
					p.velocidade++;
					plano[p.coordx][p.coordy].developer = false;
					p.devs++;
				}
			}
		}
	}

	public void mover(int r) {
		instantesvezes++;
		instantes+=r;
		for (Planeta p : Planetas) {
			if (!p.explodiu) {
				for (int j = 0; j < r; j++) {
					int x = p.coordx;
					int y = p.coordy;
					for (int i = 0; i < p.velocidade; i++) {
						p.moverUm();
					}
					p.horasPassadas += p.horasPorInstante;
					plano[x][y].ocupada = false;
					plano[x][y].planeta = null;
					plano[p.coordx][p.coordy].ocupada = true;
					plano[p.coordx][p.coordy].planeta = p;
				}
			}
		}
		verificarParada(plano);
	}

	public String Infos() {
		String saida = "";
		for (Planeta p : Planetas) {
			saida += p.imprimirInformacoes();
		}
		return saida;
	}

	public String Distancia() {
		String saida = "";
		for (Planeta p1 : Planetas) {
			if (p1.nome != "java") {
				saida += "\nDistancia de " + p1.nome + ": \n";
				for (Planeta p2 : Planetas) {
					if (p1 != p2) {
						int Area = (Diferenca(p1.coordx, p2.coordx) + 1) * (Diferenca(p1.coordy, p2.coordy) + 1);
						double xsquare = Math.pow((Diferenca(p1.coordx, p2.coordx) + 1), 2);
						double ysquare = Math.pow((Diferenca(p1.coordy, p2.coordy) + 1), 2);
						double Euclidiana = Math.sqrt((xsquare + ysquare));
						saida += "para " + p2.nome + " Area: " + Area + ", Euclidiana: " + Euclidiana + "\n";
					}
				}
			}
		}
		return saida;
	}

	public String DadosFinais() {
		String saida = "";
		for (Planeta p : Planetas) {
			if(p.nome!="java") {
			saida += "Relatorio do Planeta " + p.nome + ":\n";
			saida += "Bugs atingidos: " + p.bugs + "\n";
			saida += "Devs atingidos: " + p.devs + "\n";
			if (!p.explodiu)
				saida += "Não explodiu\n";
			else
				saida += "Explodiu\n";
			saida += "Dias passados: " + p.horasPassadas + "\n";
			saida += p.resumo + "\n";
		}
		saida+="Foram pedidos instantes " + (instantesvezes-1) + " vezes e a soma dos instantes é de: " + instantes;}
		return saida;
	}
}
