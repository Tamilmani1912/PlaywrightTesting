package org.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaywrightTest {
  static Playwright playwright;
  static Browser browser;

  BrowserContext context;
  Page page;

  @BeforeAll
  static void launchBrowser() {
    playwright = Playwright.create();
    browser = playwright.chromium().launch();
  }

  @AfterAll
  static void closeBrowser() {
    playwright.close();
  }

  @BeforeEach
  void createContextAndPage() {
    context = browser.newContext();
    page = context.newPage();
  }

  @AfterEach
  void closeContext() {
    context.close();
  }

  @Test
  void shouldSearchGoogle() {
    page.navigate("https://www.google.com");
    page.locator("textarea[name='q']").fill("playwright java");
   [name='q']").press("Enter");
    page.waitForTimeout(2000); // Wait for results to load
    assertTrue(page.url().contains("search"));
  }
}
