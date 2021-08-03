import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class insert_a extends Frame implements ActionListener
{
             Connection con;
               Statement st;
               ResultSet rs;                                                                                    

int i;
Button b1=new Button("Submit");
Button b2=new Button("Back");
Label l[]=new Label[8];
Label l1=new Label("* INSERT ABOUT STUDENT'S :-");
TextField t[]=new TextField[8];
String str[]={"sl no","Name","Father","Address","Gender","DOB(eg:24nov98)","Stream","Year"};

        insert_a()
              {
                setLayout(null);
                  for(i=0;i<8;i++)
                     {
                       l[i]=new Label(str[i]);
                        add(l[i]);
                     }
                               for(i=1;i<=8;i++)
                                  {
                                     l[i-1].setBounds(20,i*60,100,40);
                                     
                                  }
      for(i=0;i<8;i++)
          {
            t[i]=new TextField("");
             add(t[i]);	
          }
                for(i=1;i<=8;i++)
                    {
                      t[i-1].setBounds(200,i*60,200,40);
                      t[i-1].setBackground(Color.red);
                    }
 add(b1);add(b2);add(l1);
  l1.setBounds(20,20,300,50);
 b1.addActionListener(this);
 b2.addActionListener(this);
 b1.setBounds(200,550,80,40);
 b2.setBounds(350,550,80,40);
 b1.setBackground(Color.blue);
 b2.setBackground(Color.blue);
setBackground(Color.yellow);
setVisible(true);
setBounds(50,100,800,900);

     connect();
  }// end constructor





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


 public void add1_f()		
        {
    	   int sn=Integer.parseInt(t[0].getText());
                String nm=t[1].getText();
                String fn=t[2].getText();
                String add=t[3].getText();
                String gn=t[4].getText();
                String db=t[5].getText();
                String sm=t[6].getText();
                int yr=Integer.parseInt(t[7].getText());
                                      
                String tsql="insert into COLLEGE values("+sn+",'"+nm+"'"+",'"+fn+"'"+",'"+add+"'"+",'"+db+"'"+",'"+gn+"'"+",'"+sm+"',"+yr+")"; 
                System.out.println(tsql);
               
         try
 	    {
            st=con.createStatement();
             rs=st.executeQuery(tsql);
             
             
                  
                 
              }catch(SQLException e){e.printStackTrace();}
        }
   
     




public void actionPerformed(ActionEvent e)
{
Button bb1=(Button)e.getSource();
   if(bb1==b2)
      {
        view_a av=new view_a();
        dispose();
       }
    if(bb1==b1)
      {
           add1_f();  
      }
}//end actionperformed
}//end class


class put1
        {
    public static void main(String args[])
      {
      
        insert_a rt=new insert_a();
      }
}          
