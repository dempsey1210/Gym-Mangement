import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

	BorderPane root;
	VBox addusers; // holding the fields of users
	TextField[] fields = new TextField[7]; // for getting data from fields
	TextField staffs_name;
	PasswordField staffs_pass;
	Button register, verify;
	HBox topbar;
	boolean isStaff = false;
	
	Label status = new Label("Verify staff in order to Add Member!");
	
	Staff staff = new Staff("staff", "staff123", "staff@gmail.com", "343423", 18, "Asdf", "male", "GYM");
	
	TableColumn<String, Users> column1,column2,column3,column5,column6,column7;
	TableColumn<Integer, Users> column4;
	TableView tableView;
	
	final String FILE_NAME =  "members.txt";
	
	ArrayList<Users> list = new ArrayList<Users>();
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("Gym Management System");
		root = new BorderPane();
		register = new Button("Register Member");
		register.setTranslateY(20);
		register.setTranslateX(15);
		register.setDisable(true);
		
		//topbar
		topbar = new HBox();
		topbar.setPadding(new Insets(10));
		
		staffs_name = new TextField(); // staff username
		staffs_name.setPromptText("staff name");
		staffs_pass = new PasswordField(); //pass
		staffs_pass.setPromptText("staff password");
		
		topbar.getChildren().add(staffs_name);
		topbar.getChildren().add(staffs_pass);
		
		verify = new Button("Verify Staff");
		topbar.getChildren().add(verify);
		
		root.setTop(topbar);
		root.setBottom(status);
		
		status.setPadding(new Insets(10));
		
		//left bar
		addusers = new VBox();
		addusers.setPadding(new Insets(10));
		addusers.getChildren().add(new Label("Fill to Register"));
		
		for (int i = 0; i < fields.length; i++) {
			fields[i] = new TextField();
			addusers.getChildren().add(fields[i]);
			fields[i].setTranslateX(1);
			fields[i].setTranslateY(1 * 10);
		
		}
		
		fields[0].setPromptText("name");
		fields[1].setPromptText("email");
		fields[2].setPromptText("phone");
		fields[3].setPromptText("age");
		fields[4].setPromptText("address");
		fields[5].setPromptText("gender");
		fields[6].setPromptText("gym name");
		
		root.setLeft(addusers);
		addusers.getChildren().add(register);
		
		
		
		//table to display members data
		 	tableView = new TableView();

		    column1 = new TableColumn<>("name");
		    column1.setCellValueFactory(new PropertyValueFactory<>("name"));


		    column2 = new TableColumn<>("email");
		    column2.setCellValueFactory(new PropertyValueFactory<>("email"));


		    column3 = new TableColumn<>("phone");
		    column3.setCellValueFactory(new PropertyValueFactory<>("phone"));
		    

		    column4 = new TableColumn<>("age");
		    column4.setCellValueFactory(new PropertyValueFactory<>("age"));
		    

		    column5 = new TableColumn<>("address");
		    column5.setCellValueFactory(new PropertyValueFactory<>("address"));
		    
		   
		    column6 = new TableColumn<>("gender");
		    column6.setCellValueFactory(new PropertyValueFactory<>("gender"));
		    
		    column7 = new TableColumn<>("gymname");
		    column7.setCellValueFactory(new PropertyValueFactory<>("gymname"));

		    tableView.getColumns().add(column1);
		    tableView.getColumns().add(column2);tableView.getColumns().add(column3);
		    tableView.getColumns().add(column4);tableView.getColumns().add(column5);
		    tableView.getColumns().add(column6);tableView.getColumns().add(column7);
			/*
			 * tableView.getItems().add(new Person("John", "Doe"));
			 * tableView.getItems().add(new Person("Jane", "Deer"));
			 */

		    VBox vbox = new VBox(tableView);
		    root.setCenter(vbox);
		    
		    for (int i = 0; i < fields.length; i++) {
				fields[i].setDisable(true);
			}
		    
		    verify.setOnAction(e -> {
		    	
		    	String n =  staffs_name.getText().trim();
		    	String p = staffs_pass.getText().trim();
		    	
		    	if(n.equalsIgnoreCase(staff.getName()) && p.equalsIgnoreCase(staff.getPass())) {
		    		status.setText("Staff verification success!");
		    		register.setDisable(false);
		    		
		    		loadData();
		    		
		    		staffs_name.setText("");
		    		staffs_pass.setText("");
		    		
		    		for (int i = 0; i < fields.length; i++) {
						fields[i].setDisable(false);
					}
				    
		    	}else {
		    		status.setText("Staff verification failed, Try again!");
		    	}
		    	
		    	
		    });
		    
		  
		    register.setOnAction( e ->{
		    	
		    	try {
		    
		    	String name =  fields[0].getText().trim();
		    	String email = fields[1].getText().trim();
		    	String phone = fields[2].getText().trim();
		    	String a = fields[3].getText().trim();
		    	int age = Integer.parseInt(a);
		    	String addre = fields[4].getText().trim();
		    	String gender= fields[5].getText().trim();
		    	String gymname = fields[6].getText().trim();
		    	
		    	Users u = new Users(name, email, phone, age, addre, gender, gymname);
		   
		    	list.add(u);
		    	
		    	 
		    	MyFiles mf = new MyFiles();
		    	mf.writeToFile(FILE_NAME, list); // write to file
		    	

		    	
				for (int i = 0; i < fields.length; i++) {
					fields[i].setText(""); // setting empty
				}
		    	
				 int age1 = list.get(list.size()-1).getAge();
				 tableView.getItems().add(new  Users(list.get(list.size()-1).getName(),list.get(list.size()-1).getEmail(),list.get(list.size()-1).getPhone(),age1,list.get(list.size()-1).getAddress(),list.get(list.size()-1).getGender(),list.get(list.size()-1).getGymname()));   
				    
				
				
		    	
		    	}catch (Exception ex) {
					// TODO: handle exception
		    		System.out.println(ex.getMessage());
				}
		    	
		    	
		    });
		
		Scene sc = new Scene(root,730,500);
		stage.setScene(sc);
		stage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	
	void loadData() {
		
		
		try {
			//reads object for every line
			Scanner s1 = new Scanner(new File(FILE_NAME));
			
			while (s1.hasNextLine()) {
				
			    String[] split = s1.nextLine().split(" "); //splitting with space to get the data of perticular column
			    //Integer.parseInt -> converts string to int
			  
			    
			    tableView.getItems().add(new Users(split[0],split[1],split[2],Integer.parseInt(split[3]),split[4],split[5],split[6]));   
			    
			    Users u = new Users(split[0],split[1],split[2],Integer.parseInt(split[3]),split[4],split[5],split[6]);
			    list.add(u);
			    
			}
			
			
			
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	
		
		
		
		
	}

}
