package automationpractice.enums;

/**
 * Created by Ale on 09/01/18.
 */
public enum SubjectHeading {

    CUSTOMER_SERVICE("Customer service"), WEBMASTER("Webmaster");

    private String label;

    SubjectHeading(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
