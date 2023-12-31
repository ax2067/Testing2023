
    @Test(description = "Test how site delete all cookies")
    public void testDeleteCookiesLoggedUser() {
        driver.get("https://www.nytimes.com/subscription/onboarding-offer?campaignId=7JFJX&EXIT_URI=https%3A%2F%2Fwww.nytimes.com%2Finternational%2F&login=email&auth=login-email");
        WebElement changeLanguageButton = setWebElement(By.xpath("//a[@class='onOffPLObundle__getstarted']"));
        changeLanguageButton.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        driver.manage().deleteAllCookies();
        Assert.assertEquals(driver.manage().getCookies().size(), 0, "Problems with cookies");
    }

    @Test(description = "Test how user can save page")
    public void testSavePage() {
        driver.get("https://www.nytimes.com/wirecutter/money/rei-gear-up-get-out-sale-2023-1114/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        driver.manage().window().fullscreen();
        WebElement savePageButton = setWebElement(By.xpath("//button[@data-save-content-name='save_article']"));
        savePageButton.click();
        List<WebElement> saveBlock = driver.findElements(By.xpath("//div[@class='a25d1d11']"));
        Assert.assertTrue(saveBlock.isEmpty());
    }

    @Test(description = "Test find article from author page")
    public void findArticleTest() {
        driver.get("https://www.nytimes.com/by/claire-moses");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement searchPanel = setWebElement(By.xpath("//a[@data-id='search']"));
        searchPanel.click();
        WebElement searchPanelText = setWebElement(By.xpath("//input[@placeholder='Search']"));
        searchPanelText.sendKeys("A Grocery Chain Just Fired Its Self-Checkouts");
        WebElement searchResult = setWebElement(By.xpath("//h3[@class='css-p0xou9']"));
        Assert.assertTrue(searchResult.getText().contains("A Grocery Chain Just Fired Its Self-Checkouts"));
    }

    @Test(description = "Test find article author page")
    public void navigateToTheAuthorPageTest() throws InterruptedException {
        driver.get("https://www.nytimes.com/wirecutter/money/rei-gear-up-get-out-sale-2023-1114/");
        new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='_68b640ca'] ")));
        WebElement closeButton = setWebElement(By.xpath("//button[@class='_68b640ca']"));
        closeButton.click();
        WebElement authorNameLink = setWebElement(By.xpath("//a[@data-gtm-trigger='author_name_link']"));
        authorNameLink.click();
        new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.urlToBe("https://www.nytimes.com/wirecutter/authors/nathan-burrow/"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.nytimes.com/wirecutter/authors/nathan-burrow/", "Author link doesn't work");
    }

    @Test(description = "Test searchbar")
    public void testSearchField() throws InterruptedException {
        driver.get("https://www.nytimes.com/wirecutter/");
        driver.manage().window().fullscreen();
        new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='Search Wirecutter']")));
        WebElement searchBar = setWebElement(By.xpath("//input[@aria-label='Search Wirecutter']"));
        searchBar.sendKeys("Kitchen");
        WebElement submitButton = setWebElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='_37cb874a']")));
        WebElement titleResult = setWebElement(By.xpath("//h3[@class='_37cb874a']"));
        Assert.assertTrue(titleResult.getText().contains("Kitchen"), "Problem lies in search");
    }

    @Test(description = "Test filters")
    public void testSearchFilters() {
        driver.get("https://www.nytimes.com/search?query=Climate");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement filterButton = setWebElement(By.xpath("//select[@class='css-v7it2b']"));
        filterButton.click();
        WebElement filterOption = setWebElement(By.xpath("//option[@value='oldest']"));
        filterOption.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.nytimes.com/search?dropmab=false&query=Climate&sort=oldest", "Problems with filters");
    }

//    @Test(description = "Test deals page")
//    public void testNavigationToDealPage() throws InterruptedException {
//        driver.get("https://www.nytimes.com/wirecutter/deals/");
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
//        WebElement closeButton = setWebElement(By.xpath("//button[@class='_27f88555']"));
//        Thread.sleep(2000);
//        closeButton.click();
//        WebElement dealOption = setWebElement(By.xpath("//li[@class='dea75f89 swiper-slide _7437d1fd swiper-slide-visible swiper-slide-active']"));
//        dealOption.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        String handle = driver.getWindowHandles().toArray()[1]
//                .toString();
//        driver.switchTo().window(handle);
//        Thread.sleep(5000);
//        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.nytimes.com/wirecutter/deals/", "Problems with navigation");
//    }

    @Test(description = "Test navigation to social sites")
    public void testNavigationToSocialSite() throws InterruptedException {
        driver.get("https://www.nytimes.com/wirecutter/reviews/best-cutting-board/");
        WebElement closeButton = setWebElement(By.xpath("//button[@class='_68b640ca']"));
        Thread.sleep(5000);
        closeButton.click();
        WebElement socialSiteButton = setWebElement(By.xpath("//a[@class='_27bd825e _6dcff3f7']"));
        socialSiteButton.click();
        String handle = driver.getWindowHandles().toArray()[1]
                .toString();
        driver.switchTo().window(handle);
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://twitter.com/i/flow/login?redirect_after_login=%2Fintent%2Ftweet%3Ftext%3DThe%2520Best%2520Cutting%2520Boards%2520%257C%2520Wirecutter%26url%3Dhttps%3A%2F%2Fwww.nytimes.com%2Fwirecutter%2Freviews%2Fbest-cutting-board%2F%26via%3Dwirecutter", "Problem with social site navigation");
    }

    @Test(description = "Test adding cookies")
    public void testAddingCookies() {
        driver.get("https://www.nytimes.com/wirecutter/reviews/the-best-refrigerator/");
        Assert.assertTrue(!driver.manage().getCookies().isEmpty(), "Problem lies in adding cookies");
    }