package commandPrikazy;

import java.util.ArrayList;
import java.util.HashMap;

import hlavni.Lokalita;

public interface Command {

	//public void akce(Lokalita oblast);
	//public void akce(int poloha,HashMap<Integer,Lokalita> mapa, Lokalita oblast);
	
	//public boolean isMatch(ArrayList<Argument> list);

	public void execute(Lokalita oblast);
	public void execute(int poloha,HashMap<Integer,Lokalita> mapa, Lokalita oblast);
}
