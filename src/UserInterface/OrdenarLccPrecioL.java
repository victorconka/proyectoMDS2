package UserInterface;

import java.util.Comparator;

import bbdd_gestion.Casa;

public class OrdenarLccPrecioL  implements Comparator<bbdd_gestion.Casa> {

	@Override
	public int compare(Casa arg0, Casa arg1) {
		Double d0 = null, d1 = null;
		
		int ret = 0;
		if(arg0 != null){
			d0 = arg0.getPrecio();
			ret = -1;
		}
		if(arg1 != null){
			d1 = arg1.getPrecio();
			ret+=1;
		}
		if(arg0 != null && arg1 != null)
			return d0.compareTo(d1)*-1;
		
		return ret;
	}

}
