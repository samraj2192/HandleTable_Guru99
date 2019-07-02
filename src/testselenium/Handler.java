package testselenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Handler {
	static WebDriver driver;
	static WebElement Elem_table;
	static WebElement Elem_rows;
	static List<WebElement> Header;
	static List<WebElement> Rows;
	static List<WebElement> Columns;
	
	public static void Handle_launcher(String browser){
		switch(browser){
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Samraj_backup\\Softwares\\Extracted jars\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://demo.guru99.com/test/web-table-element.php#");
			driver.manage().timeouts().implicitlyWait(13000, TimeUnit.MILLISECONDS);
			
//		case "IE":
//			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//			capabilities.setCapability("requireWindowFocus", true);  
//			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, false);
//			capabilities.setCapability("ie.ensureCleanSession", true);
//			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//			capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
//			System.setProperty("webdriver.ie.driver", "C:\\Samraj_backup\\Softwares\\Extracted jars\\BrowserDrivers\\IEDriverServer.exe");
//			driver = new InternetExplorerDriver(capabilities);
////			driver.manage().window().maximize(); 
//			driver.get("http://demo.guru99.com/test/web-table-element.php#");
//			driver.manage().timeouts().implicitlyWait(13000, TimeUnit.MILLISECONDS);
		}
		
	}
	
	public static void Handle_table(){
		Elem_table = driver.findElement(By.xpath("//table[@class= 'dataTable']"));
		Elem_rows = driver.findElement(By.xpath("//table[@class= 'dataTable']/tbody//td"));
		Rows = Elem_rows.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
//		System.out.println(Header.size());
//		for(int i=1; i<=Header.size(); i++){
//			String h_r = driver.findElement(By.xpath("//table[@class= 'dataTable']/thead//th["+i+"]")).getText();
//			System.out.println(h_r);
//		}
		for(int a=1; a<=Rows.size(); a++){
			Columns = Elem_rows.findElements(By.xpath("//table[@class='dataTable']/tbody/tr["+a+"]/td"));
			for(int b=1; b<=Columns.size(); b++){
				String values = Elem_rows.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+a+"]/td["+b+"]")).getText();
				System.out.print(values + "  ");
			}
			System.out.println("");
		}
		
	}
	
	public static void Handle_SpecificRows(){
		Rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		for(int a=1; a<Rows.size(); a++){
			String Company = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+a+"]/td[1]")).getText();
			System.out.println(a + " : " + Company);
		}
	}
	
	public static void Handle_SpecificValues(double d, double e){
		Rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		for(int a=1; a<Rows.size(); a++){
			String c = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+a+"]/td[5]")).getText();
			float Percent_change = Handler.Handle_integers(c);
			if((Percent_change>=d)&&(Percent_change<=e)){
				String Company = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+a+"]/td[1]")).getText();
				System.out.println(Company + " : " + Percent_change);
			}
			
		}
	}

	public static float Handle_integers(String str){
		String s = str;
		StringBuffer sbuf =  new StringBuffer();
		char[] char_s = s.toCharArray();
		for(int i=0; i<char_s.length; i++){
			if(char_s[i]!='+'&&char_s[i]!=' '){
				sbuf.append(char_s[i]);
			}
		}
		float num = Float.valueOf(sbuf.toString());
		return num;
	}
	
}
