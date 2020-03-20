package eg.edu.alexu.csd.datastructure.linkedList.cs77_cs84;
import java.util.InputMismatchException;
import java.util.Scanner; 
public class Main2 {
    public static void printMenu() {
    	System.out.println("====================================================================");
    	System.out.println("Please choose an action");
     	System.out.println("------------------------");
    	System.out.println("1-Set a polynomial variable");
    	System.out.println("2- Print the value of a polynomial variable");
    	System.out.println("3- Add two polynomials");
    	System.out.println("4- Subtract two polynomials");
    	System.out.println("5- Multiply two polynomials");
    	System.out.println("6- Evaluate a polynomial at some point");
    	System.out.println("7- Clear a polynomial variable");
    	System.out.println("8- Exit");
    	System.out.println("====================================================================");
    }

    public static char check(String word, PolynomialSolver a,char menu) {
    	Scanner sc = new Scanner(System.in);
    	Boolean done=false;
    	char choice = 0 ;
    	while(!done) {
    		try {
    			System.out.println(word);
    			choice = sc.next().charAt(0);
    			choice = Character.toUpperCase(choice);
    			if(menu=='2' || menu=='6' || menu=='7') {
    				if(choice=='A' ||choice=='B' || choice=='C' || choice=='R'){
    	    			if(!(a.switchs(choice).isEmpty())){
    	    	    	 done=true;
    	    	    	 }
    	    			else {
    	    			 System.out.println("Variable not set\n");
    	    			}
    	    	    	}
    	    			else {
    	    				System.out.println("Invalid input\n");
    	    			}
    			}
    			else {
    			if(choice=='A' ||choice=='B' || choice=='C'){
    			if(!(a.switchs(choice).isEmpty())){
    	    	 done=true;
    	    	 }
    			else {
    			 System.out.println("Variable not set\n");
    			}
    	    	}
    			else {
    				System.out.println("Invalid input\n");
    			}
    			}
    		}
    		catch(InputMismatchException e) {
    			sc.next();
    			System.out.println("Invalid input\n");
    		}
    	}
		return choice;
	}
    public static String printArray(int[][] arr) {
    	String array="("+arr[0][0]+","+arr[0][1]+")";
    	for(int i=1;i<arr.length;i++) {
          array+=", ("+arr[i][0]+","+arr[i][1]+")";
    	}
    	
		return array;
    }
    public static void scanArray(char poly,PolynomialSolver a){
    	Scanner sc = new Scanner(System.in);
    	Boolean done=false;
    	int size=0;
    	while(!done) {
    		try {
    			System.out.println("Enter number of terms");
    	    	 size=sc.nextInt();
    	    	 done=true;
    		}
    		catch(InputMismatchException e) {
    			sc.next();
    			System.out.println("Invalid input\n");
    		}
    	}
    	done=false;
    	int[][] array=new int[size][2];
    	int coefficient=0;
    	int exponent=0;
    	for(int i=0;i<size;i++) {
    		while(!done) {
    			try {
    	    		System.out.println("Enter coefficient: ");
    	    		coefficient= sc.nextInt();
        	    	 done=true;
        		}
        		catch(InputMismatchException e) {
        			sc.next();
        			System.out.println("Invalid input\n");
        		}
    		}
            done=false;
    		while(!done) {
    			try {
    	    		System.out.println("Enter exponent: ");
    	    		exponent= sc.nextInt();
        	    	 done=true;
        		}
        		catch(InputMismatchException e) {
        			sc.next();
        			System.out.println("Invalid input\n");
        		}
    		}
    		done=false;
    		array[i][0]=coefficient;
    		array[i][1]=exponent;
    	}
		a.setPolynomial(poly, array);
    }
    
 public static void main(String[] args) {
	 PolynomialSolver polynomial=new PolynomialSolver();
	 Scanner sc = new Scanner(System.in);
	 Boolean Exit = false;
	 while(! Exit) {
	 printMenu();
	 char choice = sc.next().charAt(0);
	 if(choice=='1') {
	    System.out.println("Insert the variable name: A, B or C");
        char poly = sc.next().charAt(0);
        scanArray(Character.toUpperCase(poly),polynomial);
	 }
	 else if(choice=='2') {
		 char poly=check("Insert the variable name: A, B, C or R", polynomial,choice);
		 System.out.println(poly+" value in "+poly+": "+polynomial.print(poly));
		 System.out.println("====================================================================");
	 }
	 else if(choice=='3') { 
       char poly=check("Insert first operand variable name: A, B or C", polynomial,choice);
       char poly2=check("Insert second operand variable name: A, B or C", polynomial,choice);
       int[][] result = polynomial.add(poly, poly2);
	   System.out.println("Result set in R: "+printArray(result));
	 }
	 else if(choice=='4') {
		       char poly=check("Insert first operand variable name: A, B or C", polynomial,choice);
		       char poly2=check("Insert second operand variable name: A, B or C", polynomial,choice);
		       int[][] result = polynomial.subtract(poly, poly2);
			   System.out.println("Result set in R: "+printArray(result));
	 }
	 else if(choice=='5') {	 
		       char poly=check("Insert first operand variable name: A, B or C", polynomial,choice);
		       char poly2=check("Insert second operand variable name: A, B or C", polynomial,choice);
		       int[][] result = polynomial.multiply(poly, poly2);
			   System.out.println("Result set in R: "+printArray(result));
	 }
	 else if(choice=='6') {
		 char poly=check("Insert the variable name: A, B, C or R", polynomial,choice);
		 Boolean done=false;
		 float value=0f;
		 while(!done) {
	    		try {
	    			System.out.println("Enter value of x");
	    	    	 value=sc.nextFloat();
	    	    	 done=true;
	    		}
	    		catch(InputMismatchException e) {
	    			sc.next();
	    			System.out.println("Invalid input\n");
	    		}
	    	}
		 System.out.println(polynomial.evaluatePolynomial(poly, value));
	 }
	 else if(choice=='7'){
		 char poly=check("Insert the variable name to clear: A, B, C or R", polynomial,choice);
		 polynomial.clearPolynomial(poly);
	 }
	 else if(choice=='8') {
		 Exit=true;
	 }
	 else {
		 System.out.println("Invalid input\n");
	 }
	 
 }
 }
}

