import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyFiles {
	
	public void writeToFile(String filename, List<Users> list) {
		
		try {

			File file = new File(filename);
		    // if file doesnt exists, then create it
		    if (!file.exists()) {
		      file.createNewFile();
		    }
		    

		    FileWriter fw = new FileWriter(file.getAbsoluteFile());
		    BufferedWriter bw = new BufferedWriter(fw);
		    
		    
		    for (int i = 0; i < list.size(); i++) {
		    	bw.write("");
		    	bw.write(""+list.get(i).getName()+" ");bw.write(""+list.get(i).getEmail()+" ");
		    	bw.write(""+list.get(i).getPhone()+" ");bw.write(""+list.get(i).getAge()+" ");
		    	bw.write(""+list.get(i).getAddress()+" ");
		    	bw.write(""+list.get(i).getGender()+" ");bw.write(""+list.get(i).getGymname()+" ");
				bw.write("\n");
				
			}
		   	
		   
		    
		    bw.close();
		    
		  } catch (IOException e1) {
		    e1.printStackTrace();
		  }
		
	}

	
	public void appendToFile(String filename, List<Users> list) {
		
		try {

			File file = new File(filename);
		    // if file doesnt exists, then create it
		    if (!file.exists()) {
		      file.createNewFile();
		    }
		    

		    FileWriter fw = new FileWriter(file.getAbsoluteFile());
		    BufferedWriter bw = new BufferedWriter(fw);
		    
		    
		    for (int i = 0; i < list.size(); i++) {
		    	bw.append("\n");
		    	bw.append(""+list.get(i).getName()+" ");bw.write(""+list.get(i).getEmail()+" ");
		    	bw.append(""+list.get(i).getPhone()+" ");bw.write(""+list.get(i).getAge()+" ");
		    	bw.append(""+list.get(i).getAddress()+" ");
		    	bw.append(""+list.get(i).getGender()+" ");bw.write(""+list.get(i).getGymname()+" ");
				bw.append("\n");
				
			}
		   	
		   
		    
		    bw.close();
		    
		  } catch (IOException e1) {
		    e1.printStackTrace();
		  }
		
	}

	
}
