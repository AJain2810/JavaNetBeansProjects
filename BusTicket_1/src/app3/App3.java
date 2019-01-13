package app3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App3 {

     public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        Bus b=new Bus();
        Random rand=new Random();
        System.out.println("Enter your name to begin");
        String name=sc.nextLine();
        int tcktno=1643156;
        int[][]tktno={
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}};
        int tkt=0;
        Date d=new Date();
        menu:
        
        while(1>0)
        {
            
            int flag=0;
            sc.nextLine();
            System.out.println("Select\n1. to Book\n2. to Cancel a Ticket\n3. to Exit");
                int c=sc.nextInt();
                switch (c) {
                    case 1:
                        flag=0;
                        break;
                    case 2:
                        flag=2;
                        break;
                    case 3:
                        flag=1;
                        break;
                    default:
                        System.exit(0);
                        break;
                    }
            switch (flag) {
                case 1:
                    System.out.println("Hope to see you again!!");
                    System.exit(0);
                case 0:
                {
                    System.out.println("The route on which tickets are available are:");
                    System.out.println("JPR to DEL");
                    System.out.println("\nPress Enter to continue");
                    sc.nextLine();
                    float fare=300;
                    System.out.println("\n\n\n\n\n");
                    int count=0;
                    int count2=0;
                    
                    System.out.println("\n\n\n\n\n\n\nSeats remaining");
                    for(int i=0;i<50;i++)
                    {
                        if(b.bs[i]==0&&i<20)
                            count++;
                        if(b.bs[i]==0&&i>19)
                            count2++;
                    }
                    System.out.println("Sleeper:"+ count);
                    System.out.println("Sitting:"+ count2+"\n");
                    showslpr q= new showslpr();
                    int st=0;
                    try{
                        st=sc.nextInt();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Incorrect Choice\nTry again.");
                        break;
                    }
                    int u=20,l=1;
                    switch(st)
                    {
                        case 1:
                            if(count==0)
                                break menu;
                            fare*=1.5;
                            break;
                        case 2:
                            if(count==0)
                                break menu;
                            fare*=1.1;
                            u=50;l=20;
                            break;
                        default:
                            break;
                    }

                    System.out.println("Number of seats required\nNo more than 3 seats can be booked on a single ticket");
                    int num=0;
                    try{
                        num=sc.nextInt();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Incorrect Choice\nTry again.");
                        break;
                    }
                    if((st==1&&num>count)||(st==2&&num>count2)||(num<0))
                    {
                        System.out.println("Sorry, this many seats not available");
                        break;
                    }
                    

                    /*
                    Till now we have taken the users choices
                    whether he'd like an AC bus
                    A sleeper bus
                    Which route would he like to travel
                    Now we're gonna give him the choice
                    for seat numbers.

                    */
                    System.out.println("Seats available:");
                    fare*=num;
                    for(int i=(l-1);i<u;i++)
                    {
                        if(b.bs[i]==0)
                            System.out.print(i+1+" ");
                    }
                    System.out.println(" ");
                    //Choice is for AC or Non AC 
                    // num if sor number of seats 
                    //st for Sitting or Sleeper 
                    System.out.println("\nChoose your seats:\n Input format: Seat1 <space> Seat 2");
                    int[] choices=new int[count];
                    for(int i=0;i<num;i++)
                    {
                        try{
                            choices [i]=sc.nextInt();
                        }
                        catch(Exception e )
                        {
                            continue menu;
                        }
                    }
                        
                        
                    for(int i=0;i<num;i++)
                    {
                        if(b.bs[choices[i]-1]!=0)
                        {
                            System.out.println("Seats not available");
                            break menu;
                        }
                    }
                    for(int i=0;i<num;i++)
                    {
                        b.bs[choices[i]-1]=1;
                    }
                    System.out.println("Booking Successful");
                    System.out.println("Ticket Number is:"+ tcktno);
                    int i;
                    for(i=0;i<7;i++)
                    {
                        if(tktno[i][0]==0)
                            break;
                    }
                    if(i==7)
                    {
                        System.out.println("Sorry. No more tickets can be booked\nYou've exhausted your booking quota");
                        break menu;
                    }
                    else
                        tktno[i][0]=tcktno;
                    for(int ii=0, jj=1;ii<num;ii++)
                    {
                        
                            tktno[i][jj]=choices[ii];
                            jj++;
                    }
                    tcktno+=rand.nextInt(100);
                    System.out.println("\n\nFare is:"+fare);
                    
                    int date=d.getDate()+10;
                    int month=d.getMonth();
                    int year=d.getYear();
                    if(date>30)
                    {
                        date%=30;
                        month++;
                    }
                    if(month>12)
                    {
                        month=month%12;
                        year++;
                    }
                    tkt++;
                    try
                    {
                        FileOutputStream fs=new FileOutputStream("C:\\Users\\abhin\\Dropbox\\Documents/file3.txt");
                        String res="Name:"+name+((char)13)+"\nTicketNo.:"+tcktno+((char)13)+"\nJourney Date(MM-DD-YY):"+month+"-"+date+"-"+year+((char)13)+"\nTicket From: Jaipur to Delhi"+((char)13)+"\nTime of Journey: 8pm"+((char)13)+"\nBus Type:Volvo\n";
                        String seats;
                        seats=Integer.toString(tktno[i][1]);
                        if(!(Integer.toString(tktno[i][2]).equals("0")))
                            seats=seats+" "+Integer.toString(tktno[i][2]);
                        if(!(Integer.toString(tktno[i][3]).equals("0")))
                            seats=seats+" "+Integer.toString(tktno[i][3]);
                        res=res+"Seats :"+seats;
                        byte[]t=res.getBytes();
                        fs.write(t);
                        
                        
                    } 
                    catch (FileNotFoundException ex) 
                    {
                        Logger.getLogger(App3.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                    
                }
                case 2:
                    {
                        System.out.println("Enter Ticket Number");
                        int tno = 0;
                        try{
                            tno=sc.nextInt();
                        }
                        catch(Exception e)
                        {
                            
                        }
                        int indx=0;
                        int i;
                        for(i=0;i<13;i++)
                        {
                            try{
                                if(tktno[i][0]==tno)
                                    break;
                            }
                            catch(ArrayIndexOutOfBoundsException a)
                            {
                                System.out.println("Ticket Number not valid!!");
                                System.exit(0);
                                break;
                            }
                        }
                        if(i==13)
                        {
                            System.out.println("Sorry Ticket Number Isn't valid");
                            continue menu;
                        }
                        else
                        {
                            tktno[i][0]=0;
                            for(int kk=1;kk<3;kk++)
                            {
                                b.bs[tktno[i][kk+1]]=0;
                            }
                        }
                        System.out.println("\nTicket Cancelled\n\n");
                        break;
                    }
                default:
                    continue menu;
            }
    }
}
   
    
static class showslpr
{
    public showslpr()
    {
        System.out.println("Select:\n1. for Sleeper and 2. for Sitting ");
    }
}


public static class Bus
{
    public int[]bs=new int[50];
    public Bus()
    {
        for(int i=0;i<50;i++)
            bs[i]=0;
    }
}

}
