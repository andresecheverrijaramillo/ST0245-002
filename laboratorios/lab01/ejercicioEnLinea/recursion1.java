    
 /**
 * Write a description of class recursion1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
 public class recursion1{
    public boolean nestParen(String str) {
    if(str.length()==0)
        return true;
    if(str.length()==1)
        return false;
    if (str.equals("")) return true;
      if (str.charAt(0) == '(' && str.charAt(str.length()-1) == ')')
        return nestParen(str.substring(1,str.length()-1));
    else
        return false;
  }
    public int count11(String str) {
    if(str.length()<=1) 
        return 0;
    if (str.substring(0, 2).equals("11")) 
        return 1+count11(str.substring(2));
    return count11(str.substring(1));
  } 
  public String endX(String str) {
    str=endXAux(str,0);
    return str;
   }
   private String endXAux(String str, int start) {
         if (str.equals("")) 
         return str;
         if(str.length()>1){
         if(str.charAt(start)=='x'){
             return endXAux(str.substring(1),start) + 'x';
            }
        }
         return str.charAt(0) + endXAux(str.substring(1),start);
  }
    public String changePi(String str) {
    if (str.equals("") || str.length() < 2) 
    return str;
          if(str.length()>=2)
      if (str.substring(0, 2).equals("pi")) 
          return "3.14"+changePi(str.substring(2));
       return str.charAt(0) + changePi(str.substring(1));
  }

 } 
