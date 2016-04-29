package exercicio1;

public class Batalha extends Controller{
	Treinador treinador = new Treinador("Ash", "Pikachu", "Choque do Trovao", 32.0, "Esfera Eletrica", 28.0, "Investida Trovao", 30.0, "Ataque Rapido", 28.0,
												"Charmander", "Brasas", 28.0, "Lanca-chamas", 32.0, "Garra de Metal", 30.0, "Furia", 25.0,
												"Squirtle", "Bolhas", 27.0, "Rajada de Bolhas", 32.0, "Hidro Bomba", 28.0, "Raio de Gelo", 30.0,
												"Bulbasaur", "Raio Solar", 25.0, "Folha Navalha", 28.0, "Chicote de Cipo", 29.0, "Investida", 30.0); 
	Treinador treinador2 = new Treinador("Brock", "Onix", "Triturar", 23.0, "Cavar", 25.0, "Investida", 22.0, "Batida", 20.0,
												"Geodude", "Poder Oculto", 22.0, "Lancamento de Rocha", 29.0, "Investida", 22.0, "Mega-soco", 23.0,
												"Zubat", "Supersonico", 22.0, "Voar", 21.0, "Redemoinho de Vento", 23.0, "Mordida", 24.0,
												"Vulpix", "Agilidade", 10.0, "Giro de fogo", 20.0, "Lanca-chamas", 22.0, "Trovao", 15.0);

	private class Ataque extends Event {
		private boolean decisao = true;
		private Treinador trainer;
		private Treinador trainer2;
		
		public Ataque(long eventTime, Treinador trainer, Treinador trainer2) {
			super(eventTime);
			this.trainer = trainer;
			this.trainer2 = trainer2;
		}
		
		public void action(){
			decisao = trainer.acertarHit(trainer2);
		}
		
		public String description() {
			if(decisao == false)
				return ""+trainer.getNome()+" usou o ataque "+trainer.getAtaque()+" do pokemon "+trainer.getPokemonAtual()+"\nFim da luta com "+trainer.getNome()+" vencedor!";
			else
				return ""+trainer.getNome()+" usou o ataque "+trainer.getAtaque()+" do pokemon "+trainer.getPokemonAtual()+".";
		}
	}
	
	private class trocaPokemonAtivo extends Event {	
		private Treinador trainer;
		public trocaPokemonAtivo(long eventTime, Treinador trainer) {
			super(eventTime);
			this.trainer = trainer;
		}
		public void action(){
			trainer.mudaPokemon();
		}
		public String description() {
			return ""+trainer.getNome()+" trocou para o pokemon "+trainer.getPokemonAtual()+".";
		}
	}

	private class curaPokemonAtivo extends Event {
		private Treinador trainer;
		public curaPokemonAtivo(long eventTime, Treinador trainer) {
			super(eventTime);
			this.trainer = trainer;
		}
		public void action(){
			trainer.recuperaVida();
		}
		public String description() {
			return ""+trainer.getNome()+" usou item de cura no pokemon "+trainer.getPokemonAtual()+".";
		}
	}
	
	private class correr extends Event {
		private Treinador trainer;
		private Treinador trainer2;
		public correr(long eventTime, Treinador trainer, Treinador trainer2) {
			super(eventTime);
			this.trainer = trainer;
			this.trainer2 = trainer2;
		}
		public void action(){
			return;
		}
		public String description(){
			return ""+trainer.getNome()+" correu da luta.\n"+trainer2.getNome()+" eh o vencedor.";
		}
	}
	
	private class Inicio extends Event {
		public Inicio(long eventTime) {
			super(eventTime);
		}
		public void action() {
			long tm = System.currentTimeMillis();
			
			addEvent(new Ataque(tm, treinador, treinador2));
			addEvent(new Ataque(tm + 100, treinador2, treinador));
			
			addEvent(new Ataque(tm + 200, treinador, treinador2));
			addEvent(new Ataque(tm + 300, treinador2, treinador));
			
			addEvent(new Ataque(tm + 400, treinador, treinador2)); 
			addEvent(new Ataque(tm + 500, treinador2, treinador));
			
			addEvent(new Ataque(tm + 600, treinador, treinador2));
			addEvent(new trocaPokemonAtivo(tm + 650, treinador2));
			
			addEvent(new curaPokemonAtivo(tm + 700, treinador));
			addEvent(new Ataque(tm + 800, treinador2, treinador));
			
			addEvent(new Ataque(tm + 900, treinador, treinador2));
			addEvent(new Ataque(tm + 1000, treinador2, treinador));
			addEvent(new trocaPokemonAtivo(tm + 1050, treinador));
			
			addEvent(new Ataque(tm + 1100, treinador, treinador2));
			addEvent(new Ataque(tm + 1200, treinador2, treinador));
			
			addEvent(new Ataque(tm + 1300, treinador, treinador2));
			addEvent(new Ataque(tm + 1400, treinador2, treinador));
			
			addEvent(new Ataque(tm + 1500, treinador, treinador2));
			addEvent(new trocaPokemonAtivo(tm + 1550, treinador2));
			
			addEvent(new Ataque(tm + 1600, treinador, treinador2));
			addEvent(new Ataque(tm + 1700, treinador2, treinador));
			
			addEvent(new Ataque(tm + 1800, treinador, treinador2));
			addEvent(new Ataque(tm + 1900, treinador2, treinador));
			
			addEvent(new Ataque(tm + 2000, treinador, treinador2));
			addEvent(new Ataque(tm + 2100, treinador2, treinador));
			addEvent(new trocaPokemonAtivo(tm + 2150, treinador));
			
			addEvent(new curaPokemonAtivo(tm + 2200, treinador2));
			addEvent(new Ataque(tm + 2300, treinador, treinador2));
			
			addEvent(new Ataque(tm + 2400, treinador, treinador2));
			addEvent(new trocaPokemonAtivo(tm + 2500, treinador2));
			
			addEvent(new Ataque(tm + 2600, treinador, treinador2));
			addEvent(new Ataque(tm + 2700, treinador2, treinador));
			
			addEvent(new Ataque(tm + 2800, treinador, treinador2));
			addEvent(new Ataque(tm + 2900, treinador2, treinador));
			
			addEvent(new Ataque(tm + 3000, treinador, treinador2));
			addEvent(new Ataque(tm + 3100, treinador2, treinador));
			
			addEvent(new Ataque(tm + 3200, treinador, treinador2));

		}
		public String description() {
			return "Comeca a batalha";
		}
		//Este metodo se assemelha ao Restart do exemplo, ja que ele agrega os
		//as chamadas de criada de novos eventos. Porem, foi chamada de Inicio
		//por parecer mais natural para este caso.
	}
	
	public static void main(String[] args) {
		Batalha gc = new Batalha();
		long tm = System.currentTimeMillis();
		gc.addEvent(gc.new Inicio(tm));
		gc.run();
	}

}
