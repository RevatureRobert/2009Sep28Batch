public class EnvironmentVariablesTest{
	public static void main(String[]args){
		int x = 0;
		
		for(String s : args){
			System.out.println("Arg " + (x++) + ": " + s);
		}
	}
}