package dev.football.playbook.Entity;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.*;

public class PopulateDb {

     private final String teamImages = "https://loodibee.com/nfl/";
     private final String teamPlaybooks ="https://huddle.gg/23/playbooks/";

     private  final ChromeOptions options = new ChromeOptions();

     private  List<WebElement> playBookLinks;

     private final int offTotal = 32;



    public PopulateDb() {
    }

    public WebDriver createDriver() {

        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors",
                "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");

        return new ChromeDriver(options);
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

            if(driver.findElement(By.xpath("//main[@id='main']/article//div[@class='entry-content']/div[3]")).findElements(By.cssSelector("figure")).size() == 0) {

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


    public List<WebElement> choosePlayBooks(String playbooksType){

      List<WebElement> playbookLinks = new ArrayList<>();

        WebDriver driver = createDriver();

        driver.get(teamPlaybooks);


        if(playbooksType.toUpperCase().equals("OFFENSE")){

            //Get list of all playbook links
            playbookLinks = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/ul[1]")).findElements(By.cssSelector("li"));


        }else if(playbooksType.toUpperCase().equals("DEFENSE")){

            //Get list of all playbook links
            playbookLinks = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/ul[2]")).findElements(By.cssSelector("li"));

        }
        driver.quit();

        return playbookLinks;
    }


    public  Map<String,Set<String>> getPlayBooks(String site,String playBookType){


        int formationTotal;
        String playbookName;
        String formationName;

        Map<String, Set<String>> playBookMap = new HashMap<>();

        WebDriver  driver = createDriver();

        driver.get(site);

        //Get list of all playbook links
        playBookLinks = choosePlayBooks(playBookType);

        System.out.println(offTotal);

        for(int i=0; i<= offTotal-1; i++){

            Set<String> formations = new HashSet<>();

            //Click on the first link
            playBookLinks.get(i).click();

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



    public Map<String,Set<String>> getSchemes(String site, String playBookTypes){

        Map<String,Set<String>> schemesInfo = new TreeMap<>();
        Set<String> schemes = new HashSet<>();
        String  formationName = null;
        String schemeName;
        int schemeTotal;
        int i; //offenseNumber
        int f = 1; //Formation Number
        int s = 0; //Scheme number

        WebDriver  driver = createDriver();

        driver.get(site);

        //Get list of all playbook links
        playBookLinks = choosePlayBooks(playBookTypes);

        //Get number of links
         int offTotal = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/ul[1]")).findElements(By.cssSelector("li")).size();


            //List to catch and record errors that occur
            List<String> errorList = new ArrayList<>();

            // System.out.println(offTotal);
            for (i = 0; i <= offTotal - 1; i++) { //change back to 0
                try {

                //Click on the first link
                playBookLinks.get(i).click();

                //Get Playbook name
                String playbookName = driver.findElement(By.xpath("/html//div[@class='body-content']/div//h1[@class='heading heading--blue']")).getText();

               // System.out.println(playbookName);

                //Getting the number of formations on page
                int formationTotal = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div")).findElements(By.cssSelector("h3")).size();

               // System.out.println(formationTotal);

                for ( f = 1; f <= formationTotal; f++) {//Change back to 1
                    driver.navigate().refresh();

                    formationName = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div/h3[" + f + "]")).getText();

                 //   System.out.println(formationName);

                    schemeTotal = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div/ul[" + f + "]")).findElements(By.cssSelector("li")).size() - 1;

                   // System.out.println(schemeTotal + 1);
                    try {
                        for ( s = 0; s <= schemeTotal; s++) {


                            //Element goes dead after iterating

                            List<WebElement> schemeElements = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div/ul[" + f + "]")).findElements(By.cssSelector("li"));


                            schemeElements.get(s).click();


                            schemeName = driver.findElement(By.xpath("/html//div[@class='body-content']/div//h1[@class='heading heading--blue']")).getText();

                        //    System.out.println(schemeName + "\n");

                            schemes.add(schemeName);

                            driver.navigate().back();
                        }

                    } catch (NoSuchElementException exc) {

                        //continue;

                    }
                    //driver.navigate().back();
                }

                String playbookFormation = playbookName +"_" +formationName;

                schemesInfo.put(playbookFormation, schemes);

                driver.navigate().back();

                }catch(Exception exc) {
                 String offense = "Offensive number: "+ i;
                String formation = "Formation number: "+f;
                String scheme = "Scheme number: " + s;

                errorList.add(offense+"\n"+formation+"\n"+scheme);

                    schemes.clear();
            }

            }

        driver.quit();

        System.out.println(schemesInfo);

        return schemesInfo;
    }



    public void getPlays(String site, String playbookType) {

        List<WebElement> formationLinks;
        List<WebElement> schemeLinks;
        String playName;
        String playImage;
        //List to catch and record errors that occur
        List<String> errorList = new ArrayList<>();

        WebDriver driver = createDriver();

        driver.get(site);

            for (int p = 0; p <= 31; p++) {

                //Get list of all playbook links
                playBookLinks = choosePlayBooks(playbookType);
                // playbookLinks = driver.findElement(By.xpath(".l-sidebar__main > ul:nth-of-type(1)")).findElements(By.cssSelector("li"));

                playBookLinks.get(p).click();

                //Get Playbook name
                String playbookName = driver.findElement(By.xpath("/html//div[@class='body-content']/div//h1[@class='heading heading--blue']")).getText();

                System.out.println(playbookName);

              int  formationLinksSize = driver.findElement(By.cssSelector(".py-5.wrapper > ul:nth-of-type(1)")).findElements(By.cssSelector("li")).size();

                for (int f = 0; f <= formationLinksSize ; f++) {

                    try {

                        //number of unordered lists formations
                        formationLinks = driver.findElement(By.cssSelector(".py-5.wrapper > ul:nth-of-type(1)")).findElements(By.cssSelector("li"));

                        formationLinks.get(f).click();

                        String formationName = driver.findElement(By.cssSelector(".heading.heading--blue")).getText();

                        System.out.println(formationName);

                    }catch (TimeoutException exc){

                        driver.navigate().refresh();
                        continue;
                    }

                    int schemeLinksSize = 0;

                        try {
                         schemeLinksSize  = driver.findElement(By.cssSelector(".play-tile-list")).findElements(By.cssSelector("a")).size();


                        }catch (NoSuchElementException exc){
                            formationLinks.get(f).click();

                           // continue;
                        }
                        for (int s = 0; s <= schemeLinksSize - 1; s++) {



                                //Get all scheme links
                                schemeLinks = driver.findElement(By.cssSelector(".play-tile-list")).findElements(By.cssSelector("a"));

                                schemeLinks.get(s).click();

                               // String schemeName = driver.findElement(By.xpath("/html//div[@class='body-content']/div//h1[@class='heading heading--blue']")).getText();

                                //  System.out.println(schemeName);

                                System.out.println(driver.findElement(By.cssSelector("a:nth-of-type(" + 1 + ") > .play-tile__info")).getText());
                                //playName = driver.findElement(By.cssSelector("a:nth-of-type(s) > .play-tile__info")).getText(); //change number variable

                                System.out.println(driver.findElement(By.cssSelector("a:nth-of-type(" + 1 + ") > .play-tile__image")).getCssValue("background-image"));
                                // playImage = driver.findElement(By.cssSelector("a:nth-of-type(s) > .play-tile__image")).getCssValue("background-image");


                                driver.navigate().back();
                            }
                            driver.navigate().refresh();
                            driver.navigate().back();
                        }


                        driver.navigate().back();
                    }
                }

            // driver.quit();



    public static void main(String[] args) {

        PopulateDb popDb = new PopulateDb();

        //  popDb.getDefensivePlayBooks(popDb.teamPlaybooks);

        popDb.getPlays("https://huddle.gg/23/playbooks/", "Offense");


        //popDb.getTeamImages("https://loodibee.com/nfl/"); team image site


    }
}
