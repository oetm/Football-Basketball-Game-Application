import java.util.*;

public class ReclamaThread extends Thread{ 
    
    public ReclamaThread(){
        
    }
    
    public ReclamaThread(String nume){
        super(nume);
    }
    
    @Override
    public void run(){ 
        while(true){             
                try{
                    ReclamaThread.sleep(300000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Reclama");                                       
       }
    }
}