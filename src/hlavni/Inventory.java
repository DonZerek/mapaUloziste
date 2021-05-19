package hlavni;
import java.util.ArrayList;
import java.util.Collections;

public class Inventory {

	private ArrayList<Item> itemy = new ArrayList<>();

	public ArrayList<Item> getItemy() {
		return itemy;
	}

	public void setItemy(ArrayList<Item> itemy) {
		this.itemy = itemy;
	}
    
	public void addItem(Item i) {
		itemy.add(i);
	}
	
	@Override
	public String toString() {
		String vps="";
		int poradi=0;
		Collections.shuffle(itemy);
		for(Item i : itemy) {
			poradi++;
			vps+= poradi+". "+i.toString()+"\n";
		}
		return "\n"+vps;
	}
	
	
	
	
}
