package dev.football.playbook.Entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.*;

public class PopulateDb {

     private String teamImages = "https://loodibee.com/nfl/";
     private String teamPlaybooks ="https://huddle.gg/23/playbooks/";

    private List<WebElement> playbookLinks;

    public PopulateDb() {
    }

    public WebDriver createDriver() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors",
                "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");

     WebDriver  driver = new ChromeDriver(options);// add options back for headless mode

        return driver;
    }

    public Map<String, String> getTeamImages(String site){

        Map<String,String> teamInfo = new HashMap<>();

        WebDriver driver = createDriver();

        driver.get(site);

        String teamName;

        String imagePath;

        List<WebElement> elements;

        for(int i=0; i<=driver.findElement(By.xpath("//main[@id='main']/article//div[@class='entry-content']/div[5]")).findElements(By.cssSelector("figure")).size()-1; i++){

            //Get team name
            teamName = driver.findElement(By.cssSelector("div:nth-of-type(5) > figure:nth-of-type("+(i+1)+") > figcaption > a")).getText();

            //Click on team
            driver.findElement(By.xpath("//main[@id='main']/article//div[@class='entry-content']/div[5]/figure["+(i+1)+"]")).click();

            //Get team image list
            elements = driver.findElement(By.xpath("//main[@id='main']/article//div[@class='entry-content']/div[3]")).findElements(By.cssSelector("figure"));

            if(driver.findElement(By.xpath("//main[@id='main']/article//div[@class='entry-content']/div[3]")).findElements(By.cssSelector("figure")).size()<=0) {

                //Get team image list
                elements = driver.findElement(By.xpath("//main[@id='main']/article//div[@class='entry-content']/div[4]")).findElements(By.cssSelector("figure"));

                //Get image location
                imagePath = elements.get(1).findElement(By.cssSelector("img")).getAttribute("src");

                teamInfo.put(teamName,imagePath);

             //   System.out.println("No."+(i+1)+" : "+ teamName+" \n"+ "image Location: "+ imagePath );

                driver.navigate().back();

                continue;
            }
            //Get image location
            imagePath = elements.get(1).findElement(By.cssSelector("img")).getAttribute("src");


            teamInfo.put(teamName,imagePath);

            System.out.println("No."+(i+1)+" : "+ teamName+" \n"+ "image Location: "+ imagePath );

            driver.navigate().back();
        }

        driver.quit();

        return teamInfo;

    }

    public  Map<String,Set<String>> getOffensivePlayBooks(String site){

        int offTotal;
        int formationTotal;
        String playbookName;
        String formationName;

        Map<String, Set<String>> playBookMap = new HashMap<>();


        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors",
                "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");

        WebDriver  driver = new ChromeDriver(options);// add options back for headless mode

        driver.get(site);

        //Get list of all playbook links
         playbookLinks = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/ul[1]")).findElements(By.cssSelector("li"));

        //Get number of links
        offTotal = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/ul[1]")).findElements(By.cssSelector("li")).size();

        System.out.println(offTotal);
        for(int i=0; i<= offTotal-1; i++){

            Set<String> formations = new HashSet<>();

            //Get list of all playbook links
            playbookLinks = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/ul[1]")).findElements(By.cssSelector("li"));


            //Click on the first link
            playbookLinks.get(i).click();

            //Get Playbook name
            playbookName = driver.findElement(By.xpath("/html//div[@class='body-content']/div//h1[@class='heading heading--blue']")).getText();

            //Getting the number of formations on page
            formationTotal =driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div")).findElements(By.cssSelector("h3")).size();

            for(int f = 1; f<= formationTotal; f++){
                //Getting formation name
                formationName = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div/h3["+f+"]")).getText();

                formations.add(formationName);
            }

            playBookMap.put(playbookName,formations);

            int j = i+1;

            System.out.println(j+": "+playbookName+" "+"no of formations: "+formationTotal+"\n"+ formations+ "\n");

            driver.navigate().back();
        }



        driver.quit();

        return playBookMap;
    }

    public  Map<String,Set<String>> getDefensivePlayBooks(String site){

        int defTotal;
        int formationTotal;
        String playbookName;
        String formationName;

        Map<String, Set<String>> playBookMap = new HashMap<>();


        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors",
                "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");

        WebDriver  driver = new ChromeDriver(options);// add options back for headless mode

        driver.get(site);

        //Get list of all playbook links
         playbookLinks = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/ul[2]")).findElements(By.cssSelector("li"));

        //Get number of links
        defTotal = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/ul[2]")).findElements(By.cssSelector("li")).size();

        //for debugging
        //System.out.println(total);
        for(int i=0; i<= defTotal-1; i++){

            Set<String> formations = new HashSet<>();

            //Get list of all playbook links
            playbookLinks = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/ul[2]")).findElements(By.cssSelector("li"));


            //Click on the first link
            playbookLinks.get(i).click();

            //Get Playbook name
            playbookName = driver.findElement(By.xpath("/html//div[@class='body-content']/div//h1[@class='heading heading--blue']")).getText();

            //Getting the number of formations on page
            formationTotal =driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div")).findElements(By.cssSelector("h3")).size();

            for(int f = 1; f<= formationTotal; f++){
                //Getting formation name
                formationName = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div/h3["+f+"]")).getText();

                formations.add(formationName);
            }

            playBookMap.put(playbookName,formations);

            int j = i+1;

            //For debugging
           // System.out.println(j+": "+playbookName+" "+"no of formations: "+formationTotal+"\n"+ formations+ "\n");

            driver.navigate().back();
        }



        driver.quit();

        return playBookMap;
    }

    public Map<String,Set<String>> getOffensiveSchemes(String site){

        Map<String,Set<String>> schemesInfo = new HashMap<>();
        String  formationName = null;
        String schemeName = null;
        int schemeTotal = 0;


        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors",
                "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");

        WebDriver  driver = new ChromeDriver(options);// add options back for headless mode

        driver.get(site);

        //Get list of all playbook links
        playbookLinks = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/ul[1]")).findElements(By.cssSelector("li"));

        //Get number of links
      int offTotal = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/ul[1]")).findElements(By.cssSelector("li")).size();

       // System.out.println(offTotal);
        for(int i=0; i<= offTotal-1; i++) {


            Set<String> schemes = new HashSet<>();

            //Get list of all playbook links
            playbookLinks = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/ul[1]")).findElements(By.cssSelector("li"));


            //Click on the first link
            playbookLinks.get(i).click();

            //Get Playbook name
            String playbookName = driver.findElement(By.xpath("/html//div[@class='body-content']/div//h1[@class='heading heading--blue']")).getText();

            System.out.println(playbookName);

            //Getting the number of formations on page
            int formationTotal = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div")).findElements(By.cssSelector("h3")).size();

            System.out.println(formationTotal);

            for(int f=1; f<= formationTotal; f++){
                driver.navigate().refresh();

                formationName = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div/h3["+f+"]")).getText();

                System.out.println(formationName);

                schemeTotal = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div/ul["+f+"]")).findElements(By.cssSelector("li")).size()-1;

                System.out.println(schemeTotal+1);

                for(int s = 0; s<=schemeTotal; s++) {

                    //Element goes dead after iterating
                    
                    List<WebElement> schemeElements = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div/ul["+f+"]")).findElements(By.cssSelector("li"));


                    schemeElements.get(s).click();

                    schemeName = driver.findElement(By.xpath("/html//div[@class='body-content']/div//h1[@class='heading heading--blue']")).getText();

                    System.out.println(schemeName + "\n");

                    driver.navigate().back();
                }

                //driver.navigate().back();
            }


            driver.navigate().back();
        }


        driver.quit();

        return schemesInfo;
    }


    public static void main(String[] args) {

        PopulateDb popDb = new PopulateDb();

      //  popDb.getDefensivePlayBooks(popDb.teamPlaybooks);

        popDb.getOffensiveSchemes(popDb.teamPlaybooks);



       //popDb.getTeamImages("https://loodibee.com/nfl/"); team image site




//        ChromeOptions options = new ChromeOptions();
//
//        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors",
//                "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
//
//        WebDriver  driver = new ChromeDriver(options);// add options back for headless mode
//
//        driver.get("https://huddle.gg/23/playbooks/");
//
//        //Get list of all offensive playbook links count
//        System.out.println(driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/ul[1]")).findElements(By.cssSelector("li")).size());
//
//        //Get list of all playbook links
//        List<WebElement> elements = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/ul[1]")).findElements(By.cssSelector("li"));
//
//        //Click on the first link
//        elements.get(0).click();
//
//        //Get Playbook name
//        System.out.println(driver.findElement(By.xpath("/html//div[@class='body-content']/div//h1[@class='heading heading--blue']")).getText());
//
//        //Getting the number of formations on page
//        System.out.println(driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div")).findElements(By.cssSelector("h3")).size());
//
//        //Getting formation name
//        System.out.println(driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div")).findElement(By.cssSelector("h3")).getText());
//
//        //Getting number of schemes
//        System.out.println(driver.findElement(By.xpath("/html//div[@class='body-content']//div[@class='l-sidebar__main']/div/ul[1]")).findElements(By.cssSelector("li")).size());
//
//        //Loop through to get each scheme name
//        System.out.println(driver.findElement(By.xpath("/html//div[@class='body-content']//div[@class='l-sidebar__main']/div/ul[1]")).findElement(By.cssSelector("ul:nth-of-type(1) > li:nth-of-type(1) > .playbooks-list__link")).getText());
//
//        //Click scheme link
//        driver.findElement(By.xpath("/html//div[@class='body-content']//div[@class='l-sidebar__main']/div/ul[1]")).findElement(By.cssSelector("ul:nth-of-type(1) > li:nth-of-type(1) > .playbooks-list__link")).click();
//
//        //Get scheme name
//        System.out.println(driver.findElement(By.xpath("/html//div[@class='body-content']/div//h1[@class='heading heading--blue']")).getText());
//
//        //Get number of plays
//        System.out.println(driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='play-tile-list']")).findElements(By.cssSelector("a")).size());
//
//        //Get play name
//        System.out.println(driver.findElement(By.cssSelector("a:nth-of-type(1) > .play-tile__info")).getText());
//
//        //Get play picture location
//        System.out.println(driver.findElement(By.cssSelector("a:nth-of-type(1) > .play-tile__image")).getCssValue("background-image"));

//        driver.quit();
    }

}
