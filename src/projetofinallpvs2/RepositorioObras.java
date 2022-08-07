package projetofinallpvs2;

public class RepositorioObras {
	
	private static String[] tipos = {"Livro", "Trabalho Acadêmico", "Revista"};
	
	public static Obra[] getObras() {
		Obra[] obras = new Obra[] {
				//new Obra("tipo", "título", "autor 1", "autor 2", ano, quantidade),
				new Obra(tipos[0], "As Crônicas de Nárnia".toUpperCase(), 
						"C. S. Lewis", "", 2005, 2),
				new Obra(tipos[0], "Dracula".toUpperCase(),
						"Bram Stoker", "", 2015, 2),
				new Obra(tipos[0], "Frankenstein".toUpperCase(),
						"Mary Shelley", "", 1997, 3),
				new Obra(tipos[0], "It - A Coisa".toUpperCase(),
						"Stephen King", "", 2014, 2),
				new Obra(tipos[0], "Moby Dick".toUpperCase(),
						"Herman Melville", "", 2019, 5),
				new Obra(tipos[0], "O Cão dos Baskervilles".toUpperCase(),
						"Sir Arthur Conan Doyle", "", 2012, 1),
				new Obra(tipos[0], "O Guia Definitivo do Mochileiro das Galáxias".toUpperCase(),
						"Douglas Adams", "", 2016, 3),
				new Obra(tipos[0], "O Pequeno Príncipe".toUpperCase(),
						"Antoine de Saint-Exupéry", "", 2018, 3),
				new Obra(tipos[0], "O Silêncio dos Inocentes".toUpperCase(),
						"Thomas Harris", "", 2019, 1)
		};
		return obras;
	}
	
}
