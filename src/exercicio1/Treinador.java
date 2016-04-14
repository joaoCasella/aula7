package exercicio1;

class Ataque{
	private String nome;
	private double dano;
	
	public void preencheNome(String nome){
		this.nome = nome;
	}
	
	public String getNomeAtaque(){
		return nome;
	}
	
	public void preencheDano(double dano){
		this.dano = dano;
	}
	
	public double getDano(){
		return dano;
	}
}

class Pokemon {
	private String nome;
	private double HP = 100.0;
	private Ataque ataques[] = new Ataque[4];
	
	public void nomePokemon(String name){
		nome = name;
	}
	
	public double getHp(){
		return HP;
	}
	
	public String getNomePokemon(){
		return nome;
	}
	
	public void preencheAtaques(String[] nomes, double[] hits){
		for(int i = 0; i < 4; i ++){
			ataques[i].preencheNome(nomes[i]);
			ataques[i].preencheDano(hits[i]);
		}
	}
}

public class Treinador {
	private String id;
	private Pokemon pokemons[] = new Pokemon[6];
	
	public void idTreinador(String nome){
		id = nome;
	}
	
	public String getNome(){
		return id;
	}
	
	public void preenchePokemons(String[] nomes){
		for(int i = 0; i < 7; i ++){
			pokemons[i].nomePokemon(nomes[i]);
		}
	}
	
	public void ataquesPokemons(String[][] ataques, double[][] dano){
		for(int j = 0; j < 6; j ++){
			pokemons[j].preencheAtaques(ataques[j], dano[j]);
		}
	}
}
