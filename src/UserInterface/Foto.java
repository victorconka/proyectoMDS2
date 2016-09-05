/*
package UserInterface;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Foto extends JPanel {

	protected ImageIcon foto;
	
	public Foto() {
		setOpaque(false);
		setLayout(null);
		setSize(Utils.wMedio, Utils.hMedio);
		foto = new ImageIcon(getClass().getClassLoader().getResource("Iconos/imagen_casa.png"));
	}

	protected void paintComponent(Graphics g) {
		//g.drawImage(foto.getImage(), 10, 110, 100, 100, null);
	}
}
*/

package UserInterface;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Foto extends JPanel {
	protected ImageIcon foto;
	private JPanel fotoPanel = new JPanel();	
	JLabel pic;
	boolean fixed = true;//we want a scaled image or a fixed
    int curImg = 0;
    int width = 152;//desired width of image
    int height = 165;//desired height of image
    String[] list = {"Iconos/imagen_casa.png"};
    JButton btnPrev = new JButton();
    JButton btnNext = new JButton();
    
    //  esta clase se modifico para cumplir con el requisito de herencia por parte de la InformacionListaCasas  
    public Foto (){
		setOpaque(false);
		setLayout(null);
		setSize(Utils.wMedio, Utils.hMedio);
		foto = new ImageIcon(getClass().getClassLoader().getResource("Iconos/imagen_casa.png"));
    }
    public Foto (String[] imgs){
    	this.list = imgs;
    }
    public void setImages(String[] imgs){
    	this.list = imgs;
    }
    //Metodo para inicializar la lista de imagenes.
    public void initSlider(){   	
    	pic = new JLabel();
    	fotoPanel.add(pic);
    	fotoPanel.setBounds(0, 0, width, height);
    	pic.setBounds(0, 0, width, height);
    	
        //button previous-------------------------------------------
        btnPrev.addActionListener(new ActionListener() {        	 
        public void actionPerformed(ActionEvent e) {
                 goPrevious();
             }
         });
         btnPrev.setLocation(0, 142);
         btnPrev.setText("<");
         btnPrev.setSize(41, 23);
         this.fotoPanel.add(btnPrev);
         
         //button next-------------------------------------------------
         btnNext.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
                 goNext();
             }
         });      
         btnNext.setText(">");
         btnNext.setLocation(111, 142);
         btnNext.setSize(41, 23);
         this.fotoPanel.add(btnNext);
         
         //Call The Function SetImageSize
         SetImageSize(0);
         
         this.fotoPanel.add(pic);
         //tm.start();
         this.setLayout(null);
         this.fotoPanel.setLayout(null);
         setSize(153, 166);
         this.fotoPanel.setBackground(Color.decode("#bdb67b"));
         //setLocationRelativeTo(null); //frame
         //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //frame
         
         this.fotoPanel.setVisible(true);
         this.add(fotoPanel);
    }
    //create a function to resize the image 
    public void SetImageSize(int i){
    	if(this.fixed){
    		SetImageSizeFixed(i);
    	}else{
    		SetImageSizeScaled(i);
    	}
    }
    //create a function to resize the image 
    public void SetImageSizeFixed(int i){
    	if(list != null && list.length > 0){
	        ImageIcon icon = new ImageIcon(list[i]);
	        Image img = icon.getImage();
	        if(list[i].contains("http")){
	        	try {
					img = ImageIO.read(new URL(list[i]));
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	        ImageIcon newImc = new ImageIcon(newImg);
	        pic.setIcon(newImc);
    	}
    }
    public void SetImageSizeScaled(int i){
    	if(list != null && list.length > 0){
	        ImageIcon icon = new ImageIcon(list[i]);
	        Image img = icon.getImage();
	        if(list[i].contains("http")){
	        	try {
					img = ImageIO.read(new URL(list[i]));
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
	        ImageIcon newImc = new ImageIcon(newImg);
	        pic.setIcon(newImc);
    	}
    }
    public void goPrevious(){
    	SetImageSize(curImg);
    	this.curImg = (curImg - 1) % this.list.length;
    	if(curImg == -1)
    		curImg = this.list.length -1;
    }
    
    public void goNext(){
    	SetImageSize(curImg);
    	this.curImg = (curImg + 1) % this.list.length;
    }
}
