package ar.com.fdvs.dj.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Collection;

import net.sf.jasperreports.engine.design.JRDesignStyle;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtils;

import ar.com.fdvs.dj.core.DJException;
import ar.com.fdvs.dj.domain.Style;


public class Utils {
	
	private Utils(){
		
	}
	
	/**
	 * Returns true if collection is null or empty
	 * @param col
	 * @return 
	 */
	public static boolean isEmpty(Collection col){
		if (col == null)
			return true;
				
		return col.isEmpty();
		
	}


	/**
	 * This takes into account objects that breaks the JavaBean convention
	 * and have as getter for Boolean objects an "isXXX" method.
	 * @param dest
	 * @param orig
	 */
	public static void copyProperties(Object dest, Object orig){
		try {
			if (orig != null && dest != null){
				BeanUtils.copyProperties(dest, orig);
				
				PropertyUtils putils = new PropertyUtils();
	            PropertyDescriptor origDescriptors[] = putils.getPropertyDescriptors(orig);

	            for (int i = 0; i < origDescriptors.length; i++) {
	                String name = origDescriptors[i].getName();
	                if ("class".equals(name)) {
	                    continue; // No point in trying to set an object's class
	                }
	                
	                Class propertyType = origDescriptors[i].getPropertyType();
					if (! Boolean.class.equals(propertyType) && ! (boolean.class.equals(propertyType) ))
	                	continue;
	                
	                if (!putils.isReadable(orig, name)){ //because of bad convention 
	                	Method m = orig.getClass().getMethod("is" + name.substring(0,1).toUpperCase() + name.substring(1)  , null);
	                	Object value = m.invoke(orig, null);
	                	
	                	if (m!=null && putils.isWriteable(dest, name)){
	                		BeanUtilsBean.getInstance().copyProperty(dest, name, value);
	                	}
	                }
	                
	            }	            
			}
		} catch (Exception e) {
			throw new DJException("Could not copy properties for shared object: " + orig +", message: " + e.getMessage(),e);
		}		
	}
	
	
	public static void main(String[] args) {
		JRDesignStyle s1 = new Style().transform();
		JRDesignStyle s2 = new Style().transform();
		
		s1.setBold(Boolean.TRUE);
		s1.setItalic(Boolean.TRUE);
		s1.setUnderline(Boolean.TRUE);
		
		Utils.copyProperties(s2, s1);
		
		System.out.println(s2.isBold() + " - " + s2.isItalic() + " - " + s2.isUnderline());
		
		
	}
	
}