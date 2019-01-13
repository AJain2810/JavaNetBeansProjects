package test11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CstmExcp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // TODO code application logic here 
        int regno;
        int j;
        menu:
        for(j=0;j==0;)
        {
            try{
                regno=sc.nextInt();
                if(regno<10000)
                    throw new IllegalArgumentException("Value Should be greater than 10k");
                continue menu;
            }
            catch(InputMismatchException e)
            {
                System.err.println("Enter Correct Value :"+e);
                j++;
                continue menu;
            }

            catch( IllegalArgumentException i)
            {
                System.err.println(i.getMessage());
                j++;
                continue menu;
            }
            
            finally
                    {
                      System.out.println("Hey, The control is in the finally block")  ;
                    }
        }
        
        String name;
        sc.next();
        name=sc.nextLine();
        try{
            if(!name.contains(" "))
                throw new ValueMismatch("Name","\nEnter Complete Name( First Name <space> Last Name )");
        }
        
        catch(ValueMismatch v)
        {
            System.out.println(v.getmessage());
        }
    }
    
    static public class ValueMismatch extends Exception{
        String obj;
        String type;
        public String getmessage()
        {
            return(obj+" value not in correct format"+type);
        }
        public ValueMismatch(String str,String a)
        {
            obj=str;
            type=a;
        }
        
       /* public ValueMismatch()
        {
            obj=" ";
        }*/
        
    }
    
}
