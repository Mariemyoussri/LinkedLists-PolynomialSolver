package eg.edu.alexu.csd.datastructure.linkedList.cs77_cs84;
import java.awt.Point;
import java.lang.Math;


public class PolynomialSolver implements IPolynomialSolver {
   SinglyLinkedLists A = new SinglyLinkedLists();
   SinglyLinkedLists B = new SinglyLinkedLists();
   SinglyLinkedLists C = new SinglyLinkedLists();
   SinglyLinkedLists R = new SinglyLinkedLists();
  public int size=0;

    public SinglyLinkedLists switchs(char poly) {
    	switch(poly) {
    	case 'A':
    		return A;
    	case 'B':
    		return B;
    	case 'C':
    		return C;
    	case'R':
    		return R;
    	}
		return null;
    }
    
    
   
    public void SortList(SinglyLinkedLists list) {
    	for (int i = 0; i < list.size; i++) {
            for (int j = i+1; j < list.size; j++) {
        		Point temp1 =(Point) list.get(i);
            	Point temp2 =(Point) list.get(j);
               if(temp1.y < temp2.y) {    
                   list.set(i, temp2);
                   list.set(j,temp1); 
               } 
            } 
        }
    }
    
    public void RemoveDuplicate(char poly) {
    	SinglyLinkedLists list = switchs(poly);
    	SortList(list);
    	for(int i=0; i<list.size-1; i++) {
    		Point temp =(Point) list.get(i);
    		if(temp.x==0) {
    			list.remove(i);
    			i--;
    		}
    		else {
    		Point temp1 =(Point) list.get(i+1);
    		if(temp1.x==0) {
    			list.remove(i+1);
    			i--;
    		}
    		else {
    		if(temp.y == temp1.y) {
    			    temp.x+=temp1.x;
    				list.set(i, temp);
    				list.remove(i+1);
    				i--;
    		}
    		}
    	}
    	}
    }

	public void arrayToList(int[][] terms,SinglyLinkedLists list) {
		for(int i=0;i<terms.length;i++) {
			Point exponent = new Point(terms[i][0],terms[i][1]);
			list.add(exponent);
		}
	}
	
	public int[][] listToArray(SinglyLinkedLists list) {
		int[][] terms=new int[list.size][2];
		for(int i=0;i<list.size();i++) {
			Point temp =(Point) list.get(i);
			terms[i][0]=temp.x;
			terms[i][1]=temp.y;
		}
		return terms;
	}
	
	public String term(Point p) {
		String temp;
		if(p.y==0) {
			temp=Integer.toString(p.x);
		}
		else if(p.y==1){
			if(p.x==1) {
				temp="x";
			}
			else if(p.x==-1) {
				temp="-x";
			}
			else {
				temp=p.x+"x";
			}
		}
		else {
			if(p.x==1) {
				temp="x^"+p.y;
			}
			else if(p.x==-1) {
				temp="-x^"+p.y;
			}
			else {
				temp=p.x+"x^"+p.y;
			}
		}

		return temp;
	}
	

	public String listToStringArray(SinglyLinkedLists list) {
		Point temp =(Point)list.get(0);
		String polynomial=term(temp);
		for(int i=1;i<list.size();i++) {
            temp=(Point)list.get(i);
            if(temp.x>0) {
            polynomial+=" + "+term(temp);
            }
            else {
            	 polynomial+=term(temp);	
            }
		}
		return polynomial;
	}
	
	
	
	@Override
	public void setPolynomial(char poly, int[][] terms) {
		SinglyLinkedLists list=switchs(poly);
		list.clear();
		arrayToList(terms,switchs(poly));
		RemoveDuplicate(poly);
	}

	@Override
	public String print(char poly) {
		return listToStringArray(switchs(poly));
	}

	@Override
	public void clearPolynomial(char poly) {
		SinglyLinkedLists temp=switchs(poly);
		temp.clear();
	}

	@Override
	public float evaluatePolynomial(char poly, float value) {
		SinglyLinkedLists temp=switchs(poly);
        int count=0;
        float evaluate=0;
        while(count<temp.size) {
        	Point points = (Point)temp.get(count);
        	evaluate+=(float)((float)points.x*Math.pow(value, points.y));
        	count++;		
        }
		return evaluate;
	}

	@Override
	public int[][] add(char poly1, char poly2) {
		R.clear();
		SinglyLinkedLists first = switchs(poly1);
		SinglyLinkedLists second = switchs(poly2);
		for(int i=0;i<first.size;i++) {
			Point temp1 = (Point) first.get(i);
			Point point = new Point();
			point.x=temp1.x;
			point.y=temp1.y;
			R.add(point);
		}
		for(int j=0;j<second.size;j++) {
			R.add(second.get(j));
		}
		RemoveDuplicate('R');
		RemoveDuplicate('R');
		if(R.isEmpty()) {
			Point t = new Point(0,0);
			R.add(t);
		}
		return listToArray(R);
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		R.clear();
		SinglyLinkedLists first = switchs(poly1);
		SinglyLinkedLists second = switchs(poly2);
		for(int i=0; i<first.size; i++) {
			Point temp1 = (Point) first.get(i);
			Point point = new Point();
			point.x=temp1.x;
			point.y=temp1.y;
			R.add(point);
		}
		for(int i=0; i<second.size; i++) {
			Point temp = (Point) second.get(i);
			Point point = new Point();
			point.x=temp.x*-1;
			point.y=temp.y;
			R.add(point);
		}
		RemoveDuplicate('R');
		RemoveDuplicate('R');
		if(R.isEmpty()) {
			Point t = new Point(0,0);
			R.add(t);
		}
		return listToArray(R);
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		R.clear();
		SinglyLinkedLists first = switchs(poly1);
		SinglyLinkedLists second = switchs(poly2);
		for(int i=0;i<first.size;i++) {
			Point temp = (Point)first.get(i);
			for(int j=0;j<second.size;j++) {
				Point temp2 = (Point)second.get(j);
				Point temp3 = new Point(temp.x*temp2.x,temp.y+temp2.y);
				R.add(temp3);
			}
			RemoveDuplicate('R');
		}
		RemoveDuplicate('R');
		if(R.isEmpty()) {
			Point t = new Point(0,0);
			R.add(t);
		}
		return listToArray(R);
	}

}
