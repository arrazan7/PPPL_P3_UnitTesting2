import org.example.Wallet;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WalletTest {
    private List<Wallet> wallet;
    private String methodName;

    @BeforeAll
    public void initClass() {
        wallet = new ArrayList<>();
        System.out.println("Running Wallet Test - Before All");
    }

    @BeforeEach
    public void initMethod() {
        Wallet dompet1 = new Wallet("Saya");
        Wallet dompet2 = new Wallet("Kamu");
        Wallet dompet3 = new Wallet("Dia");
        wallet.add(dompet1);
        wallet.add(dompet2);
        wallet.add(dompet3);
        System.out.println("Running Wallet Test - Before Each");
    }

    @AfterEach
    public void cleanMethod() {
        wallet.clear();
        System.out.println("Running Wallet Test - After Each - " + methodName);
    }

    @AfterAll
    public void cleanClass() {
        System.out.println("Running Wallet Test - After All");
    }

    @Test
    void testConstructor() {
        methodName = "testConstructor";

        Assertions.assertFalse(wallet.isEmpty());
    }

    @Test
    void testGetOwner() {
        methodName = "testGetOwner";

        Assertions.assertEquals("Saya", wallet.get(0).getOwner());
        Assertions.assertEquals("Kamu", wallet.get(1).getOwner());
        Assertions.assertEquals("Dia", wallet.get(2).getOwner());
    }

    @Test
    void testSetOwner() {
        methodName = "testSetOwner";
        wallet.get(0).setOwner("Fayyadh");
        wallet.get(1).setOwner("Arrazan");
        wallet.get(2).setOwner("Miftakhul");

        Assertions.assertEquals("Fayyadh", wallet.get(0).getOwner());
        Assertions.assertEquals("Arrazan", wallet.get(1).getOwner());
        Assertions.assertEquals("Miftakhul", wallet.get(2).getOwner());
    }

    @Test
    void testAddOneMoney() {
        methodName = "testAddOneMoney";
        wallet.get(0).addMoney(1000);
        wallet.get(1).addMoney(1000);
        wallet.get(2).addMoney(1000);

        Assertions.assertEquals(1, wallet.get(0).getMoneys().get(1000));
        Assertions.assertEquals(1, wallet.get(1).getMoneys().get(1000));
        Assertions.assertEquals(1, wallet.get(2).getMoneys().get(1000));
    }

    @Test
    void testAddThreeMoneys() {
        methodName = "testAddThreeMoneys";
        wallet.get(0).addMoney(1000);
        wallet.get(0).addMoney(2000);
        wallet.get(0).addMoney(10000);

        Assertions.assertEquals(1, wallet.get(0).getMoneys().get(1000));
        Assertions.assertEquals(1, wallet.get(0).getMoneys().get(2000));
        Assertions.assertEquals(1, wallet.get(0).getMoneys().get(10000));
    }

    @Test
    void testAddWrongMoneys() {
        methodName = "testAddWrongMoneys";
        wallet.get(0).addMoney(3000);
        wallet.get(0).addMoney(6000);
        wallet.get(0).addMoney(70000);

        Assertions.assertNull(wallet.get(0).getMoneys().get(3000));
        Assertions.assertNull(wallet.get(0).getMoneys().get(6000));
        Assertions.assertNull(wallet.get(0).getMoneys().get(70000));
    }

    @Test
    void testTakeMoneys() {
        methodName = "testTakeMoneys";
        wallet.get(0).addMoney(1000);
        wallet.get(0).addMoney(2000);
        wallet.get(0).addMoney(10000);
        wallet.get(0).takeMoneys(1000);
        wallet.get(0).takeMoneys(2000);
        wallet.get(0).takeMoneys(10000);

        Assertions.assertEquals(0, wallet.get(0).getMoneys().get(1000));
        Assertions.assertEquals(0, wallet.get(0).getMoneys().get(2000));
        Assertions.assertEquals(0, wallet.get(0).getMoneys().get(10000));
    }

    @Test
    void testAddOneCoin() {
        methodName = "testAddOneCoin";
        wallet.get(0).addCoin(100);

        Assertions.assertEquals(1, wallet.get(0).getCoins().get(100));
    }

    @Test
    void testAddThreeCoins() {
        methodName = "testAddThreeCoins";
        wallet.get(0).addCoin(1000);
        wallet.get(0).addCoin(500);
        wallet.get(0).addCoin(200);

        Assertions.assertEquals(1, wallet.get(0).getCoins().get(1000));
        Assertions.assertEquals(1, wallet.get(0).getCoins().get(500));
        Assertions.assertEquals(1, wallet.get(0).getCoins().get(200));
    }

    @Test
    void testAddWrongCoins() {
        methodName = "testAddWrongCoins";
        wallet.get(0).addCoin(300);
        wallet.get(0).addCoin(600);
        wallet.get(0).addCoin(7000);

        Assertions.assertNull(wallet.get(0).getCoins().get(300));
        Assertions.assertNull(wallet.get(0).getCoins().get(600));
        Assertions.assertNull(wallet.get(0).getCoins().get(7000));
    }

    @Test
    void testTakeCoins() {
        methodName = "testTakeCoins";
        wallet.get(0).addCoin(1000);
        wallet.get(0).addCoin(500);
        wallet.get(0).addCoin(200);
        wallet.get(0).takeCoins(1000);
        wallet.get(0).takeCoins(500);
        wallet.get(0).takeCoins(200);

        Assertions.assertEquals(0, wallet.get(0).getCoins().get(1000));
        Assertions.assertEquals(0, wallet.get(0).getCoins().get(500));
        Assertions.assertEquals(0, wallet.get(0).getCoins().get(200));
    }

    @Test
    void testAddOneCard() {
        methodName = "testAddOneCard";
        String card = "BCA";
        boolean isCardAvailable = false;
        wallet.get(0).addCard(card);

        for (int i = 0; i < wallet.get(0).getCards().size(); i++) {
            if (wallet.get(0).getCards().get(i).equals(card)) {
                isCardAvailable = true;
                break;
            }
        }

        Assertions.assertTrue(isCardAvailable);
    }

    @Test
    void testAddThreeCards() {
        methodName = "testAddThreeCards";
        String card1 = "BCA";
        String card2 = "Mandiri";
        String card3 = "BNI";
        boolean isCard1Available = false;
        boolean isCard2Available = false;
        boolean isCard3Available = false;
        wallet.get(0).addCard(card1);
        wallet.get(0).addCard(card2);
        wallet.get(0).addCard(card3);

        for (int i = 0; i < wallet.get(0).getCards().size(); i++) {
            if (wallet.get(0).getCards().get(i).equals(card1)) {
                isCard1Available = true;
            }
            if (wallet.get(0).getCards().get(i).equals(card2)) {
                isCard2Available = true;
            }
            if (wallet.get(0).getCards().get(i).equals(card3)) {
                isCard3Available = true;
            }
        }

        Assertions.assertTrue(isCard1Available);
        Assertions.assertTrue(isCard2Available);
        Assertions.assertTrue(isCard3Available);
    }

    @Test
    void testSizeCards() {
        methodName = "testSizeCards";
        String card1 = "BCA";
        String card2 = "Mandiri";
        String card3 = "BNI";
        wallet.get(0).addCard(card1);
        wallet.get(0).addCard(card2);
        wallet.get(0).addCard(card3);

        Assertions.assertEquals(3, wallet.get(0).getCards().size());
    }

    @Test
    void testTakeCards() {
        methodName = "testTakeCards";
        String card1 = "BCA";
        String card2 = "Mandiri";
        String card3 = "BNI";
        boolean isCard1Available = false;
        boolean isCard2Available = false;
        boolean isCard3Available = false;
        wallet.get(0).addCard(card1);
        wallet.get(0).addCard(card2);
        wallet.get(0).addCard(card3);
        wallet.get(0).takeCard(card1);
        wallet.get(0).takeCard(card2);
        wallet.get(0).takeCard(card3);

        for (int i = 0; i < wallet.get(0).getCards().size(); i++) {
            if (wallet.get(0).getCards().get(i).equals(card1)) {
                isCard1Available = true;
            }
            if (wallet.get(0).getCards().get(i).equals(card2)) {
                isCard2Available = true;
            }
            if (wallet.get(0).getCards().get(i).equals(card3)) {
                isCard3Available = true;
            }
        }

        Assertions.assertFalse(isCard1Available);
        Assertions.assertFalse(isCard2Available);
        Assertions.assertFalse(isCard3Available);
    }

    @Test
    void testCalculateCoins() {
        methodName = "testCalculateCoins";
        wallet.get(0).addCoin(1000);
        wallet.get(0).addCoin(500);
        wallet.get(0).addCoin(200);
        wallet.get(0).addCoin(100);
        wallet.get(0).addCoin(200);
        wallet.get(0).addCoin(500);
        wallet.get(0).addCoin(1000);
        wallet.get(0).addCoin(100);

        Assertions.assertEquals(3600, wallet.get(0).calculateCoins());
    }

    @Test
    void testCalculateMoneys() {
        methodName = "testCalculateMoneys";
        wallet.get(0).addMoney(1000);
        wallet.get(0).addMoney(2000);
        wallet.get(0).addMoney(10000);
        wallet.get(0).addMoney(5000);
        wallet.get(0).addMoney(1000);
        wallet.get(0).addMoney(1000);
        wallet.get(0).addMoney(2000);
        wallet.get(0).addMoney(50000);
        wallet.get(0).addMoney(50000);
        wallet.get(0).addMoney(100000);
        wallet.get(0).addMoney(50000);

        Assertions.assertEquals(272000, wallet.get(0).calculateMoneys());
    }

    @Test
    void testMoneyAvailable() {
        methodName = "testMoneyAvailable";
        wallet.get(0).addMoney(1000);
        wallet.get(0).addMoney(2000);
        wallet.get(0).addMoney(10000);
        wallet.get(0).addMoney(5000);
        wallet.get(0).addMoney(1000);
        wallet.get(0).addMoney(1000);
        wallet.get(0).addMoney(2000);
        wallet.get(0).addMoney(50000);
        wallet.get(0).addMoney(50000);
        wallet.get(0).addMoney(100000);
        wallet.get(0).addMoney(50000);
        wallet.get(0).addCoin(1000);
        wallet.get(0).addCoin(500);
        wallet.get(0).addCoin(200);
        wallet.get(0).addCoin(100);
        wallet.get(0).addCoin(200);
        wallet.get(0).addCoin(500);
        wallet.get(0).addCoin(1000);
        wallet.get(0).addCoin(100);

        Assertions.assertEquals(275600, wallet.get(0).getMoneyAvailable());
    }
}
