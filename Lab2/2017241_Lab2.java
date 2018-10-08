import java.util.*;
class Box
{
	public double length;
	public double breadth;
	public double height;
	
	public Box()
	{
	this.length=0;
	this.length=0;
	this.height=0;
	}

	public Box(double length,double breadth,double height)
	{
	this.length=length;
	this.breadth=breadth;
	this.height=height;
	}

	public Box(double everything)
	{
	this.length=everything;
	this.breadth=everything;
	this.height=everything;
	}

	public double calVol()
	{
	return (this.length*this.height*this.breadth);
	}

	public static void main(String[] args)
	{
		Box b1=new Box();
		System.out.println(b1.calVol());
		Box b2=new Box(1,2,3);
		System.out.println(b2.calVol());
		Box b3=new Box(1);
		System.out.println(b3.calVol());
	}
}
