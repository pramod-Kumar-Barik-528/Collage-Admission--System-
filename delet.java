 import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class delet_a extends Frame implements ActionListener
  {
	
              Connection con;
               Statement st;
               ResultSet rs; 
    Label l1=new Label("Delet by NAME:-");
    
    Button b4=new Button("BACK");
    Button b3=new Button("Delet");
    TextField t=new TextField("");
        
         delet_a()
                
                {
                  setLayout(null);
 
                  l1.setBounds(50,50,200,40);
                 
                  t.setBounds(120,220,200,40);
                  b3.setBounds(370,220,70,40);
		  b4.setBounds(470,220,70,40);
              add(l1); 
              add(b3);add(b4);
              b4.addActionListener(this);
              b3.addActionListener(this);
                  add(t);
   
               b4.setBackground(Color.cyan);
               b3.setBackground(Color.cyan);
               t.setBackground(Color.green);
               l1.setBackground(Color.red);


             setVisible(true);
             setBounds(0,0,700,700);
              setBackground(Color.red); 
                 connect();
               } //end con...

 public void connect()		
       {
    try
      {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
      if(con!=null){ System.out.println("CONNECTION OK......");}
      else{ System.out.println("TRY AGAIN NO CONNECTION !!!!!!!!");}  
      }catch(Exception e){e.printStackTrace();}
       } 


      public void delete_a()		
        {
    	   
          String sr=t.getText();
          String sql1="DELETE FROM COLLEGE WHERE name='"+sr+"'";
          System.out.println(sql1);    
         try
 	    {
             st=con.createStatement();
              rs=st.executeQuery(sql1);
               
                 
             
                  
                }catch(SQLException e){e.printStackTrace();}
        }

public void actionPerformed(ActionEvent e)
{
Button bb3=(Button)e.getSource();
    if(bb3==b3)
      {
          delete_a(); 
            
      }
    if(bb3==b4)
       {
             view_a av=new view_a();
             dispose();
       }
   
}//end actionperformed
  


         }//end class


class delet1
   {
    public static void main(String arg[])
      {
        delet_a dlt=new delet_a();
      }
   }
                  
           
    
    