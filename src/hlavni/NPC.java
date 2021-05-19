package hlavni;

public class NPC {

	private String jmeno, popis;
	private int zivoty, poskozeni;

	public NPC(String jmeno, String popis, int zivoty, int poskozeni) {
		super();
		this.jmeno = jmeno;
		this.popis = popis;
		this.zivoty = zivoty;
		this.poskozeni = poskozeni;
	}

	@Override
	public String toString() {
		return  jmeno + "\n popis: " + popis+"\n zivoty: "+zivoty+"\n poskozeni: "+poskozeni;
	}
	
	public String getJmeno() {
		return jmeno;
	}

	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}

	public String getPopis() {
		return popis;
	}

	public void setPopis(String popis) {
		this.popis = popis;
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
	
	public void poskozeniNPC(int utrpeni) {
		if(zivoty>0)
		zivoty-=utrpeni;
		else zivoty=0;
		
	}

}
