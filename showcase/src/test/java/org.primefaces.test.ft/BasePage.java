package org.conventions.archetype.test.ft;

import junit.framework.Assert;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.GrapheneElement;
import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.Serializable;
import java.util.List;


public abstract class BasePage implements Serializable {

    @Drone
    private WebDriver browser;

    public String getLocation() {
        if (!getClass().isAnnotationPresent(Location.class)) {
            throw new RuntimeException("Provide @Location annotation for class:" + getClass().getSimpleName());
        }
        Location location = getClass().getAnnotation(Location.class);
        return location.value();
    }

    @FindByJQuery("div.ui-growl-message")
    private GrapheneElement growl;

    public void verifyMessage(String msg) {
        Graphene.waitAjax().until().element(growl).is().present();
        Assert.assertEquals(msg.trim(), growl.getText().trim());
    }

    protected void selecionaItem(GrapheneElement selectOne, String desc) {
        this.selectItem(selectOne, desc, false);
    }

    protected void selectItem(GrapheneElement selectOne, String itemDesc, boolean hasListener) {
        Graphene.waitModel().until().element(selectOne).is().present();
        selectOne.click();
        Graphene.waitAjax().until().element(By.className("ui-selectonemenu-items-wrapper")).is().present();
        String strXpath = "//li[contains(text(),'" + itemDesc + "')]";
        if (hasListener) {
            Graphene.guardAjax(selectOne.findElement(By.className("ui-selectonemenu-item").xpath(strXpath))).click();
        } else {
            selectOne.findElement(By.className("ui-selectonemenu-item").xpath(strXpath)).click();
        }
    }

    public List<WebElement> getTableRows(String tableId){
        return browser.findElements(By.xpath("//tbody[contains(@id,'" +tableId +"')]//tr[@role='row']"));
    }

    public List<WebElement> getTableRowsWithTDs(String tableId){
        return browser.findElements(By.xpath("//tbody[contains(@id,'" +tableId +"')]//tr[@role='row']//td[@role='gridcell']"));
    }
}
