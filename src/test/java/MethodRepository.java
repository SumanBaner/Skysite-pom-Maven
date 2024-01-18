import junit.framework.Assert;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Filter;


public class MethodRepository {
    private WebDriver driver;


    public void browserApplicationLaunch(String browserName, String url) throws InterruptedException {

        try {
            if (browserName.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }

            if (browserName.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
            if (browserName.equals("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
            }

            driver.get(url);
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //public void loginInApplication() throws InterruptedException {

    //WebElement txtUsername = driver.findElement(By.id("UserID"));
    // txtUsername.sendKeys("louissuman16@gmail.com");

    //WebElement txtPassword = driver.findElement(By.id("Password"));
    //txtPassword.sendKeys("123456");

    //WebElement btnLogin = driver.findElement(By.id("btnLogin"));
    //btnLogin.click();
    // Relative path-Skysite website---Relative path
//        WebElement txtUserName = driver.findElement(By.xpath("//input[@id='UserID']"));
//        txtUserName.sendKeys("louissuman16@gmail.com");
//        Thread.sleep(3000);
//        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='Password']"));
//        txtPassword.sendKeys("123456");
//        Thread.sleep(3000);
//        WebElement btnLogin = driver.findElement(By.xpath("//button[@id='btnLogin']"));
//        btnLogin.click();
//        //Verification with Page Title
//        String expPageTitle = "Project list - SKYSITE Projects";
//        System.out.println(expPageTitle);
//        String actPageTitle = driver.getTitle();
//        System.out.println(actPageTitle);
//        if (expPageTitle.equals(actPageTitle)) {
//            System.out.println("Login is successful with valid credentials");
//        } else {
//            System.out.println("Login is unsuccessful with valid credentials");
//        }
    //Verification with CurrentURL


//        String expCurrentURL = "https://app.skysite.com/Project/ProjectList?x=0&isFromLogin=True&isFromSharedProject=False";
//        String actCurrentURL = driver.getCurrentUrl();
//
//        if (expCurrentURL.equals(actCurrentURL)) {
//            System.out.println("Login is successful with valid credentials");
//        } else {
//            System.out.println("Login is unsuccessful with valid credentials");
//        }

    //Absolute path -Skysite website---absolute path
//        WebElement txtUserName = driver.findElement(By.xpath("/html/body/form/div/div/div/div/div/div/div/input"));
//         txtUserName.sendKeys("louissuman16@gmail.com");
//        Thread.sleep(3000);
//        WebElement txtPassword = driver.findElement(By.xpath("/html/body/form/div/div/div/div/div/div/div[2]/input"));
//         txtPassword.sendKeys("123456");
//        Thread.sleep(3000);
//        WebElement btnLogin = driver.findElement(By.xpath("/html/body/form/div[1]/div/div/div[3]/div/div[1]/div[4]/button"));
//        btnLogin.click();
    //}

    public void SelectFilter() throws InterruptedException {
        WebElement filterDropDown = driver.findElement(By.xpath("//*[@id='aAdvanceFilter']"));
        filterDropDown.click();
        //Select st = new Select(filterDropDown);
    }

    //    private boolean filterDropDownequals(boolean click) {
//        boolean clickable = true;
//        if (filterDropDownequals(clickable)) {
//            System.out.println("Done");
//        } else {
//            System.out.println("Not Done");
//        }
//        return clickable;
//    }
    public void loginWithPropertyFileData() throws InterruptedException, AWTException, IOException {
        try {
            FileReader reader = new FileReader("./testdata/testdata.properties");
            Properties props = new Properties();
            props.load(reader);
            String uname = props.getProperty("username");
            String pwd = props.getProperty("Password");
            WebElement username = driver.findElement(By.id("UserID"));
            username.sendKeys(uname);
            Thread.sleep(3000);
            WebElement Password = driver.findElement(By.id("Password"));
            Password.sendKeys(pwd);
            Thread.sleep(3000);
            WebElement btnLogin = driver.findElement(By.id("btnLogin"));
            btnLogin.click();

            String expPageTitle = "Single Page Apps for GitHub Pages";
            String actPageTitle = driver.getTitle();

            if (expPageTitle.equals(actPageTitle)) {
                System.out.println("Login is successful with valid credentials");
            } else {
                System.out.println("Login is unsuccessful with valid credentials");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loginWithRobotClass() {
        try {
            FileReader reader = new FileReader("./testdata/testdata.properties");
            Properties props = new Properties();
            props.load(reader);
            String uname = props.getProperty("username");
            String pwd = props.getProperty("password");
            WebElement username = driver.findElement(By.xpath("//*[@id='UserID']"));
            username.sendKeys(uname);
            Thread.sleep(3000);

            WebElement txtpassword = driver.findElement(By.xpath("//*[@id='Password']"));
            txtpassword.sendKeys(pwd);
            Thread.sleep(3000);

            Robot robot = new Robot();
            Thread.sleep(2000);
            /* Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_NUM_LOCK, false); */
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(2000);

            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(2000);

            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(2000);

            robot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            String expPageTitle = "SKYSITE Archives";
            String actPageTitle = driver.getTitle();
            if (expPageTitle.equals(actPageTitle)) {
                System.out.println("Login is successful with valid credentials");
            } else {
                System.out.println("Login is unsuccessful with valid credentials");
            }
        } catch (AWTException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedOperationException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void dataDrivenExcel() throws IOException, InterruptedException {
        File file = new File("./testdata/testdataexcelskysite3.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheet("Login");
        XSSFRow row = null;
        XSSFCell cell = null;
        String username = null;
        String password = null;

        /* Navigate through the rows*/
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            /* Navigate through the columns */
            for (int j = 0; j < row.getLastCellNum(); j++) {
               /* cell = row.getCell(j);
                if (j == 0) {
                    username = cell.getStringCellValue();
                }
                if (j == 1) {
                    password = cell.getStringCellValue();
                }*/
                DataFormatter dataFormatter = new DataFormatter(Locale.US);
                if (j == 0) {
                    username = dataFormatter.formatCellValue(row.getCell(j));
                }
                if (j == 1) {
                    password = dataFormatter.formatCellValue(row.getCell(j));
                }
            }
            Thread.sleep(2000);
            driver.findElement(By.id("UserID")).clear();
            driver.findElement(By.id("UserID")).sendKeys(username);
            driver.findElement(By.id("Password")).clear();
            driver.findElement(By.id("Password")).sendKeys(password);
            driver.findElement(By.id("btnLogin")).click();
            Thread.sleep(5000);
            String result = null;
            try {
                Boolean isLoggedIn = driver.findElement(By.xpath("//*[@id='footerpoweredby']")).isDisplayed();
                if (isLoggedIn == true) {
                    result = "PASS";
                }
                System.out.println("Username: " + username + " -----> " + "Password: " + password + " -----> Login Success? " + result);
                WebElement Signout = driver.findElement(By.xpath("/html/body/footer/div[2]/div/div[2]/ul/li[5]/a"));
                Signout.click();
                Thread.sleep(2000);
                WebElement pb = driver.findElement(By.xpath("//button[@id='button-1']"));
                pb.click();
                Thread.sleep(5000);
            } catch (Exception e) {

                Boolean isSignin = driver.findElement(By.xpath("//button[@id='btnLogin']")).isDisplayed();
                if (isSignin == true) {
                    result = "FAIL";
                }
                System.out.println("Username: " + username + " -----> " + "Password: " + password + " -----> Login Failed? " + result);
                Thread.sleep(3000);

            }


        }
    }

    public void TestWebtable() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
            driver.manage().window().maximize();
            Thread.sleep(10000);
            List<WebElement> columns = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
            System.out.println("No of cols are : " + columns.size());
            List<WebElement> rows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
            System.out.println("No of rows are : " + rows.size());
            for (int i = 1; i <= rows.size(); i++) {
                String companyName = driver.findElement(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr[" + i + "]/td[1]")).getText();
                if (companyName.equals("Nesco Ltd") || companyName.equals("IFB Industries") || companyName.equals("MCX") || companyName.equals("Jindal Saw")) {
                    String currentPrice = driver.findElement(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr[" + i + "]/td[4]")).getText();
                    System.out.println("The Current Price of " + companyName + " is: " + currentPrice);
                    break;
                } else {
                    System.out.println("Company name is not found");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //driver.close();
    }


}









