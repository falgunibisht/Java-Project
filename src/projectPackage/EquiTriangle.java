package projectPackage;

public class EquiTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=1; i<=4; i++)
		{
			for(int j=4; j>=i; j--)
			{
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
