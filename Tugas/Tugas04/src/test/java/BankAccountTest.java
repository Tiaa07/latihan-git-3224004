import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }

    @Test
    void testSaldoAwal() {
        assertEquals(0.0, account.getBalance());
    }

    @Test
    void testDepositBerhasil() {
        account.deposit(100000);

        assertEquals(100000.0, account.getBalance());
    }

    @Test
    void testDepositNegatif() {
        assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(-50000)
        );
    }

    @Test
    void testWithdrawBerhasil() {
        account.deposit(100000);
        account.withdraw(40000);

        assertEquals(60000.0, account.getBalance());
    }

    @Test
    void testWithdrawMelebihiSaldo() {
        account.deposit(50000);

        assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(60000)
        );
    }

    @Test
    void testWithdrawNegatif() {
        account.deposit(50000);

        assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(-10000)
        );
    }

    @Test
    void testGetBalanceSetelahBeberapaTransaksi() {
        account.deposit(100000);
        account.deposit(50000);
        account.withdraw(25000);

        assertEquals(125000.0, account.getBalance());
    }
}