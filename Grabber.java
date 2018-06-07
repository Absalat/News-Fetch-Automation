import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Grabber{

    private ArrayList<String> headlines = new ArrayList<String>();
    private ArrayList<String> storys = new ArrayList<String>();

    public Grabber(){

    }

    public void insertHeadlines(String headline){
        headlines.add(headline);

    }

    public void insertStory(String story){
        storys.add(story);
    }
    public List<String> getStories(){
        return this.storys;
    }

    public List<String> getHeadlines(){
        displaySite();
        return this.headlines;
    }

    public void displaySite(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Nahom/IdeaProjects/newsautomation/src/News.html");
        int i = 0, j = 0;
        while (i < storys.size()){
            while (j < headlines.size()) {
                String singleHeadline = headlines.get(j);
                String singleStory = storys.get(i);
//            System.out.println(singleHeadline);
                WebElement divHeadlines = driver.findElement(By.id("headlines"));
                divHeadlines.sendKeys(singleHeadline);

                WebElement divStories = driver.findElement(By.id("details"));
                divStories.sendKeys(singleStory);

                WebElement addButton = driver.findElement(By.id("addBtn"));
                addButton.click();

                divHeadlines.clear();
                divStories.clear();

                j++;
                i++;
//            break;
            }
        }


    }
}
