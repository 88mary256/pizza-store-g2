package pizzeria.gui;

import javax.swing.*;

import pizzeria.business.OrderItem;
import pizzeria.data.IngredientType;
import pizzeria.data.PizzaTypes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumSet;

public class Panel extends JPanel implements ActionListener{
    JButton ordenarButton = new JButton("Registrar Orden");
    JButton addButton = new JButton("Add Pizza");
    public Panel() {
	setBackground(SystemColor.window);
	//setLayout(new FlowLayout(FlowLayout.RIGHT));
	setLayout(new BorderLayout(5,5));
	add(ordenarButton,BorderLayout.SOUTH);
	ordenarButton.addActionListener(this);
	add(addButton,BorderLayout.EAST);
	addButton.addActionListener(this);
	
	JComboBox comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel( PizzaTypes.values() ));
	comboBox.setSelectedIndex(0);
	add(comboBox, BorderLayout.NORTH);
	comboBox.addActionListener(this);
	
	JComboBox Ingredients = new JComboBox();
	Ingredients.setModel(new DefaultComboBoxModel( IngredientType.values() ));
	Ingredients.setSelectedIndex(0);
	add(Ingredients, BorderLayout.WEST);
	Ingredients.addActionListener(this);
    }
    public void paintComponent(Graphics g) {
	super.paintComponents(g);
	g.drawString("Welcome to Jala Pizza", 200, 100);
	g.drawRect(185, 85, 200, 20);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
	Object whichButton = e.getSource();
	final ArrayList<OrderItem> order = new ArrayList<OrderItem>();
	if(whichButton == ordenarButton) {
	System.out.println("Calculate cost and Billing");
	}else if (whichButton == addButton) {
	    order.add(new OrderItem(1, PizzaTypes.VEGGIE_PIZZA));
	    System.out.println("Item Added");
	}
    }
    
}
