
public class TestTaller4 {

	    
	    public static boolean ejercicio1(){
	        int a,b,c,d;
	        a = Taller4.maximo(new int[] {12,324,43,2,3,43,2,3,43},8);
	        b = Taller4.maximo(new int[] {3,2,343,2,43,55,67,68,86,3,4},10);
	        c = Taller4.maximo(new int[] {56,7,6,45,8,4,34,8,7,5,34,7,78,9},13);
	        d = Taller4.maximo(new int[] {1,2,3,4,5,5},5);
	        
	        if(a!=324 || b!=343 || c!=78 || d!=5)
	            return false;
	        return true;
	    }
	    
	    public static boolean ejercicio2(){
	    	boolean a, b, c, d;
			a=Taller4.groupSum(0, new int[] {2, 4, 8}, 9);
			b=Taller4.groupSum(0, new int[] {2, 4, 8}, 8);
			c=Taller4.groupSum(0, new int[] {10, 2, 2, 5}, 9);
			d=Taller4.groupSum(0, new int[] {10, 2, 2, 5}, 17);
			if(!a && b && c && d)
				return true;
			return false;
		}
	    
	    
	
}