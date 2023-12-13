package lab6;
			
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
						
public class GUI extends JFrame implements ActionListener {

	private Font myFont;
	private JButton load, save, search, next, add, delete;
	private JTextField searchField, nameField, numberField;
	
	private Phonebook myPhonebook = new Phonebook();
	
	private int personCounter = 0;
	private ArrayList<Person> personArr;
	
	boolean readAddPerson = false;
	
	public GUI() {
		this.setTitle("Interactive phone book");
		myFont = new Font("SansSerif", Font.PLAIN, 20);
		
		
		load = new JButton("Load phonebook");
		load.setFont(myFont);
		load.addActionListener(this);
		
		save = new JButton("Save phonebook");
		save.setFont(myFont);
		save.addActionListener(this);
		
		search = new JButton("Search");
		search.setFont(myFont);
		search.addActionListener(this);
		
		next = new JButton("Next name");
		next.setFont(myFont);
		next.addActionListener(this);
		
		add = new JButton("Add person");
		add.setFont(myFont);
		add.addActionListener(this);
		
		delete = new JButton("Delete person");
		delete.setFont(myFont);
		delete.addActionListener(this);
		
		save.setEnabled(false);
		search.setEnabled(false);
		next.setEnabled(false);
		add.setEnabled(false);
		delete.setEnabled(false);
		
		
		
		searchField = new JTextField();
		searchField.setFont(myFont);
		searchField.addActionListener(this);
		
		nameField = new JTextField();
		nameField.setFont(myFont);
		
		numberField = new JTextField();
		numberField.setFont(myFont);
		
		
		numberField.setEditable(false);
		nameField.setEditable(false);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setLayout(new GridLayout(3,2));
		
		JPanel panelRight = new JPanel();
		panelRight.setLayout(new GridLayout(3,1));
		
		panelLeft.add(load);
		panelLeft.add(save);
		panelLeft.add(search);
		panelLeft.add(next);
		panelLeft.add(add);
		panelLeft.add(delete);
		
		panelRight.add(searchField);
		panelRight.add(nameField);
		panelRight.add(numberField);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(1,2));
		c.add(panelLeft);
		c.add(panelRight);
		pack();
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		if (e.getSource() == load || e.getSource()== searchField) {
			String searchString = searchField.getText();
			searchField.setText("");
			nameField.setText(myPhonebook.load(searchString));
			
			if(nameField.getText().equals("Phone book loaded")) {
				save.setEnabled(true);
				search.setEnabled(true);
				add.setEnabled(true);
				delete.setEnabled(true);
			}
		}
		
		if (e.getSource() == save) {
			String searchString = searchField.getText();
			searchField.setText("");
			if(searchString.isEmpty()) {
				nameField.setText("Provide a file name");
			}
			else {
				nameField.setText(myPhonebook.save(searchString));
			}
			
		}
		
		
		if (e.getSource() == search) {
			String searchString = searchField.getText();
			searchField.setText("");
			
			personArr = myPhonebook.search(searchString);
			if (personArr.size() == 0) {
				nameField.setText("Provide a name");
				numberField.setText("");
			}
			else if (personArr.size() == 1){
				nameField.setText(personArr.get(0).getFullName());
				try {
					numberField.setText(Integer.toString(personArr.get(0).getPhoneNumber()));
				} catch (NumberFormatException ierr) {}
				
			}
			else {
				next.setEnabled(true);
				personCounter = 0;			
				
				nameField.setText(personArr.get(personCounter).getFullName());
				try {
					numberField.setText(Integer.toString(personArr.get(personCounter).getPhoneNumber()));
				} catch (NumberFormatException ierr) {}
			}
			
		}
		if (e.getSource() == next) {
			personCounter++;
			if (personCounter >= personArr.size()) {
				personCounter = 0;
				next.setEnabled(false);
			}
			nameField.setText(personArr.get(personCounter).getFullName());
			try {
				numberField.setText(Integer.toString(personArr.get(personCounter).getPhoneNumber()));
			} catch (NumberFormatException ierr) {}
			
		}
		
		
		
		if (e.getSource() == delete) {
			String deleteName = nameField.getText();
			try {
				Integer deleteInt = Integer.parseInt(numberField.getText());
				searchField.setText(myPhonebook.deletePerson(deleteName, deleteInt));
			} catch(NumberFormatException ierr) {
				searchField.setText("Person/number does not exist");
			}
			
		}
		
		if (e.getSource() == add) {
			if(!readAddPerson) {
				nameField.setText("");
				numberField.setText("");
				searchField.setText("Type in name and phonenumber");
				searchField.setEditable(false);
				
				nameField.setEditable(true);
				numberField.setEditable(true);
				readAddPerson = true;
			} else {
				try {
					boolean personAdded = myPhonebook.addPerson(nameField.getText(), Integer.parseInt(numberField.getText()));
					
					
					nameField.setText("");
					nameField.setEditable(false);
					
					numberField.setText("");
					numberField.setEditable(false);
					
					searchField.setEditable(true);
					
					if (personAdded) {
						searchField.setText("Person added");
					}else {
						searchField.setText("Person could not be added");
					}
					readAddPerson = false;
				} catch(NumberFormatException ierr) {}
				
				
				
			}
		}
		
	
	}
	

	
	public static void main(String[] args) {
		GUI myGUI = new GUI();
		
	}



}
