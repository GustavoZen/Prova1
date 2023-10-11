package javaLar;

import java.util.Scanner;
import java.util.Random;

public class Main {
	public static void plotarPlano(SistemaJavaLar s) {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (s.plano[j][i].ocupada == false) {
					System.out.print("* ");
				} else if (s.plano[j][i].bug)
					System.out.print("b ");
				else if (s.plano[j][i].developer)
					System.out.print("d ");
				else
					System.out.print("O ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// Instantiating variables

		Scanner entrada = new Scanner(System.in);
		Random Rand = new Random();
		Coordenada[][] plano = new Coordenada[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				Coordenada a = new Coordenada(i, j);
				plano[i][j] = a;
				plano[i][j].NorteOuSul();
			}
		}
		SistemaJavaLar sistema = new SistemaJavaLar(plano);
		Planeta javaLar = new JavaLar();
		sistema.Planetas.add(new Python(sistema));
		sistema.Planetas.add(new JavaScript(sistema));
		sistema.Planetas.add(new Ruby(sistema));
		sistema.Planetas.add(new PHP(sistema));
		sistema.Planetas.add(new CSharp(sistema));
		sistema.Planetas.add(new C(sistema));
		sistema.Planetas.add(new Cplusplus(sistema));
		sistema.Planetas.add(javaLar);
		sistema.AlocarPlanetasNoPlano();
		plotarPlano(sistema);
		int r=1;
		int b=1;
		int d=1;
		// Start Experience
		while (r!=0 || b!=0 || d!=0) {
			System.out.println("ATENÇÃO PARA SAIR DO PROGRAMA RESPONDA TODAS AS PERGUNTAS COM '0'");
			System.out.println("Quantos instantes deseja mover?");
			r = entrada.nextInt();
			System.out.println("Quantos bugs deseja colocar?");
			b = entrada.nextInt();
			System.out.println("Quantos desenvolvedores deseja colocar?");
			d = entrada.nextInt();
			sistema.colocarBugAleatorio(b);
			sistema.colocarDesenvolvedorAleatorio(d);
			sistema.mover(r);

			plotarPlano(sistema);
			System.out.println(sistema.NorteSul());
			System.out.println(sistema.Alinhados());
			System.out.println(sistema.Infos());
			System.out.println(sistema.Distancia());
		}
		System.out.println(sistema.DadosFinais());
	}
}
