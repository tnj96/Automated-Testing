package DDT_Test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Parameterisation {
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {{"TestOne", "TestTwo", "TestThree","TestFour"}, {"PassOne", "PassTwo", "PassThree", "PassFour"}});	
	}
	
	private String x;
	private String y;
	private String z;
	private String a;
	
	public Parameterisation(String x, String y, String z, String a) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.a = a;
	}
	
	@Test
	public void test1() {
		System.out.println(x +" " +y +" " +z +" " +a);
	}


}
