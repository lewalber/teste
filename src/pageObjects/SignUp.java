package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class SignUp {
	
	WebDriver driver;
    
    By titlemrs = By.id("id_gender2");
    By firstname = By.id("customer_firstname"); 
    By lastname = By.id("customer_lastname");
    By pass = By.id("passwd");
    By address1 = By.id("address1");
    By city = By.id("city");
    By state = By.id("id_state");
    By postcode = By.id("postcode");
    By country = By.id("id_country");
    By phone_mobile = By.id("phone_mobile");
    By save_button = By.id("submitAccount");

    public String firstName = "leticia";
    public String lastName = "walber";
    public String address = "Street 14 n 14";
    public String post = "88888";
    public String city1= "curitiba";
    public String state1 = "Arizona";
    public String country1 = "United States";
    public String pwd = "123456";
    public String mobile = "5541888888888";
    

    
    public SignUp(WebDriver driver){
    	
        this.driver = driver;
    }

    //Set title
    public void setTitleMrs(){
    	
        driver.findElement(titlemrs).click();
    }
    
    //Set first name
    public void setFirstName(String first){
    	
         driver.findElement(firstname).sendKeys(first);
    }
    
    //Set last name
    public void setLastName(String last){
    	
        driver.findElement(lastname).sendKeys(last);
   }
    
    //Set password
    public void setPassword(String pwd){
    	
        driver.findElement(pass).sendKeys(pwd);
   }
    
    //Set address
    public void setAddress(String address){
    	
        driver.findElement(address1).sendKeys(address);
   }
       
    //Set city
    public void setCity(String cit){
    	
        driver.findElement(city).sendKeys(cit);
   }
  
    //Set state
    public void setState(String stat){
 
    	driver.findElement(state).click();
        driver.findElement(state).sendKeys(stat);
        Actions builder = new Actions(driver); 
        builder.sendKeys(Keys.ENTER);
         
   }
    
    //Set post code
    public void setPost(String post){
    	
        driver.findElement(postcode).sendKeys(post);
   }
    
    //Set country
    public void setCountry(String countr){

    	driver.findElement(country).click();
        driver.findElement(country).sendKeys(countr);
        Actions builder = new Actions(driver); 
        builder.sendKeys(Keys.ENTER);
        
   }
    
    //Set mobile
    public void setMobile(String mobile){
    	
        driver.findElement(phone_mobile).sendKeys(mobile);
   }

    //Click on Save button
    public void clickSave(){
    	
            driver.findElement(save_button).click();
    }

    // Cadastrar Usuário
    public void cadastro() throws InterruptedException {
    	
    	this.setTitleMrs();
    	this.setFirstName(firstName);
    	this.setLastName(lastName);
    	this.setPassword(pwd);
    	this.setAddress(address);
    	this.setPost(post);
    	this.setCity(city1);
    	this.setState(state1);
    	this.setCountry(country1);
    	this.setMobile(mobile);
    	
    }


}
