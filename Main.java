import java.util.*;
                
public class Main{
    static int x;
    static int y;
    public static void main(String[] args){  
            System.out.println("Introduceti echipele: ");
            Thread t = new ReclamaThread();
            t.start();
            
            
            while(true){
                    Scanner s = new Scanner(System.in);
                    String cmd = s.nextLine();
                    String [] cuv = cmd.split(" ");
                    
                    
                       try{
                           switch(cuv[0]){   
                           case "stop_echipe": 
                                
                                try{
                                   if(Campionat.getInstance().getEchipe().size() < 2){                    
                                       throw new PreaPutineEchipeException();
                                   } else{
                                       System.out.println("Introduceti partidele jucate: ");
                                   }                
                                }catch(PreaPutineEchipeException e){ 
                                    Campionat.getInstance().stergeEchipe();
                                }
                                break;  
                           
                           case "meci":
                                y--;        
                                System.out.println("Nr Echipe = " + x );
                                System.out.println("Nr Meciuri = " + y);
                                
                                Clasament c1 = new Clasament();
                                Clasament c2 = new Clasament();           
                                c1.NumeEchipa = cuv[1];
                                c1.joacaAcasa(c1);
                                c2.NumeEchipa = cuv[2];
                                c2.joacaInDeplasare(c2);                                  
                                try{
                                   c1.GoluriMarcate = Integer.parseInt(cuv[3]);
                                   c1.GoluriPrimite = Integer.parseInt(cuv[4]);
                                   c2.GoluriMarcate = Integer.parseInt(cuv[4]);
                                   c2.GoluriPrimite = Integer.parseInt(cuv[3]);
                                     
                                   c1.calculeazaPunctaj(Integer.parseInt(cuv[3]), Integer.parseInt(cuv[4]));
                                   c2.calculeazaPunctaj(Integer.parseInt(cuv[4]), Integer.parseInt(cuv[3]));
                                }catch(NumberFormatException e){
                                   System.out.println("Pentru goluri, introduceti valori numerice!");
                                   Campionat.getInstance().stergeEchipe();                
                                }
                                Campionat.getInstance().actualizareMeci(c1);
                                Campionat.getInstance().actualizareMeci(c2);
                                
                                Campionat.getInstance().sorteazaEchipe(c1);
                                Campionat.getInstance().sorteazaEchipe(c2);
                                
                                                    
                                if(y == 0){
                                   Campionat.getInstance().afiseazaEchipe();
                                   t.stop();
                                   return;
                                }    
                                
                                try{
                                   if(cuv[1].equals(cuv[2])){
                                       throw new FormatIncorectException();
                                   }
                                }catch(FormatIncorectException e){
                                   System.out.println("O echipa nu poate juca cu ea insasi! Introduceti doua echipe diferite: ");
                                   Campionat.getInstance().stergeEchipe();
                                }                
                                
                                try{
                                    if(((c1.GoluriMarcate < 0) || (c1.GoluriMarcate > 15)) || ((c1.GoluriPrimite < 0) || (c1.GoluriPrimite > 15))){
                                        throw new FormatIncorectException();    
                                    } 
                                }catch(FormatIncorectException e){
                                   System.out.println("Introduceti un numar de goluri plauzibil !");
                                   Campionat.getInstance().stergeEchipe();
                                } 
                                break;
                                
                           case "situatie_curenta":
                                Campionat.getInstance().afiseazaEchipe();                
                                break;
                                
                           case "finalizeaza_campionat":  
                                Campionat.getInstance().afiseazaEchipe();
                                t.stop();               
                                return;
                                
                           case "restart":
                                Campionat.getInstance().stergeEchipe();
                                System.out.println("Se reia campionatul. Introduceti alte echipe: ");
                                break; 
                           case "exit":
                                System.out.println("Programul se inchide.....");
                                return;
                                
                           default:
                                Clasament c = new Clasament();
                                c.NumeEchipa = cuv[0];
                                Campionat.getInstance().adaugaEchipe(c);
                                x = Campionat.getInstance().getEchipe().size();
                                y = 2 * x - 2 ;
                                try{
                                    if(c.NumeEchipa.trim().isEmpty()){
                                        throw new NumeGresitEchipaException();
                                    } 
                                }catch(NumeGresitEchipaException e){
                                        Campionat.getInstance().stergeEchipe();
                                        x = 0;
                                }
                            
                                try{
                                   if(c.isNumeric(c.NumeEchipa)){
                                        throw new NumeGresitEchipaException();
                                   }
                                }catch(NumeGresitEchipaException e){
                                        Campionat.getInstance().stergeEchipe();
                                        x = 0;
                                }
                        }
                    } catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Introduceti un nume corect!");
                        Campionat.getInstance().stergeEchipe();
                    }
            }
    }
}
    
    
