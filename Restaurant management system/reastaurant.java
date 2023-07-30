package restaurant;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class reastaurant {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("");
			System.out.println("++++++++++++++++++++++++** welcome to hotel xyz **+++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("To enter the user detail press: 1");
			System.out.println("If you are new customer press : 2");
			System.out.println("to exit the program press     : 3");
			System.out.println("");
			int c;
			c=Integer.parseInt(br.readLine());
			
			if (c==1)
			{
				//checking the user detail
				System.out.println("");
				System.out.println("enter the user name:");
				String name=br.readLine();
				System.out.println("enter the user contact number:");
				String number=br.readLine();
				System.out.println("enter the user email address:");
				String email=br.readLine();
				
				user us=new user(name,number,email);
				
				System.out.println("");
				System.out.println("showing the details you have entered");
				System.out.println("");
				System.out.println("-----------------------------------------------------");
				System.out.println("|name= "+user.getName());
				System.out.println("|phone number= "+us.contact_number);
				System.out.println("|email id="+us.email_id);
				System.out.println("-----------------------------------------------------");
				System.out.println("");
				restaurantDao.checkUser(us);
				
				// showing the menu
				restaurantDao.showingMenu();
				
				// getting the order
				user.getOrder();
				
				//generating the bill
				restaurantDao.bill();
				
				
			}
			
			else if(c==2) {
				String name;
				String email;
				String number;
				while(true) {
				System.out.println("enter the user name:");
				name=br.readLine();
				if (name.matches("^[a-zA-Z ]*$")) {break;}
				else {System.out.println("Invalid name\nRenter the name");}
				} 
				
				while(true) {
				System.out.println("enter the user contact number:");
				number=br.readLine();
				String checkMobile="^\\d{10}$";
				if(number.matches(checkMobile)) {break;}
				else {System.out.println("INVALID mobile number\nRenter the mobile number");}
				}
				
				while(true) {
				System.out.println("enter the user email address:");
				email=br.readLine();
				String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"+"[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
				if(email.matches(regexPattern)){break;}
				else {System.out.println("Invalid email\nRenter the email");}
				}
				
				user us=new user(name,number,email);
				
				System.out.println("showing the details you have entered");
				boolean ans=restaurantDao.insertUser(us);
				System.out.println(us);
				
				if(ans) {
					System.out.println("you data is successfully added");
				}
				else {
					System.out.println("something went wrong please try again later");
				}
				
				// showing the menu
				restaurantDao.showingMenu();
				
				// getting the order
				user.getOrder();
				
				//generating the bill
				restaurantDao.bill();
				
			}
			
			
			else if(c==3) {break;}
			
			else if(c==4) {restaurantDao.showingMenu();}
				
		}
		
			System.out.println("Thank you for visiting out hotle");
			System.out.println("see you again");
	}

}
