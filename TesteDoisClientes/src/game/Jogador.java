package game;
/*
 * by: Ronaldd Pinho
 * ronaldppinho@gmail.com
 */

import java.io.Serializable;

public class Jogador implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int MAX_BARCOS = 3; // num máximo de barcos
	public static final int TAB_SIZE = 8;   // tamanho do tabuleiro

	private byte[] bytes;
	private String nome;
	private int n_tiros = 10;
	private int n_barcos = 0;
	private int pontos = 0;
	private Tabuleiro tab;

	public Jogador(String n){
		this.nome = n;
		this.tab = new Tabuleiro(TAB_SIZE, TAB_SIZE);
	}

	//--- getters e setters -------------------------------------------------//
	public String getNome(){
		return this.nome;
	}

	public int getNumBarcos(){
		return this.n_barcos;
	}

	public int getTiros(){
		return this.n_tiros;
	}

	public void setTiros(int tiros) {
		this.n_tiros = tiros;
	}

	public int getPontos(){
		return this.pontos;
	}

	public void setPontos(int pontos){
		this.pontos = pontos;
	}

	// retorna a matriz do tabuleiro
	public char[][] getTab(){
		return this.tab.tab;
	}

	public void setTab(char[][] matriz){
		this.tab.setTab(matriz);
	}

	// retorna o caractere da posição específica da matriz do tabuleiro
	public char getTab(int x, int y){
		return this.tab.tab[x][y];
	}

	// define o caractere em uma posição específica da matriz do tabuleiro
	public void setTab(int x, int y, char ch){
		this.tab.tab[x][y] = ch;
	}
	//----------------------------------------------------------------------//

	public void printTab(){
		//System.out.println("Mapa de "+ this.nome);
		this.tab.print();
	}

	public void printTabSecret() {
		//System.out.println("Mapa de "+ this.nome);
		this.tab.printSecret();
	}

	public void posicionarBarco(int x, int y) {
		if (n_barcos < MAX_BARCOS){ // se o número atual de barcos for menor que o máximo
			if (tab.tab[x][y] == '~') { // adiciona se a posição atual for "mar"
				this.tab.tab[x][y] = 'B';
				this.n_barcos++; // incrementa o número atual de barcos
			}
		} else {
			System.out.println("Número máximo de barcos excedido.");
		}
	}