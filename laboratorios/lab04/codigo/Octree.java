/**
 *This is our data structure, Octree. This will be responsible for positioning each bee in a specific quadrant, 
 *so you can determine if it collides or not. Its main function will be divided into eight quadrants, in 3D. 
 *If more than one bee is found in a quadrant, this quadrant will be divided into multiple subOctrees, found 
 *in the limits of this, until the bee is alone, or within a diagonal quadrant of less than 100 meters in length. 
 *This is done to ensure that all the bees within this quadrant are in danger of colliding.
 * @author: Daniel Otero Gomez, Rafael Mateus Carrion - Andrés Echeverri Jaramillo, Santiago González Rodríguez, Mariana Vásquez Escobar.
 * @version: 4/7/2019/A
 * @see Octree
 * @see Bee
 */
import java.util.ArrayList;
import java.util.LinkedList;
public class Octree
{
    private double midD,midW,midH;
    /**
     * This will be the method that represents the Octree, on this method all the recursion will be done, here each bee will be assigned 
     *to its respective sector of the Octree, represented by an ArrayList of 8 spaces (each one representing each sector), where it will 
     *be stored in a LinkedList. The process of deciding which sector each bee goes to will be done by the hashing method. After each bee
     *is located in a sector it will happen to create the sub-views of the Octree with the new method Octree. Before going on to create 
     *the new subdivisions of the Octree, it is asked if the octual diagonal is less than 100 meters, if so it will start printing the 
     *bees located in the sectors where there is more than one bee.
     * @param ArrayList<Bee> abejas: ArrayList with all the bees
     * @param ArrayList<Double> mins: they are the values of the coordinates, to which they will be sumed with all others in order to determine
     * the posicion in the Octree. It can be resemble as a vertex of the Octree.
     * @param double midD: will be the value of the latitude found in the middle of the bee with the lowest latitude and the bee with the highest latitude
     * @param double midW: will be the value of the latitude found in the middle of the bee with the lowest longitude and the bee with the highest longitude
     * @param double midD: will be the value of the latitude found in the middle of the bee with the lowest altitude and the bee with the highest altitude
     * @see hashing
     * @see nuevoOct
     */
    public void octree (LinkedList<Bee> abejas,ArrayList<Double> mins,double midD,double midW,double midH) {
        this.midD=midD; //c1
        this.midW=midW; //c2
        this.midH=midH; //c3 
        ArrayList<LinkedList<Bee>> octree=new ArrayList(8); //Octree ---> c4
        for (int i=0;i<8;++i) { //c5*8 + c6
            LinkedList<Bee> ab=new LinkedList(); //c7*8
            octree.add(ab); //8n
        }
        for (int i=0;i<abejas.size();++i) { //c8*n+c9
            Bee abeja=abejas.poll(); //c10*n
            int sector=hashing(abeja,mins);//c11*n
            octree.get(sector).addFirst(abeja); //(n+c12)*n
        }
        double ph=Math.sqrt(Math.pow((midD)*111325,2)+Math.pow((midW)*111325,2)); //Primera hipotenusa ----> c13
        double diagonal=Math.sqrt(Math.pow(ph,2)+Math.pow((midH),2)); //c14
        if (diagonal>100) { //c15
            for (int i=0;i<8;++i) { //c16*8+c17
                if (octree.get(i).size()>1) { //8n
                    nuevoOctree(octree.get(i),mins,i); //8(n+c18)
                }
            }
        } else {
            for (int i=0;i<8;++i) { //c19*8+c20
                if (octree.get(i).size()>0) { //(n+c21)8
                    choque(octree.get(i)); }//(n+c22)8
            }
        }
        /*
         * T(n)=c1+c2+c3+c4+c6+c9+c13+c14+c15+c17+c20+8c5+8c7+8c16+8c18+8c19+8c21+8c22+8n+8n+8n+8n+8n+c8n+c10n+c11n+c12n+n*n
         * T(n) es O(c1+c2+c3+c4+c6+c9+c13+c14+c15+c17+c20+8c5+8c7+8c16+8c18+8c19+8c21+8c22+8n+8n+8n+8n+8n+c8n+c10n+c11n+c12n+n*n)
         * T(n) es O(8(c5+c7+c16+c18+c19+c21+c22)+48n+n(c10+c11)+n^2)
         * T(n) es O(48n+n(c10+c11)+n^2)
         */
    }

    /**
     * This method will be responsible for receiving each bee that is in the octree, and place it in a certain sector of the data structure, 
     *so that it will be located in the space of the ArrayList table corresponding to the sector in which the bee is positioned. Determine the 
     *sector by comparing the minimum, that is, the vertices of the Octree, plus the average values of the Octree with which it is being worked.
     * @param Bee abeja: abeja que sera ubicada
     * @param ArrayList<Double> mins: this ArrayList will contain the minimum, that is, the vertex composed by each coordinate. This parameter 
     *is necessary to be able to make an appropriate location for each bee, because the use of this parameter will simplify the code so that only 
     *one value will have to be added to determine if a bee is in a sector or in other.
     * @return number of the sector the Bee is located in.
     */
    private int hashing(Bee abeja,ArrayList<Double> mins) {
        if (abeja.getLatitude()<=mins.get(0)+midD) {
            if (abeja.getLongitude()<=mins.get(1)+midW) {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    return 2;
                } else {
                    return 3;
                }
            }
        } else {
            if (abeja.getLongitude()<=mins.get(1)+midW) {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    return 4;
                } else {
                    return 5;
                }
            } else {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    return 6;
                } else {
                    return 7;
                }
            }
        }
        //T(n) es O(1)
    }

    /**
     * This method is responsible for making the recursion, with respect to the main octree method. Receive the parameters corresponding to 
     *the bees located in the sector, and the vertices of this, which are in the ArrayLis mins. With the paramtero sector they identify how 
     *the vertices of the next sub-octree should be redefined, since these vary by sector.
     * @param LinkedList<Bee> abejas: bees of the corresponding sector
     * @param ArrayList<Double> mins: they are the minimum values of coordinates, to which other parameters will be added to redefine the 
     *vertex of the next Octree. Take it as if it were one of the vertex of the octree.
     * @param int sector: sector in which it is located.
     */
    public void nuevoOctree(LinkedList<Bee> abejas,ArrayList<Double> mins,int sector) {
        if (sector==0) { 
            octree(abejas,mins,midD/2,midW/2,midH/2); 
        } else if (sector==1) {
            double nuevoH=mins.get(2)+midH;
            mins.remove(2);
            mins.add(2,nuevoH);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==2) {
            double nuevoW=mins.get(1)+midW;
            mins.remove(1);
            mins.add(1,nuevoW);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==3) {
            double nuevoH=mins.get(2)+midH;
            mins.remove(2);
            mins.add(2,nuevoH);
            double nuevoW=mins.get(1)+midW;
            mins.remove(1);
            mins.add(1,nuevoW);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==4) {
            double nuevoD=mins.get(0)+midD;
            mins.remove(0);
            mins.add(0,nuevoD);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==5) {
            double nuevoD=mins.get(0)+midD;
            mins.remove(0);
            mins.add(0,nuevoD);
            double nuevoH=mins.get(2)+midH;
            mins.remove(2);
            mins.add(2,nuevoH);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==6) {
            double nuevoD=mins.get(0)+midD;
            mins.remove(0);
            mins.add(0,nuevoD);
            double nuevoW=mins.get(1)+midW;
            mins.remove(1);
            mins.add(1,nuevoW);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else {
            double nuevoD=mins.get(0)+midD;
            mins.remove(0);
            mins.add(0,nuevoD);
            double nuevoW=mins.get(1)+midW;
            mins.remove(1);
            mins.add(1,nuevoW);
            double nuevoH=mins.get(2)+midH;
            mins.remove(2);
            mins.add(2,nuevoH);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        }
    }

    /**
     * This sector is in charge of printing all the coordinates of the bees of the sector, if it prints them is because
     * all these Bees are in risk of colliding.
     * @param LinkedList<Bee> abejas: bees of the sector
     */
    public void choque(LinkedList<Bee> abejas) {
        //System.out.println("Las abejas en las siguientes coordenadas estan en peligro de chocarse");
        for (Bee abeja:abejas) {
            System.out.println(abejas.poll().getLatitude()+","+abejas.poll().getLongitude()+","+abejas.poll().getAltitude());
        }
    }

}