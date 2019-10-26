public class Clasament extends Echipa{   
    int NrTotalPartide = 0;
    int NrPartideAcasa = 0;
    int NrPartideDeplasare = 0;
    int Punctaj = 0;  
    
    @Override
    public void joacaAcasa(Clasament c){
        if(!c.NumeEchipa.isEmpty()){
            NrPartideAcasa++;            
        }else{
            NrPartideAcasa = 0;
        }            
    }
    
    @Override
    public void joacaInDeplasare(Clasament c){
        if(!c.NumeEchipa.isEmpty()){
            NrPartideDeplasare++;
        }else{
            NrPartideDeplasare = 0;
        }
    }
    
    public String toString(){
        return NumeEchipa + " Partide: " +  NrTotalPartide + " Partide acasa: " + NrPartideAcasa + " Partide deplasare: " + NrPartideDeplasare + " Goluri marcate: " + GoluriMarcate + " Goluri primite: " + GoluriPrimite + " Puncte: " + Punctaj;
    }       
    
    public int calculeazaPartide(){
        NrTotalPartide = this.NrPartideAcasa + this.NrPartideDeplasare;
        return this.NrTotalPartide;
    }        
    
    public int calculeazaPunctaj(int GoluriMarcate, int GoluriPrimite){
        if(GoluriMarcate > GoluriPrimite){
            return Punctaj+= 3;
        }else if(GoluriMarcate == GoluriPrimite){
            return Punctaj++;
        }else
            return Punctaj;        
    }   
    
  public static boolean isNumeric(String str){  
  try{  
    double d = Double.parseDouble(str);  
  }  
  catch(NumberFormatException e){  
    return false;  
  }  
  return true;  
}    
}
