package UserInterface;

import java.util.Comparator;
import java.util.Date;
import bbdd_gestion.Casa;

public class OrdenarLccFechaL implements Comparator<bbdd_gestion.Casa> {

	@Override
	public int compare(Casa arg0, Casa arg1) {
		Date d0 = null, d1 = null;
		System.out.println(arg0.getId_Inmueble() + " - " + arg1.getId_Inmueble());
		int ret = 0;
		if(arg0 != null){
			d0 = arg0.getFecha();
			ret = -1;
		}
		if(arg1 != null){
			d1 = arg1.getFecha();
			ret+=1;
		}
		
		if(arg0 != null && arg1 != null)
			ret = d0.compareTo(d1)*(-1);
		
		return ret;
	}

}
