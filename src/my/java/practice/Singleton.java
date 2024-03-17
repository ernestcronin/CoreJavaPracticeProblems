package my.java.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Singleton classes should be created as ENUMS to prevent reflection
public class Singleton implements Serializable, Cloneable{

	 //INSTANCE;
	private static Singleton instance = new Singleton();
	
	 	//implicit empty constructor so must do something if exists
	    private Singleton()
	    {
	    	System.out.println("in constructor");
	        // private constructor
	    }
	    
	    protected Object readResolve() { return instance; }
	    
	    @Override
	    protected Object clone() throws CloneNotSupportedException {
	    	throw new CloneNotSupportedException();
	    }
	    
	    public static void main(String[] args)
	    {
//	        Singleton instance1 = Singleton.INSTANCE;
//	        Singleton instance2 = null;
//	        try {
//	            Constructor[] constructors
//	                = Singleton.class.getDeclaredConstructors();
//	            for (Constructor constructor : constructors) {
//	                // Below code will destroy the singleton
//	                // pattern
//	                constructor.setAccessible(true);
//	                instance2
//	                    = (Singleton)constructor.newInstance();
//	                break;
//	            }
//	        }
//	 
//	        catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	 
//	        System.out.println("instance1.hashCode():- "
//	                           + instance1.hashCode());
//	        System.out.println("instance2.hashCode():- "
//	                           + instance2.hashCode());
	    	
	    	try {
	            Singleton instance1 = Singleton.instance;
	            ObjectOutput out = new ObjectOutputStream(
	                new FileOutputStream("file.text"));
	           
	            out.writeObject(instance1);
	            out.close();
	 
	            // deserialize from file to object
	            ObjectInput in = new ObjectInputStream(
	                new FileInputStream("file.text"));
	            Singleton instance2
	                = (Singleton)in.readObject();
	            in.close();
	 
	            System.out.println("instance1 hashCode:- "
	                               + instance1.hashCode());
	            System.out.println("instance2 hashCode:- "
	                               + instance2.hashCode());
	            
	            instance2 = (Singleton) instance1.clone();
	        }
	 
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    	
	    }
}
