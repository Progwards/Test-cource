package ru.progwards.java1.SeaBattle;

import java.lang.reflect.InvocationTargetException;

public class CompetitionRunner {
	public static String run(String[] students) {
		String str = "";
		int n = 0;
		for(String name : students) {
			str += 	"      {\"name\": "+name+", \"number\": "+(++n)+", \"points\": "+runOne(name)+"}";
			if (n<students.length)
				str += ",";
			str += "\r\n";
		}
 		
		return "{\"competition\": {\r\n" + 				"  \"name\": \"Морской бой\",\r\n" + 
				"  \"results\": {\r\n" + 
				"    \"student\": [\r\n" +
				str+
				"    ]\r\n" + 
				"  }\r\n" + 
				"}}";
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static String runOne(String name) {
		String pname = CompetitionRunner.class.getName();
		int n = pname.lastIndexOf(".");
		pname = pname.substring(0, n+1)+name;
		try {
			Class classs = Class.forName(pname+".BattleAlg");
			Class[] params = {};
			BattleAlg alg = (BattleAlg) classs.getConstructor(params).newInstance();
			return alg.test("2");
			//System.out.println(alg.test("1"));
	   } catch (InstantiationException | IllegalAccessException | ClassNotFoundException |
			   NoSuchMethodException | InvocationTargetException e) {
	       //e.printStackTrace();
		   return "0";
	   }
	}

	public static void main (String[] args) 
	{
		String[] students = { "vpupkin", "pvasechkin", "iivinov" };
		System.out.println(run(students));
	} 
}
