import java.awt.*;
import java.awt.event.*;
import java.sql.*;
 class update_a extends Frame implements ActionListener
  {
   
               Connection con;
               Statement st;
               ResultSet rs; 




    Label l1=new Label("Update page BY NAME:-");
    Label l2=new Label("*..Put here what can do you change/update.......");
    TextField t1=new TextField("");
    Label l3=new Label("*..put here sl no which sl no belongs to name column value/put update  values sl no");
    TextField t2=new TextField("");
    Button b=new Button("Update");
    Button b1=new Button("Back");
         
              update_a()
                     {
                         setLayout(null);
                         
                        l1.setBounds(50,50,400,40);
                        l2.setBounds(130,100,500,40);
                        t1.setBounds(120,160,200,40);
                        l3.setBounds(175,250,700,40);
                        t2.setBounds(180,300,200,40);
                        b.setBounds(430,300,60,40);
                        b1.setBounds(520,300,60,40);
                        b1.addActionListener(this);
                         b.addActionListener(this);
                          setBackground(Color.cyan);
                          b.setBackground(Color.red);
                          b1.setBackground(Color.red);
                          t1.setBackground(Color.yellow);
                          t2.setBackground(Color.yellow);

                                     
                        add(l1);add(l2);add(l3);
                        add(t1);add(t2);
                        add(b);add(b1);
  
                        
                        setBounds(0,0,1000,1000);
                        setVisible(true);
                      connect();
                     }// end cont.....
    
                
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

     






        public void update_p()		
        {
    	   
                    String nm=t1.getText();
              
                     int sn=Integer.parseInt(t2.getText());
          String sql1="UPDATE COLLEGE SET NAME ='"+nm+"'WHERE SlNO="+sn;
          System.out.println(sql1);
               
         try
 	    {
            st=con.createStatement();
             rs=st.executeQuery(sql1);
             
             
                  
                 
              }catch(SQLException e){e.printStackTrace();}
        }

  





  public void actionPerformed(ActionEvent ae)
{
   Button bb4=(Button)ae.getSource();
   if(bb4==b)
       {
          update_p();
       }

   if(bb4==b1)
       {
           view_a av1=new view_a();
        dispose(); 
       }
  
    
 }// end actionperform
  
       
  

 


  }//end class
                            

    



   class update1
       {
   public static void main(String arg[]) 
           {
            update_a up=new update_a();
           }
       }           
     