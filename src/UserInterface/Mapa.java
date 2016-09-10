package UserInterface;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mapa extends JPanel{
	private JLabel mapa;
	
    int width = 800;
    int height = 400;
    Double x = 36.829205;
    Double y = -2.4046174;
    
	public Mapa() {
		this.mapa = new JLabel();
		this.add(mapa);
		this.setVisible(true);
		
	}
	public void loadMapa(String x, String y){
		try {
			this.remove(mapa);
			if(x != null && x != "")
				this.x = Double.valueOf(x);
			if(y != null && y != "")
				this.y = Double.valueOf(y);
			
            String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="+ this.x +","+ this.y +"&size=" + this.getWidth() + "x" + this.getHeight() + "&sensor=true&zoom=18";
            String destinationFile = "image.jpg";
            String str = destinationFile;
            URL url = new URL(imageUrl);
            
            URLConnection openConnection = url.openConnection();
    		openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
    		
            
            InputStream is = openConnection.getInputStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
            
            this.mapa.setIcon(new ImageIcon((new ImageIcon("image.jpg")).getImage().getScaledInstance(this.getWidth() , this.getHeight(), java.awt.Image.SCALE_SMOOTH)));
            this.add(mapa);
            
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

	}
	public static void main(String[] args) throws IOException {
        JFrame test = new JFrame("Google Maps");
        test.setBounds(0, 0, 800, 600);
        Mapa m = new Mapa();
        m.setBounds(0, 0, 800, 600);
        m.loadMapa("36.829205", "-2.4046174");
        test.add(m);
        test.setVisible(true);
	}
	
}