import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class SeleniumDemo {
    //执行结果
    public static String result;

    public static void main(String[] args) throws InterruptedException {
        //驱动地址
        String chromedriver = "/Users/lliming/Desktop/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromedriver);
        //初始化一个chrome浏览器实例
        WebDriver driver = new ChromeDriver();
        //最大化窗口
        driver.manage().window().maximize();
        //设置隐性等待时间
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        //打开百度
        driver.get("https://www.baidu.com");


        //元素name定位 搜索框
        WebElement input = driver.findElement(By.name("wd"));
        //输入文本
        input.sendKeys("Selenium");

        //元素id定位 百度一下按钮
        WebElement button = driver.findElement(By.id("su"));
        String isDisplayed = button.isDisplayed() ? "可见" : "不可见";
        System.out.println("百度一下按钮是否可见： "+isDisplayed);

        //点击按钮
        button.click();
        Thread.sleep(2000);

        //元素定位class 搜索框
        String search_text = driver.findElement(By.className("s_ipt")).getAttribute("value");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));

        //断言
        result = Assert.equals("Selenium", search_text) ? "成功" : "失败";

        //打印执行结果
        System.out.println("用例执行" + result);
        //关闭驱动连接
        driver.close();

    }
}
