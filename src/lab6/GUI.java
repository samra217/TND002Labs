package lab6;
			
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
						
public class GUI extends JFrame implements ActionListener {

	private Font myFont;
	private JButton load, save, search, next, add, delete;
	private JTextField searchField, nameField, numberField;
	
	private Phonebook myPhonebook = new Phonebook();
	
	
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
	}
	

	
	public static void main(String[] args) {
		GUI myGUI = new GUI();
		
	}



}
