package AndrewWebServices;
public class PromoNotifier {
    private final EmailService emailService;

    public PromoNotifier(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendPromotion(String email) {
        emailService.sendPromoEmail(email, "Check out our latest offers!");
    }
}

