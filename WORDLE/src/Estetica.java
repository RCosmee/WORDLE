class Estetica {

	
	final static ColorImage bg(){
		
		ColorImage bg = new ColorImage(Constantes.DEFAULT_WIDTH,Constantes.DEFAULT_HEIGHT);
		for(int x=0;x!=Constantes.DEFAULT_WIDTH;x++)
			for(int y=0;y!=Constantes.DEFAULT_HEIGHT;y++)
				bg.setColor(x,y,Constantes.DEFAULT_BG);
		return bg;
		
	}
		
	
	static void icon(ColorImage bg, int a, int b, Color color,char c){
		 
		
		 for(int x=a;x!=Constantes.ICON_SIZE+a;x++)
			for(int y=b;y!=Constantes.ICON_SIZE+b;y++)
				bg.setColor(x,y,color);
		bg.drawCenteredText(a+20,b+20,""+c,Constantes.ICON_SIZE,Constantes.white);
		 
	 
	 }
	
	
	static void grid(ColorImage bg,char[][]c,String puzzle){
	
		int a = 0;
		int b = 0;
			
		for(int i =0;i!= c.length;i++){
			for(int j=0;j!=c[i].length;j++){
				icon(bg,225+a,75+b,Constantes.EMPTY_BG,' ');
				if(c[i][j]==puzzle.charAt(j))
					icon(bg,225+a,75+b,Constantes.CORRECT_BG,c[i][j]);
				else {
					if(c[i][j]!='\0')
					icon(bg,225+a,75+b,Constantes.NOT_IN_WORD_BG,c[i][j]);
					for(int k = 0;k!=puzzle.length();k++){
						if(c[i][j]==puzzle.charAt(k))
							Estetica.icon(bg,225+a,75+b,Constantes.EXISTS_BG,c[i][j]);
					}
				}
				a+=45;
			}
			b+=45;
			a=0;
			}
		}
		
	
	
	
	static void teclado(ColorImage bg,char [][]c,int[]state){
		int a=0;
		int b=0;
		int d = 0;
	
		for(int i =0;i!= c.length;i++){
			for(int j=0;j!=c[i].length;j++){
				
				if(state[c[i][j]-'A']==Constantes.CORRECT_POSITION)
					icon(bg,125+a+d,420+b,Constantes.CORRECT_BG,c[i][j]);
				if(state[c[i][j]-'A']==Constantes.EXISTS)
					icon(bg,125+a+d,420+b,Constantes.EXISTS_BG,c[i][j]);
				if(state[c[i][j]-'A']==Constantes.NOT_EXISTS)
					icon(bg,125+a+d,420+b,Constantes.NOT_IN_WORD_BG,c[i][j]);
				if(state[c[i][j]-'A']==Constantes.UNTESTED)
					icon(bg,125+a+d,420+b,Constantes.EMPTY_BG,c[i][j]);
				a+=45;	
			}	

		b+=45;
		a=0;
		d+=22;
		}
	
		
	}
	
	
	static void Comecar(){
		ColorImage background = bg();
		Game g = new Game(background);
		
	return;
	}
	
	 
	 
	  static String acentos (String word){
		
		word = word.toUpperCase();
		char [] wordVet = word.toCharArray();
		
		for(int i = 0; i!=wordVet.length;i++){
			if(wordVet[i]== '�' || wordVet[i] == '�' || wordVet[i] == '�'|| wordVet[i] == '�')
				wordVet[i]='A';
			if(wordVet[i] == '�'|| wordVet[i] == '�'|| wordVet[i] == '�')
				wordVet[i]= 'E';
			if(wordVet[i] == '�')
				wordVet[i]= 'I'; 
			if(wordVet[i] == '�'|| wordVet[i] == '�'|| wordVet[i] == '�')
				wordVet[i] = 'O';
			if(wordVet[i] == '�')
				wordVet[i] = 'U';
			if (wordVet[i] == '�')
				wordVet[i] = 'C';
		}
				
		
		return new String (wordVet);
		
	}

	  
	 
	  
}