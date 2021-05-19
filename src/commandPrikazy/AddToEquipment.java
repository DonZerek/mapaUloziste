package commandPrikazy;

import java.util.HashMap;

import javax.swing.JOptionPane;

import hlavni.Lokalita;

public class AddToEquipment implements Argument {

	
	@Override
	public void execute(Lokalita oblast) {
		if(oblast.getHrac().getInventar().getItemy().size()>0) {
            if(oblast.getHrac().getEquipment().getItemy().size()<3) {
              if(oblast.getHrac().getInventar().getItemy().get(0).getTyp().urciType()) {
         	       oblast.getHrac().getEquipment().addItem(oblast.getHrac().getInventar().getItemy().get(0));
         	    /*   if(!oblast.getHrac().getEquipment().getItemy().contains(oblast.getHrac().getInventar().getItemy().get(0)))
         	    	   oblast.getHrac().getInventar().getItemy().add(oblast.getHrac().getInventar().getItemy().get(0));
         	    	  */ 
         	       oblast.getHrac().getInventar().getItemy().remove(oblast.getHrac().getInventar().getItemy().get(0));
           // }
                  }
               } else {
             	  JOptionPane.showMessageDialog(null,"equipment je plny");
               }
              }

	}

	@Override
	public void execute(int poloha, HashMap<Integer, Lokalita> mapa,Lokalita oblast) {
		
	}
	
	@Override
	public boolean exists(Argument a) {
		
		return a instanceof AddToEquipment;
	}

}
