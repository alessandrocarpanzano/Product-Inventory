/**
 *
 * @author Alessandro Carpanzano
 */
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class ProductGUI extends JFrame implements ActionListener
{               
        private JDialog AddJFrame = new JDialog();
        private JDialog SellJFrame = new JDialog();
        private JDialog ModifyJFrame = new JDialog();
        private JDialog AboutAppJframe = new JDialog();
        
                //textfields
        private JTextField productNameText = new JTextField(15);
        private JTextField productPriceText = new JTextField(15);
        private JTextField productStockLevelText = new JTextField(15);
        private JTextField quantitySellText = new JTextField(15);
        private JTextField productNameText1 = new JTextField(15);
        private JTextField productPriceText1 = new JTextField(15);
        private JTextField productStockLevelText1 = new JTextField(15);
        
        
        
                //menu
        private JMenuBar bar = new JMenuBar();
        private JMenu productMenu = new JMenu("Product");
        private JMenu infoMenu = new JMenu("Info");
        private JMenuItem addProductItem = new JMenuItem("Add");
	private JMenuItem modifyProductItem = new JMenuItem("Modify");
	private JMenuItem removeProductItem = new JMenuItem("Remove");
        private JMenuItem sellProductItem = new JMenuItem("Sell");
        private JMenuItem aboutApp = new JMenuItem("About App");
        
                //Buttons
        private JButton sellButton = new JButton("Sell");
        private JButton sellButton1 = new JButton("Sell");
        private JButton addButton = new JButton("Add");
        private JButton modifyButton = new JButton("Modify");
        private JButton removeButton = new JButton("Remove");
        private JButton addButton1 = new JButton("Add");
        private JButton cancelButton = new JButton("Cancel");
        private JButton cancelButton1 = new JButton("Cancel");
        private JButton cancelButton2 = new JButton("Cancel");
        private JButton modifyButton1 = new JButton("Modify");
        
                //Labels
        private JLabel productName = new JLabel("Product Name: ");
        private JLabel productPrice = new JLabel("Price: ");
        private JLabel productStockLevel = new JLabel("Stock level: ");
        private JLabel productName1 = new JLabel("Set name: ");
        private JLabel productPrice1 = new JLabel("Set price: ");
        private JLabel productStockLevel1 = new JLabel("Re stock: ");
        private JLabel productNameInfo = new JLabel("");
        private JLabel productStockLevelInfo = new JLabel("");
        private JLabel productPriceInfo = new JLabel("");
        private JLabel quantitySellLabel = new JLabel("Quantity to sell: ");
        private JLabel productListLabel = new JLabel("Products List");
        private JLabel productInformationLabel = new JLabel("PRODUCT INFORMATION");
        private JLabel productUpdated = new JLabel("");
        
             
		//panels
	private JPanel topPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private JPanel middlePanel = new JPanel();
        
                //List
        private JScrollPane scrollPane;
        private JList<String> listArray;
        private DefaultListModel modelList = new DefaultListModel();
        
		//collection object
	private ProductCollection collection;
        
        
        
        
		//constructor
	public ProductGUI() {
        setTitle("Product Inventory Alessandro Carpanzano 1800996");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      
        
        
        
            //AddJFrame
        AddJFrame.setTitle("Add Product");
        AddJFrame.setSize(300,300);
        AddJFrame.setLayout(null);
        AddJFrame.add(addButton1);
        addButton1.setBounds(170, 200, 75, 30);
        addButton1.addActionListener(this);
        AddJFrame.add(productNameText);
        AddJFrame.add(productStockLevelText);
        AddJFrame.add(productPriceText);
        AddJFrame.add(cancelButton);
        cancelButton.addActionListener(this);
        cancelButton.setBounds(50, 200, 75, 30);
        AddJFrame.add(productName);
        productName.setBounds(40, 13, 90, 15);
        productNameText.setBounds(140, 10, 90, 20);
        AddJFrame.add(productStockLevel);
        productStockLevel.setBounds(40, 30, 100, 100);
        productStockLevelText.setBounds(140, 70, 90, 20);
        AddJFrame.add(productPrice);
        productPrice.setBounds(40, 95, 100, 100);
        productPriceText.setBounds(140, 135, 90, 20);
        AddJFrame.setResizable(false);
        
        //ModifyJFrame
        ModifyJFrame.setTitle("Modify Product");
        ModifyJFrame.setSize(300,300);
        ModifyJFrame.setLayout(null);
        ModifyJFrame.add(modifyButton1);
        modifyButton1.setBounds(170, 200, 80, 30);
        modifyButton1.addActionListener(this);
        ModifyJFrame.add(productNameText1);
        ModifyJFrame.add(productStockLevelText1);
        ModifyJFrame.add(productPriceText1);                    
        ModifyJFrame.add(cancelButton2);
        cancelButton2.addActionListener(this);
        cancelButton2.setBounds(50, 200, 80, 30);
        ModifyJFrame.add(productName1);
        productName1.setBounds(40, 13, 90, 15);
        productNameText1.setBounds(140, 10, 90, 20);
        ModifyJFrame.add(productStockLevel1);
        productStockLevel1.setBounds(40, 30, 100, 100);
        productStockLevelText1.setBounds(140, 70, 90, 20);
        ModifyJFrame.add(productPrice1);
        productPrice1.setBounds(40, 95, 100, 100);
        productPriceText1.setBounds(140, 135, 90, 20);
        ModifyJFrame.setResizable(false);
        

        //SellJFrame
        SellJFrame.setTitle("Sell Product");
        SellJFrame.setSize(300, 200);
        SellJFrame.setLayout(null);
        SellJFrame.add(sellButton1);
        sellButton1.setBounds(150,110,80,30);
        cancelButton1.setBounds(50,110,80,30);
        SellJFrame.add(quantitySellText);
        quantitySellText.setBounds(150, 40, 80, 30);
        quantitySellLabel.setBounds(50, 40, 90, 30);
        SellJFrame.add(quantitySellLabel);
        SellJFrame.add(cancelButton1);
        cancelButton1.addActionListener(this);
        SellJFrame.setResizable(false);
        
        //AboutAppJframe
        AboutAppJframe.setTitle("About App");
        AboutAppJframe.setSize(300,300);
        AboutAppJframe.setLayout(null);
        
        //frameposition
        AddJFrame.setLocation(dim.width/2-AddJFrame.getSize().width/2, dim.height/2-AddJFrame.getSize().height/2);
        SellJFrame.setLocation(dim.width/2-SellJFrame.getSize().width/2, dim.height/2-SellJFrame.getSize().height/2);
        ModifyJFrame.setLocation(dim.width/2-ModifyJFrame.getSize().width/2, dim.height/2-ModifyJFrame.getSize().height/2);
        //Menu
        setJMenuBar(bar);
        bar.add(productMenu);
        productMenu.add(addProductItem);
        productMenu.add(modifyProductItem);
        productMenu.add(sellProductItem);
        productMenu.add(removeProductItem);
        addProductItem.addActionListener(this);
        modifyProductItem.addActionListener(this);
        sellProductItem.addActionListener(this);
        removeProductItem.addActionListener(this);
        aboutApp.addActionListener(this);
        bar.add(infoMenu);
        infoMenu.add(aboutApp);
        
        //Panels Layout
        add(BorderLayout.NORTH, topPanel);
        add(BorderLayout.SOUTH, bottomPanel);
        topPanel.setBackground(Color.white);
        topPanel.setPreferredSize(new Dimension(250, 250));
        topPanel.setLayout(null);
        bottomPanel.setLayout(null);
        bottomPanel.setBackground(Color.LIGHT_GRAY);
        bottomPanel.setPreferredSize(new Dimension(250, 250));
        
        
        //TopPanel buttons
        topPanel.add(productListLabel);
        productListLabel.setBounds(50, 1, 80, 30);
        topPanel.add(addButton);
        removeButton.setBounds(350, 190, 80, 30);
        topPanel.add(modifyButton);
        sellButton.setBounds(250, 190, 80, 30);
        topPanel.add(removeButton);
        addButton.setBounds(50, 190, 80, 30);
        topPanel.add(sellButton);
        modifyButton.setBounds(150, 190, 80, 30);
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        sellButton.addActionListener(this);
        modifyButton.addActionListener(this);
        
        
        
            //topPanel list
        	scrollPane = new JScrollPane();
                topPanel.add(scrollPane);
		scrollPane.setBounds(50, 30, 380, 150);
                modelList = new DefaultListModel();
                JList listArray = new JList(modelList);
                scrollPane.setViewportView(listArray);
                listArray.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int selectedProduct = listArray.getSelectedIndex();
				if (selectedProduct > -1) {
				
					productNameInfo.setText("Product Name: " + collection.getProduct(selectedProduct).getName());
                                        productStockLevelInfo.setText("Stock Level: " + collection.getProduct(selectedProduct).getStockLevel());
                                        productPriceInfo.setText("Price: " + collection.getProduct(selectedProduct).getPrice()+ " £");
                                        productUpdated.setText("");
				}

			}
		});
                
                //removebutton
                removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = listArray.getSelectedIndex();
				if (index > -1) {
						collection.removeProduct(index);
						modelList.remove(index);
                                                productNameInfo.setText("");
                                                productStockLevelInfo.setText("");
                                                productPriceInfo.setText("");
                                                productUpdated.setText("");
				} else {
					JOptionPane.showMessageDialog(getContentPane(), "First you must select a Product to remove ", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
                
                //removeProductItem
                removeProductItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = listArray.getSelectedIndex();
				if (index > -1) {
						collection.removeProduct(index);
						modelList.remove(index);
                                                productNameInfo.setText("");
                                                productStockLevelInfo.setText("");
                                                productPriceInfo.setText("");
                                                productUpdated.setText("");
				} else {
					JOptionPane.showMessageDialog(getContentPane(), "First you must select a Product to remove ", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
                
                //sellbutton
                sellButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            SellJFrame.setModal(true);
                            int index = listArray.getSelectedIndex();
		if (index > -1){
                SellJFrame.setVisible(true);
            }else{JOptionPane.showMessageDialog(getContentPane(), "First you must select a Product to sell ", "Error",
							JOptionPane.ERROR_MESSAGE);
            }
                        }});
                
                //sellButton1
                sellButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int productToSell = listArray.getSelectedIndex();
				try {
					String quantitySellTextString = quantitySellText.getText();   
                                        int quantitySellTextInt = Integer.parseInt(quantitySellTextString);
					if (quantitySellTextInt > 0) {
						try {
                                                                collection.getProduct(productToSell).sell(quantitySellTextInt);
                                                        	productNameInfo.setText("Product Name: " + collection.getProduct(productToSell).getName());
                                                                productStockLevelInfo.setText("<html>Stock Level: " + collection.getProduct(productToSell).getStockLevel()+ " <font color='red'>(UPDATED)</font></html>");
                                                                productPriceInfo.setText("Price: " + collection.getProduct(productToSell).getPrice()+ " £");
                                                                SellJFrame.setVisible(false);
                                                                quantitySellText.setText("");
                                                                productUpdated.setText("");
                                                                
                                                }catch (SellException e) {
							JOptionPane.showMessageDialog(getContentPane(), e.getMessage(), "Error",
									JOptionPane.ERROR_MESSAGE);
						}
                                }
					else {
						JOptionPane.showMessageDialog(getContentPane(), "Item cannot be less than 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					} 
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(getContentPane(),
							"Couldn't sell the product, you didn't enter a number in the Quantity field", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
                        
		});
                
                //sellIProductITem
                sellProductItem.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            SellJFrame.setModal(true);
                            int index = listArray.getSelectedIndex();
		if (index > -1){
                SellJFrame.setVisible(true);
            }else{JOptionPane.showMessageDialog(getContentPane(), "First you must select a Product to sell ", "Error",
							JOptionPane.ERROR_MESSAGE);
            }
                        }});
                
                
                //modifybutton
                 modifyButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            ModifyJFrame.setModal(true);
                            int index = listArray.getSelectedIndex();
		if (index > -1){
                
                           productNameText1.setText(collection.getProduct(index).getName());
                                String StockLevelString = Integer.toString(collection.getProduct(index).getStockLevel()); 
                                productStockLevelText1.setText(StockLevelString);
                                String PriceString = Double.toString(collection.getProduct(index).getPrice());
                                productPriceText1.setText(PriceString);
                                ModifyJFrame.setVisible(true);
            }else{JOptionPane.showMessageDialog(getContentPane(), "First you must select a Product to modify", "Error",
							JOptionPane.ERROR_MESSAGE);
            }
                        }});
                 
                //modifybutton1
                modifyButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int productToModify = listArray.getSelectedIndex();
                                if(!productNameText1.getText().equals("")){
                                    
                                    collection.getProduct(productToModify).setName(productNameText1.getText());
                                    modelList.setElementAt(productNameText1.getText(), productToModify);
                                }
                                try{
                                        String productStockLevelText1String = productStockLevelText1.getText(); 
                                        int productStockLevelText1Int = Integer.parseInt(productStockLevelText1String);
                                        if(productStockLevelText1Int>0){
                                            collection.getProduct(productToModify).reStock(productStockLevelText1Int);
                                        }
                                
                              
                                
                                        String productPriceText1String = productPriceText1.getText();
                                        double productPriceText1Double = Double.parseDouble(productPriceText1String);
                                        if(productPriceText1Double>0)
                                        {
                                            collection.getProduct(productToModify).setPrice(productPriceText1Double);
                                            
                                        }
                                        productNameInfo.setText("Product Name: " + collection.getProduct(productToModify).getName());
                                        productStockLevelInfo.setText("Stock Level: " + collection.getProduct(productToModify).getStockLevel());
                                        productPriceInfo.setText("Price: " + collection.getProduct(productToModify).getPrice()+ " £");
                                        productUpdated.setText("<html><font color='red'>(PRODUCT UPDATED)</font></html>");
                                        ModifyJFrame.setVisible(false);
                                 }catch(NumberFormatException e){
                                        JOptionPane.showMessageDialog(getContentPane(),"Couldn't modify the product, you didn't enter a number in the Stock/Price field", "Error",JOptionPane.ERROR_MESSAGE);
                                        }
                        }});
                
                //modifyItemProduct
                modifyProductItem.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            ModifyJFrame.setModal(true);
                            int index = listArray.getSelectedIndex();
		if (index > -1){
                            
                           productNameText1.setText(collection.getProduct(index).getName());
                                String StockLevelString = Integer.toString(collection.getProduct(index).getStockLevel()); 
                                productStockLevelText1.setText(StockLevelString);
                                String PriceString = Double.toString(collection.getProduct(index).getPrice());
                                productPriceText1.setText(PriceString);
                                ModifyJFrame.setVisible(true);
            }else{JOptionPane.showMessageDialog(getContentPane(), "First you must select a Product to modify", "Error",
							JOptionPane.ERROR_MESSAGE);
            }
                        }});
                
                                       

         
          //bottom panel 
             bottomPanel.add(productNameInfo);
             bottomPanel.add(productStockLevelInfo);
             bottomPanel.add(productPriceInfo);
             bottomPanel.add(productInformationLabel);
             bottomPanel.add(productUpdated);
             productUpdated.setBounds(20,60, 400, 50);
             productUpdated.setBackground(Color.red);
             productInformationLabel.setBounds(180,50,400,50);
             productNameInfo.setBounds(20,90, 400, 50);
             productNameInfo.setBackground(Color.red);
             productStockLevelInfo.setBounds(20,120, 400, 50);
             productStockLevelInfo.setBackground(Color.red);
             productPriceInfo.setBounds(20,150, 400, 50);
             productPriceInfo.setBackground(Color.red);
              
               
		
        //collection object
        collection = new ProductCollection();
        //set frame visible
                
        setVisible(true);
     
}

        
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==addButton || e.getSource()==addProductItem)
            {
                AddJFrame.setModal(true);
                AddJFrame.setVisible(true);
                
                
            }
            if(e.getSource()==addButton1)
            {
if (!productNameText.getText().equals("") && !productStockLevelText.getText().equals("") && !productPriceText.getText().equals(""))                {
                    try{
                        String productStockString = productStockLevelText.getText();
                        int productStockInt = Integer.parseInt(productStockString);
                        String productPriceString = productPriceText.getText();
                        double productPriceDouble = Double.parseDouble(productPriceString);
                        Product objectX = new Product(productNameText.getText(), productStockInt,productPriceDouble);
			collection.addProduct(objectX);
			modelList.addElement(objectX.getName());
                        AddJFrame.setVisible(false);
                        productNameText.setText("");
                        productStockLevelText.setText("");
                        productPriceText.setText("");
                        
                        }
                    
                        catch (NumberFormatException f) {JOptionPane.showMessageDialog(getContentPane(),"Couldn't add the product, you didn't enter a number in the Stock/Price field", "Error",JOptionPane.ERROR_MESSAGE);
						}
					} 

				 else {
                                            if (productNameText.getText().equals("") && productNameText.getText().equals("") && productStockLevelText.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(), "You cannot leave the fields empty", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
                                            else if (productNameText.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(), "Name field cannot be empty", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (productStockLevelText.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(), "Stock field cannot be empty", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (productPriceText.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(), "Price field cannot be empty", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
            if(e.getSource() == cancelButton || e.getSource() == cancelButton1 || e.getSource() == cancelButton2)
            {
                AddJFrame.setVisible(false);
                SellJFrame.setVisible(false);
                ModifyJFrame.setVisible(false);
            }
            if(e.getSource() == aboutApp)
            {
                JOptionPane.showMessageDialog(getContentPane(), "This is a Product Inventory Application developed by Alessandro Carpanzano ©", "About App",
								JOptionPane.INFORMATION_MESSAGE);
            }
}
}
        

