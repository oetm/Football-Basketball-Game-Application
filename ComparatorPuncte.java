import java.util.*;

public class ComparatorPuncte implements Comparator<Clasament>{
    
    @Override
    public int compare(Clasament c1, Clasament c2) {
        if (c1.Punctaj < c2.Punctaj){
             return 1;
         }
        else if (c1.Punctaj > c2.Punctaj){
            return -1;
        }
        return 0;    
    } 

}
