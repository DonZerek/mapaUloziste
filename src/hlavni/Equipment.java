package hlavni;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Equipment {

	private HashSet<Item> itemy = new HashSet<>();

	public HashSet<Item> getItemy() {
		return itemy;
	}

	public void setItemy(HashSet<Item> itemy) {
		this.itemy = itemy;
	}
	
	public void addItem(Item i) {
		itemy.add(i);
	}

	@Override
	public String toString() {
		String vps="";
		int poradi=0;
	
		for(Item i : itemy) {
			poradi++;
			vps+=poradi+". "+i.toString()+"\n";
		}
		return "\n"+vps;
	}
	
	
}
