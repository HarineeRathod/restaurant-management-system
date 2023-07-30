package restaurant;

import java.sql.*;
import java.io.*;

public class restaurantDao {
	
	/*------------------------------------------------------------------------------------------------------------------------*/
	
	public static void showingMenu()  {
		
		
		
			try {
			Connection con=Conn.create();
			
			Statement st=con.createStatement(); 
			
			String s[]= {"veg soups","starters","chat","snack","sabsi","roti","naan"};
			
				
			
	          	for(int i=0;i<s.length;i++) {
						
					String q="select * from menu where category ='"+s[i]+"';";
					//System.out.println(q);
					ResultSet set=st.executeQuery(q);
					set.next();
					String category=set.getString(4);
					
					if(category.equalsIgnoreCase(s[i]))	
						
					{
					   System.out.printf("");
			           System.out.println("*****************"+s[i]+": ****************");
			           System.out.printf("|%-30s|%-5s|%n","foode name","price");
			           System.out.println("_______________________________________");
						
						while(set.next()) 
						{
						
									String foodName=set.getString(2);
									int price=(int) (set.getDouble(3));
									String category1=set.getString(4);
									
									
									
									System.out.printf("|%-30s|%-5d|%n",foodName,price);
									//System.out.println("food name : "+foodName+"           price     : "+price);
									//System.out.println("           price     : "+price);
									
									//System.out.println("categary  : "+category1);
									
									
									
						}
						System.out.println("_______________________________________");
					}
					
					else {continue;}
			}
						
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*------------------------------------------------------------------------------------------------------------------------*/
	
	static boolean insertUser(user us) {
		
		boolean f=false;
		
		try {
			Connection con=Conn.create();
			
			Statement st=con.createStatement(); 
			String q="insert into customer(c_Name,c_contact_number,c_email) value(?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(q);
			
			pstmt.setString(1,user.getName());
			pstmt.setString(2,us.getContact_number());
			pstmt.setString(3,us.getEmail_id());
			
			pstmt.executeUpdate();
			
			f=true;	
			
		   }
			
			catch(Exception e)
			{
				e.printStackTrace();
				 f=false;
			}
	
			return f;
	}
	
	
	/*------------------------------------------------------------------------------------------------------------------------*/
	
		static boolean bill () throws IOException
		{
			// creating new file
			String billFileName = user.getName() + ".txt";
			File bill=new File(billFileName);
			bill.createNewFile();
			//writing the file
		FileWriter billWrite=new FileWriter(bill);
			
			boolean f=false;
			
			
		try {
				Connection con=Conn.create();
				Statement st=con.createStatement(); 
				String orderAr[]=user.getOrderArray();
			
			
				/* user usOrder=new user();
				usOrder.getOrder();*/

				
				//String priceQuery="select price from menu where foodname="+orderAr[i];
				
				
				int countDao=user.count;
				double totalAmount=0;
				
				String billLine="++++++++++++++++++++++++++++++++ welcome to hotel xyz ++++++++++++++++++++++++++++++++";
				billWrite.write(billLine);
						for(int i=0;i<countDao;i++)
							
						{
							        String q1="select * from menu where foodname='"+orderAr[i]+"';";
//							        System.out.println(q1);
							        ResultSet fetchRes=st.executeQuery(q1);
							        fetchRes.next();
							        int foodId = fetchRes.getInt(1);
									String foodName=fetchRes.getString(2);
									int price= fetchRes.getInt(3);
									String category=fetchRes.getString(4);
									
									totalAmount=totalAmount+price;
									
									String billLine1 = "\nfood id:  "+foodId+"\n"+"food name: "+foodName+" \n"+"food price:"+price+"\n";
								
									
									billWrite.write(billLine1);
									
						
									
									
//									set.next();
						        
						}
						billWrite.write("-----------------------------------");
						billWrite.write("|total amount= "+totalAmount+"|");
						billWrite.write("-----------------------------------");
						String billLine3="\n+++++++++++++++++++++++++++++++ Thanks for visiting ++++++++++++++++++++++++++++++++";
						billWrite.write(billLine3);
						billWrite.close();	
				
				 f=true;	
				
				}
				
							catch(Exception e)
							{
								e.printStackTrace();
								 f=false;
							}
					
							return f;
			
		}
		
		
		/*-------------------------------------------------------------------------------------------------------------------*/
				
		static void checkUser(user us) {
			//boolean f=false;
			
			try {
				Connection con=Conn.create();
				
				Statement st=con.createStatement(); 
				
				String name=user.getName();
			    String number=us.getContact_number();
			    String email=us.getEmail_id();
			    
			    
				
				String q="select * from customer where c_Name='"+name+"' and c_contact_number='"+number+"' and c_email='"+email+"';";
				ResultSet set=st.executeQuery(q);
				
				set.next();
				String c_name=set.getString(2);
				String c_number=set.getString(3);
				String c_email=set.getString(4);
				
				
				
				if(name.equalsIgnoreCase(c_name)&& number.equalsIgnoreCase(c_number)&& email.equalsIgnoreCase(c_email) ) {
					
					System.out.println(" you have entered the right detail");
					System.out.println(" please enter your order");
					
				}
				else {
					System.out.println(" you have entered the wrong detail");
					System.out.println(" please renter your details ");
					System.out.println(" or if you dont have an account signup the new one ");
					
				}
				
				
			//	f=true;
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
				//f=false;
			}
		//	return f;
			
			
		}	
		
		
	}





