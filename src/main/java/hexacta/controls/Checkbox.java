package hexacta.controls;

import org.openqa.selenium.By;

public class Checkbox extends BaseControl {
    public Checkbox(By locator) {
        super(locator);
    }

    public void check() {

        if (this.isChecked()) {
            return;
        } else {
            this.webElement().click();
        }
    }

    public boolean isChecked() {
        if (this.webElement().isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public void uncheck() {
        if (!this.isChecked()) {
            return;
        } else {
            this.webElement().click();
        }
    }

}
