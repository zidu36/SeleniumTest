import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SimpleBingTest {

    //验证点击登录是否有效，获取跳转的标题
    public String jumpByID(String id,WebDriver driver){
        WebElement element=driver.findElement(By.id(id));
        element.click();
        return driver.getTitle();

    }
    public String jumpByCss(String css,WebDriver driver){
        WebElement element=driver.findElement(By.cssSelector(css));
        element.click();
        String test=driver.getTitle();
        return test;

    }
    //不输入，直接下一步
    public String noInput(WebDriver driver){
        WebElement element1=driver.findElement(By.id("idSIButton9"));
        element1.click();
        WebElement element2=driver.findElement(By.id("usernameError"));
        return element2.getText();
    }
    //输入未注册或错误电话号码，验证是否能跳转页面
    public String inputPhone(String account,WebDriver driver) throws InterruptedException {
        //获取输入框
        WebElement element=driver.findElement(By.id("i0116"));
        element.sendKeys(account);
        //下一步
        WebElement element1=driver.findElement(By.id("idSIButton9"));
        element1.click();
        //获取新窗口句柄
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles())
        {
            if (winHandle.equals(winHandleBefore))
            {
                continue;
            }
            driver.switchTo().window(winHandle);
            break;
        }
        //确定电话号码下一步
        WebElement element2=driver.findElement(By.cssSelector("#idSIButton9"));
        element2.click();

        WebElement welement=driver.findElement(By.id("usernameError"));
        return welement.getText();
    }
    //输入已注册电话号，输入错误密码验证
    public String phoneLoginById(String account,String id,WebDriver driver){
        WebElement element=driver.findElement(By.id(id));
        element.sendKeys(account);
        WebElement element1=driver.findElement(By.id("idSIButton9"));
        element1.click();
        WebElement welement=driver.findElement(By.id("i0118"));
        welement.sendKeys("1234");
        WebElement element2=driver.findElement(By.id("idSIButton9"));
        element2.submit();
        WebElement weelement=driver.findElement(By.id("passwordError"));
        return weelement.getText();
    }

}