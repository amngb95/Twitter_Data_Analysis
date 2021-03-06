package Phase1Package;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PBMDemo1 {
	public static void main(String[] args) {
		 
		// TODO Auto-generated method stub
			String iPath= args[0];//"C:\\Users\\Hiresh\\Desktop\\UMKC\\PBM\\Book1.csv";
			String oPath="C:\\Users\\Hiresh\\Desktop\\UMKC\\PBM\\Phase1_URLHashTags.txt";
			BufferedReader br = null;
			BufferedWriter bw=null;
	        String line = "";

	        try {

	            br = new BufferedReader(new FileReader(iPath));
	            bw=new BufferedWriter(new FileWriter(oPath,true));
	            while ((line = br.readLine()) != null) {
	                Pattern hashTag=Pattern.compile("([#]{1})([a-zA-Z0-9]+)");
	                Matcher mHash= hashTag.matcher(line);	
	                while(mHash.find())
	                {
	                System.out.print(mHash.group(0)+" ");
	                bw.append(mHash.group(0)+" ");
	                }
	                System.out.println("");
	                Pattern email=Pattern.compile("([w]{3})([.]{1})([a-zA-Z0-9]+)([.]{1})([a-zA-Z]+)");
	                Matcher mEmail= email.matcher(line);	
	                if(mEmail.find())
	                {
	                System.out.println(mEmail.group(0));
	                bw.append(mEmail.group(0)+" ");
	                }
	                
	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 
	}

}
