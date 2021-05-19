package commandPrikazy;

import java.util.HashMap;

import hlavni.Lokalita;

public class RemoveToInventory implements  Argument {

	
	@Override
	public void execute(Lokalita l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(int poloha, HashMap<Integer, Lokalita> mapa, Lokalita oblast) {
		
		if(oblast.getHrac().getInventar().getItemy().size()>0) {
            mapa.get(poloha).addItem(oblast.getHrac().getInventar().getItemy().get(0));
            oblast.getHrac().getInventar().getItemy().remove(0);
           }

	}
	
	@Override
	public boolean exists(Argument a) {
		
		return a instanceof RemoveToInventory;
	}

}
