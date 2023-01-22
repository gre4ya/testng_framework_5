package utilities;

import org.openqa.selenium.WebDriver;

public class WindowHandler {

    static String mainWindow;
    static WebDriver driver;

    static {
        driver = Driver.getDriver();
    }


    public static void switchToChildWindow(){
        mainWindow = driver.getWindowHandle();
        for(String windowId : driver.getWindowHandles()){
            if(!windowId.equals(mainWindow)){
                driver.switchTo().window(windowId);
                break;
            }
        }
    }

    public static void switchBackToParent(){
        driver.switchTo().window(mainWindow);
    }
}
