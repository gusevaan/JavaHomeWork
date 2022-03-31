import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumStart {

    private WebDriver webDriver;

    private static final String baseURL = "https://yandex.ru/";

    //локаторы
    private static final String inputField = "//input[@aria-label='Запрос']";
    private static final String YANDEX_LOGO = "//div[@aria-label='Яндекс']";
    private static final String findButton = "//span[text() ='Найти']/parent::button";
    private static final String resultList = "//ul[@aria-label='Результаты поиска']";
    private static final String WEATHER = "//div[@class='weather__header']//a[text()='Погода']";
    private static final String currentTemperature = "//div[@class='weather__temp']";
    private static final String tomorrTemperature = "//div[text()='Сегодня']/ancestor::div[1]/following-sibling::div[2]//span[text()='днём']/following-sibling::span[contains(@class,'temp__value')]";

    private static final String YA_NARKET_LOC = "//ul[@class='services-new__list']//a[@data-id='market']";
    private static final String CATALOG_BUTTON_ID = "catalogPopupButton";
    private static final String ZOO_FOOD_LOC = "//span[text()='Зоотовары']/ancestor::a";
    private static final String CAT_HAPPINIES_LOC = "//a[text()='Для кошек']/parent::div/following-sibling::ul//a[text()='Лакомства']";
    private static final String PRICE_FROM_ID = "glpricefrom";
    private static final String PRICE_FROM_LOC = "//label[text()='Цена, \u20BD от']//parent::span//div//div//input";
    private static final String PRICE_TO_ID = "glpriceto";
    private static final String PRICE_TO_LOC = "//label[text()='Цена, \u20BD до']//parent::span//div//div//input";
    private static final String DELIVERY_METHOD_LOC = "//span[text()='Доставка курьером']//ancestor::label/div";
    private static final String SHOW_ALL = "//legend[text()='Производитель']/following-sibling::footer/button[text()='Показать всё']";
    private static final String FIND_FIELD = "//input[@name='Поле поиска']";
    private static final String HAPPINIES_NAME_LOC = "//span[text()='Мнямс']/parent::div";




    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        webDriver = new ChromeDriver(options);
        webDriver.get(baseURL);
        webDriver.manage().window().maximize();
    }

    @Test
    @DisplayName("Найти лучшие мотиваторы")
    public void findbestMotivatorTest() throws InterruptedException {
       Assertions.assertTrue(webDriver.findElement(By.xpath(YANDEX_LOGO)).isDisplayed());

       webDriver.findElement(By.xpath(inputField)).sendKeys("лучшие мотиваторы");
       webDriver.findElement(By.xpath(findButton)).click();

       WebElement firstResult = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(resultList)));
    }

    @Test
    @DisplayName("Получить прогноз погоды на сегодня")
    public void findCurrentTemperatureTest() {
        String todayTemperature;
        todayTemperature = webDriver.findElement(By.xpath(currentTemperature)).getText();
        System.out.println("Today is " + todayTemperature);
    }

    @Test
    @DisplayName("Получить прогноз погоды на завтра")
    public void findTomorrowTemperatureTest() throws InterruptedException, IOException {
        //String oldTab = webDriver.getWindowHandle();
        String tomorrowTemperature;
        WebElement webElement = webDriver.findElement(By.xpath(WEATHER));
        webElement.click();

        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
        tomorrowTemperature = webDriver.findElement(By.xpath(tomorrTemperature)).getText();
        System.out.println("Tomorrow is " + tomorrowTemperature);
        File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src\\test\\resources\\screenshot.png"));
    }
    @Test
    @DisplayName("Найти корм коту")
    public void findCatFood(){
        webDriver.findElement(By.xpath(YA_NARKET_LOC)).click();

        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }

        webDriver.findElement(By.id(CATALOG_BUTTON_ID)).click();
        Actions action = new Actions(webDriver);
        WebElement zoo_food = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(ZOO_FOOD_LOC)));
        action.moveToElement(zoo_food).build().perform();
        webDriver.findElement(By.xpath(CAT_HAPPINIES_LOC)).click();

        Boolean isPriceId = webDriver.findElements(By.id(PRICE_FROM_ID)).size() > 0;
        if(isPriceId == true){
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block:\"center\"})", webDriver.findElement(By.id(PRICE_FROM_ID)));
            webDriver.findElement(By.id(PRICE_FROM_ID)).sendKeys("50");
            webDriver.findElement(By.id(PRICE_TO_ID)).sendKeys("150");
        }else{
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block:\"center\"})", webDriver.findElement(By.id(PRICE_FROM_LOC)));
            webDriver.findElement(By.xpath(PRICE_FROM_LOC)).sendKeys("50");
            webDriver.findElement(By.xpath(PRICE_TO_LOC)).sendKeys("150");
        }

        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block:\"center\"})",webDriver.findElement(By.xpath(DELIVERY_METHOD_LOC)));

        WebElement delivery = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(DELIVERY_METHOD_LOC)));
        delivery.click();
        WebElement show_all = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(SHOW_ALL)));
        show_all.click();
       // ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block:\"center\"})",webDriver.findElement(By.xpath(FIND_FIELD)));

        WebElement find_field = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(FIND_FIELD)));
        find_field.sendKeys("Мнямс");
        WebElement happinies_name = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(HAPPINIES_NAME_LOC)));
        happinies_name.click();
    }

    @AfterEach
    public void tearDown() {
        //webDriver.quit();
    }
}
