/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: University of Almeria
 * License Type: Academic
 */
package bbdd_gestion;

import org.orm.*;

public class CasaSetCollection extends org.orm.util.ORMSet {
	public CasaSetCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int targetKey, int collType) {
		super(owner, adapter, ownerKey, targetKey, true, collType);
	}
	
	public CasaSetCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int collType) {
		super(owner, adapter, ownerKey, -1, false, collType);
	}
	
	/**
	* Return an iterator over the persistent objects
	* @return The persisten objects iterator
	*/
	public java.util.Iterator getIterator() {
		return super.getIterator(_ownerAdapter);
	}
	
	/**
	 * Add the specified persistent object to ORMSet
	 * @param value the persistent object
	 */
	public void add(Casa value) {
		if (value != null) {
			super.add(value, value._ormAdapter);
		}
	}
	
	/**
	 * Remove the specified persistent object from ORMSet
	 * @param value the persistent object
	 */
	public void remove(Casa value) {
		super.remove(value, value._ormAdapter);
	}
	
	/**
	 * Return true if ORMSet contains the specified persistent object
	 * @param value the persistent object
	 * @return True if this contains the specified persistent object
	 */
	public boolean contains(Casa value) {
		return super.contains(value);
	}
	
	/**
	 * Return an array containing all of the persistent objects in ORMSet
	 * @return The persistent objects array
	 */
	public Casa[] toArray() {
		return (Casa[]) super.toArray(new Casa[size()]);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMSet
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>id_casa</li>
	 * <li>precio</li>
	 * <li>superficie</li>
	 * <li>habitaciones</li>
	 * <li>banios</li>
	 * <li>tipo</li>
	 * <li>linkMapa</li>
	 * <li>estado</li>
	 * <li>accion</li>
	 * <li>numVisitas</li>
	 * <li>numFavoritos</li>
	 * <li>visible</li>
	 * <li>dCorta</li>
	 * <li>dLarga</li>
	 * </ul>
	 * @return The persistent objects sorted array
	 */
	public Casa[] toArray(String propertyName) {
		return toArray(propertyName, true);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMSet
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>id_casa</li>
	 * <li>precio</li>
	 * <li>superficie</li>
	 * <li>habitaciones</li>
	 * <li>banios</li>
	 * <li>tipo</li>
	 * <li>linkMapa</li>
	 * <li>estado</li>
	 * <li>accion</li>
	 * <li>numVisitas</li>
	 * <li>numFavoritos</li>
	 * <li>visible</li>
	 * <li>dCorta</li>
	 * <li>dLarga</li>
	 * </ul>
	 * @param ascending true for ascending, false for descending
	 * @return The persistent objects sorted array
	 */
	public Casa[] toArray(String propertyName, boolean ascending) {
		return (Casa[]) super.toArray(new Casa[size()], propertyName, ascending);
	}
	
	protected PersistentManager getPersistentManager() throws PersistentException {
		return bbdd_gestion.ProjectMDS2PersistentManager.instance();
	}
	
}

