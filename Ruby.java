package javaLar;

public class Ruby extends Planeta {

	public Ruby(SistemaJavaLar s) {
		nome = "Ruby";
		velocidade = 2;
		offset = 3;
		darCoordenadas(s);
		horasPorInstante = 48;
		resumo = "Ruby é uma linguagem interpretada e orientada a objetos com tipagem dinâmica e forte.";
	}
}