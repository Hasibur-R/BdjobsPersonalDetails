import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class test {

    public static void main(String[] args) {
        // Path to the adblocker extension
        String adblockerPath = "src/main/resources/uBlock-Origin-Chrome-Web-Store.crx";

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(adblockerPath));
        WebDriver driver = new ChromeDriver(options);

        // Maximize the window and set up WebDriverWait
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));  // Increased timeout

        try {
            // Navigate to bdjobs.com
            driver.get("https://mybdjobs.bdjobs.com/mybdjobs/signin.asp?q=cab");

            // Login process
            //WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.hidden-xs.soca > a")));
            //loginLink.click();

            //WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-mbdj-r > .btn-wraper > .btn.slu-btn")));
            //loginButton.click();

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TXTUSERNAME")));
            usernameField.sendKeys("avary");

            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.btn-signin")));
            nextButton.click();

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TXTPASS")));
            passwordField.sendKeys("12345678");

            WebElement finalLoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.btn-signin.btn-block")));
            finalLoginButton.click();
            Thread.sleep(2000);

            // Navigate to the jobs section
            WebElement jobsSection = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='jobs active'] span[class='wr']")));
            jobsSection.click();
            Thread.sleep(2000);

            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            Set<String> allWindowHandles = driver.getWindowHandles();
            for (String handle : allWindowHandles) {
                String mainWindowHandle = "";
                if (!handle.equals(mainWindowHandle)) {
                    driver.switchTo().window(handle);
                }
            }

            // List of CSS selectors for Functional Category
            String[] radioSelectors = {
                    "#fcat-1001", "#fcat1", "#fcat26", "#fcat2"

            };

            // Loop through each radio button
            for (String selector : radioSelectors) {
                // Click the filter section to reveal the radio buttons
                WebElement filterSection = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Category']")));
                filterSection.click();

                // Short delay to ensure dropdown is fully open
                Thread.sleep(1000);

                // Re-verify selector accuracy and wait for presence
                WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));

                // Scroll to the radio button to ensure it's in view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);

                // Click the radio button using JavaScript
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);

                // Wait for a short time to ensure the click is registered
                Thread.sleep(1000);

                // Click the 'Send' button
                WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='dropdown dropdown-1 ttest open'] input[name='btnSend']")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton);

                // Wait for a short time to ensure actions are completed
                Thread.sleep(1000);
            }

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Clear']"))).click();
            Thread.sleep(2000);

            // Define the list of CSS selectors for Special Skilled Category
            String[] radioSelectors1 = {
                    "#fcat-1002", "#fcat88", "#fcat90", "#fcat76", "#fcat91"

            };
            // Loop through each radio button
            for (String selector : radioSelectors1) {
                // Click the filter section to reveal the radio buttons
                WebElement filterSection = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Category']")));
                filterSection.click();

                // Short delay to ensure dropdown is fully open
                Thread.sleep(1000);

                // Re-verify selector accuracy and wait for presence
                WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));

                // Scroll to the radio button to ensure it's in view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);

                // Click the radio button using JavaScript
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);

                // Wait for a short time to ensure the click is registered
                Thread.sleep(1000);

                // Click the 'Send' button
                WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='dropdown dropdown-1 ttest open'] input[name='btnSend']")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton);

                // Wait for a short time to ensure actions are completed
                Thread.sleep(1000);
            }

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Clear']"))).click();
            Thread.sleep(1000);

            // for Organization Type
            String[] radioSelectors3 = {
                    "#qOT0", "#qOT1", "#qOT2", "#qOT3", "#qOT4", "#qOT5", "#qOT6"
            };
            // Loop through each radio button
            for (String selector : radioSelectors3) {
                // Click the filter section to reveal the radio buttons
                WebElement filterSection = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Industry']")));
                filterSection.click();

                // Short delay to ensure dropdown is fully open
                Thread.sleep(1000);

                // Re-verify selector accuracy and wait for presence
                WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));

                // Scroll to the radio button to ensure it's in view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);

                // Click the radio button using JavaScript
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);

                // Wait for a short time to ensure the click is registered
                Thread.sleep(1000);

                // Click the 'Send' button
                WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='dropdown dropdown-2 ttest open'] input[name='btnSend']")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton);

                // Wait for a short time to ensure actions are completed
                Thread.sleep(1000);
            }

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Clear']"))).click();
            Thread.sleep(1000);

            //Industry Type

            String[] radioSelectors4 = {
                    "#iCat0", "#iCat3", "#iCat21", "#iCat5", "#iCat14", "#iCat1", "#iCat27",
                    "#iCat-10"
            };

            // Loop through each radio button
            for (String selector : radioSelectors4) {
                // Click the filter section to reveal the radio buttons
                WebElement filterSection = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Industry']")));
                filterSection.click();

                // Short delay to ensure dropdown is fully open
                Thread.sleep(1000);

                // Re-verify selector accuracy and wait for presence
                WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));

                // Scroll to the radio button to ensure it's in view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);

                // Click the radio button using JavaScript
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);

                // Wait for a short time to ensure the click is registered
                Thread.sleep(1000);

                // Click the 'Send' button
                WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='dropdown dropdown-2 ttest open'] input[name='btnSend']")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton);

                // Wait for a short time to ensure actions are completed
                Thread.sleep(1000);
            }

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Clear']"))).click();
            Thread.sleep(1000);

            String[] location = {
                    "#Country0", // Inside Bangladesh
                    //"#Country1", // Outside of Bangladesh
                    "#District1", // Dhaka Division
                    "#LcationList16", // Faridpur
                    "#LcationList19", // Gazipur
                    "#LcationList20", // Gopalganj


                    "#District2", // Chattogram Division
                    "#LcationList3",   // Bandarban
                    "#LcationList1",   // Brahmanbaria


                    "#District3", // Rajshahi Division
                    "#LcationList6",  // Bogura
                    "#LcationList9",  // Chapainawabganj


                    "#District4", // Khulna Division
                    "#LcationList2",  // Bagerhat
                    "#LcationList11", // Chuadanga

                    "#District6", // Rangpur Division
                    "#LcationList15", // Dinajpur
                    "#LcationList18", // Gaibandha


                    "#District7", // Barishal Division
                    "#LcationList7",  // Barguna
                    "#LcationList4",  // Barishal


                    "#District8", // Mymensingh Division
                    "#LcationList22", // Jamalpur


                    "#Country1", // Outside of Bangladesh
                    "#LcationList101", // Afghanistan
                    "#LcationList102", // Albania


            };



            // Loop through each radio button
            for (String selector : location) {
                // Click the filter section to reveal the radio buttons
                WebElement filterSection = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Location']")));
                filterSection.click();

                // Short delay to ensure dropdown is fully open
                Thread.sleep(1000);

                // Re-verify selector accuracy and wait for presence
                WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));

                // Scroll to the radio button to ensure it's in view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);

                // Click the radio button using JavaScript
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);

                // Wait for a short time to ensure the click is registered
                Thread.sleep(1000);

                // Click the 'Send' button
                WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='dropdown dropdown-3 ttest open'] input[name='btnSend']")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton);

                // Wait for a short time to ensure actions are completed
                Thread.sleep(1000);
            }

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Clear']"))).click();
            Thread.sleep(1000);


            // deadline

            String[] deadline = {
                    ".filter .custradio input#qPosted0",  // Selects the "Any" radio button
                    ".filter .custradio input#qPosted1",  // Selects the "Today" radio button
                    ".filter .custradio input#qPosted2",  // Selects the "Last 2 days" radio button
                    ".filter .custradio input#qPosted3",  // Selects the "Last 3 days" radio button
                    ".filter .custradio input#qPosted4",  // Selects the "Last 4 days" radio button
                    ".filter .custradio input#qPosted5",  // Selects the "Last 5 days" radio button
                    ".filter .custradio label#spqPosted0",  // Selects the "Any" label
                    ".filter .custradio label#spqPosted1",  // Selects the "Today" label
                    ".filter .custradio label#spqPosted2",  // Selects the "Last 2 days" label
                    ".filter .custradio label#spqPosted3",  // Selects the "Last 3 days" label
                    ".filter .custradio label#spqPosted4",  // Selects the "Last 4 days" label
                    ".filter .custradio label#spqPosted5"   // Selects the "Last 5 days" label
            };
            // Loop through each radio button
            for (String selector : deadline) {
                // Click the filter section to reveal the radio buttons
                WebElement filterSection = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Deadline']")));
                filterSection.click();

                // Short delay to ensure dropdown is fully open
                Thread.sleep(1000);

                // Re-verify selector accuracy and wait for presence
                WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));

                // Scroll to the radio button to ensure it's in view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);

                // Click the radio button using JavaScript
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);

                // Wait for a short time to ensure the click is registered
                Thread.sleep(1000);

                // Click the 'Send' button
                WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='dropdown dropdown-7 open'] input[name='btnSend']")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton);

                // Wait for a short time to ensure actions are completed
                Thread.sleep(1000);
            }

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Clear']"))).click();
            Thread.sleep(1000);




            // Click on Newspaper

            String[] newspaper = {
                    "#Newspaper0",
                    "#Newspaper1",
                    "#Newspaper2",
                    "#Newspaper5",
                    "#Newspaper36"
            };

            // Loop through each radio button
            for (String selector : newspaper) {
                // Click the filter section to reveal the radio buttons
                WebElement filterSection = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Newspaper']")));
                filterSection.click();

                // Short delay to ensure dropdown is fully open
                Thread.sleep(1000);

                // Re-verify selector accuracy and wait for presence
                WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));

                // Scroll to the radio button to ensure it's in view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);

                // Click the radio button using JavaScript
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);

                // Wait for a short time to ensure the click is registered
                Thread.sleep(1000);

                // Click the 'Send' button
                WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='dropdown dropdown-8 ttest open'] input[name='btnSend']")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton);

                // Wait for a short time to ensure actions are completed
                Thread.sleep(1000);
            }

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Clear']"))).click();
            Thread.sleep(1000);

    //Job Nature
            WebElement filterSection = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='images/Other-Filter.png']")));
            filterSection.click();
            Thread.sleep(500);
            // Locate the dropdown element
            WebElement jobNatureDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("qJobNature")));

            // Get all the options in the dropdown
            List<WebElement> options1 = jobNatureDropdown.findElements(By.tagName("option"));

            // Loop through each option in the dropdown
            for (int i = 0; i < options1.size(); i++) {
                // Re-fetch the dropdown element and options to avoid StaleElementReferenceException
                jobNatureDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("qJobNature")));
                options1 = jobNatureDropdown.findElements(By.tagName("option"));

                // Select the current option
                WebElement option = options1.get(i);
                option.click();
                Thread.sleep(500);

                // Click the "Send" button
                WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='containerm'] input[name='btnSend']")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton);
                Thread.sleep(500);

                // Reopen the filter section after clicking the "Send" button (if necessary)
                WebElement filterSection1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='images/Other-Filter.png']")));
                filterSection1.click();
                Thread.sleep(500);
            }
            // Click the "Send" button
            WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='containerm'] input[name='btnSend']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton);
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Clear']"))).click();
            Thread.sleep(1000);

// Job Level

            WebElement filterSection4 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='images/Other-Filter.png']")));
            filterSection4.click();
            Thread.sleep(500);
            // Locate the dropdown element
            WebElement jobLevel = wait.until(ExpectedConditions.elementToBeClickable(By.id("qJobLevel")));

            // Get all the options in the dropdown
            List<WebElement> options2 = jobLevel.findElements(By.tagName("option"));

            // Loop through each option in the dropdown
            for (int i = 0; i < options2.size(); i++) {
                // Re-fetch the dropdown element and options to avoid StaleElementReferenceException
                jobNatureDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("qJobLevel")));
                options2 = jobNatureDropdown.findElements(By.tagName("option"));

                // Select the current option
                WebElement option = options2.get(i);
                option.click();
                Thread.sleep(500);

                // Click the "Send" button
                WebElement sendButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='containerm'] input[name='btnSend']")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton1);
                Thread.sleep(500);

                // Reopen the filter section after clicking the "Send" button (if necessary)
                WebElement filterSection1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='images/Other-Filter.png']")));
                filterSection1.click();
                Thread.sleep(500);
            }
            // Click the "Send" button
            WebElement sendButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='containerm'] input[name='btnSend']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton2);
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Clear']"))).click();
            Thread.sleep(1000);

    //Fresher / Experience
            WebElement filterSection5 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='images/Other-Filter.png']")));
            filterSection5.click();
            Thread.sleep(500);
            // Locate the dropdown element
            WebElement exp = wait.until(ExpectedConditions.elementToBeClickable(By.id("qExp")));

            // Get all the options in the dropdown
            List<WebElement> options3 = exp.findElements(By.tagName("option"));

            // Loop through each option in the dropdown
            for (int i = 0; i < options3.size(); i++) {
                // Re-fetch the dropdown element and options to avoid StaleElementReferenceException
                jobNatureDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("qExp")));
                options3 = jobNatureDropdown.findElements(By.tagName("option"));

                // Select the current option
                WebElement option = options3.get(i);
                option.click();
                Thread.sleep(500);

                // Click the "Send" button
                WebElement sendButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='containerm'] input[name='btnSend']")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton3);
                Thread.sleep(500);

                // Reopen the filter section after clicking the "Send" button (if necessary)
                WebElement filterSection2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='images/Other-Filter.png']")));
                filterSection2.click();
                Thread.sleep(500);
            }
            // Click the "Send" button
            WebElement sendButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='containerm'] input[name='btnSend']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton3);
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Clear']"))).click();
            Thread.sleep(1000);

    //Age Range
            WebElement filterSection6 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='images/Other-Filter.png']")));
            filterSection6.click();
            Thread.sleep(500);
            // Locate the dropdown element
            WebElement age = wait.until(ExpectedConditions.elementToBeClickable(By.id("qAge")));

            // Get all the options in the dropdown
            List<WebElement> options4 = age.findElements(By.tagName("option"));

            // Loop through each option in the dropdown
            for (int i = 0; i < options4.size(); i++) {
                // Re-fetch the dropdown element and options to avoid StaleElementReferenceException
                jobNatureDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("qAge")));
                options4 = jobNatureDropdown.findElements(By.tagName("option"));

                // Select the current option
                WebElement option = options4.get(i);
                option.click();
                Thread.sleep(500);

                // Click the "Send" button
                WebElement sendButton4 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='containerm'] input[name='btnSend']")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton4);
                Thread.sleep(500);

                // Reopen the filter section after clicking the "Send" button (if necessary)
                WebElement filterSection3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='images/Other-Filter.png']")));
                filterSection3.click();
                Thread.sleep(500);
            }
            // Click the "Send" button
            WebElement sendButton4 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='containerm'] input[name='btnSend']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton4);
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Clear']"))).click();
            Thread.sleep(1000);

            WebElement filterSection7 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='images/Other-Filter.png']")));
            filterSection7.click();
            Thread.sleep(1000);

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#spqGender1"))).click();
            // Click the "Send" button
            WebElement sendButton5 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='containerm'] input[name='btnSend']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton5);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Clear']"))).click();
            Thread.sleep(1000);

            WebElement filterSection8 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='images/Other-Filter.png']")));
            filterSection8.click();
            Thread.sleep(1000);

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#spqGender2"))).click();
            // Click the "Send" button
            WebElement sendButton6 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='containerm'] input[name='btnSend']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton6);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Clear']"))).click();
            Thread.sleep(1000);

            WebElement filterSection9 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='images/Other-Filter.png']")));
            filterSection9.click();
            Thread.sleep(1000);

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#spqGender3"))).click();
            // Click the "Send" button
            WebElement sendButton7 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='containerm'] input[name='btnSend']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton7);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Clear']"))).click();
            Thread.sleep(1000);

            WebElement filterSection10 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='images/Other-Filter.png']")));
            filterSection10.click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("spqWorkstation0"))).click();

            // Click the "Send" button
            WebElement sendButton8 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='containerm'] input[name='btnSend']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton8);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Clear']"))).click();
            Thread.sleep(1000);


    // Finally apply all filters
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Category']"))).click();
            Thread.sleep(2000);

            wait.until(ExpectedConditions.elementToBeClickable(By.id("spfcat8"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='dropdown dropdown-1 ttest open'] input[name='btnSend']"))).click();
            Thread.sleep(1000);

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Industry']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("spqOT4"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("spiCat11"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='dropdown dropdown-2 ttest open'] input[name='btnSend']"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Location']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("spDistrict1"))).click();
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='dropdown dropdown-3 ttest open'] input[name='btnSend']"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Deadline']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("spqPosted5"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='dropdown dropdown-7 open'] input[name='btnSend']"))).click();
            Thread.sleep(2000);

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Newspaper']")));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("spNewspaper1"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='dropdown dropdown-8 ttest open'] input[name='btnSend']"))).click();


            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='images/Other-Filter.png']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#spqGender1"))).click();
            Thread.sleep(1000);

            wait.until(ExpectedConditions.elementToBeClickable(By.id("qJobNature"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("option[value='FullTime']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='containerm'] input[name='btnSend']"))).click();




        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
