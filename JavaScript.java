package javaLar;

public class JavaScript extends Planeta {

	public JavaScript(SistemaJavaLar s) {
		nome = "JavaScript";
		velocidade = 3;
		offset = 2;
		horasPorInstante = 10;
		darCoordenadas(s);
		resumo = "Javascript atua na programação front-end, a parte 'visual' de uma aplicaçao";
	}

}
