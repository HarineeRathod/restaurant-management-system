package restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class user {
	
	static String name;
	String contact_number;
	String email_id;
	 static //vector<String>= new <String>(n);
    String orderArray[]=new String[20];
	static int count=0;
	
	
	public user(String name, String contact_number, String email_id) {
		super();
		this.name = name;
		this.contact_number = contact_number;
		this.email_id = email_id;
		
		
	}
	




	public static String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContact_number() {
		return contact_number;
	}


	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}


	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}


	@Override
	public String toString() {
		return "user [name=" + name + ", contact_number=" + contact_number + ", email_id=" + email_id + "]";
	}
	
	
    static void getOrder() throws IOException 
    {
    	System.out.println("");
    	System.out.println("****************************************");
		System.out.println("please give your order");
		System.out.println("****************************************");
		System.out.println("");
		System.out.println("****************************************");
		System.out.println("to finish the order type finish");
		System.out.println("****************************************");
		System.out.println("");
		
//		Scanner scan=new Scanner(System.in) ;
		BufferedReader scan= new BufferedReader(new InputStreamReader(System.in));

		//String st=new String();
		

				for(int i=0;i<20;i++) 
					{
							System.out.println("Enter Item: ");
							String order = scan.readLine();
							
							
							if(order.equals("finish")) 
							{
								break;
							}
							else 
							{
								orderArray[i]=order;
								count++;
							}
							
					}
				System.out.println("you have orderd total "+count+" items");
        }
    
   public static String[] getOrderArray() 
    {
    	return orderArray;
    }


	public user() {
		
	}
    
    
    
}
