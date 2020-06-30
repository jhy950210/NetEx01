import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class MapEx02 extends JFrame {
	 private JPanel contentPane;
	   private JTextField tf1;
	   private JTextField tf3;
	   private JButton btn;
	   private JTextField tf2;

	   /**
	    * Launch the application.
	    */
	   public static void main(String[] args) {
	      EventQueue.invokeLater(new Runnable() {
	         public void run() {
	            try {
	               MapEx02 frame = new MapEx02();
	               frame.setVisible(true);
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	         }
	      });
	   }

	   /**
	    * Create the frame.
	    */
	   public MapEx02() {
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setBounds(100, 100, 450, 300);
	      contentPane = new JPanel();
	      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	      setContentPane(contentPane);
	      contentPane.setLayout(null);
	      
	      JPanel panel = new JPanel();
	      panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC5ED \uC785\uB825", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	      panel.setBounds(6, 25, 290, 45);
	      contentPane.add(panel);
	      panel.setLayout(null);
	      
	      tf1 = new JTextField();
	      tf1.setBounds(6, 17, 278, 21);
	      panel.add(tf1);
	      tf1.setColumns(10);
	      
	      JPanel panel_1 = new JPanel();
	      panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC704\uB3C4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	      panel_1.setBounds(6, 76, 128, 45);
	      contentPane.add(panel_1);
	      panel_1.setLayout(null);
	      
	      tf2 = new JTextField();
	      tf2.setBounds(6, 17, 116, 21);
	      panel_1.add(tf2);
	      tf2.setColumns(10);
	      
	      JPanel panel_2 = new JPanel();
	      panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uACBD\uB3C4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	      panel_2.setBounds(6, 125, 128, 45);
	      contentPane.add(panel_2);
	      panel_2.setLayout(null);
	      
	      tf3 = new JTextField();
	      tf3.setBounds(6, 17, 116, 21);
	      panel_2.add(tf3);
	      tf3.setColumns(10);
	      
	      btn = new JButton("검색");
	      btn.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent e) {
	            BufferedReader br = null;
	            
	            try {
	               String strUrl = String.format("https://maps.googleapis.com/maps/api/geocode/json?address=%s&key=AIzaSyAbVFS-qIntFVB06FBnXHkiT1NwtbD_MZ4", tf1.getText());
	               URL url = new URL(strUrl);
	               URLConnection conn = url.openConnection();

	               br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	               
	               String line = null;
	               String latitude = null;
	               String longitude = null;
	               while((line = br.readLine()) != null ) {
	                  if(line.contains("\"location\"") ) {
	                     
	                     
	                     latitude = br.readLine().trim().substring(8).replaceAll(",","");
	                     longitude = br.readLine().trim().substring(8);
	                     
	                     tf2.setText(latitude);
	                     tf3.setText(longitude);
	                  }  
	               }
	               }catch (MalformedURLException e1) {
	               // TODO 자동 생성된 catch 블록
	               e1.printStackTrace();
	            } catch (IOException e1) {
	               // TODO 자동 생성된 catch 블록
	               e1.printStackTrace();
	            } finally {
	               if(br != null) try {br.close();} catch(IOException e1) {}
	               
	               
	            }
	            
	         }
	      });
	      btn.setBounds(325, 41, 97, 23);
	      contentPane.add(btn);
	      
	      JButton btn2 = new JButton("지도보기");
	      btn2.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent e) {
	            try {
	               String strOption = String.format("https://www.google.co.kr/maps/@%s,%s,%s", tf2.getText(),tf3.getText(),"16z");
	               ProcessBuilder processBuilder
	               = new ProcessBuilder("c:\\Program Files\\Internet Explorer\\iexplore.exe",strOption);
	               processBuilder.start();
	            } catch (IOException e1) {
	               // TODO 자동 생성된 catch 블록
	               e1.printStackTrace();
	            }

	         }
	      });
	      btn2.setBounds(187, 110, 97, 23);
	      contentPane.add(btn2);
	   }

	
}
