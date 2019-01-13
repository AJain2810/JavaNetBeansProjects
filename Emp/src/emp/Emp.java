package emp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Emp {
    public static void main(String[] args) {
        System.out.println("Number of Employees whose details you wanna Enter");
        // TODO code application logic here
        Scanner in=new Scanner(System.in);
        int  qwe;
        qwe=in.nextInt();
        
        Employee[] emp=new Employee[qwe];
        for(int i=0;i<qwe;i++)
        {
            emp[i]=new Employee();
        }
        try{
           emp[0].create();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        Scanner sc=new Scanner(System.in);
        
        System.out.println("\nHow would you like to Search??\n");
        System.out.println("Select:\n1.to search by State\n2.to search by City\n3.tosearch by Employee- Number");
        int choice = 0;
        try{
            choice=sc.nextInt();
            if(choice<1||choice>3)
                throw new ArithmeticException("Value Not in Range");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        String inpt;
        inpt=sc.next();
        int chc;
        try{
                switch(choice)
                    {
                        case 1:
                            emp[0].searchstate(inpt);
                            break;
                        case 2:
                            emp[0].searchcity(inpt);
                            break;
                        case 3:
                            chc=Integer.parseInt(inpt);
                            emp[0].search(chc);
                            break;
                    }
        }
        
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        
    }
    
}
class Person{
    Scanner sc=new Scanner(System.in);
    
    String name;
    int age;
    String city;
    String state;
    String add;
    public Person()
    {
        System.out.println("Enter Your Name");
        name=sc.nextLine();
        System.out.println("Age");
        try{
                age=sc.nextInt();
                if(age<18||age>60)
                {
                    System.err.println("Enter Details Correctly");
                    throw new ArithmeticException("Age should be in the range of 18- 60");
                } 
            }
        catch(Exception e)
        {
            System.err.println("Enter Details Correctly!!!!");
            System.exit(0);
        }
        System.out.println("Enter your Flat No. , Street and Locality\nInput Format: FlatNo. <space> Street <space> Locality");
        
        add=sc.next();
        add+=" ";
        add+=sc.next();
        System.out.println(add);
        System.out.println("Enter the State and City\nFormat: City <space> State");
        city=sc.next();
        state=sc.next();
          
    }
    public Person(int j)
    {
        
    }
    
    
}
class Employee extends Person{
    Scanner sc=new Scanner(System.in);
    String empnum;
    
    public Employee()
    {
        System.out.println("Enter the Emp Number");
        empnum=sc.next();
    }
    public Employee(int i)
    {
        
    }
    public void search(int empno)
    {
        Scanner sc=new Scanner(System.in);
        int i=0,flag=0;
        String s1[]=new String[20];//Buffer Reading all the lines of the File       
        BufferedReader br=null;
        try{
            int z=s1.length-1;
            FileReader fr=new FileReader("C:\\Users\\abhin\\Dropbox\\Documents\\Emp.txt");
            br=new BufferedReader(fr);
            String s;//Reading the String Buffer
            while((s=br.readLine())!=null)//Reading the file till the last line 
            {
               s1[i]=s; // Storing ith line at ith index of Arrays1
               i++;
            }
             for(i=0;i<s1.length;i++)
                {
                 int j=0;       
                 for(j=0;j<s1[i].length()-6;j++)
                    {
                     if((s1[i].substring(j,j+6)).equals("EmpNo:"))
                        {
                         int indx1=j+7;     
                                            
                         int indx2=0;
                         String str1=s1[i].substring(indx1,indx1+6);
                            
                         String str2=Integer.toString(empno);
                            System.out.println(str1+" "+str2);
                         if(str1.equalsIgnoreCase(str2))
                            flag=1;
                        }
                     if(flag==1)
                     {
                         System.out.println(s1[i]);
                         System.exit(0);
                     }
                    }
                 
                }
            }
        catch(IOException e)
        {
            System.out.println(e);
        }
}
    public void searchcity(String ct)
    {   
        String s1[]=new String[10];//Buffer Reading all the lines of the File       
        BufferedReader br=null;
        int len=ct.length();
            try{
                int i=0;
                FileReader fr=new FileReader("C:\\Users\\abhin\\Dropbox\\Documents/Emp.txt");
                br=new BufferedReader(fr);
                String s;
                
                while((s=br.readLine())!=null)//Reading the file till the last line 
                {
                   s1[i]=s;
                    // Storing ith line at ith index of Arrays1
                   i++;
                }
                
                }
            catch(IOException e)
            {
                System.out.println(e);
            }
            
            try{
                    for(int i=0;s1[i]!=null;i++)
                    {
                        System.out.println(i);
                        int j=27;
                        while(s1[i].substring(j)!=null)
                        {
                            
                            if(s1[i].substring(j, j+6).equalsIgnoreCase("City: "))
                            {
                                break;
                            }
                            j++;
                        }
                        int indx=j+7;
                        String str1=s1[i].substring(indx,indx+len);
                        String str2=ct;
                        if(str2.equalsIgnoreCase(str1))
                        {
                            System.out.println(s1[i]);
                        }
                    }
            }
            catch(Exception e)
            {
                
            }
            
            

    }
    public void searchstate(String st)
    {   
        String s1[]=new String[10];//Buffer Reading all the lines of the File       
        BufferedReader br=null;
        int len=st.length();
            try{
                    int i=0;
                    FileReader fr=new FileReader("C:\\Users\\abhin\\Dropbox\\Documents/Emp.txt");
                    br=new BufferedReader(fr);
                    String s;

                    while((s=br.readLine())!=null)//Reading the file till the last line 
                    {
                       s1[i]=s;
                        // Storing ith line at ith index of Arrays1
                       i++;
                    }
                
                }
            catch(IOException e)
            {
                System.out.println(e);
            }
            
            try{
                    for(int i=0;s1[i]!=null;i++)
                    {
                        System.out.println(i);
                        int j=33;
                        while(s1[i].substring(j)!=null)
                        {
                            if(s1[i].substring(j, j+7).equalsIgnoreCase("State: "))
                            {
                                break;
                            }
                            j++;
                        }
                        int indx=j+7;
                        String str1=s1[i].substring(indx,indx+len);
                        String str2=st;
                        if(str2.equalsIgnoreCase(str1))
                        {
                            System.out.println(s1[i]);
                        }
                    }
            }
            catch(Exception e)
            {
                
            }
            
            

    }
    public void search(String name)
    {
        try {
            FileReader fs=new FileReader("C:");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void create() throws IOException{
        
            String res="EmpNo: "+empnum+"\tName: "+name+"\tAge: "+Integer.toString(age)+"\tAddress: "+add+"\tCity: "+city+"\tState: "+state;
            FileWriter fw;
            fw = new FileWriter("C:\\Users\\abhin\\Dropbox\\Documents\\Emp.txt");
            System.err.println("Entry Created Successfully!!!!!");
            fw.write(res);
            fw.close();
    }
    
}