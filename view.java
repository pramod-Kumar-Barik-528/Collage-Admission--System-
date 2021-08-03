import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class view_a extends Frame implements ActionListener
{
       int r,c,i,g;
       Color c1;

               Connection con;
               Statement st;
               ResultSet rs;
               ResultSetMetaData rsmd;
       TextField t[][]=new TextField[10][8];
       String str[]={"view","insert","update","search","delet","exit"};
       Button b[]=new Button[6]; 
      
     
  Label l=new Label("                      INFORMATION ABOUT STUDENTS");
       Font f1=new Font("Copperplate Gothic",Font.BOLD,20);

                
   view_a()
   {
              setLayout(null);

                 for(r=0;r<10;r++)
                 {
                   for(c=0;c<8;c++)
                   {
                           t[r][c]=new TextField("");
                           add(t[r][c]);
                   }
                 }
     		for(r=1;r<=10;r++)
                {
                 for(c=1;c<=8;c++)
                 {
                         t[r-1][c-1].setBounds(c*150,r*60,140,30);
                         t[r-1][c-1].setBackground(Color.cyan);
                 }
                }

        
      for(i=0;i<6;i++)
      {
        b[i]=new Button(str[i]);
        add(b[i]);
        b[i].addActionListener(this);
      }

        for(i=1;i<=6;i++)
        {
            b[i-1].setBounds(i*130,650,90,50);
            b[i-1].setBackground(Color.pink);
        }
   add(l);
   l.setBounds(60,10,500,80);
    l.setFont(f1);
setVisible(true);
setBounds(0,0,4500,4500);
         
       l.setBackground(Color.green); 
           setBackground(Color.green);
      connect();

  

    }//end constructor
 

           void insert12()
                   {
                      insert_a sh=new insert_a();
                      dispose();
                   }

     void search_p()
              {
                srh sr=new srh();
                dispose();
              }

   void delet_p()
      {
    delet_a dlt=new delet_a();
    dispose();
      }
          void update_p()
                 {
              update_a upd=new update_a();
                dispose();
                 }



  public void connect()	
        {
    try
   {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
      if(con!=null){ System.out.println("CONNECTION OK......");}
      else{ System.out.println("TRY AGAIN NO CONNECTION !!!!!!!!");}  
     }catch( Exception e){e.printStackTrace();}
  }
     



public void actionPerformed(ActionEvent ae)
{
   Button bb=(Button)ae.getSource();
   if(bb==b[0])
       {
          retrive();
       }

   if(bb==b[1])
       {
           insert12();   
       }
  
    if(bb==b[2])
        {
              update_p();
        }
    if(bb==b[3])
        {
           search_p();    
        }
     if(bb==b[4])
        {
              delet_p();
        }
       if(bb==b[5])
        {
                   dispose();
        }

 }// end actionperform


void  retrive()
  {
    String str="SELECT * FROM COLLEGE";
      try 
         {
           st=con.createStatement();
           rs=st.executeQuery(str);
           rsmd=rs.getMetaData();
           int col=rsmd.getColumnCount();
           int r=0; 
           for(int c=0;c<col;c++)
              {
              String cname=rsmd.getColumnName(c+1);
              t[r][c].setText("   "+cname);
              }	
		int x=1;
	while(rs.next())
              {
                  int k=0;
        int sn=rs.getInt(1);
       String nm=rs.getString(2); 
       String fn=rs.getString(3); 
       String add=rs.getString(4); 
       String db=rs.getString(5); 
       String gn=rs.getString(6); 
       String sm=rs.getString(7); 
       int yr=rs.getInt(8); 

            t[x][k].setText("             "+sn);
            k++;
            t[x][k].setText(nm);
            k++;
            t[x][k].setText(fn);
            k++;
            t[x][k].setText(add);
            k++;
            t[x][k].setText(db);
            k++;
            t[x][k].setText("       "+gn);
            k++;
            t[x][k].setText("       "+sm);
            k++;
            t[x][k].setText("       "+yr);
            x++;

               }          
           
        }catch(SQLException e){e.printStackTrace();}                         
    
     }//End retrive

   }//end class

class view1
{
public static void main(String arg[])
{
view_a at=new view_a();
}
}
	  