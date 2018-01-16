package automationpractice.builders;

import automationpractice.enums.SubjectHeading;

/**
 * Created by Ale on 09/01/18.
 */
public class ContactMessage {

    private SubjectHeading subject;
    private String email;
    private String orderReference;
    private String message;

    public ContactMessage(ContactMessageBuilder builder) {
        this.subject = builder.subject;
        this.email = builder.email;
        this.orderReference = builder.orderReference;
        this.message = builder.message;
    }

    public SubjectHeading getSubject() {
        return subject;
    }

    public String getEmail() {
        return email;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public String getMessage() {
        return message;
    }


    public static class ContactMessageBuilder {

        private SubjectHeading subject;
        private String email;
        private String orderReference;
        private String message;

        public ContactMessageBuilder subject(SubjectHeading subject) {
            this.subject = subject;
            return this;
        }

        public ContactMessageBuilder email(String email) {
            this.email = email;
            return this;
        }

        public ContactMessageBuilder orderReference(String orderReference) {
            this.orderReference = orderReference;
            return this;
        }

        public ContactMessageBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ContactMessage build() {
            return new ContactMessage(this);
        }
    }
}
