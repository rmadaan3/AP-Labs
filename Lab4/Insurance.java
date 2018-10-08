import java.util.*;

public class Insurance
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		Random random = new Random();
		Vehicle e1=new EnginePoweredVehicle("KTM","Popeye","thirdparty",2);
		e1.sethasPolicy(false);

		Vehicle e2=new EnginePoweredVehicle("Harley","Baniya","thirdparty",2);
		e2.sethasPolicy(true);
		
		Vehicle e3=new EnginePoweredVehicle("Maybach","Bagga Boi","package",4);
		e3.sethasPolicy(true);
		
		Vehicle e4=new EnginePoweredVehicle("Grand Tourismo","Protick","package",4);
		e4.sethasPolicy(false);
		
		Vehicle n1=new NonEnginePoweredVehicle("Cycle","Pakistani",2);
		// Vehicle n2=new NonEnginePoweredVehicle("Bullock Cart","Bansal",4);


		Vehicle[] v=new Vehicle[5]; 
		
		v[0]=e1;
		v[1]=e2;
		v[2]=e3;
		v[3]=e4;
		v[4]=n1;
		// v[5]=n2;


		System.out.println("Simulations are going to start");
		
		System.out.println();
		int a=0;
		// while (a<6)
		while(a<5)
		{
			//v[a] is the collision initiator
			int b=0;
			// while(b<6)
			while (b<5)
			{
				if(b!=a)
				{

				System.out.print("Vehicle 1"+" ");
				v[a].printable();
				System.out.print(" ");
				System.out.print(" collided with ");
				System.out.print("Vehicle 2"+" ");
				v[b].printable();
				
				// System.out.println();
				// System.out.print("Enter Damages to self: ");
				double self= random.nextInt(2000);
				// System.out.println();
				// System.out.print("Enter Damage to oncoming: ");
				double oncoming=random.nextInt(2000);

				//collision initiated by nonenginepoweredvehicle
				if (v[a] instanceof NonEnginePoweredVehicle)
				{
					if (v[b] instanceof EnginePoweredVehicle)
					{

					v[a].setDamage(self);
					v[b].setDamage(oncoming);
					
					System.out.print("Damages awarded to Self: ");
					System.out.println(v[a].getDamage());
					System.out.print("Damages awarded to Oncoming Vehicle: ");
					System.out.println(v[a].getDamage());
					
					v[b].setsettlement(((v[b].getDamage()))*0.1);
					
					System.out.println("Settlement Details");
					System.out.println("Damages to Self: "+v[a].getDamage()+"Settlement : "+v[a].getsettlement());
					// System.out.println(v[a].getDamage());
					System.out.println("Damages to Oncoming: "+v[b].getDamage()+"Settlement : "+v[b].getsettlement());
					// System.out.println(v[a].getDamage());
					// System.out.print("Settlement for oncoming vehicle: ");
					// System.out.println(v[b].getsettlement());
					
					System.out.println("You just collided with a enginepoweredvehicle; you might have to battle it out MMA style ");
					System.out.println();
					}
					else
					{
						
						System.out.println("You just collided with a nonenginepoweredvehicle; MAY THE BEST MAN WIN ");
						System.out.println();
					}
				}

				//collision initiated by enginepoweredvehicle
				else
				{
					//holds a valid policy 
					if(v[a].hasPolicy)
					{
						if(v[a].noOfWheels==4)
						{
							v[a].setDamage(self);
							v[b].setDamage(oncoming);

							System.out.print("Damages awarded to Self: ");
							System.out.println(v[a].getDamage());
							System.out.print("Damages awarded to Oncoming: ");
							System.out.println(v[b].getDamage());

							v[a].setsettlement(((v[a].getDamage())*0.6));
							v[b].setsettlement(((v[b].getDamage())*0.8));
							System.out.println("Settlement Details");
							System.out.println("Damages to Self: "+v[a].getDamage()+"Settlement : "+v[a].getsettlement());
					// System.out.println(v[a].getDamage());
							System.out.println("Damages to Oncoming: "+v[b].getDamage()+"Settlement : "+v[b].getsettlement());
							// System.out.println(v[a].getDamage());
							System.out.println();



						}
						//is a two wheeler having valid policy
						else
						{
							v[a].setDamage(self);
							v[b].setDamage(oncoming);
							System.out.print("Damages awarded to Vehicle 1: ");
							System.out.println(v[a].getDamage());
							System.out.print("Damages awarded to Vehicle 2: ");
							System.out.println(v[a].getDamage());
							v[a].setsettlement(((v[a].getDamage())*0.1));
							v[b].setsettlement(((v[b].getDamage())*0.5));

							System.out.println("Settlement Details");
							System.out.println("Damages to Self: "+v[a].getDamage()+"Settlement : "+v[a].getsettlement());
					// System.out.println(v[a].getDamage());
							System.out.println("Damages to Oncoming: "+v[b].getDamage()+"Settlement : "+v[b].getsettlement());
							System.out.println();

						}
					}
					//does not hold a valid policy
					else
					{
						v[a].setDamage(self);
						v[b].setDamage(oncoming);

						v[a].setsettlement((v[a].getDamage())*0.1);
						System.out.println("Settlement Details");
						System.out.println("Damages to Self: "+v[a].getDamage()+"Settlement : "+v[a].getsettlement());
					// System.out.println(v[a].getDamage());
						System.out.println("Damages to Oncoming: "+v[b].getDamage()+"Settlement : "+v[b].getsettlement());
							
						System.out.println("Collision initiator has expired policy; time for a fight");
						System.out.println();
					}
				}

				}
				b++;
			}
			a++;
		}
	}
}