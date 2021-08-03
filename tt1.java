import java.awt.*;
class tt extends Frame
      {
          int r,c,i;
             TextField t[][]=new TextField[10][8];
       String str[]={"view","insert","update","search","delet","exit"};
       Button b[]=new Button[6];               
             
   tt()
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
                           t[r-1][c-1].setBounds(c*110,r*60,100,30);
                       }
              }

        
      for(i=0;i<6;i++)
{
   b[i]=new Button(str[i]);
   add(b[i]);
}

                  for(i=1;i<=6;i++)
                       {
                           b[i-1].setBounds(i*150,650,100,50);
                       }

setVisible(true);
setBounds(0,0,800,900);
}


}




class rw
{
public static void main(String arg[])
{
tt at=new tt();
}
}
  