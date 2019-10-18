package Tester;

import java.sql.Date;
import java.util.Scanner;

import dao.VendorDao;

public class TestVend {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)) {
			System.out.println("Enter your choice ");
			VendorDao vd=new VendorDao();
			boolean exit=false;
			while(!exit)
				try {
					System.out.println("\n 1 : View all vendors after a specific Date"
							+ "\n 2 : Update vendors Details"
							+ "\n 3 : Delete vendors Record ");
					
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter  city-name  Date(yyyy-MM-dd) ");
						vd.viewall(sc.next(), Date.valueOf(sc.next())).forEach(System.out::println);
						
						break;
					case 2:
						System.out.println("Enter  New-city  New-phone_no  Existing-emailid");
						vd.update(sc.next(), sc.next(), sc.next());
						break;
					case 3 :
						System.out.println("Enter email to delete vendor details");
						vd.delete(sc.next());
						break;

					default:
						vd.close();
						break;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
