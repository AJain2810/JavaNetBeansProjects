
    package app2;

    import java.util.Scanner;

    public class App2 {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc= new Scanner(System.in);
        int w=0;
        System.out.println("Welcome!!!");
        m:
        for(w=0;w==0;)
        {
            System.out.println("Enter your name and e-mail");
            String name=sc.nextLine();
            String mail=sc.nextLine();
            int indx1,indx2;
            indx1=mail.indexOf("@");
            indx2=mail.indexOf(".com");
            if(indx1>indx2||indx1>=mail.length()||indx2>=mail.length()||indx1==-1||indx2==-1)
            {
                System.out.println("Enter details correctly\n\n");
                continue m;
            }
            else
                w=1;
        }
                int test=0;
            menu:
            for(test=1;test>0;test++)
            {
                System.out.println("\n\n\n\nThe properties currently listed are:");
                System.out.println("1. 3BHK near Cyber City, Gurgaon");
                System.out.println("2. 4BHK in Dwarka, New Delhi");
                System.out.println("3. 2BHK in Sector- 17, CHD");

                System.out.println("\n\nWhich property are you interested in???");
                System.out.println("Enter the option only...\ni.e. Enter 1 if you'd like to buy the first property that is listed");
                int a = 0;
                try{
                    a=Integer.parseInt(sc.next().substring(0,1));
                }
                catch(Exception e)
                {
                    System.out.println("Enter value in the correct format please");
                    continue menu;
                }

                int cost=0;
                switch(a)
                {
                    case 1:cost=10000000;break;
                    case 2:cost+=10010000;break;
                    case 3:cost+=10020000;break;
                    default:
                        System.out.println("Choose Correctly");
                        continue menu;
                }
                System.out.println("The cost of the property selected by you is Rs."+cost);
                System.out.println("Enter 1. if you'd like to continue, \n9. If you'd like to exit\n or press any other to return to the main menu");
                try{
                    int i=sc.nextInt();
                    switch (i) {
                        case 1:
                            break;
                        case 9:
                            System.exit(0);
                        default:
                            continue menu;
                    }
                }
                catch(Exception e)
                {
                    continue menu;
                }
                int dp=0;
                System.out.println("\n\nThats a really nice choice of yours!!");
                
                dwnpymnt:
                for(int q=1;q==1;)
                {
                    
                    System.out.println("The down-payment for the chosen property is at least Rs. 1,00,000");
                    dp=0;
                    System.out.println("Enter the amount youd be depositing initially");
                    System.out.println("Enter the amount only. No need for comma ");
                    System.out.println("Amount should be an integer value in the multiples of thousand only");
                    try{
                       dp=sc.nextInt();
                       if(dp<100000)
                       {
                           System.out.println("Enter correct amount");
                           continue dwnpymnt;
                       }
                       else if(dp>cost)
                            continue dwnpymnt;
                       else
                           q=0;
                    }
                    catch(Exception e)
                    {
                        continue menu;
                    }
                }
                float inte=0,time=0;
                int rem=0;
                rem=cost-dp;
                
                int m;
                yup:
                for(int t=0;t==0;)
                {
                
                    System.out.println("Select time period of your choice");
                    System.out.println("1. 36 months\n2. 60 months\n3. 48 months\n4. 96 months");
                    System.out.println("Interest rate 7%,7.5%,7.25%,8% p.a. respectively");
                    
                    try{
                        m=sc.nextInt();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Enter value in correct format");
                        continue yup;
                    }
                    System.out.println("\n\n\n\n\n\nMonthly:");
                    
                    switch(m)
                    {
                        case 1: 
                            inte=(float)7;
                            time=3;
                            break;
                        case 2: 
                            inte=(float)7.5;
                            time=5;
                            break;
                        case 3: 
                            inte=(float)7.25;
                            time=4;
                            break;
                        case 4: 
                            inte=(float)8.00000;
                            time=8;
                            break;
                        default:
                            System.out.println("Enter correct value");
                            continue yup;
                    }
                    t++;
                }
                float we =rem*time*inte/100;
                float amt=we+rem;
                amt/=time;
                amt/=12;
                System.out.println("Amount to be deposited each month:"+amt);
                w++;
                test=-1;
                
            }
    }
}



