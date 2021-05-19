package hlavni;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import commandPrikazy.*;


public class MapaSveta  implements Serializable, KeyListener {
	
    private HashMap<Integer, Lokalita> mapa = new HashMap<>();
	private Lokalita oblast;
	private JFrame okno;
	private DrawCanvas canvas;
	public static final int POCATECNI_LOKALITA = 9;
	
	
	public MapaSveta() throws IOException {
		okno = new JFrame();
		okno.setVisible(true);
		okno.setPreferredSize(new Dimension(600,500));
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno.addKeyListener(this);
		canvas = new DrawCanvas();
		okno.setContentPane(canvas);
		canvas.setPreferredSize(new Dimension(600,500));
		okno.pack();
		cteniSouboru("mapaNova.csv");
		pocatecniPoloha(POCATECNI_LOKALITA);
		
	}
	/**
	 * metoda nacte mapu ze souboru
	 * */
	public void cteniSouboru(String soubor) throws IOException {
		
		BufferedReader bR = new BufferedReader(new FileReader(soubor));
		String radek = "";
		
		while((radek=bR.readLine())!=null) {
			String[] pole = radek.split(";");
			oblast = new Lokalita(pole[1],Integer.parseInt(pole[0]),pole[3],new Hrac(566,98));
			oblast.setPopis(pole[4]);
			for(int i=0;i<3;i++) {
			   
				oblast.addNPC(new NPC(pole[i+5],pole[i+8],Integer.parseInt(pole[i+11]),Integer.parseInt(pole[i+14])));
				
			}
			mapa.put(oblast.getId(), oblast);
			
		}
		bR.close();
				
	
	}
	
	public void pocatecniPoloha(int i) {
		oblast = mapa.get(i);
	}
	
	public Lokalita nazevAktualniPolohy() {
		return oblast;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
    /**
     * metoda slouzici k ovladani MapySveta
     * po mape se muze chodit  ctyrmi smery
     * nahoru, dolu, doprava, doleva
     * v mape se pohybujete za hrace u ktereho
     * si nastavite zivoty hrace a poskozeni hrace
     * 
     * hrac kdyz vejde do mistnosti:
     * po zmacknuti klavesy F se zobrazi inventar hrace
     * kde jsou videt jeho aktualni zivoty, hracovo poskozeni,
     * inventar a equipment
     * 
     * po zmacknuti klavesy M se zobrazi nazev, id,a popis lokality
     * take npc v mistnosti ze kteryma se muze hrac utkat
     * npc v kazde mistnosti jsou 3
     * a itemy v mistnosti
     * 
     * po stisknuti cisla 1,2 nebo 3 si hrac vybere se kterym npc 
     * se chce hrac utkat a po kazdem stisknuti si npc z hracem navzajem 
     * zacnou ubirat zivoty dokud jednomu z nich klesnou zivoty na nula
     *  pokud hracovi i danemu npc hrozi ze se mohou jednim poskozenim na vzajem
     *  tak npc bude vzdy rychlejsi a zvytezi nad hracem
     *  
     *  po stisknuti V se vlozi Item do inventare
     *  po stisknuti R se vymaze a vrati do dane oblasti kde se prave hrac nachazi
     *  po stisknuti E se vlozi Item z Inventare do equipmentu
     *  po stisknuti Q se odendaji vsechny Itemy z equipmentu zpatky do Inventare
     * */
	@Override
	public void keyPressed(KeyEvent e) {
		
		int aktualniOblast = oblast.getId();
		
		switch(e.getKeyCode()) {
		case /*KeyEvent.VK_UP,*/ KeyEvent.VK_W:
			if(aktualniOblast != 3 && aktualniOblast != 6 && aktualniOblast != 9)
			    aktualniOblast--;
		    if(mapa.get(aktualniOblast)==null)
			    aktualniOblast++;
		
		break;
		case /*KeyEvent.VK_RIGHT,*/ KeyEvent.VK_D: 
			    if(aktualniOblast != 6)
			    aktualniOblast+=3;
			if(mapa.get(aktualniOblast)==null)
				aktualniOblast-=3;
		
		break;
		case /*KeyEvent.VK_DOWN,*/ KeyEvent.VK_S:
			if(aktualniOblast != 2 && aktualniOblast != 5 && aktualniOblast != 8)
			    aktualniOblast++;
		    if(mapa.get(aktualniOblast)==null)
			    aktualniOblast--;
		  
		break;
		case /*KeyEvent.VK_LEFT,*/ KeyEvent.VK_A: 
			    aktualniOblast-=3;
			if(mapa.get(aktualniOblast)==null)
				aktualniOblast+=3;
			
		break;
		case KeyEvent.VK_F: JOptionPane.showMessageDialog(okno,oblast.getHrac());
		break;
		case KeyEvent.VK_1: int kolo =0;
			                while(oblast.getHrac().getZivoty()!=0 && mapa.get(aktualniOblast).getNPCcka().get(0).getZivoty()!=0)
		                    {
			                oblast.hracUtrpeni(0, mapa.get(aktualniOblast).getNPCcka().get(0).getPoskozeni(),mapa, aktualniOblast);
		                    mapa.get(aktualniOblast).npcUtrpeni(0, oblast.getHrac().getPoskozeni());
		                    JOptionPane.showMessageDialog(okno,"kolo "+(kolo++)+"\n"+oblast.getHrac()+"\n\n npc: "+mapa.get(aktualniOblast).getNPCcka().get(0));
		                    }        
		break;
		case KeyEvent.VK_2: kolo =0;
			                while(oblast.getHrac().getZivoty()!=0 && mapa.get(aktualniOblast).getNPCcka().get(1).getZivoty()!=0)
		                    {
			                oblast.hracUtrpeni(1,mapa.get(aktualniOblast).getNPCcka().get(1).getPoskozeni(),mapa,aktualniOblast);
                            mapa.get(aktualniOblast).npcUtrpeni(1, oblast.getHrac().getPoskozeni());
                            JOptionPane.showMessageDialog(okno,"kolo "+(kolo++)+"\n"+oblast.getHrac()+"\n\n npc: "+mapa.get(aktualniOblast).getNPCcka().get(1));
                            }
		break;         
		case KeyEvent.VK_3: kolo=0;
			                while(oblast.getHrac().getZivoty()!=0 && mapa.get(aktualniOblast).getNPCcka().get(2).getZivoty()!=0)
		                    {
			                oblast.hracUtrpeni(2,mapa.get(aktualniOblast).getNPCcka().get(2).getPoskozeni(),mapa,aktualniOblast);
                            mapa.get(aktualniOblast).npcUtrpeni(2, oblast.getHrac().getPoskozeni());
                            JOptionPane.showMessageDialog(okno,"kolo "+(kolo++)+"\n"+oblast.getHrac()+"\n\n npc: "+mapa.get(aktualniOblast).getNPCcka().get(2));
                            }
        break;
		case KeyEvent.VK_M: JOptionPane.showMessageDialog(okno, mapa.get(aktualniOblast).popis());
		break;
		/*case KeyEvent.VK_V: new AddToInventory().akce(aktualniOblast, mapa, oblast);//oblast.vlozItem(aktualniOblast, mapa);
		break;
		case KeyEvent.VK_R: new RemoveToInventory().akce(aktualniOblast, mapa, oblast);// oblast.vymazItem(aktualniOblast, mapa);
		break;
		case KeyEvent.VK_E: new AddToEquipment().akce(oblast);//oblast.vlozEquipment();
		break;
		case KeyEvent.VK_Q: new RemoveToEquipment().akce(oblast);//oblast.vymazEquipment();
		*/
		case KeyEvent.VK_H: oblast.vyleceni();
		}
		 oblast.setId(aktualniOblast);
		 oblast.setNazev(mapa.get(aktualniOblast).getNazev());
		 oblast.setFotka(mapa.get(aktualniOblast).getFotka()); 
		 if(commandMapa().containsKey(e.getKeyCode())) {
			 if( commandMapa().get(e.getKeyCode()).exists(commandMapa().get(e.getKeyCode()))) {
			 commandMapa().get(e.getKeyCode()).execute(oblast);
			 commandMapa().get(e.getKeyCode()).execute(aktualniOblast, mapa, oblast);
			 }
		 }
		 
		
	}
	//0 les    3  ves  6 potok 9 start
	//1 bazina 4 louka 7 hory
	//2 hrad   5 rybnik 8 oblast
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public HashMap<Integer, Argument> commandMapa() {
		
		HashMap<Integer, Argument> cmapa = new HashMap<>();
		cmapa.put(KeyEvent.VK_V, new AddToInventory());
		cmapa.put(KeyEvent.VK_R, new RemoveToInventory());
		cmapa.put(KeyEvent.VK_E, new AddToEquipment());
		cmapa.put(KeyEvent.VK_Q, new RemoveToEquipment());
		
		return cmapa;
	}
	
	private class DrawCanvas extends JPanel {
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			repaint();
			try {
				
				g.drawImage(ImageIO.read(new File(oblast.getFotka())),150, 150, 300, 300, null);
				g.setColor(Color.black);
				g.setFont(new Font("zadny", Font.BOLD, 20));
				g.drawString(oblast.toString(), 260, 150);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

}
