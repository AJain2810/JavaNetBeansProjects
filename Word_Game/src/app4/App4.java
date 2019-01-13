package app4;

import java.util.Scanner;

public class App4 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] st1={"comart","unprofited","addiction","assassination","belongings","eventful","fashionable","inaudible","manager","scuffle","uncomfortable"};
        char ch[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int size=0;
        try{
            for(int i=0;;i++)
            {
                size=i;
                String s=st1[i];
            }
            
        }
        catch(Exception e)
        {
            
            System.out.println(size);
        }
        int h=0;
        String[]formed=new String[11];
        menu:
        for(int j=1;j>0;j++)
            {
                System.out.println("Welcome!!You have to form words from the characters given below");
                System.out.println("The words must have been coined by Shakespeare");
                for(int i=0;i<26;i++)
                {
                    if(ch[i]=='2')
                        continue;
                    else
                        System.out.print(ch[i]+" ");
                }
                
                
                String st2=sc.next();
                st2=st2.toLowerCase();
                int l=st2.length();
                int flag=0;
                for(int p=0;p<h;p++)
                {
                   if(formed[p].equals(st2))
                   {
                       flag=2;
                   }
                }
                int temp=0;
                int u=0;
                for(int i=0;i<l;i++)
                {
                    for(int k=0;k<26;k++)
                    {
                        if(st2.charAt(i)!=ch[k])
                            temp=1;
                    }
                    if(temp==1)
                        flag=3;
                }
                if(flag!=2&&flag!=3)
                {
                    for(int i=0;i<11;i++)
                    {
                        if(st2.equals(st1[i]))
                        {
                            flag=1;
                            formed[h]=st1[i];
                            h++;
                        }

                    }
                }
            switch (flag) {
                case 0:
                    System.out.println("Try again..\nWord not coined by Shakespeare");
                    continue menu;
                case 1:
                    System.out.println("Word correct");
                    break;
                case 2:
                    System.out.println("Word already formed..Try again\n\n");
                    continue menu;
                case 3:
                    System.out.println("You have to form words only from the characters mentioned above");
                default:
                    break;
            }
                
                l=st2.length();
                char[] ch2=st2.toCharArray();
                for(int i=0;i<l;i++)
                {
                    for(int k=0;k<26;k++)
                    {
                        if(ch[k]==ch2[i])
                            ch[k]='2';
                    }
                }
                int count=0;
                for(int i=0;i<26;i++)
                {
                    if(ch[i]!='2')
                        count++;
                }
                if(count<5)
                {
                    System.out.println("Game Over....");
                    System.exit(0);
                }
                System.out.println("Press 1. to exit and");
                System.out.println(" 2. to continue");
                int a;
                try{
                a=sc.nextInt();
                }
                catch(Exception e)
                {
                    System.out.println("Enter value in correct format from next time..");
                    continue menu;
                }
            switch (a) {
                case 1:
                    System.out.println("Thanks for Playing!!\nYour final score is: "+h);
                    System.exit(0);
                case 2:
                    continue menu;
                default:
                    System.out.println("\nWrong option selected. Therefore exiting");
                    System.exit(0);
                    break;
            }
            }
        
    }
}
