package javaLar;

public class Python extends Planeta {

	public Python(SistemaJavaLar s) {
		nome = "Pyton";
		velocidade = 4;
		offset = 1;
		horasPorInstante = 24;
		darCoordenadas(s);
		resumo = "O Python é uma linguagem de programação amplamente usada em aplicações da Web, desenvolvimento de software, ciência de dados e machine learning (ML). Os desenvolvedores usam o Python porque é eficiente e fácil de aprender e pode ser executada em muitas plataformas diferentes.";
	}
}
