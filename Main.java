

public class Main {

    public static void main(String[] args) {
       // Test tst = new Test();
       //char[] ch = {'t', 'h', 'e', ' ', 'd', 'o', 'g', ' ', ' ', ' ', ' ', ' ', ' '};
        
       //int length = 7;//the dog there are 7 chars
       // replaceSpaces(ch, length); 
    	System.out.println(compression3("aaaaaaaaaaaabbbccdde"));
    	System.out.println(countCompression("aaaaaaaaaaaabbbccdde"));
    }
    //perform basic string compression using the counts of repeated chars
    //aabcccccaaa -> a2b1c5a3
    
    public static String compression(String str){
    	if(str==null||str.length()<2)return str;
    	String s="";
    	char last=str.charAt(0);//record the last element, keep update it
    	int count=1;
    	for(int i=1;i<str.length();i++){
    		if(str.charAt(i)==last){
    			count++;
    		}else{
    			s=s+last+count;//char could be plus to a string
    			//string concatenation operates in O(k^2)
    			last=str.charAt(i);
    			count=1;
    		}
    	}
    	s=s+last+count;
    	
    	if(s.length()>str.length())return str;
    	return s;
    }// time O(n+k^2) space O(n)
    
    //Use StringBuffer
    public static String compression2(String str){
    	if(str==null) return str;
    	if( str.length()<=countCompression(str)) return str;
    	
    	StringBuffer sb=new StringBuffer();
    	int count=1;
    	char last=str.charAt(0);
    	for(int i=1;i<str.length();i++){
    		if(str.charAt(i)==last){
    			count++;
    		}else{
    			sb.append(last);
    			sb.append(count);
    			last=str.charAt(i);
    			count=1;
    		}
    	}
    	sb.append(last);
		sb.append(count);

    	return sb.toString();
    }//time O(n) space O(n)
    
    public static int countCompression(String str){
    	if(str==null || str.isEmpty()) return 0;
    	char last=str.charAt(0);
    	int size=0,count=1;
    	for(int i=1;i<str.length();i++){
    		if(str.charAt(i)==last){
    			count++;
    		}else{
    			last=str.charAt(i);
    			size = size+1+String.valueOf(count).length();
    			count=1;
    		}
    	}
    	size = size+1+String.valueOf(count).length();//11 takes 2 spaces, 102 takes 3 spaces
    	return size;

    }

    //we could also use an array to store the new string
    //char[] a=new char[countCompression(str)];
    //copy the char of string and the count string to this array
    
    public static String compression3(String str){
    	int size=countCompression(str);
    	if(size>=str.length()) return str;
    	char[] a=new char[size];
    	char last=str.charAt(0);
    	int count=1;
    	int index=0;
    	for(int i=1;i<str.length();i++){
    		if(str.charAt(i)==last){
    			count++;
    		}else{
    			index=setChar(a,last,index,count);
    			last=str.charAt(i);
    			count=1;
    		}
    	}
    	index=setChar(a,last,index,count);
    	return String.valueOf(a);

    }
    
    public static int setChar(char[] a, char last, int index, int count){
    	a[index]=last;
    	index++;
    	char[] cnt=String.valueOf(count).toCharArray();
    	for(char c:cnt){
    		a[index]=c;
    		index++;
    	}
    	return index;
    }


}