package students.Onur;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class lab01 {
        public static void main(String[] args) {
            WebDriverManager.chromedriver().setup();
            WebDriver chrome = new ChromeDriver();
            chrome.get("https://www.etsy.com/");
            chrome.manage().window().maximize();
            chrome.manage().window().minimize();

            System.out.println("****************");

            chrome.get("https://www.amazon.com/");
            String title = chrome.getTitle();
            System.out.println("Title of current page is = " + title);

    }
}
