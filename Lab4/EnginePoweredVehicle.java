public class EnginePoweredVehicle extends Vehicle implements printable
{
	
	public String policyclass;
	public boolean hasPolicy;
		

	public EnginePoweredVehicle(String modelName,String ownerName,String policyclass,int noOfWheels)
	{
		this.modelName=modelName;
		this.ownerName=ownerName;
		this.policyclass=policyclass;
		this.noOfWheels=noOfWheels;
		
	}
	public void printable()
	{
		System.out.print("Model Name "+this.modelName+" Owner Name "+this.ownerName);
	}



	public boolean gethasPolicy()
	{
		return this.hasPolicy;
	}
	public void sethasPolicy(boolean hasPolicy)
	{
		this.hasPolicy=hasPolicy;
	}

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

}