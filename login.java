import java.awt.*;
import java.awt.event.*;
import java.sql.*;
 class login_a extends Frame implements ActionListener,Runnable
  {
   
               Connection con;
               Statement st;
               ResultSet rs; 
         
         int i;
         Color c1;
             


    Label l1=new Label("            WELL COME:-");
    
    TextField t1=new TextField("");
    Label l2=new Label("Enter password");

   
    Label l3=new Label("Enter user Id");
    TextField t2=new TextField("");
   

   

    Button b=new Button("Submit");
    Button b1=new Button("Exit");
        
     Thread th=new Thread(this);
         
              login_a()
                     {
                        th.start();
                         
                          setLayout(null);
                         
                        l1.setBounds(100,50,200,30);
                        
      			l2.setBounds(100,100,100,40);
                        t1.setBounds(240,100,200,40);
                        
			l3.setBounds(100,150,100,40);
                        t2.setBounds(240,150,200,40);
                       


		        b.setBounds(140,270,60,40);
                        b1.setBounds(240,270,60,40);

                         b1.addActionListener(this);
                         b.addActionListener(this);
                        
                        
                         
                        
                                     
                        add(l1);add(l2);add(l3);
                        add(t1);add(t2);
                        add(b);add(b1);
  
                        
                        setBounds(300,100,550,400);
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

   public void run()
            {
           
              try{
                    for(i=0;i<=230;i++)
                     {
                       th.sleep(10);
                       c1=new Color(i,230,200);
                       setBackground(c1);
                      
                       if(i==230)
                         {
                              
                              i=0;

                         }

                       }
                  }catch(Exception ae){ae.toString();}
              
               }

 public void login_p()		
       {
                try{ 
		 String pwd1=t1.getText();
                  String sql1="select * from login where pswd='"+pwd1+"'";

                    
                     String user1=t2.getText();
                    String sql2="select * from user_id1 where user_id='"+user1+"'";
			System.out.println(sql2);
                        st=con.createStatement();
                       rs=st.executeQuery(sql2);

                  



                   System.out.println(sql1);
                   st=con.createStatement();
                   rs=st.executeQuery(sql1);
                   
                   while(rs.next())
                   {  
                     String data=rs.getString(1);
                     System.out.println("in while"+data+"  pwd1="+pwd1); 
		     view_a at=new view_a();
                    
                                 
                  }
              }catch(SQLException e){e.printStackTrace();}
        }
 
        



 public void actionPerformed(ActionEvent ae)
{
   Button log=(Button)ae.getSource();
   if(log==b)
       {
         login_p();
       }

   if(log==b1)
       {
           
        dispose(); 
       }
  
    
 }// end actionperform
  
  }//end class
                            

    
   class login1
       {
   public static void main(String arg[]) 
           {
            login_a lg=new login_a();
           }
       }           
     