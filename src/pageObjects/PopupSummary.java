package pageObjects;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PopupSummary{
	
	WebDriver driver;

    By quantity = By.id("layer_cart_product_quantity");
    By proceed = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a");
    By total_products = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[1]/span");
    By total_shipping = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[2]/span");
    By total_all = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div:nth-child(4) > span");
    
    
    public PopupSummary(WebDriver driver){

    	this.driver = driver;

    }
    
    public WebElement PrecoUnitario, TotalBuscado;


    public float BuscarPrecoUnitario() {
    	
    	PrecoUnitario = driver.findElement(total_products);

    			String StringPrecoUnitario;
    			float ValorProduto = 0;
    			StringPrecoUnitario = PrecoUnitario.getText();
//    			StringPrecoUnitario = StringPrecoUnitario.substring(2,10);
    			StringPrecoUnitario = StringPrecoUnitario.replace(',', ' ');
    			StringPrecoUnitario = StringPrecoUnitario.replaceAll("\\s", "");

    			ValorProduto = Float.valueOf(StringPrecoUnitario.trim()).floatValue();

    			return ValorProduto;
}


    public float BuscarValorTotal() {

    	TotalBuscado = driver.findElement(total_all);
    	String StringValorTotal;
    	float ValorTotal = 0;
    	StringValorTotal = TotalBuscado.getText();
    	StringValorTotal = StringValorTotal.substring(2,10);
    	StringValorTotal = StringValorTotal.replace(',', ' ');
    	StringValorTotal = StringValorTotal.replaceAll("\\s", "");
    	ValorTotal = Float.valueOf(StringValorTotal.trim()).floatValue();
    	return ValorTotal;
     }
    
    
   



    //verify quantity
    public void verifyQuantity(int qty) {
    	
        assertEquals(qty, driver.findElement(quantity));

    }
    
    //verify total products price
    public void verifyTotalProducts(String total) {
    	
        assertEquals(total, driver.findElement(total_products).getText());

    }
    
    //Get shipping price
    public String getShippingPrice() {
    	
        return driver.findElement(total_shipping).getText();
    }
    
    //Get product total price
    public WebElement getProdTotal() {
    	
        return driver.findElement(total_products);
    }

    //Click proceed to checkout
    public void clickCheckout(){
            driver.findElement(proceed).click();
     }

}
