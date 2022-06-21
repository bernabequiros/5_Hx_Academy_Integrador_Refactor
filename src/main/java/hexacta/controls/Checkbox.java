package hexacta.controls;

import org.openqa.selenium.By;

public class Checkbox extends BaseControl {
    public Checkbox(By locator) {
        super(locator);
    }

    public void check() {
        if (this.isChecked()) {
            return;
            } 
        this.webElement().click();   
    }

    public boolean isChecked() {
        return this.webElement().isSelected();
    }

    public void uncheck() {
        if (!this.isChecked()) {
            return;
            } 
        this.webElement().click();
    }
}
