//ДЗ урока 2, задача 1
package Test1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClass1{
	
	// массив с данными для процессинга результата теста
	// 0: идентификатор теста, - имя функции @Test
	// 1: имя теста словами, если == "", то возмется идентификатор
	// 2: баллы за эту часть теста
	// 3: * отмечены обязательные части теста
	private static String[][] testData = { 
			// первая строка содержит данные о всем тесте. Оценка отражает прходной балл 
			{"TestTask21", "ДЗ урока 2, задача 1", "20", ""}, 
			{"test1", "Название подтеста 1", "20", "*"},
			{"test2", "Название подтеста 2", "10", ""},
	};
	
	@Before
    public void init() 
	{ 
	}
    
	@After
    public void done()
    {
    }
	
	
	@Test
	public void test1()
	{
		TestTask21 tt = new TestTask21();
		Assert.assertTrue(tt.t1().equals("111"));
	}

	@Test
	public void test2()
	{
		TestTask21 tt = new TestTask21();
		Assert.assertTrue("проверка a", tt.t2() == 222);
		Assert.assertTrue("проверка b", tt.t2() == 111);
		Assert.assertTrue("проверка c", tt.t2() == 333);
	}

	public static String[][] getData()
	{
		return testData;
	}
}

