package commandPrikazy;

import java.util.HashMap;

import javax.swing.JOptionPane;

import hlavni.Lokalita;

public class AddToInventory implements  Argument {

	
	@Override
	public void execute(Lokalita l) {
		
		

	}
	@Override
	public void execute(int poloha, HashMap<Integer, Lokalita> mapa,Lokalita oblast) {
		
		if(oblast.getHrac().getInventar().getItemy().size()<10) {
			if(mapa.get(poloha).getItemy().size()>0) {
				oblast.getHrac().getInventar().addItem(mapa.get(poloha).getItemy().get(0));
                mapa.get(poloha).getItemy().remove(0);
			}
		}else {
			JOptionPane.showMessageDialog(null,"inventar je plny");
		}
		
	}
	@Override
	public boolean exists(Argument a) {
		
		return a instanceof AddToInventory;
	}

	
}
