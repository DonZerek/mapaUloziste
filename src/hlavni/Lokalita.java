package hlavni;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JOptionPane;

public class Lokalita implements Serializable{
	
	private String nazev, fotka, popis;
	private int id, pocetProvedeni;
	private ArrayList<NPC> npccka = new ArrayList<>();
	private ArrayList<Item> itemy = new ArrayList<>();
	private Hrac hrac;
	
	
	public Lokalita(String nazev, int id, String fotka,Hrac hrac){
		this.nazev=nazev;
		this.id=id;
		this.fotka=fotka;
		this.hrac=hrac;
		itemy();
	}
	
	public String getFotka() {
		return fotka;
	}

	public void setFotka(String fotka) {
		this.fotka = fotka;
	}

	public String getNazev() {
		return nazev;
	}

	public void setNazev(String nazev) {
		this.nazev = nazev;
	}    
	
	public void addNPC(NPC npc) {
		npccka.add(npc);
	}
	
	public void addItem(Item item) {
		itemy.add(item);
	}
	/**
	 * itemy v lokalite
	 * */
	
	public void itemy() {
	    Random rnd = new Random();
		itemy.add(new Item("jidlo","na vyleceni",ItemType.Spotrebovatelny,rnd.nextInt(30)+10));
		itemy.add(new Item("lektvar","na obnoveni many",ItemType.Spotrebovatelny,rnd.nextInt(50)+50));
		itemy.add(new Item("zbran","na sebe",ItemType.Vybaveni,rnd.nextInt(180)+20));
		itemy.add(new Item("stit","na sebe",ItemType.Vybaveni,rnd.nextInt(70)+30));
		itemy.add(new Item("zbroj","na sebe",ItemType.Vybaveni,rnd.nextInt(100)+50));
	}
	/**
	 * metoda vlozi prvni item v mistnosti do inventare a pote ho z mistnosti odstrani
	 * */
	public void vlozItem(int poloha,HashMap<Integer,Lokalita> mapa) {
		
		if(hrac.getInventar().getItemy().size()<10) {
			if(mapa.get(poloha).itemy.size()>0) {
				hrac.getInventar().addItem(mapa.get(poloha).itemy.get(0));
                mapa.get(poloha).itemy.remove(0);
			}
		}else {
			JOptionPane.showMessageDialog(null,"inventar je plny");
		}
	}
	/**
	 * metoda provede opak metody predchozi takze odstrani item z inventare a prida ho 
	 * do mistnosti kde se hrac nachazi
	 * */
	public void vymazItem(int poloha, HashMap<Integer,Lokalita> mapa) {
		if(hrac.getInventar().getItemy().size()>0) {
			mapa.get(poloha).addItem(hrac.getInventar().getItemy().get(0));
            hrac.getInventar().getItemy().remove(0);
		}
	}
	/**
	 * metoda vlozi item z inventare do equipmentu
	 * */
	public void vlozEquipment() {
		
		if(hrac.getInventar().getItemy().size()>0) {
            if(hrac.getEquipment().getItemy().size()<3) {
                if(hrac.getInventar().getItemy().get(0).getTyp().urciType()) {
         	         hrac.getEquipment().addItem(hrac.getInventar().getItemy().get(0));
         	         hrac.getInventar().getItemy().remove(hrac.getInventar().getItemy().get(0));
           
                                }
                            } else {
             	       JOptionPane.showMessageDialog(null,"equipment je plny");
                       }
                    }
	}
	/**
	 * metoda vlozi vsechny itemy z equipmentu zpatky do inventare
	 * */
	public void vymazEquipment() {
		if(hrac.getEquipment().getItemy().size()>0) {
		   if(hrac.getInventar().getItemy().size()<10) {
            hrac.getInventar().getItemy().addAll(hrac.getEquipment().getItemy());
            hrac.getEquipment().getItemy().removeAll(hrac.getEquipment().getItemy());
		    } else {
		    	JOptionPane.showMessageDialog(null, "inventar je plny nelze vratit equipment");
		    }
		   }
	}
	
	public void vyleceni() {
		if(hrac.getZivoty()>0) {
			if(!hrac.getInventar().getItemy().get(0).getTyp().urciType()) {
				hrac.setZivoty(hrac.getZivoty()+hrac.getInventar().getItemy().get(0).getHodnota());
				hrac.getInventar().getItemy().remove(0);
			}
		}
	}
	
	/**
	 * popis lokality
	 * */
	public String popis() {
		String npc = "";
		int poradi =0;
		for(NPC n : npccka) {
			poradi++;
			npc += poradi+". "+n.toString() +"\n\n";
		}
		String item="";
		int poradiI =0;
		Collections.shuffle(itemy);
		for(Item i : itemy) {
			poradiI++;
			item+= poradiI+". "+i.toString()+"\n";
		}
		
		return "nazev "+nazev +", id="+ id +", popis lokality: "+popis+",\n podle cisla vyberte s kym se chcete utkat"  
				+"\n npc v mistnosti :\n\n"+ npc+" itemy v mistnosti:\n" + item;
	}
	
	public String toString() {
		
		return nazev +" id="+ id;
	}
	
	public Hrac getHrac() {
		return hrac;
	}
   /**
    * metoda ktera zpusobuje hracovi poskozeni a ubere hracovi zivoty od daneho npc
    * pokud ma npc vic zivotu nez nula
    * jinak se hracovi pokud zabije npc pricte 50 zivotu
    * */
	public void hracUtrpeni(int i,int p,HashMap<Integer,Lokalita> mapa,int poloha) {
    	 
    	if(mapa.get(poloha).npccka.get(i).getZivoty()>0) {
    	hrac.poskozeniHrace(p);	
    	pocetProvedeni=0;
    	}else{
    		if(pocetProvedeni==0)
    			hrac.setZivoty(hrac.getZivoty()+50);
    		pocetProvedeni++;
    	}
    }
    /**
     * metoda diky ktere hrac dava poskozeni danemu npc
     * */
    public void npcUtrpeni(int i,int p) {
    	if(hrac.getZivoty()>0)
    	npccka.get(i).poskozeniNPC(p);
    }
    
	public void setHrac(Hrac hrac) {
		this.hrac = hrac;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id=id;
	}

	public ArrayList<NPC> getNPCcka() {
		return npccka;
	}

	public void setNPCcka(ArrayList<NPC> npccka) {
		this.npccka = npccka;
	}

	public ArrayList<Item> getItemy() {
		return itemy;
	}

	public void setItemy(ArrayList<Item> itemy) {
		this.itemy = itemy;
	}

	public String getPopis() {
		return popis;
	}

	public void setPopis(String popis) {
		this.popis = popis;
	}
	
	
	

}
