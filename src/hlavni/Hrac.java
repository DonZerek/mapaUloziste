package hlavni;

public class Hrac {

	private String jmeno,popis;
	private int zivoty, poskozeni;
	private Inventory inventar;
	private Equipment equipment;

	public Hrac(int zivoty, int poskozeni) {
		super();
		this.zivoty = zivoty;
		this.poskozeni = poskozeni;
		inventar=new Inventory();
		equipment = new Equipment();
	}

	public int getZivoty() {
		return zivoty;
	}

	public void setZivoty(int zivoty) {
		this.zivoty = zivoty;
	}

	public int getPoskozeni() {
		return poskozeni;
	}

	public void setPoskozeni(int poskozeni) {
		this.poskozeni = poskozeni;
	}
	
	public Inventory getInventar() {
		return inventar;
	}

	public void setInventar(Inventory inventar) {
		this.inventar = inventar;
	}
	
	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public void poskozeniHrace(int utrpeni) {
		if(zivoty>0)
		zivoty-=utrpeni;
		else zivoty=0;
		     
	}
	
	@Override
	public String toString() {
		return "Hrac\n zivoty: " + zivoty + "\n poskozeni: " + poskozeni 
				+ "\n Inventory: "+inventar +"\n equipment: "+equipment;
	}
	
	
}
