package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class AndrewWebServicesTest {
    Database database;
    RecSys recommender;
    PromoService promoService;
    AndrewWebServices andrewWebService;

    @Before
    public void setUp() {
        // You need to use some mock objects here
        database = new Database(); // We probably don't want to access our real database...
        recommender = new RecSys();
        promoService = new PromoService();

        andrewWebService = new AndrewWebServices(database, recommender, promoService);
    }

    @Test
    public void testLogIn() {
        // This is taking way too long to test
        assertTrue(andrewWebService.logIn("Scotty", 17214));
    }

    @Test
    public void testGetRecommendation() {
        // This is taking way too long to test
        assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
        // How should we test sendEmail() when it doesn't have a return value?
        // Hint: is there something from Mockito that seems useful here?
    }

    @Test
    public void testNoSendEmail() {
        // How should we test that no email has been sent in certain situations (like right after logging in)?
        // Hint: is there something from Mockito that seems useful here?
    }
    @Test
    public void testLogIn_withFakeDatabase() {
    InMemoryDatabase fakeDb = new InMemoryDatabase();
    fakeDb.addUser("testuser", "1234");
    boolean result = fakeDb.authenticate("testuser", "1234");
    assertTrue(result);
    }
    @Test
    public void testGetRecommendation_withStubService() {
    RecommendationService stub = new RecommendationService() {
        @Override
        public String getRecommendation(String userId) {
            return "Try our new product!";
        }
    };
    String recommendation = stub.getRecommendation("user123");
    assertEquals("Try our new product!", recommendation);
    }
    @Test
    public void testSendPromoEmail_withMock() {
    EmailService mockEmailService = mock(EmailService.class);
    PromoNotifier notifier = new PromoNotifier(mockEmailService);
    notifier.sendPromotion("user@example.com");
    verify(mockEmailService).sendPromoEmail("user@example.com", "Check out our latest offers!");
    }

}
