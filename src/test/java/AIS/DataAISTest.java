package AIS;

public class DataAISTest {

	public static void main(String[] args) {
		DataAISImpl dataAIS = new DataAISImpl();
		//here is an exemple of what returns getAISData() with coordinates between Ouessant and Le Conquet
		dataAIS.getAISData(1, 48.427295, -4.777388, 48.328113, -4.912193);
	}
	
	//MAXLAT=48.427295
	//MAXLON=-4.777388
	//MINLAT=48.328113
	//MINLON=-4.912193
	
}
