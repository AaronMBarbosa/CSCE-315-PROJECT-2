package serverview;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class serverview implements ActionListener{
	
	static int n1 = 0;
	static int n2 = 0;
	static int n3 = 0;
	static int n4 = 0;
	static int n5 = 0;
	static int n6 = 0;
	static int n7 = 0;
	static int n8 = 0;
	static int n9 = 0;
	static int n10 = 0;
	static int n11 = 0;
	static int n12 = 0;
	static int n13 = 0;
	static int n14 = 0;
	static int n15 = 0;
	static int n16 = 0;
	static int n17 = 0;
	static int n18 = 0;
	static int n19 = 0;
	static int n20 = 0;
	static int n21 = 0;
	static int n22 = 0;
	static int n23 = 0;
	static int n24 = 0;

	private static JTextField textField;

    public static void main(String[] args) {
        showWindow();
    }

    public static void showWindow() {
    	
        JFrame serv = new JFrame("Server View");
        serv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create a object
        GUI s2 = new GUI();
        serv.setSize(800, 600);
        
        JLabel lblNewLabel = new JLabel("Customer Order");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        
        JLabel lblNewLabel_1 = new JLabel("Customer Name:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        textField = new JTextField();
        textField.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Event ID:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JButton btnNewButton = new JButton("Veiw Events");
        
        JLabel lblNewLabel_3 = new JLabel("Date:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JLabel lblNewLabel_4 = new JLabel("TODAYS DATE");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JLabel lblNewLabel_5 = new JLabel("Payment Type:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("Cash");
        
        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Credit");
        
        JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Debit");
        
        JLabel lblNewLabel_6 = new JLabel("Meals:");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JCheckBox chckbxNewCheckBox_3 = new JCheckBox("5 Finger Meal");
        
        JCheckBox chckbxNewCheckBox_4 = new JCheckBox("4 Finger Meal");
        
        JCheckBox chckbxNewCheckBox_5 = new JCheckBox("3 Finger Meal");
        
        JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Kids Meal");
        
        JCheckBox chckbxNewCheckBox_7 = new JCheckBox("Gallon of Tea");
        
        JCheckBox chckbxNewCheckBox_8 = new JCheckBox("Family Pack");
        
        JLabel lblNewLabel_7 = new JLabel("Drinks:");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JLabel lblNewLabel_8 = new JLabel("Individual Items:");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JLabel lblNewLabel_9 = new JLabel("Sides:");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JCheckBox chckbxNewCheckBox_9 = new JCheckBox("Fountain Drink");
        
        JCheckBox chckbxNewCheckBox_10 = new JCheckBox("Bottle Drink");
        
        JCheckBox chckbxNewCheckBox_11 = new JCheckBox("Club Sandwich Only");
        
        JCheckBox chckbxNewCheckBox_12 = new JCheckBox("Chicken Sandwich");
        
        JCheckBox chckbxNewCheckBox_13 = new JCheckBox("Grill Cheese Sandwhich");
        
        JCheckBox chckbxNewCheckBox_14 = new JCheckBox("Chicken Finger");
        
        JCheckBox chckbxNewCheckBox_15 = new JCheckBox("Club Sandwich Meal");
        
        JCheckBox chckbxNewCheckBox_16 = new JCheckBox("Grill Cheese Meal");
        
        JCheckBox chckbxNewCheckBox_17 = new JCheckBox("Sandwich Meal");
        
        JCheckBox chckbxNewCheckBox_18 = new JCheckBox("Layne's Sauce");
        
        JCheckBox chckbxNewCheckBox_19 = new JCheckBox("Texas Toast");
        
        JCheckBox chckbxNewCheckBox_20 = new JCheckBox("Potato Salad");
        
        JCheckBox chckbxNewCheckBox_21 = new JCheckBox("Crinkle Cut Fries");
        
        JLabel lblNewLabel_10 = new JLabel("Managers Specials:");
        lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JCheckBox chckbxNewCheckBox_22 = new JCheckBox("Special 1");
        
        JCheckBox chckbxNewCheckBox_23 = new JCheckBox("Special 2");
        
        JCheckBox chckbxNewCheckBox_24 = new JCheckBox("Special 3");
        
        JCheckBox chckbxNewCheckBox_25 = new JCheckBox("Special 4");
        JButton btnNewButton_1 = new JButton("Place Order");
        
        
        
        chckbxNewCheckBox_3.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_3, "How many Items are being added? ");
        		n1 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_4.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_4, "How many Items are being added? ");
        		n2 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_5.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_5, "How many Items are being added? ");
        		n3 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_6.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_6, "How many Items are being added? ");
        		n4 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_7.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_7, "How many Items are being added? ");
        		n5 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_8.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_8, "How many Items are being added? ");
        		n6 = Integer.parseInt(str);
        	}
        });
        chckbxNewCheckBox_9.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_9, "How many Items are being added? ");
        		n7 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_10.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_10, "How many Items are being added? ");
        		n8 = Integer.parseInt(str);
        	}
        });
        
        
        chckbxNewCheckBox_11.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_11, "How many Items are being added? ");
        		n9 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_12.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_12, "How many Items are being added? ");
        		n10 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_13.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_13, "How many Items are being added? ");
        		n11 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_14.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_14, "How many Items are being added? ");
        		n12 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_15.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_15, "How many Items are being added? ");
        		n13 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_16.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_16, "How many Items are being added? ");
        		n14 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_17.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_17, "How many Items are being added? ");
        		n15 = Integer.parseInt(str);
        	}
        });
        //
        
        chckbxNewCheckBox_18.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_18, "How many Items are being added? ");
        		n16 = Integer.parseInt(str);
        	}
        });
        
        
        chckbxNewCheckBox_19.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_19, "How many Items are being added? ");
        		n17 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_20.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_20, "How many Items are being added? ");
        		n18 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_21.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_21, "How many Items are being added? ");
        		n19 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_22.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_22, "How many Items are being added? ");
        		n20 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_23.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_23, "How many Items are being added? ");
        		n21 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_24.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_24, "How many Items are being added? ");
        	    n22 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_25.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_25, "How many Items are being added? ");
        		n23 = Integer.parseInt(str);
        	}
        });
        
        btnNewButton_1.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
            	float subtot1 = 0, subtot2 = 0, subtot3 = 0, subtot4 = 0, subtot5 = 0, subtot6 = 0, subtot7 = 0, subtot8 = 0, 
            			subtot9 = 0, subtot10 = 0, subtot11 = 0, subtot12 = 0, subtot13 = 0, subtot14 = 0, subtot15 = 0, subtot16 = 0, 
            			subtot17 = 0, subtot18 = 0, subtot19 = 0, subtot20 = 0, subtot21 = 0, subtot22 = 0, subtot23 = 0, subtot24 = 0, 
            			subtot25 = 0;
            	String submsg1 = " ", submsg2 = " ", submsg3 = " ", submsg4 = " ", submsg5 = " ", submsg6 = " ", submsg7 = " ", 
            			submsg8 = " ", submsg9 = " ", submsg10 = " ", submsg12 = " ", submsg13 = " ", submsg14 = " ", submsg15 = " ", submsg16 = " ",
            					submsg17 = " ", submsg18 = " ", submsg19 = " ", submsg20 = " ", submsg21 = " ", submsg22 = " ", submsg23 = " ", submsg24 = " ",
            							 submsg25 = " ", submsg11 = " ";
            	
            	
            	if(chckbxNewCheckBox_3.isSelected()) {
            		subtot1 = (float) (5.5*n1);
            		submsg1 = "4 Finger Meal";
            	}
            	if(chckbxNewCheckBox_4.isSelected()) {
            		subtot2 = (float) (6.5*n2);
            		submsg2 = "5 Finger Meal";
            	}
            	if(chckbxNewCheckBox_5.isSelected()) {
            		subtot3 = (float) (4.5*n3);
            		submsg3 = "3 Finger Meal";
            	}
            	if(chckbxNewCheckBox_6.isSelected()) {
            		subtot4 = (float) (2.5*n4);
            		submsg4 = "Kids Meal";
            	}
            	if(chckbxNewCheckBox_7.isSelected()) {
            		subtot5 = (float) (5*n5);
            		submsg5 = "Gallon of Tea";
            	}
            	if(chckbxNewCheckBox_8.isSelected()) {
            		subtot6 = (float) (32.0*n6);
            		submsg6 = "Family Pack";
            	}
            	if(chckbxNewCheckBox_9.isSelected()) {
            		subtot7 = (float) (4.5*n7);
            		submsg7 = "Fountain Drink";
            	}
            	if(chckbxNewCheckBox_10.isSelected()) {
            		subtot8 = (float) (2.0*n8);
            		submsg8 = "Bottle Drink";
            	}
            	
            	
            	if(chckbxNewCheckBox_11.isSelected()) {
            		subtot9 = (float) (3.75*n9);
            		submsg9 = "Club Sandwich Only";
            	}
            	if(chckbxNewCheckBox_13.isSelected()) {
            		subtot10 = (float) (3.5*n10);
            		submsg10 = "Grill Cheese Sandwich";
            	}
            	if(chckbxNewCheckBox_14.isSelected()) {
            		subtot11 = (float) (1.5*n11);
            		submsg11 = "Chicken Finger";
            	}
            	if(chckbxNewCheckBox_15.isSelected()) {
            		subtot12 = (float) (5.75*n12);
            		submsg12 = "Club Sandwich Meal";
            	}
            	if(chckbxNewCheckBox_16.isSelected()) {
            		subtot13 = (float) (4.5*n13);
            		submsg13 = "Grill Cheese Meal";
            	}
            	if(chckbxNewCheckBox_17.isSelected()) {
            		subtot14 = (float) (32.0*n14);
            		submsg14 = "Sandwich Meal";
            	}
            	if(chckbxNewCheckBox_18.isSelected()) {
            		subtot15 = (float) (0.1*n15);
            		submsg15 = "Layne's Sauce";
            	}
            	if(chckbxNewCheckBox_19.isSelected()) {
            		subtot16 = (float) (0.5*n16);
            		submsg16 = "Texas Toast";
            	}
            	
            	if(chckbxNewCheckBox_20.isSelected()) {
            		subtot17 = (float) (1.5*n17);
            		submsg17 = "Potato Salad";
            	}
            	if(chckbxNewCheckBox_21.isSelected()) {
            		subtot18 = (float) (1.75*n18);
            		submsg18 = "Crinkle Cut Fries";
            	}
            	float total = subtot1+subtot2+subtot3+subtot4+subtot5+subtot6+subtot7+subtot8+subtot9+subtot10+subtot11+subtot12+
            			subtot13+subtot14+subtot15+subtot16+subtot17+subtot18;
            	JOptionPane.showMessageDialog(null, submsg1+ " : " + subtot1 + "\n" + submsg2+ " : " + subtot2 + "\n" + 
            			submsg3+ " : " + subtot3 + "\n" + submsg4+ " : " + subtot4 + "\n" + 
            			submsg5+ " : " + subtot5 + "\n" + submsg6+ " : " + subtot6 + "\n" + 
            			submsg7+ " : " + subtot7 + "\n" + submsg8+ " : " + subtot8 + "\n" + 
            			submsg9+ " : " + subtot9 + "\n" + submsg10+ " : " + subtot10 + "\n" + 
            			submsg11+ " : " + subtot11 + "\n" + submsg12+ " : " + subtot12 + "\n" + 
            			submsg13+ " : " + subtot13 + "\n" + submsg14+ " : " + subtot14 + "\n" + 
            			submsg15+ " : " + subtot15 + "\n" + submsg16+ " : " + subtot16 + "\n" + 
            			submsg17+ " : " + subtot17 + "\n" + submsg18+ " : " + subtot18 + "\n" +
            			"TOTAL: " + total);
        	
        }
        });
        
        
        
        
        
        GroupLayout groupLayout = new GroupLayout(serv.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnNewButton))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
        									.addComponent(chckbxNewCheckBox_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addComponent(chckbxNewCheckBox_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
        									.addComponent(chckbxNewCheckBox_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        								.addComponent(lblNewLabel_6))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        								.addComponent(chckbxNewCheckBox_10, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        									.addComponent(lblNewLabel_7)
        									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        										.addComponent(chckbxNewCheckBox_7, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
        										.addComponent(chckbxNewCheckBox_9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        						.addComponent(chckbxNewCheckBox_6, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(lblNewLabel_8, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        						.addComponent(chckbxNewCheckBox_12)
        						.addComponent(chckbxNewCheckBox_11, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
        						.addComponent(chckbxNewCheckBox_13, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
        						.addComponent(chckbxNewCheckBox_14, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(lblNewLabel_9)
        						.addComponent(chckbxNewCheckBox_18, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        						.addComponent(chckbxNewCheckBox_21, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        						.addComponent(chckbxNewCheckBox_20, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(chckbxNewCheckBox_19, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(chckbxNewCheckBox_25, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
        						.addComponent(chckbxNewCheckBox_24, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
        						.addComponent(chckbxNewCheckBox_23, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
        						.addComponent(chckbxNewCheckBox_22, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_10)))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addComponent(lblNewLabel_5)
        							.addGap(18)
        							.addComponent(chckbxNewCheckBox)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(chckbxNewCheckBox_1))
        						.addComponent(chckbxNewCheckBox_8, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
        						.addComponent(chckbxNewCheckBox_17, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
        						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(chckbxNewCheckBox_15, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(chckbxNewCheckBox_16, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(chckbxNewCheckBox_2))
        				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel)
        			.addGap(15)
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblNewLabel_1)
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel_2)
        				.addComponent(btnNewButton))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_3)
        				.addComponent(lblNewLabel_4))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_5)
        				.addComponent(chckbxNewCheckBox)
        				.addComponent(chckbxNewCheckBox_1)
        				.addComponent(chckbxNewCheckBox_2))
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_6)
        				.addComponent(lblNewLabel_9)
        				.addComponent(lblNewLabel_8)
        				.addComponent(lblNewLabel_10)
        				.addComponent(lblNewLabel_7))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(chckbxNewCheckBox_3)
        				.addComponent(chckbxNewCheckBox_7)
        				.addComponent(chckbxNewCheckBox_11)
        				.addComponent(chckbxNewCheckBox_18)
        				.addComponent(chckbxNewCheckBox_22))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(chckbxNewCheckBox_4)
        				.addComponent(chckbxNewCheckBox_9)
        				.addComponent(chckbxNewCheckBox_19)
        				.addComponent(chckbxNewCheckBox_23)
        				.addComponent(chckbxNewCheckBox_12))
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(2)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(chckbxNewCheckBox_5)
        						.addComponent(chckbxNewCheckBox_10))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(chckbxNewCheckBox_6)
        						.addComponent(chckbxNewCheckBox_14))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(chckbxNewCheckBox_8))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(chckbxNewCheckBox_20)
        						.addComponent(chckbxNewCheckBox_24)
        						.addComponent(chckbxNewCheckBox_13))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(chckbxNewCheckBox_21)
        						.addComponent(chckbxNewCheckBox_25))))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(chckbxNewCheckBox_15)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(chckbxNewCheckBox_16)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(chckbxNewCheckBox_17)
        			.addGap(37)
        			.addComponent(btnNewButton_1)
        			.addGap(102))
        );
        
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.setLabel("EVENTS");
        addPopup(btnNewButton, popupMenu);
        serv.getContentPane().setLayout(groupLayout);

        serv.setVisible(true);
     }
	
    

    private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
