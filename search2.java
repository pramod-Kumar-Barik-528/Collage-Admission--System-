import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class srh extends Frame implements ActionListener
{
              Connection con;
               Statement st;
               ResultSet rs; 
int r,c;
              ResultSetMetaData rsmd; 
             TextField t[][]=new TextField[3][8];  
           Button b1=new Button("Search");
           Button b2=new Button("BACK");
           Label l=new Label("*Search by:-");   
           TextField t1=new TextField("");
  
    srh()
          {
        setLayout(null);
          for(r=0;r<3;r++)
                 {
                   for(c=0;c<8;c++)
                   {
                           t[r][c]=new TextField("");
                           add(t[r][c]);
                   }
                 }
     		for(r=1;r<=3;r++)
                {
                 for(c=1;c<=8;c++)
                 {
                         t[r-1][c-1].setBounds(c*110,r*60,80,30);
                         t[r-1][c-1].setBackground(Color.pink);
                 }
                }

     
    
         b1.setBounds(400,400,50,30);
         b2.setBounds(400,450,50,30);
         t1.setBounds(140,400,200,40);
         l.setBounds(130,370,200,40);
         t1.setBackground(Color.red);
         b1.setBackground(Color.yellow);      
         b2.setBackground(Color.yellow); 

      add(b1);add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(t1);
        add(l);
        
        setBackground(Color.cyan);
        setVisible(true);
        setBounds(0,0,1200,1200);
 
       connect();
         }


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

 public void show_a()		
        {
    	   
          String sr=t1.getText();
          String sql1="select * from COLLEGE where NAME='"+sr+"'";
          System.out.println(sql1);    
         try
 	    {
             st=con.createStatement();
           rs=st.executeQuery(sql1);
           rsmd=rs.getMetaData();
           int col=rsmd.getColumnCount();
          	int r=0; 
           for(int c=0;c<col;c++)
              {
              String cname=rsmd.getColumnName(c+1);
              t[r][c].setText(cname);
               
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

            t[x][k].setText(" "+sn);
            k++;
            t[x][k].setText(nm);
            k++;
            t[x][k].setText(fn);
            k++;
            t[x][k].setText(add);
            k++;
            t[x][k].setText(db);
            k++;
            t[x][k].setText(gn);
            k++;
            t[x][k].setText(sm);
            k++;
            t[x][k].setText(" "+yr);
            x++;

               }          
             
                  
                 
              }catch(SQLException e){e.printStackTrace();}
        }

   







public void actionPerformed(ActionEvent e)
{
Button bb2=(Button)e.getSource();
    if(bb2==b1)
      {
               show_a();
      }
    if(bb2==b2)
       {
             view_a av=new view_a();
             dispose();
       }
   
}//end actionperformed





}//end srh class

class search1
{
public static void main(String arg[])
{
srh sr=new srh();
}
}
          		  
