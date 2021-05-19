package commandPrikazy;

import java.util.HashMap;

import javax.swing.JOptionPane;

import hlavni.Lokalita;

public class RemoveToEquipment implements  Argument {

	
	
	@Override
	public void execute(Lokalita oblast) {
		
		if(oblast.getHrac().getEquipment().getItemy().size()>0) {
			if(oblast.getHrac().getInventar().getItemy().size()<10) {
            oblast.getHrac().getInventar().getItemy().addAll(oblast.getHrac().getEquipment().getItemy());
            oblast.getHrac().getEquipment().getItemy().removeAll(oblast.getHrac().getEquipment().getItemy());
			} else {
				JOptionPane.showMessageDialog(null, " inventar je plny nelze vratit itemy s equipmentu");
			}
         }

	}

	@Override
	public void execute(int poloha, HashMap<Integer, Lokalita> mapa,Lokalita l) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public boolean exists(Argument a) {
		
		return a instanceof RemoveToEquipment;
	}


}
