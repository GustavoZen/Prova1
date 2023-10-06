package javaLar;

public class C extends Planeta {

	public C(SistemaJavaLar s) {
		nome = "C";
		velocidade = 10;
		offset = 7;
		horasPorInstante = 0.1;
		darCoordenadas(s);
		resumo= "C e uma linguagem de programação compilada de proposito geral, estruturada, imperativa, procedural, padronizada pela Organizacao Internacional para Padronizacao (ISO)";
	}
}