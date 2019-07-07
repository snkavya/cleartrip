package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import generic.Base_Page;

public class welcomepage extends Base_Page{

	public welcomepage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
@FindBy(id="OneWay")
private WebElement oneway;

@FindBy(id="FromTag")
private WebElement from;

@FindBy(id="ToTag")
private WebElement to;

@FindBy(xpath="//i[.='Cal']")
private WebElement cal;

@FindBy(xpath="(//a[.='3'])[2]")
private WebElement date;

@FindBy(id="Adults")
private WebElement adult;

@FindBy(id="Childrens")
private WebElement children;

//Infants
@FindBy(id="Infants")
private WebElement infts;
//MoreOptionsLink

@FindBy(id="MoreOptionsLink")
private WebElement link;

//Class
@FindBy(id="Class")
private WebElement clas;

//SearchBtn
@FindBy(id="SearchBtn")
private WebElement serach;


public void onewaytrip()
{
	oneway.click();
}

public void fromplace(String fplace)
{
	from.sendKeys(fplace);
}

public void toplace(String tplace)
{
	to.sendKeys(tplace);
}

public void cal()
{
	cal.click();
}

public void date()
{
	date.click();
}

public void adlt()
{
	Select s=new Select(adult);
	s.selectByValue("3");
}

public void chldren()
{
	Select s=new Select(children);
	s.selectByValue("2");
}

public void infts()
{
	Select s=new Select(infts);
	s.selectByValue("1");
}

public void links()
{
link.click();
}


public void clas()
{
	Select s=new Select(clas);
	s.selectByVisibleText("Economy");
}

public void search()
{
	serach.click();
}

public void Verifyhomepage(String title)
{
	String extitle = driver.getTitle();
	Assert.assertEquals(title, extitle);
	VerifyTitle(title);
}
}
