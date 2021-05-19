package hlavni;

public enum ItemType {

	Spotrebovatelny{

		@Override
		public boolean urciType() {
			// TODO Auto-generated method stub
			return false;
		}
		},
	Vybaveni{

		@Override
		public boolean urciType() {
			// TODO Auto-generated method stub
			return true;
		}};
	
	public abstract boolean urciType();
}
