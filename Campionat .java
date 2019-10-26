import java.util.*;

public class Campionat{
    int NrMeciuri;
   private List<Clasament> echipe = new ArrayList<>(); 
   
   private static Campionat SINGLETON; 
   
   private Campionat(){       
   }
    
   public static Campionat getInstance(){
      if(SINGLETON == null){
          SINGLETON = new Campionat();
      }            
      return SINGLETON;
   }
   
   public void adaugaEchipe(Clasament c){
       echipe.add(c);             
   } 
   
   public void afiseazaEchipe(){
       for(int i = 0 ; i < echipe.size() ; i++){
           System.out.println(i + 1 + ": " + echipe.get(i));
       }
   }
   
   public void sorteazaEchipe(Clasament c){              
       
       for(int i = 0 ; i < echipe.size() ; i++){           
             Collections.sort(echipe, new ComparatorPuncte());              
             if(c.Punctaj == echipe.get(i).Punctaj){                                                          
                       Collections.sort(echipe, new ComparatorGoluri());                                        
                
           }
       }          
   }
   
   public void stergeEchipe(){
       echipe.removeAll(echipe);
   }         
       
   public void actualizareMeci(Clasament c){
       for(int i = 0 ; i < echipe.size() ; i++){
           if(echipe.get(i).NumeEchipa.equals(c.NumeEchipa)){  
               echipe.get(i).NrPartideAcasa += c.NrPartideAcasa;
               echipe.get(i).NrPartideDeplasare += c.NrPartideDeplasare;
               echipe.get(i).calculeazaPartide();
               echipe.get(i).GoluriMarcate += c.GoluriMarcate;
               echipe.get(i).GoluriPrimite += c.GoluriPrimite;
               echipe.get(i).calculeazaPunctaj(c.GoluriMarcate, c.GoluriPrimite);
            }
       }
   }      
   
   public void nrMeciuri(){
       for(int i = 0 ; i < echipe.size() ; i++){
           NrMeciuri = i;
       }
   }
        
   public void setEchipe(){
       this.echipe = echipe;      
   }
   
   public List<Clasament> getEchipe(){
       return this.echipe;
   }  
}




