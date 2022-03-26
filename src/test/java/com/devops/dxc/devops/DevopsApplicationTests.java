package com.devops.dxc.devops;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devops.dxc.devops.model.Util;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DevopsApplicationTests {

	//Caso 1
	//Sueldo: $2.000.000
	//Ahorro: $10.000.000
	@Test
	public void testGetDxc_CASO1() throws Exception{
		assertEquals(1000000, Util.getDxc(10000000, 2000000));
	}
	
	@Test
	public void testGetImpuesto_CASO1() throws Exception{
		assertEquals(80000, Util.getImpuesto(10000000, 2000000));
	}
	
	@Test
	public void testGetSaldo_CASO1() throws Exception{
		assertEquals(9000000, Util.getSaldo(10000000, 2000000));
	}

	//Caso 2
	//Sueldo: $1.400.000
	//Ahorro: $30.000.000
	@Test
	public void testGetDxc_CASO2() throws Exception{
		//10%
		assertEquals(3000000, Util.getDxc(30000000, 1400000));
	}
	
	@Test
	public void testGetImpuesto_CASO2() throws Exception{
		//Impuesto
		assertEquals(0, Util.getImpuesto(30000000, 1400000));
	}
	
	@Test
	public void testGetSaldo_CASO2() throws Exception{
		//Saldo
		assertEquals(27000000, Util.getSaldo(30000000, 1400000));
	}

	//Caso 3
	//Sueldo: $2.000.000
	//Ahorro: $18.000.000
	@Test
	public void testGetDxc_CASO3() throws Exception{
		//10%
		assertEquals(1800000, Util.getDxc(18000000, 2000000));
	}
	
	@Test
	public void testGetImpuesto_CASO3() throws Exception{
		//Impuesto
		assertEquals(144000, Util.getImpuesto(18000000, 2000000));
	}
	
	@Test
	public void testGetSaldo_CASO3() throws Exception{
		//Saldo
		assertEquals(16200000, Util.getSaldo(18000000, 2000000));
	}

	@Test
	public void seleniumTest() {
	  System.out.print("**********************Ejecutando Test de Selenium***********************");
	  JavascriptExecutor js;
	  WebDriver driver;
	  System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	  driver = new ChromeDriver();
	  js = (JavascriptExecutor) driver;
	  System.out.print("Ejecutando Test de Selenium");
	  driver.get("http://localhost:3000/");
	  driver.manage().window().setSize(new Dimension(1276, 693));
	  driver.findElement(By.id("input_sueldo")).click();
	  driver.findElement(By.id("input_sueldo")).sendKeys("40000");
	  driver.findElement(By.id("input_ahorro")).click();
	  driver.findElement(By.id("input_ahorro")).sendKeys("50000");
	  driver.findElement(By.id("btn_dxc")).click();
	  driver.findElement(By.id("btn_saldo")).click();
	  driver.findElement(By.id("btn_impuesto")).click();
	}

}
