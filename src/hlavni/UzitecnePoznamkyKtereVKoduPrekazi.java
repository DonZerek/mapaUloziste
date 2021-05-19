package hlavni;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JOptionPane;

import commandPrikazy.AddToEquipment;
import commandPrikazy.AddToInventory;
import commandPrikazy.Argument;
import commandPrikazy.Command;
import commandPrikazy.RemoveToEquipment;
import commandPrikazy.RemoveToInventory;

public class UzitecnePoznamkyKtereVKoduPrekazi {

	
	
	
	/*
	 public interface Argument extends Command {
    odedil jsem od commandu
	public boolean exists(Argument a);
}
	 
	public HashMap<Integer, Command> commandMapa() {
		
		HashMap<Integer,Command> cmapa = new HashMap<>();
		cmapa.put(KeyEvent.VK_V, new AddToInventory());
		cmapa.put(KeyEvent.VK_R, new RemoveToInventory());
		cmapa.put(KeyEvent.VK_E, new AddToEquipment());
		cmapa.put(KeyEvent.VK_Q, new RemoveToEquipment());
		
		return cmapa;
	}
	 
	 
	//e.setKeyCode(KeyEvent.VK_1);
	oblast.itemy();
	
	int kolo =0;
		                    while(oblast.getHrac().getZivoty()!=0 && mapa.get(aktualniOblast).getNPCcka().get(0).getZivoty()!=0)
		                    {
			                oblast.hracUtrpeni(0, mapa.get(aktualniOblast).getNPCcka().get(0).getPoskozeni(),mapa, aktualniOblast);
		                    mapa.get(aktualniOblast).npcUtrpeni(0, oblast.getHrac().getPoskozeni());
		                    JOptionPane.showMessageDialog(okno,"kolo "+(kolo++)+"\n"+oblast.getHrac()+"\n\n npc: "+mapa.get(aktualniOblast).getNPCcka().get(0));
		                    }
	
	
	public void execute(int i,int pHrace, int pNPC, HashMap<Integer, Lokalita> mapa, int poloha) {
    	int kolo=0;
    	while(hrac.getZivoty()!=0 && mapa.get(poloha).npccka.get(i).getZivoty()!=0) {
    		hracUtrpeni(i,pNPC,mapa,poloha);
    		npcUtrpeni(i,pHrace);
    		JOptionPane.showMessageDialog(null,"kolo "+(kolo++)+"\n"+hrac+"\n\n npc: "+mapa.get(poloha).getNPCcka().get(i));
    	}
    }
	
	
	public void npcUtrpeni(int i,int p, Lokalita l) {// tato metoda pokud chci kdyz
    	if(l.hrac.getZivoty()>0) npc ubir vic nez nez hrac ma zivotu == hrac nic neubere npc
    	npccka.get(i).poskozeniNPC(p);
    }
	
	 logika vkladani do inventare
	 /* if(oblast.getHrac().getInventar().getItemy().size()<10) {
			                   if(mapa.get(aktualniOblast).getItemy().size()>0) {
			                	    oblast.getHrac().getInventar().addItem(mapa.get(aktualniOblast).getItemy().get(0));
		                            mapa.get(aktualniOblast).getItemy().remove(0);
			                	    
		                               }
		                           }else {
		                        	   JOptionPane.showMessageDialog(okno,"inventar je plny");
		                           }
	
	mazani s inventare
	if(oblast.getHrac().getInventar().getItemy().size()>0) {
			                mapa.get(aktualniOblast).addItem(oblast.getHrac().getInventar().getItemy().get(0));
			                oblast.getHrac().getInventar().getItemy().remove(0);
		                   }
	vlozeni do equipmentu
	if(oblast.getHrac().getInventar().getItemy().size()>0) {
			               if(oblast.getHrac().getEquipment().getItemy().size()<3) {
			              // for(int i=0;i<oblast.getHrac().getInventar().getItemy().size();i++) {
			               if(oblast.getHrac().getInventar().getItemy().get(0).getTyp().urciType()) {
			            	   oblast.getHrac().getEquipment().addItem(oblast.getHrac().getInventar().getItemy().get(0));
			            	   oblast.getHrac().getInventar().getItemy().remove(oblast.getHrac().getInventar().getItemy().get(0));
			              // }
			                     }
		                      } else {
		                    	  JOptionPane.showMessageDialog(okno,"equipment je plny");
		                      }
		                     }
	vymazani equipmentu
	         if(oblast.getHrac().getEquipment().getItemy().size()>0) {
			                oblast.getHrac().getInventar().getItemy().addAll(oblast.getHrac().getEquipment().getItemy());
			                oblast.getHrac().getEquipment().getItemy().removeAll(oblast.getHrac().getEquipment().getItemy());
		}
	
	
	
	
	
	
	
	// for(int i=0;i<oblast.getHrac().getInventar().getItemy().size();i++) {
			               if(oblast.getHrac().getInventar().getItemy().get(i).getTyp().urciType()) {
			            	//   oblast.getHrac().getEquipment().addItem(oblast.getHrac().getInventar().getItemy().get(i));
			              // }
	
	
	//   if(mapa.get(aktualniOblast).getItemy().contains(mapa.get(aktualniOblast).getItemy().get(mapa.get(aktualniOblast).getPamItemy()))) {
			                	//       oblast.getHrac().getInventar().addItem(mapa.get(aktualniOblast).getItemy().get(mapa.get(aktualniOblast).getPamItemy()));
			                    //       mapa.get(aktualniOblast).getItemy().remove(mapa.get(aktualniOblast).getPamItemy());      
			                	//    mapa.get(aktualniOblast).getItemy().remove(0);
			                	//           }
	*/
	/*public void t() {
		Random r = new Random();
		
		//Item tmpPam = itemy.get(rnd.nextInt(5));
		/*for(Item i : itemy) {// neni funkcni musim si pohrat s randomem
			//if(itemy.size()>0) {
				poradiI++;
				pamItemy= rnd.nextInt(itemy.size());
			item+= poradiI+". "+itemy.get(getPamItemy())+"\n";
			// }
			
		}*/
		//String pamujufor = pamFor();
	
	/*private Random rnd = new Random();
	   int tmpRandomu = rnd.nextInt(5);
	 * //String pamujufor = pamFor();
	public String pamFor() {
		item="";
		int poradiI =0;
		for(Item i : itemy) {
				poradiI++;
				pamItemy= rnd.nextInt(itemy.size());
			item+= poradiI+". "+itemy.get(getPamItemy())+"\n";
			// }
		}
		
		return item;
	}
	
	public String getItem() {
		return item;
	}
	
	public int getPamItemy() {
		return pamItemy;
	}
	 * 
	 * public Item random() {
		if(itemy.size()>0) {
			if(itemy.contains(itemy.get(tmpRandomu)))
		return itemy.get(tmpRandomu);
		}
		return null;
	}
	
	public void removeRandom() {
		if(itemy.size()>0) {
		   if(itemy.contains(itemy.get(tmpRandomu)))
		         itemy.remove(tmpRandomu);
		}
		
	}
	 * 
	 * 
	 * /*	if((radek=bR.readLine())!=null) {
			String[] pole = radek.split(";");
			for(int i=0;i<3;i++) {
				oblast.addItem(new Item(pole[rnd.nextInt(5)+17],pole[i+22]));
			}
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *
	 * Dulezite ify   
	 * //if(mapa.get(aktualniOblast).getNPCcka().get(0).getZivoty()>0)
	 * //  else oblast.getHrac().setZivoty(oblast.getHrac().getZivoty()+50);
			             
			              //  if(oblast.getHrac().getZivoty()>0)
	 * //podle setu    mapa.get(aktualniOblast).getNPCcka().get(0).setZivoty(mapa.get(aktualniOblast).getNPCcka().get(0).getZivoty()-oblast.getHrac().getPoskozeni());
	 * 
	 * case KeyEvent.VK_Z: 
			/*for(int i=0;i<3;i++) {
			  if(mapa.get(aktualniOblast).pridamZivotyIf(i)) {
				 
            	  oblast.getHrac().setZivoty(oblast.getHrac().getZivoty()+1000);
			  }
		  }
	 * 
	 * 
	 * /*int hracZivoty = hrac.getZivoty();
 	if(npccka.get(i).getZivoty()<=0) {
		hracZivoty+=1000;
		hrac.setZivoty(hracZivoty);
		
	}*/
	/*int hracZivoty = hrac.getZivoty();
	if(npccka.get(i).getZivoty()<=0) {
		hracZivoty+=p;
		hrac.setZivoty(hracZivoty);
	}
	 int hracZivoty = hrac.getZivoty();
 	if(npccka.get(i).getZivoty()<=0) {
		hracZivoty+=1000;
		hrac.setZivoty(hracZivoty);
		//return true;
	}
	//return false;
	 * 
	 * public boolean pridamZivotyIf(int i) {
    	
    	return npccka.get(i).getZivoty()<=0;
    	
    }
    
    public boolean neuberuZivotyNpcIf() {
    	return hrac.getZivoty()<=0;
    }
	 * 
	 * /*int zivotyProHrace = oblast.getHrac().getZivoty();
		                     if(mapa.get(aktualniOblast).getNPCcka().get(0).getZivoty()<=0) {
		                    	 zivotyProHrace+=1000;
		                    	 oblast.getHrac().setZivoty(zivotyProHrace);
		                     }
		                    /*spravne
		                     int zivotyProHrace = oblast.getHrac().getZivoty();
		                     if(mapa.get(aktualniOblast).pridamZivotyIf(0)) {
		                    	 zivotyProHrace+=1000;
		                    	 oblast.getHrac().setZivoty(zivotyProHrace);
		                     }
		                    */	
	
	
	 /*  if(zivotyPlus>hrac.getZivoty())
	hrac.setZivoty(hrac.getZivoty()+50);
    else hrac.setZivoty(hrac.getZivoty()-50);
    	*/
	//pocetProvedeni+=2;
	//for(int j=0;j<npccka.size();j++)
/*	pocetProvedeni++;System.out.print(pocetProvedeni);
	if(pocetProvedeni==1) {System.out.print(pocetProvedeni);
	if(zivotyPlus==hrac.getZivoty()) 
		hrac.setZivoty(hrac.getZivoty()-50);
	}*/
	
/*	for(int j=0;j<npccka.size();j++) {
		if(j==0)
			hrac.setZivoty(hrac.getZivoty()+50);
		if(j>0) {
			hrac.setZivoty(hrac.getZivoty()-50);
			hrac.setZivoty(hrac.getZivoty()+50);
			
		}
	}*/
	//}
//	hrac.setZivoty(hrac.getZivoty()+50);
	/*	int hracPlus =hrac.getZivoty()+50;
	int hracZivoty = hrac.getZivoty();
	/*if(plusZivoty()>hrac.getZivoty()+50)
		hrac.setZivoty(hrac.getZivoty()+100);
	
	if(hracPlus > hracZivoty) {
		hrac.setZivoty(hrac.getZivoty()+100);
	}
 */
	/*	pocetProvedeni++;
	System.out.print(pocetProvedeni);
	for(int j=0;j<2;j++) {
		if(j==0)
			hrac.setZivoty(hrac.getZivoty()+50);
		if(j==1)
			return;
			/* if(pocetProvedeni==1)*/
    		/*pocetProvedeni++;
    		if(pocetProvedeni==1) {
    			pocetProvedeni+=2;*/
	
	
}
