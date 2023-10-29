class Stats {

	 int [] w;
	 int v;		//vitorias
	 int j;		//jogadas
	 int p;		//percentagem
	 int s;		//sequencia
	 int b;		//best
	
	Stats(int n){
	
		w = new int [n+1];
		v = 0;
		j = 0;
		p = 0;
		s = 0;
		b = 0;
	}

	 
	
	
	static void main(){
		
	Stats s = new Stats (6);
		
	
	return;
	}
	
	
	
	void loss(){
		w[w.length-1]++;
		j++;
		p = (int)(((double)v/(double)j)*100);
		s=0;
	}
	
	void win(int l){
		
		w[l]++;
		v++;
		j++;
		p =  (int)(((double)v/(double)j)*100);
		s++;
		if(s>b)
			b = s;
		
	}
	
	
	
	
	ColorImage mostrar(){
		int a = 115;
		int d = 60;
		int c = 25;
		int o = 85;
		int l = 140;
		int k = 105;
		int u =160;
		int q = 0;
		int max = 0;

		ColorImage stats =new ColorImage(375,500,Constantes.c);
		stats.drawText(80,20,"ESTATÍSTICAS",30,Constantes.white);
		
		stats.drawText(35,a,"Jogados",14,Constantes.white);
		if(j<=9){
		stats.drawText(50,60,String.valueOf(j),50,Constantes.white);
		}else{
			stats.drawText(31,60,String.valueOf(j),50,Constantes.white);
		}
		
		stats.drawText(100,a,"% de Vitórias",14,Constantes.white);
	
		if(p==0)
			stats.drawText(133,60,String.valueOf(p),50,Constantes.white);
		
		if(p==100)
			stats.drawText(100,60,String.valueOf(p),50,Constantes.white);
			
		
		if(p>0&&p<100)
			stats.drawText(115,60,String.valueOf(p),50,Constantes.white);
			
		
		
		stats.drawText(215,60,String.valueOf(s),50,Constantes.white);
		stats.drawText(192,a,"Sequência",14,Constantes.white);
		stats.drawText(192,a+15,"de vitórias",14,Constantes.white);
		
		stats.drawText(295,60,String.valueOf(b),50,Constantes.white);
		stats.drawText(287,a,"Melhor",14,Constantes.white);
		stats.drawText(275,a+15,"sequência",14,Constantes.white);
		
		stats.drawText(47,150,"Distribuição de tentativas",25,Constantes.white);
		
		for(int i=0;i!=w.length;i++)
			if(w[i]>max)
				max=w[i];
	
		
		for(int i =0;i!=7;i++){
			u+=40;
			q++;
			if(i == 6){
				stats.drawText(d,440,"X",c,Constantes.white);
				if(w[6]!=0)
					for(int x = o ;x!=(230/max)*w[6]+o;x++)
						for(int y = 440;y!=470;y++)
							stats.setColor(x,y,Constantes.b);
				else
				for(int x = o ;x!=l;x++)
					for(int y = 440;y!=470;y++)
						stats.setColor(x,y,Constantes.c1);
			
			stats.drawText(k,u,String.valueOf(w[q-1]),c,Constantes.white);
			}
			else{
			stats.drawText(d,u,String.valueOf(q),c,Constantes.white);
			
			if(w[q-1]!=0)
				for(int x = o ;x!=(230/max)*w[q-1]+o;x++)
					for(int y = u;y!=u+30;y++)
						stats.setColor(x,y,Constantes.b);
			
			else
			for(int x = o ;x!=l;x++)
				for(int y = u;y!=u+30;y++)
					stats.setColor(x,y,Constantes.c1);

			
			stats.drawText(k,u,String.valueOf(w[q-1]),c,Constantes.white);
			}
		}
		
		
		return stats;
	}
	
}
	
	
	
	
	
