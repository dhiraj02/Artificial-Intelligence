import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.OutputStream;
//import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.FilePermission;
import java.security.Permission;
import java.lang.Object;
import java.io.InputStream;
import java.io.FileInputStream;
import java.net.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;


public class MouseProjectFrame extends Frame implements ActionListener, MouseListener
{
 
  String msg = "";
  int mouseX = 0, mouseY = 0;
  int mX = 0, mY = 0;
  double m1 = 0.0, m2 = 0.0;
  Button Start, Stop;
  Button Object1, Object2, GetRelation,ReadFromFiles,StoreInFiles;
  boolean check = false;
  boolean gr = false;
  String mg = "";
  String gh = "";
  int n = 0;
  int i = 0, j = 0, set, p1, p2, q1, q2;
  TextArea text = new TextArea ();
  String s;
  String r="A";
  String x,y;
  int f;
  String line;
  String tok;
  int t=0;
  int to=0;
  int k=0;
  int out=0;
  String out1Line;
  String out2Line;
  
   

  
  
  
  int set1 = 0;
  int set2 = 0;

  int x1[] = new int[100];
  int y1[] = new int[100];


  int x2[] = new int[100];
  int y2[] = new int[100];

  boolean calculated = false;


  /*int cox1[]=new int[100];
     int coy1[]=new int[100];


     int cox2[]=new int[100];
     int coy2[]=new int[100]; */



  int cox1[] = { 0, 0 };
  int coy1[] = { 0, 0 };
  int cox2[] = { 0, 0 };
  int coy2[] = { 0, 0 };

  

 



  public MouseProjectFrame()
  {

    Object1 = new Button ("Object1");
    Object2 = new Button ("Object2");
    Start = new Button ("Start");
    Stop = new Button ("Stop");
    GetRelation = new Button ("GetRelation");
	ReadFromFiles= new Button ("ReadFromFiles");
	StoreInFiles=new Button("StoreInFiles");


    Panel Ppanel = new Panel ();
    Panel subPanel = new Panel ();
    Panel bPanel = new Panel ();

    text.setEditable (false);


    setLayout (new BorderLayout ());
    add (subPanel, BorderLayout.NORTH);
    add (Ppanel, BorderLayout.SOUTH);
    add (bPanel, BorderLayout.EAST);

    subPanel.add (Start);
    subPanel.add (Stop);
    subPanel.add (Object1);
    subPanel.add (Object2);
    bPanel.add (GetRelation);
	bPanel.add(ReadFromFiles);
	bPanel.add(StoreInFiles);
    Ppanel.add (text);
    Start.addActionListener (this);
    Stop.addActionListener (this);
    Object1.addActionListener (this);
    Object2.addActionListener (this);
    GetRelation.addActionListener(this);
    ReadFromFiles.addActionListener(this);
	StoreInFiles.addActionListener(this);
    addMouseListener (this);
	
	


  }


  public void mouseClicked (MouseEvent me)
  {
    mouseX = me.getX ();
    mouseY = me.getY ();

    if (n == 0 && check == true)
      {
	x1[set1] = mouseX;
	y1[set1] = mouseY;
	set1++;
      }
    else if (n == 1 && check == true)
      {
	x2[set2] = mouseX;
	y2[set2] = mouseY;
	set2++;
      }
	  
	if(set1<set2)
		{
			i=set1;
		}
	else
			i=set2;



	 calculated = false;


     

  /*if ((set1 > 1) && (set2 > 1))
    {
		if (set1 < set2)
	  	{
	   	i = set1 - 2;
	   	j = set1 - 2;
	  	}
		else
		{
			i = set2 - 2;
			j = set2 - 2;
		}*/














/*if(gr==true)
{

for(p1=2,q1=2;p1<=2 && q1<=2;p1++,q1++)
{


		if(set1<set2)
		{
		i=p1-2;
		j=p1-2;
		}
		else
		{
			i=q1-2;
			j=q1-2;
		}		

		 mg = "i: " + i + " j: " + j + " ";

	    m1 = (double)(y1[i + 1] - y1[i]) / (x1[i + 1] - x1[i]);
	    m2 = (double)(y2[j + 1] - y2[j]) / (x2[j + 1] - x2[j]);

	    if (x1[i] < x2[j])
	    {
			 calculated = true;
			 mg = mg + "m1: " + m1 + " m2: " + m2 + " y1[i+1]: " + y1[i+1] + " y1[i]: " + y1[i] + " y2[j+1]: " + y2[j+1] + " y2[j]: " + y2[j] + "x1[i+1]: " 

+ x1[i+1] + " x1[i]: " + x1[i] + " x2[j+1]: " + x2[j+1] + " x2[j]: " + x2[j];

		if (m1 > 0 && m2 > 0 && m1 == m2 && y1[i + 1] < y1[i] && y2[j + 1] < y2[j])
		  mg = "Moving parallel to each other in the same direction";

		else if (m1 > 0 && m2 < 0 && m1 != m2 && y1[i + 1] < y1[i] && y2[j + 1] < y2[j])
                 {  n=2;

		  mg = "Moving away from each other in the same direction";
                 }
		else if (m1 > 0 && m2 > 0 && m1 == m2 && y1[i + 1] < y1[i] && y2[j + 1] > y2[j])
                  mg = "Moving parallel to each other in the opposite direction";
                
		else if (m1 > 0 && m2 < 0 && m1 != m2 && y1[i + 1] < y1[i] && y2[j + 1] > y2[j])
		  mg = "Moving away from each other in the opposite direction";

		else if (m1 < 0 && m2 > 0 && m1 != m2 && y1[i + 1] < y1[i] && y2[j + 1] < y2[j])
                 { n=5;
		  mg = "Moving towards each other";
                 }
		else if (m1 < 0 && m2 < 0 && m1 == m2 && y1[i + 1] < y1[i] && y2[j + 1] < y2[j])
		  mg = "Moving parallel to each other in the same direction";

		else if (m1 < 0 && m2 > 0 && m1 != m2 && y1[i + 1] < y1[i] && y2[j + 1] > y2[j])
		  mg = "Moving away from each other in the opposite direction";

		else if (m1 < 0 && m2 < 0 && m1 == m2 && y1[i + 1] < y1[i] && y2[j + 1] > y2[j])
		  mg = "Moving parallel to each other in the opposite direction";

		else if (m1 > 0 && m2 > 0 && m1 == m2 && y1[i + 1] > y1[i] && y2[j + 1] < y2[j])
		  mg = "Moving parallel to each other in the opposite direction";

		else if (m1 > 0 && m2 < 0 && m1 != m2 && y1[i + 1] > y1[i] && y2[j + 1] < y2[j])
		  mg = "Moving away fromeach other in the opposite direction";

		else if (m1 > 0 && m2 > 0 && m1 == m2 && y1[i + 1] > y1[i] && y2[j + 1] > y2[j])
		  mg = "Moving parallel to each other in the same direction";

		else if (m1 > 0 && m2 < 0 && m1 != m2 && y1[i + 1] > y1[i] && y2[j + 1] > y2[j])
		  mg = "Moving towards each other";

		else if (m1 < 0 && m2 > 0 && m1 != m2 && y1[i + 1] > y1[i] && y2[j + 1] < y2[j])
		  mg = "Moving away from each other in the opposite direction";

		else if (m1 < 0 && m2 < 0 && m1 == m2 && y1[i + 1] > y1[i] && y2[j + 1] < y2[j])
		  mg = "Moving parallel to each other in the opposite direction";

		else if (m1 < 0 && m2 > 0 && m1 != m2 && y1[i + 1] > y1[i] && y2[j + 1] > y2[j])
		  mg = "Moving away from each other in the same direction";

		else if (m1 < 0 && m2 < 0 && m1 == m2 && y1[i + 1] > y1[i] && y2[j + 1] > y2[j])
		  mg = "Moving parallel to each other in the same direction";
	    }
	    else
	    {
			 calculated = true;

				mg = "inside else i: " + i + " j: " + j + " ";

		if (m1 > 0 && m2 > 0 && m1 == m2 && y1[i + 1] < y1[i]
		    && y2[j + 1] < y2[j])
		  mg = "Moving parallel to each other in the same direction";

		else if (m1 > 0 && m2 < 0 && m1 != m2 && y1[i + 1] < y1[i]
			 && y2[j + 1] < y2[j])
		  mg = "Moving towards each";

		else if (m1 > 0 && m2 > 0 && m1 == m2 && y1[i + 1] < y1[i]
			 && y2[j + 1] > y2[j])
		  mg =
		    "Moving parallel to each other in the opposite direction";

		else if (m1 > 0 && m2 < 0 && m1 != m2 && y1[i + 1] < y1[i]
			 && y2[j + 1] < y2[j])
		  mg =
		    "Moving away from each other in the opposite direction";

		else if (m1 < 0 && m2 > 0 && m1 != m2 && y1[i + 1] < y1[i]
			 && y2[j + 1] < y2[j])
		  mg = "Moving Away from each other in the same direction";

		else if (m1 < 0 && m2 < 0 && m1 == m2 && y1[i + 1] < y1[i]
			 && y2[j + 1] < y2[j])
		  mg = "Moving parallel to each other in the same direction";

		else if (m1 < 0 && m2 > 0 && m1 != m2 && y1[i + 1] < y1[i]
			 && y2[j + 1] > y2[j])
		  mg =
		    "Moving away from each other in the opposite direction";

		else if (m1 < 0 && m2 < 0 && m1 == m2 && y1[i + 1] < y1[i]
			 && y2[j + 1] > y2[j])
		  mg =
		    "Moving parallel to each other in the opposite direction";

		else if (m1 > 0 && m2 > 0 && m1 == m2 && y1[i + 1] > y1[i]
			 && y2[j + 1] < y2[j])
		  mg =
		    "Moving parallel to each other in the opposite direction";

		else if (m1 > 0 && m2 < 0 && m1 != m2 && y1[i + 1] > y1[i]
			 && y2[j + 1] < y2[j])
		  mg = "Moving away fromeach other in the opposite direction";

		else if (m1 > 0 && m2 > 0 && m1 == m2 && y1[i + 1] > y1[i]
			 && y2[j + 1] > y2[j])
		  mg = "Moving parallel to each other in the same direction";

		else if (m1 > 0 && m2 < 0 && m1 != m2 && y1[i + 1] > y1[i]
			 && y2[j + 1] > y2[j])
		  mg = "Moving away from each other in the same direction";

		else if (m1 < 0 && m2 > 0 && m1 != m2 && y1[i + 1] > y1[i]
			 && y2[j + 1] < y2[j])
		  mg =
		    "Moving away from each other in the opposite direction";

		else if (m1 < 0 && m2 < 0 && m1 == m2 && y1[i + 1] > y1[i]
			 && y2[j + 1] < y2[j])
		  mg =
		    "Moving parallel to each other in the opposite direction";

		else if (m1 < 0 && m2 > 0 && m1 != m2 && y1[i + 1] > y1[i]
			 && y2[j + 1] > y2[j])
		  mg = "Moving towards each other";

		else if (m1 < 0 && m2 < 0 && m1 == m2 && y1[i + 1] > y1[i]
			 && y2[j + 1] > y2[j])
		  mg = "Moving parallel to each other in the same direction";

	      }

	  }

}*/
    //repaint(mouseX-1,mouseY-1,mouseX+1,mouseY+1);
    repaint ();

   

  }


  public void mouseEntered (MouseEvent me)
  {

  }

  public void mouseExited (MouseEvent me)
  {

  }

  public void mousePressed (MouseEvent me)
  {



  }

  public void mouseReleased (MouseEvent me)
  {

  }

  public void actionPerformed (ActionEvent ae)
  {

    if (ae.getSource () == Object1)
      n = 0;
    else if (ae.getSource () == Object2)
      n = 1;


    if (ae.getSource () == Start)
      {
	check = true;



      }
    else if (ae.getSource () == Stop)
      {
	check = false;




	for (int i = 0; i < set1; i++)
	  {
	    x1[i] = 0;
	    y1[i] = 0;
	  }

	for (int i = 0; i < set2; i++)
	  {
	    x2[i] = 0;
	    y2[i] = 0;
	  }

	set1 = 0;
	set2 = 0;
	mg = "";

	/*x1[0]=0;
	   y1[0]=0;
	   x1[1]=0;
	   y1[1]=0;
	   x2[0]=0;
	   y2[0]=0;
	   x2[1]=0;
	   y2[1]=0; */

	repaint ();
      }
    else if (ae.getSource () == GetRelation)
      {
        calculated=false;
	
/*  if ((set1 > 1) && (set2 > 1))
    {
		if (set1 < set2)
	  	{
	   	i = set1 - 2;
	   	j = set1 - 2;
	  	}
		else
		{
			i = set2 - 2;
			j = set2 - 2;
		}



/*for(p1=2,q1=2;p1<=set1 && q1<=set2;p1++,q1++)
{*/
		/*calculated=false;

		if(set1<set2)
		{
		i=set1-2;
		j=set1-2;
		}
		else
		{
			i=set2-2;
			j=set2-2;
		}*/		

		
		
	/*if(set1<set2)
		{
			i=set1;
		}
	else
			i=set2;*/
		
		
	if(i>0)
	{
		
	for(j=1;j<=i-1;j++)
	{
		
		 //mg = "i: " + i + " j: " + j + " ";

	    m1 = (double)(y1[j] - y1[j-1]) / (x1[j] - x1[j-1]);
	    m2 = (double)(y2[j] - y2[j-1]) / (x2[j] - x2[j-1]);

	    if (x1[j-1] < x2[j-1])
	    {
			 calculated = true;
			/* mg = mg + "m1: " + m1 + " m2: " + m2 + " y1[j]: " + y1[j] + " y1[j-1]: " + y1[j-1] + " y2[j]: " + y2[j] + " y2[j-1]: " + y2[j-1] + "x1[j]: " 

+ x1[j] + " x1[j-1]: " + x1[j-1] + " x2[j]: " + x2[j] + " x2[j-1]: " + x2[j-1];*/

		if (m1 > 0 && m2 > 0 && m1 == m2 && y1[j] < y1[j-1] && y2[j] < y2[j-1])
		  mg ="m1";

		else if (m1 > 0 && m2 < 0 && m1 != m2 && y1[j] < y1[j-1] && y2[j] < y2[j-1])
		  
                  mg ="m2\n";
			
		
                  
		else if (m1 > 0 && m2 > 0 && m1 == m2 && y1[j] < y1[j-1] && y2[j] > y2[j-1])
		  mg ="m3";

		else if (m1 > 0 && m2 < 0 && m1 != m2 && y1[j] < y1[j-1] && y2[j] > y2[j-1])
		  mg ="m4";

		else if (m1 < 0 && m2 > 0 && m1 != m2 && y1[j] < y1[j-1] && y2[j] < y2[j-1])
		                 
		  mg = "m5";
			   
		else if (m1 < 0 && m2 < 0 && m1 == m2 && y1[j] < y1[j-1] && y2[j] < y2[j-1])
		  mg ="m6";

		else if (m1 < 0 && m2 > 0 && m1 != m2 && y1[j] < y1[j-1] && y2[j] > y2[j-1])
		  mg ="m7";

		else if (m1 < 0 && m2 < 0 && m1 == m2 && y1[j] < y1[j-1] && y2[j] > y2[j-1])
		  mg ="m8";

		else if (m1 > 0 && m2 > 0 && m1 == m2 && y1[j] > y1[j-1] && y2[j] < y2[j-1])
		  mg ="m9";

		else if (m1 > 0 && m2 < 0 && m1 != m2 && y1[j] > y1[j-1] && y2[j] < y2[j-1])
		  mg ="m10";

		else if (m1 > 0 && m2 > 0 && m1 == m2 && y1[j] > y1[j-1] && y2[j] > y2[j-1])
		  mg ="m11";

		else if (m1 > 0 && m2 < 0 && m1 != m2 && y1[j] > y1[j-1] && y2[j] > y2[j-1])
		  mg ="m12";

		else if (m1 < 0 && m2 > 0 && m1 != m2 && y1[j] > y1[j-1] && y2[j] < y2[j-1])
		  mg ="m13";

		else if (m1 < 0 && m2 < 0 && m1 == m2 && y1[j] > y1[j-1] && y2[j] < y2[j-1])
		  mg ="m14";

		else if (m1 < 0 && m2 > 0 && m1 != m2 && y1[j] > y1[j-1] && y2[j] > y2[j-1])
		  mg ="m15";

		else if (m1 < 0 && m2 < 0 && m1 == m2 && y1[j] > y1[j-1] && y2[j] > y2[j-1])
		  mg ="m16";
		else if (m1>0 && m2>0 && m1!=m2 && y1[j]<y1[j-1] && y2[j]<y2[j-1] && m1>m2)
			
		  mg="m5";
		else if(m1<0 && m2<0 && m1!=m2 && m2<m1 && y1[j]<y1[j-1]&& y2[j]<y2[j-1])
		
		 mg="m5";
        		 
		else if(m1<0 && m2<0 && m1!=m2 && m1<m2 && y1[j]>y1[j-1]&& y2[j]>y2[j-1])
          mg="m12";
        else if(m1>0 && m2>0 && m1!=m2 && m1<m2 && y1[j]>y1[j-1]&& y2[j]>y2[j-1])
		  mg="m12";
		else if(m1<0 && m2<0 && m1!=m2 && m1<m2 && y1[j]<y1[j-1]&& y2[j]>y2[j-1])
		mg="m7";
		else if(m1>0 && m2>0 && m1!=m2 && m1<m2 && y1[j]>y1[j-1]&& y2[j]>y2[j-1])
		
		mg="m15";
		else if(m1<0 && m2<0 && m1!=m2 && m1<m2 && y1[j]<y1[j-1]&& y2[j]<y2[j-1])
	    mg="m2";
        else if(m1>0 && m2>0 && m1!=m2 && m1<m2 && y1[j]<y1[j-1]&& y2[j]<y2[j-1])
        mg="m2";
        else if(m1>0 && m2>0 && m1!=m2 && m1>m2 && y1[j]>y1[j-1]&& y2[j]>y2[j-1])
		mg="m15";
		else if(m1<0 && m2<0 && m1!=m2 && m1>m2 && y1[j]>y1[j-1]&& y2[j]>y2[j-1])
		mg="m15";
		else if(m1>0 && m2>0 && m1!=m2 && m1>m2 && y1[j]<y1[j-1]&& y2[j]>y2[j-1])
		mg="m4";
		else if(m1>0 && m2>0 && m1!=m2 && m1>m2 && y1[j]<y1[j-1]&& y2[j]<y2[j-1])
		mg="m2 ";
		else if(m1>0 && m2>0 && m1!=m2 && m1>m2 && y1[j]>y1[j-1]&& y2[j]>y2[j-1])
		mg="m15"; 
		
		//System.out.println(""+mg);
		s=Integer.toString(j-1);
		x=r.concat(s);
		s=Integer.toString(j);
		y=r.concat(s);
		gh=gh+"\n"+x+"->"+mg+y;
		System.out.println(""+gh);
	    }
		
	    else
	    {
			 calculated = true;

				//mg = "inside else i: " + i + " j: " + j + " ";

		if (m1 > 0 && m2 > 0 && m1 == m2 && y1[i + 1] < y1[i]
		    && y2[j + 1] < y2[j])
		  mg = "Moving parallel to each other in the same direction";

		else if (m1 > 0 && m2 < 0 && m1 != m2 && y1[i + 1] < y1[i]
			 && y2[j + 1] < y2[j])
		  mg = "Moving towards each";

		else if (m1 > 0 && m2 > 0 && m1 == m2 && y1[i + 1] < y1[i]
			 && y2[j + 1] > y2[j])
		  mg =
		    "Moving parallel to each other in the opposite direction";

		else if (m1 > 0 && m2 < 0 && m1 != m2 && y1[i + 1] < y1[i]
			 && y2[j + 1] < y2[j])
		  mg =
		    "Moving away from each other in the opposite direction";

		else if (m1 < 0 && m2 > 0 && m1 != m2 && y1[i + 1] < y1[i]
			 && y2[j + 1] < y2[j])
		  mg = "Moving Away from each other in the same direction";

		else if (m1 < 0 && m2 < 0 && m1 == m2 && y1[i + 1] < y1[i]
			 && y2[j + 1] < y2[j])
		  mg = "Moving parallel to each other in the same direction";

		else if (m1 < 0 && m2 > 0 && m1 != m2 && y1[i + 1] < y1[i]
			 && y2[j + 1] > y2[j])
		  mg =
		    "Moving away from each other in the opposite direction";

		else if (m1 < 0 && m2 < 0 && m1 == m2 && y1[i + 1] < y1[i]
			 && y2[j + 1] > y2[j])
		  mg =
		    "Moving parallel to each other in the opposite direction";

		else if (m1 > 0 && m2 > 0 && m1 == m2 && y1[i + 1] > y1[i]
			 && y2[j + 1] < y2[j])
		  mg =
		    "Moving parallel to each other in the opposite direction";

		else if (m1 > 0 && m2 < 0 && m1 != m2 && y1[i + 1] > y1[i]
			 && y2[j + 1] < y2[j])
		  mg = "Moving away fromeach other in the opposite direction";

		else if (m1 > 0 && m2 > 0 && m1 == m2 && y1[i + 1] > y1[i]
			 && y2[j + 1] > y2[j])
		  mg = "Moving parallel to each other in the same direction";

		else if (m1 > 0 && m2 < 0 && m1 != m2 && y1[i + 1] > y1[i]
			 && y2[j + 1] > y2[j])
		  mg = "Moving away from each other in the same direction";

		else if (m1 < 0 && m2 > 0 && m1 != m2 && y1[i + 1] > y1[i]
			 && y2[j + 1] < y2[j])
		  mg =
		    "Moving away from each other in the opposite direction";

		else if (m1 < 0 && m2 < 0 && m1 == m2 && y1[i + 1] > y1[i]
			 && y2[j + 1] < y2[j])
		  mg =
		    "Moving parallel to each other in the opposite direction";

		else if (m1 < 0 && m2 > 0 && m1 != m2 && y1[i + 1] > y1[i]
			 && y2[j + 1] > y2[j])
		  mg = "Moving towards each other";

		else if (m1 < 0 && m2 < 0 && m1 == m2 && y1[i + 1] > y1[i]
			 && y2[j + 1] > y2[j])
		  mg = "Moving parallel to each other in the same direction";

	      }

	  }

     
    

	repaint();

    

       }
	   /*s=Integer.toString(j-1);
		x=r.concat(s);
		s=Integer.toString(j);
		y=r.concat(s);
		gh=gh+"\n"+x+"->"+mg+y;
		System.out.println(""+gh);
		repaint();*/
	   }
	   
	if(ae.getSource() == ReadFromFiles)
	{
	
	/*for (int i = 0; i < set1; i++)
	  {
	    x1[i] = -1;
	    y1[i] = -1;
	  }

	for (int i = 0; i < set2; i++)
	  {
	    x2[i] = -1;
	    y2[i] = -1;
	  }*/
	
		
	 try
      {
         DataInputStream dataIn = new DataInputStream(new FileInputStream("data.txt"));
		
		while((line=dataIn.readLine()) != null)
		{
		 text.append(line);
			 StringTokenizer st=new StringTokenizer(line,"#");
			while(st.hasMoreTokens()){
				
				tok=st.nextToken();
				
				to=Integer.parseInt(tok);
				if(t%4==0)
			    x1[k]=to;
				else if(t%4==1)
				y1[k]=to;
				else if(t%4==2)
				x2[k]=to;
				else if(t%4==3)
				y2[k]=to;
				t++;
				
				if(t%4==0)
				k++;
				
				
				
				
				
		    }
		System.out.println("x1[0]:"+x1[0]);
		System.out.println("y1[0]:"+y1[0]);
		System.out.println("x2[0]:"+x2[0]);
		System.out.println("y2[0]:"+y2[0]);
		
		System.out.println("x1[1]:"+x1[1]);
		System.out.println("y1[1]:"+y1[1]);
		System.out.println("x2[1]:"+x2[1]);
		System.out.println("y2[1]:"+y2[1]);
			 //dataIn.close();
		}	 
      }
      catch(IOException e)
      {
         System.out.println("Problem finding file");
      }
	  catch(SecurityException e)
	 {
	     System.out.println(e);
	 }
	  
	System.out.println("line:"+line);
	
	}
	
	if(ae.getSource() == StoreInFiles)
	{
	
	try{
		DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("data.txt"));
		System.out.println(""+i);
		for(out=0;out<=i;out++)
		{
		
		if(out1Line!=null)
		{
		out1Line=out1Line+Integer.toString(x1[out])+"#"+Integer.toString(y1[out])+"#"+Integer.toString(x2[out])+"#"+Integer.toString(y2[out])+"#";
		}
		else
		out1Line=Integer.toString(x1[out])+"#"+Integer.toString(y1[out])+"#"+Integer.toString(x2[out])+"#"+Integer.toString(y2[out])+"#";
		
		}
		dataOut.writeBytes(out1Line);
		dataOut.close();
		System.out.println(""+out1Line);
		
	}
	 catch(IOException e)
      {
         System.out.println("Problem finding file");
      }
	 catch(SecurityException e)
	 {
	     System.out.println(e);
	 }
	
	
	}

  }

  public void paint (Graphics g)
  {

    if (check == true)
      {
	for (int i = 0; i < set1; i++)
	  g.fillOval (x1[i], y1[i], 5, 5);

	for (int i = 0; i < set2; i++)
	  g.drawOval (x2[i], y2[i], 5, 5);
      }


/*
	if(check==true && n==0)
	{
	
	
	
	 
	//super.paint(g);

	for(int i = 0; i < set1; i++)
		g.fillOval(x1[i], y1[i], 5, 5);
	
	}
	else if(check==true && n==1)
	{

	//super.paint(g);
	for(int i = 0; i < set2; i++)
		g.drawOval(x2[i], y2[i], 5, 5);

	}

*/







    /*g.drawString ("Mouse" + x1[0] + "," + y1[0] + "," + x1[1] + "," + y1[1] +
		  "," + set1 + "," + set2+ ",to:"+to, 100, 100);

    g.drawString ("Mouse" + x2[0] + "," + y2[0] + "," + x2[1] + "," + y2[1],
		  100, 110);*/

  
    //g.drawString (tok, 100, 120);
	
	
	if(calculated==true)
	{
		 text.append(gh+"\n");
	      mg="";
	      gh="";
	    set1=0;
		set2=0;
	}

  }

    public static void main(String args[]) {
       MouseProjectFrame f = new MouseProjectFrame();
       f.setSize(500, 500);
       f.setVisible(true);
  }
  
  
 /* public MouseProject ()
  {



  }*/
}
