package hlavni;



import java.io.IOException;
import javax.swing.SwingUtilities;



public class Main {

	public static void main(String[] args) {
				
		SwingUtilities.invokeLater(new Runnable() {
		      @Override
		      public void run() {
		         try {
					new MapaSveta();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		   });
					
					

	}

}