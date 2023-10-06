package javaLar;

public class PHP extends Planeta {

	public PHP(SistemaJavaLar s) {
		nome = "PHP";
		velocidade = 2;
		offset = 4;
		horasPorInstante = 60;
		darCoordenadas(s);
		resumo = "PHP e uma linguagem de programaçao voltada para a web, facil de utilizar, robusta e com melhorias constantes.";
	}
}