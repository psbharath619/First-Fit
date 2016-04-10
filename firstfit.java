/*
<html><applet code="firstfit.class" width=250 height=800>
</applet></html>
*/

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class firstfit extends Applet implements ActionListener 
{

Button b1;
int n;
Label l1[];
Label l2[];
TextField t1[];
TextField t2[];
TextArea op;

public void init()
{
setLayout(new FlowLayout(FlowLayout.LEFT,20,50));
op=new TextArea();
n=5;
l1=new Label[n];
l2=new Label[n];
t1=new TextField[n];
t2=new TextField[n];
for(int i=0;i<n;i++)
{
l1[i]=new Label("Process size: -"+(i+1),Label.RIGHT);
t1[i]=new TextField();
l2[i]=new Label("Partition size: -"+(i+1),Label.RIGHT);
t2[i]=new TextField();
}

for(int i=0;i<n;i++)
{
add(l1[i]);
add(t1[i]);
}

for(int i=0;i<n;i++)
{
add(l2[i]);
add(t2[i]);
}



b1=new Button("Allocate");
add(b1);
b1.addActionListener(this);
op.setRows(100);
op.setColumns(100);
add(op);
}

public void actionPerformed(ActionEvent e)
{
int flag;
int prc[]=new int[n];
int prt[]=new int[n];
int p[]=new int[n];
op.insert(" ",1);
for(int i=0;i<n;i++)
{
p[i]=0;
prc[i]=Integer.parseInt(t1[i].getText());
prt[i]=Integer.parseInt(t2[i].getText());

}

op.append("Process allocated in FIRST FIT: \n\n");

for(int i=0;i<n;i++)
{	flag=0;
	for(int j=0;j<n;j++)
	{
	 if((prt[j]>=prc[i])&&(p[j]!=1))
		{
		
		op.append("Process"+(i+1)+" allocated in partition "+(j+1)+"\n");
		p[j]=1;
		flag=1;
		break;
		}
	
	}
	if(flag==0)
	{
	 op.append("Process"+(i+1)+"cannot be allocated \n");
	}
}

}


public static void main(String args[])
{
firstfit x=new firstfit();
x.setSize(new Dimension(500,500));
x.setVisible(true);
}

}
 
class myWindowAdapter extends WindowAdapter
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
}

