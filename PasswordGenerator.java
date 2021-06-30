import java.util.*;
class PasswordGenerator {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Do you want to generate password yes/no: ");
		String response = scn.nextLine();
		if(response.equalsIgnoreCase("yes")) {
			System.out.println("Enter your password length: ");
			int len = scn.nextInt();
			System.out.println("Here is your generated password: "+framePassword(len));
			System.out.println("You like it or you want generate another one yes/no: ");
			String res = scn.next();
			if(res.equalsIgnoreCase("yes")) {
				System.out.println("Thanks for visiting,have a good day");
			}	
			else if(res.equalsIgnoreCase("no")) {
				System.out.println("Here is your generated password: "+framePassword(len));
			}
		}
		else {
			System.out.println("Enter your password: ");
			String p = scn.nextLine();
			if(checkStrength(p)) {
				System.out.println("Strong");
			}
			else {
				System.out.println("Weak");
				System.out.println("You want to enter again yes/no: ");
				String str = scn.nextLine();
				if(str.equalsIgnoreCase("yes")) {
					System.out.println("Enter your password: ");
					String ps = scn.nextLine();
					if(checkStrength(ps)) {
						System.out.println("Strong");
					}
					else {
						System.out.println("Weak");
					}
				}	
			}
		}
		
	}
	static String framePassword(int len) {
		String pass = "";
		char[] ch = new char[92];
		Random r = new Random();
		int a = 127;
		while(pass.length()<=len) {
			if(pass.length()==len) {
				break;
			}
			int n = r.nextInt(a);
			if(n>32) {
				pass+=(char)n;
			}
		}
		return pass;
	}
	static boolean checkStrength(String pass) {
		int count = 0;
		List<String> ll = Arrays.asList(pass.split(""));
		if(ll.contains(" ")||ll.contains("	")||ll.size()>=8) {
			for(int i=0;i<=9;i++) {
				if(ll.contains(""+i)) {
					count++;
				}
			}	
			for(int i=65;i<127;i++) {
				if(ll.contains((char)i+"")) {
					count++;
				}
			}
			if(count>=2) {
				return true;
			}	
		}
		return false;
	}	
}		