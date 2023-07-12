package dev.football.playbook.Entity;

import dev.football.playbook.Service.implementation.TeamServiceImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class PopulateDb {

    private final String teamImages = "https://loodibee.com/nfl/";
    private final String teamPlaybooks = "https://huddle.gg/23/playbooks/";

    private final ChromeOptions options = new ChromeOptions();
    private List<WebElement> playBookLinks;



    private TeamServiceImpl teamService;


    public PopulateDb() {
    }
    @Autowired
    public PopulateDb(TeamServiceImpl teamService) {
        this.teamService = teamService;
    }

//    public static void main(String[] args) {
//
//
//
//        PopulateDb popDb = new PopulateDb();
//
//        //  popDb.getDefensivePlayBooks(popDb.teamPlaybooks);
//
//        //popDb.getPlays("Offense");
//
//
//        popDb.getTeamImages(); //team image site
//
//
//    }

    public void getPlays( String playbookType) {


        String teamPlaybooks = "https://huddle.gg/23/playbooks/";
        List<WebElement> formationLinks;
        List<WebElement> schemeLinks;
        List<WebElement> playLinks;
        String playName;
        String playImage;
        //List to catch and record errors that occur
        List<String> errorList = new ArrayList<>();

        WebDriver driver = createDriver();

        driver.get(teamPlaybooks);

        for (int pb = 0; pb <= 31; pb++) {//change to 0
              driver.navigate().refresh();

            //Get list of all playbook links
            playBookLinks = choosePlayBooks(driver, playbookType);
            // playbookLinks = driver.findElement(By.xpath(".l-sidebar__main > ul:nth-of-type(1)")).findElements(By.cssSelector("li"));

            playBookLinks.get(pb).click();

            //Get Playbook name
            String playbookName = driver.findElement(By.xpath("/html//div[@class='body-content']/div//h1[@class='heading heading--blue']")).getText();

            System.out.println(playbookName);

            int formations = driver.findElements(By.cssSelector("ul")).size();


            for (int f = 1; f <= formations - 1; f++) {//change to 1
                int schemeLinksSize = driver.findElement(By.cssSelector(".py-5.wrapper > ul:nth-of-type(" + f + ")")).findElements(By.cssSelector("li")).size();


                String formationName = driver.findElement(By.cssSelector(".py-5.wrapper > h3:nth-of-type(" + f + ")")).getText();

                System.out.println((f ) + " . " + formationName);


                System.out.println((schemeLinksSize + 1) + " schemes");

                for (int s = 0; s <= schemeLinksSize - 1; s++) {//change to 0

                    try {

                        //number of unordered lists formations
                        schemeLinks = driver.findElement(By.cssSelector(".py-5.wrapper > ul:nth-of-type(" + f + ")")).findElements(By.cssSelector("li"));

                        schemeLinks.get(s).click();

                        String schemeName = driver.findElement(By.cssSelector(".heading.heading--blue")).getText();

                        System.out.println((s + 1) + ". " + schemeName);


                        int playLinksSize = 0;


                        playLinksSize = driver.findElement(By.cssSelector(".play-tile-list")).findElements(By.cssSelector("a")).size();

                        System.out.println(playLinksSize + " plays");


                        for (int p = 0; p <= playLinksSize - 1; p++) {


                            //Get all scheme links
                            playLinks = driver.findElement(By.cssSelector(".play-tile-list")).findElements(By.cssSelector("a"));

                            playLinks.get(p).click();

                            // String schemeName = driver.findElement(By.xpath("/html//div[@class='body-content']/div//h1[@class='heading heading--blue']")).getText();

                            //System.out.println(p + "*****************************");

                            //System.out.println(driver.findElement(By.cssSelector("a:nth-of-type(" + 1 + ") > .play-tile__info")).getText());
                            playName = driver.findElement(By.cssSelector("a:nth-of-type(s) > .play-tile__info")).getText(); //change number variable

                            //System.out.println(driver.findElement(By.cssSelector("a:nth-of-type(" + 1 + ") > .play-tile__image")).getCssValue("background-image"));
                            playImage = driver.findElement(By.cssSelector("a:nth-of-type(s) > .play-tile__image")).getCssValue("background-image");


                            driver.navigate().back();
                        }


                    } catch (Exception exc) {

                        continue;
                    }


                    driver.navigate().back();

                }

            }



            driver.navigate().back();
        }

        driver.quit();
    }

    public void getTeamImages() {

       List<Team> teamInfo = new ArrayList<>();

        WebDriver driver = createDriver();

        driver.get(teamImages);

        String teamName;

        String imagePath;

        List<WebElement> elements;

        for (int i = 0; i <= driver.findElement(By.xpath("//main[@id='main']/article//div[@class='entry-content']/div[5]")).findElements(By.cssSelector("figure")).size() - 1; i++) {

            //Get team name
            teamName = driver.findElement(By.cssSelector("div:nth-of-type(5) > figure:nth-of-type(" + (i + 1) + ") > figcaption > a")).getText();

            //Click on team
            driver.findElement(By.xpath("//main[@id='main']/article//div[@class='entry-content']/div[5]/figure[" + (i + 1) + "]")).click();

            //Get team image list
            elements = driver.findElement(By.xpath("//main[@id='main']/article//div[@class='entry-content']/div[3]")).findElements(By.cssSelector("figure"));

            if (driver.findElement(By.xpath("//main[@id='main']/article//div[@class='entry-content']/div[3]")).findElements(By.cssSelector("figure")).size() == 0) {

                //Get team image list
                elements = driver.findElement(By.xpath("//main[@id='main']/article//div[@class='entry-content']/div[4]")).findElements(By.cssSelector("figure"));

                //Get image location
                imagePath = elements.get(1).findElement(By.cssSelector("img")).getAttribute("src");



                //   System.out.println("No."+(i+1)+" : "+ teamName+" \n"+ "image Location: "+ imagePath );

                Team team = new Team(teamName, imagePath);

                teamInfo.add(team);
                driver.navigate().back();

                continue;
            }
            //Get image location
            imagePath = elements.get(1).findElement(By.cssSelector("img")).getAttribute("src");


            Team team = new Team(teamName, imagePath);

            teamInfo.add(team);

            System.out.println("No." + (i + 1) + " : " + teamName + " \n" + "image Location: " + imagePath);



            driver.navigate().back();
        }

        driver.quit();

        System.out.println(teamService.saveTeamAndFlush(teamInfo));


    }

    public WebDriver createDriver() {

        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors",
                "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");

        return new ChromeDriver(options);
    }

    public Map<String, Set<String>> getPlayBooks(String site, String playBookType) {


        int formationTotal;
        String playbookName;
        String formationName;

        Map<String, Set<String>> playBookMap = new HashMap<>();

        WebDriver driver = createDriver();

        driver.get(site);

        //Get list of all playbook links
        playBookLinks = choosePlayBooks(driver, playBookType);

        int offTotal = 32;
        System.out.println(offTotal);

        for (int i = 0; i <= offTotal - 1; i++) {

            Set<String> formations = new HashSet<>();

            //Click on the first link
            playBookLinks.get(i).click();

            //Get Playbook name
            playbookName = driver.findElement(By.xpath("/html//div[@class='body-content']/div//h1[@class='heading heading--blue']")).getText();

            //Getting the number of formations on page
            formationTotal = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div")).findElements(By.cssSelector("h3")).size();

            for (int f = 1; f <= formationTotal; f++) {
                //Getting formation name
                formationName = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div/h3[" + f + "]")).getText();

                formations.add(formationName);
            }

            playBookMap.put(playbookName, formations);

            int j = i + 1;

            System.out.println(j + ": " + playbookName + " " + "no of formations: " + formationTotal + "\n" + formations + "\n");

            driver.navigate().back();
        }


        driver.quit();

        return playBookMap;
    }

    public List<WebElement> choosePlayBooks(WebDriver driver, String playbooksType) {

        List<WebElement> playbookLinks = new ArrayList<>();


        if (playbooksType.toUpperCase().equals("OFFENSE")) {

            //Get list of all playbook links
            playbookLinks = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/ul[1]")).findElements(By.cssSelector("li"));


        } else if (playbooksType.toUpperCase().equals("DEFENSE")) {

            //Get list of all playbook links
            playbookLinks = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/ul[2]")).findElements(By.cssSelector("li"));

        }

        return playbookLinks;
    }

    // driver.quit();

    public Map<String, Set<String>> getSchemes(String site, String playBookTypes) {

        Map<String, Set<String>> schemesInfo = new TreeMap<>();
        Set<String> schemes = new HashSet<>();
        String formationName = null;
        String schemeName;
        int schemeTotal;
        int i; //offenseNumber
        int f = 1; //Formation Number
        int s = 0; //Scheme number

        WebDriver driver = createDriver();

        driver.get(site);

        //Get list of all playbook links
        playBookLinks = choosePlayBooks(driver, playBookTypes);

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

                for (f = 1; f <= formationTotal; f++) {//Change back to 1
                    driver.navigate().refresh();

                    formationName = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div/h3[" + f + "]")).getText();

                    //   System.out.println(formationName);

                    schemeTotal = driver.findElement(By.xpath("/html//div[@class='body-content']/div//div[@class='l-sidebar__main']/div/ul[" + f + "]")).findElements(By.cssSelector("li")).size() - 1;

                    // System.out.println(schemeTotal + 1);
                    try {
                        for (s = 0; s <= schemeTotal; s++) {


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
                }

                String playbookFormation = playbookName + "_" + formationName;

                schemesInfo.put(playbookFormation, schemes);

                driver.navigate().back();

            } catch (Exception exc) {
                String offense = "Offensive number: " + i;
                String formation = "Formation number: " + f;
                String scheme = "Scheme number: " + s;

                errorList.add(offense + "\n" + formation + "\n" + scheme);

                schemes.clear();
            }

        }

        driver.quit();

        System.out.println(schemesInfo);

        return schemesInfo;
    }
}
