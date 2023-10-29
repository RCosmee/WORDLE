class Game {

	private char [][] jogo = new char [6][5];
	private char [][] teclado;
	private ColorImage stats;
	private String puzzle;
	private Dictionary dict;
	private int [] state = new int [26];
	private ColorImage img;
	private int tentativa;
	private String word;
	private Stats s = new Stats(6);
	
	Game(ColorImage img){
	this.img=img;	
	tentativa=0;
	newPuzzle();
	teclado = Constantes.QWERTY;
	Estetica.teclado(img,teclado,state);
	Estetica.grid(img,jogo,puzzle);
	
	}
	
	private void newPuzzle(){
	 dict=new Dictionary ("pt_br.txt");
	 puzzle = dict.generateSecretWord(5);
	}
	
	private void vetor(){
		for(int i = 0;i!=26;i++)
			state[i]=Constantes.UNTESTED;
	}
	
	
	private void state(String word,String puzzle){
		
		
		for(int i = 0;i!=word.length();i++){
			if(word.charAt(i)==puzzle.charAt(i))
				state[word.charAt(i)-'A']=Constantes.CORRECT_POSITION;		//posi�ao certa
			for(int j = 0;j!=word.length();j++){
				if(word.charAt(j)==puzzle.charAt(i)&&state[word.charAt(j)-'A']!=Constantes.CORRECT_POSITION)
					state[word.charAt(j)-'A']=Constantes.EXISTS;			//existe
			}
			if(state[word.charAt(i)-'A']!=Constantes.CORRECT_POSITION&&state[word.charAt(i)-'A']!=Constantes.EXISTS)
				state[word.charAt(i)-'A']=Constantes.NOT_EXISTS;			//n�o existe
			
		}
	}
	
	private void inserir(String word){
		tentativa++;
		if(tentativa==0)
			for(int i = 0;i!=tentativa;i++)
				for(int j = 0; j !=word.length();j++)
					jogo[i][j]=word.charAt(j);
		else
			for(int i = tentativa-1;i!=tentativa;i++)
				for(int j = 0; j !=word.length();j++)
					jogo[i][j]=word.charAt(j);
		
	}
	
	private boolean existe(String word){
		
		return dict.exists(word);
	}
	
	private void original(){
	
	puzzle= dict.getOriginalWord(puzzle);
	}
	
	void Play(String New_Guess){
		if (New_Guess == null)
			throw new NullPointerException("A palavra tem que ter 5 letras");
		if (New_Guess.length()!=5)
			throw new IllegalArgumentException("A palavra tem que ter 5 letras");
		if (tentativa >=6)
				throw new IllegalStateException ("Acabaram se as tentativas");
		String word1 = Estetica.acentos(New_Guess);
		this.word=word1;
		if (existe(word)== false)
			throw new IllegalArgumentException("A palavra n�o existe");
		inserir(word);
		state(word,puzzle);
		Estetica.teclado(img,teclado,state);
		Estetica.grid(img,jogo,puzzle);
		if (word.equals(puzzle)){
			s.win(tentativa-1);
			original();
			System.out.print(puzzle + "   ");
		}
		if(tentativa==6 && !word.equals(puzzle)){
			s.loss();
			original();
			System.out.print(puzzle + "   ");
			
		}
	}
	
	void Restart(){
		
		jogo = new char [6][5];
		tentativa =0;
		vetor();
		newPuzzle();
		Estetica.teclado(img,teclado,state);
		Estetica.grid(img,jogo,puzzle);
	}
	

	
	ColorImage Estatisticas(){
	return  s.mostrar();
	}
		
		
		
		
	
	
	
	
	
	
}
