package com.mentee.polymorphism.notification;

public class EmailNotification extends Notification implements Notifiable, Loggable {

    private String subject;

    public EmailNotification(String notificationId, String recipient, String message, String subject) {
        super(notificationId, recipient, message);
        this.subject = subject;
    }

    @Override
    public String getRecipient() {
        return super.getRecipient();
    }

    @Override
    public boolean isSent() {
        return super.isSent();
    }

    @Override
    public boolean send() {
        System.out.println("Sending Email with subject: " + subject);
        markAsSent();
        return true;
    }

    @Override
    public String getNotificationType() {
        return "Email";
    }

    @Override
    public boolean sendNotification() {
        return send();
    }

    @Override
    public void log() {
        System.out.println("[" + getLogLevel() + "] Email sent to: " + getRecipient());
    }
}