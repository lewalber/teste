package functionalTests;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.FileUtils;
import pageObjects.*;



class Testing {

	WebDriver driver;
	
    Item itemPage;
    PopupSummary popupPage;
    Summary summaryPage;
    SignUp signupPage;
    Address addressPage;
    Shipping shippingPage;
    Payment paymentPage;


    String bank = "BANK-WIRE PAYMENT.";
	String logpath = "C://Users//Admin//eclipse-workspace//TestQA//target//screen_";
	

    public java.util.Random random1 = new java.util.Random();
	


    @Test
	public void successful_purchase() throws Throwable {

		File dir = new File("C:\\Users\\Admin\\eclipse-workspace\\TestQA\\target\\Report_successful_purchase");
    	Document doc = new Document(PageSize.A4);
    	OutputStream os = new FileOutputStream(dir + ".pdf");
    	PdfWriter.getInstance(doc,  os);
    	doc.open();
 
		Paragraph par = new Paragraph();
		par.add("Evidências de Teste");
		doc.add(par);

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationpractice.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
        	
		
	// CHOSE A PRODUCT	
		WebElement product = driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > h5 > a"));
		product.click();
		Thread.sleep(3000);
		
	// ADD TO CART    // ITEM PAGE
		itemPage = new Item(driver);
		String p = itemPage.getPrice();
		Paragraph par2 = new Paragraph();
		par2.add("Preço do Item: " + p);
		doc.add(par2);
		itemPage.clickAddToCart();
		Thread.sleep(2000);
		this.takeScreenShot(driver, logpath + "1_" + "after_add_to_cart" + ".png");

	// PROCEED TO CHECKOUT 	// POPUP SUMMARY PAGE
		popupPage = new PopupSummary(driver);
		String s = popupPage.getShippingPrice();
        par2 = new Paragraph();
		par2.add("Total de Taxa: " + s);
		doc.add(par2);
        popupPage.verifyTotalProducts(p);
        popupPage.clickCheckout();
		
	// VALIDATE IF PRODUCT WAS ADDED TO CART
		Thread.sleep(2000);
		summaryPage = new Summary(driver);
		summaryPage.verifyProductAdded(1);
        String quantidade = summaryPage.getQty();
		par2 = new Paragraph();
		par2.add("Quantidade: " + quantidade);
		doc.add(par2);
        
	// ENTER EMAIL
	    String ParteEmail1 = "";
		ParteEmail1 = this.Random1();
	    String Email1 = ParteEmail1 + "@teste.com.br";
		summaryPage.clickProceed();
		Thread.sleep(1000);
		summaryPage.setEmail(Email1);
		Thread.sleep(1000);
		summaryPage.clickCreateAccount();
		Thread.sleep(2000);
		
	// CREATE AN ACCOUNT - VALIDATE REQUIRED FIELDS - SIGNUP PAGE
		signupPage = new SignUp(driver);
        signupPage.cadastro(); 
    	signupPage.clickSave();
    	Thread.sleep(2000);
		
    // VERIFY ADDRESS
		addressPage = new Address(driver);
		Thread.sleep(2000);
        addressPage.verifyAddress();
        addressPage.clickProceed();
		Thread.sleep(2000);
        
	// ACCEPT TERMS
		shippingPage = new Shipping(driver);
		shippingPage.checkAgree();
		shippingPage.clickProceed();
        
	// VALIDATE PURCHASE VALUE 
		paymentPage = new Payment(driver);
		paymentPage.verify_total_prod(p);
		paymentPage.verify_total_shipping(s);
		Thread.sleep(3000);		

	// SELECT PAYMENT TYPE AND CONFIRM
		paymentPage.clickPayByBank();
		Thread.sleep(2000);
		paymentPage.bank_confirmation(bank);
		String total = paymentPage.getPurchaseTotal();
		par2 = new Paragraph();
		par2.add("Total da Compra: " + total);
		doc.add(par2);
		
		paymentPage.clickConfirm();
		Thread.sleep(2000);
		doc.close();
		driver.close();
	}
	
    //Get Random String
    public String Random1() {
    	
    return new BigInteger(120, random1).toString(32);

    }
    
    public static Document CriaPDFs(File dir2) throws Throwable {
    	
    	Document doc = new Document(PageSize.A4);
    	OutputStream os = new FileOutputStream(dir2 + ".pdf");
    	PdfWriter.getInstance(doc,  os);
    	doc.open();
    	
    	return doc;
    }
    

    public void takeScreenShot(WebDriver driver, String fpath) throws IOException {
    	
    	TakesScreenshot scrShot =((TakesScreenshot)driver);
    	File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
    	File DestFile = new File(fpath); 	
        FileUtils.copyFile(SrcFile, DestFile);
    	 
    }
    
	}
