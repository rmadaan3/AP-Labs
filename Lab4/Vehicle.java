public class Vehicle 
{
	public String modelName;
	public String ownerName;
	public int noOfWheels;
	public double Damage;
	public double settlement;
	public boolean hasPolicy;


	public double getDamage()
	{
		return this.Damage;
	}
	public void setDamage(double Damage)
	{
		this.Damage=Damage;
	}

	public double setsettlement(double settlement)
	{
		return this.settlement=settlement;
	}

	public double getsettlement()
	{
		return this.settlement;
	}

	public boolean gethasPolicy()
	{
		return this.hasPolicy;
	}
	public void sethasPolicy(boolean hasPolicy)
	{
		this.hasPolicy=hasPolicy;
	}

	public void printable()
	{
		System.out.print("Model Name "+this.modelName+"No of Wheels: "+this.noOfWheels+" Owner Name "+this.ownerName+" Is Policy Valid: "+this.hasPolicy);
	}
}