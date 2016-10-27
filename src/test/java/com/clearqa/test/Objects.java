package com.clearqa.test;

import org.openqa.selenium.By;
//import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public final class Objects {
		 
    private static WebElement element = null;
 
    public static WebElement SignInBtn(WebDriver driver) {
         element = driver.findElement(By.id("sign-in-button"));
         return element;
         }
 
     public static WebElement HeaderLogo(WebDriver driver){
         element = driver.findElement(By.id("header-logo"));
         return element;
         }
 
     public static WebElement SignInPopup(WebDriver driver){
         element = driver.findElement(By.id("sign-in-popup"));
         return element;
         }
	 
     public static WebElement Username(WebDriver driver){
         element = driver.findElement(By.id("user_login"));
         return element;
         }
     
     public static WebElement Password(WebDriver driver){
         element = driver.findElement(By.id("user_password"));
         return element;
         }
     
     public static WebElement CommitBtn(WebDriver driver){
         element = driver.findElement(By.name("commit"));
         return element;
         }
     
     public static WebElement AllertMsg(WebDriver driver){
         element = driver.findElement(By.className("alert"));
         return element;
         }
     
     public static WebElement MyAccount(WebDriver driver){
         element = driver.findElement(By.className("user-name-wrapper"));
         return element;
         }
     
     public static WebElement SignOutBtn(WebDriver driver){
         element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[6]/a"));
         return element;
         }
	}
