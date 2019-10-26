import java.util.*;

public class ComparatorGoluri implements Comparator<Clasament>{
    
    @Override
    public int compare(Clasament c1, Clasament c2) {
        if (c1.GoluriMarcate < c2.GoluriPrimite){
             return 1;
         }
        else if (c1.GoluriMarcate > c2.GoluriPrimite){
            return -1;
        }
        return 0;    
    } 

}
