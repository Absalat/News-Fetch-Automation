import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.util.List;

public class newstest {

    public static void main(String []args){
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.justjared.com/");

//        driver.get("file:///C:/Users/Nahom/Downloads/Celebrity%20Gossip%20and%20Entertainment%20News%20_%20Just%20Jared.html");

        Grabber grabber = new Grabber();


        int pages = 0;

        while (pages < 2) {
            List<WebElement> headlines = driver.findElements(By.className("post"));

            for (WebElement i : headlines) {
                String headline = i.findElement(By.tagName("a")).getText();
                grabber.insertHeadlines(headline);
            }

            List<WebElement> stories = driver.findElements(By.className("entry"));

            for (WebElement j : stories) {
                String story = j.getText();
                grabber.insertStory(story);

            }
            WebElement nextBtn = driver.findElement(By.cssSelector("#content > div.main-index-posts-nav > div > a:nth-child(7)"));
            nextBtn.click();

            pages++;

        }
        System.out.println(grabber.getHeadlines().size());
        System.out.println(grabber.getStories().size());






    }
}
