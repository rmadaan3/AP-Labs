public class NonEnginePoweredVehicle extends Vehicle implements printable
{
	
	public boolean hasPolicy=false;
	

	public NonEnginePoweredVehicle(String modelName,String ownerName,int noOfWheels)
	{
		this.modelName=modelName;
		this.ownerName=ownerName;
		this.noOfWheels=noOfWheels;
		// this.hasPolicy=hasPolicy;
	}
	public void printable()
	{
		System.out.print("Model Name "+this.modelName+" Owner Name "+this.ownerName);
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