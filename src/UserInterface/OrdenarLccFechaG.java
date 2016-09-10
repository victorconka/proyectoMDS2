package UserInterface;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Comparator;
import java.util.Date;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import bbdd_gestion.Casa;
import bbdd_gestion.ProjectMDS2PersistentManager;

public class OrdenarLccFechaG implements Comparator<bbdd_gestion.Casa> {

	public int compare(Casa arg0, Casa arg1) {
		PersistentTransaction t = null;
		System.out.println("G");
		Date d0 = null, d1 = null;
		
		int ret = 0;
		if(arg0 != null){
			d0 = arg0.getFecha();
			ret = 1;
		}
		if(arg1 != null){
			d1 = arg1.getFecha();
			ret-=1;
		}
		if(arg0 != null && arg1 != null){
			ret = d0.compareTo(d1);
		}

		return ret;
	}

}
