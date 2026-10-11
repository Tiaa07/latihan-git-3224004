import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RegistrationValidatorTest {

    private final RegistrationValidator validator =
            new RegistrationValidator();

    @Test
    void testNamaKosong() {
        String hasil = validator.validasiPendaftaran(
                "", 20, "andi@gmail.com", true);

        assertEquals("Nama harus diisi", hasil);
    }

    @Test
    void testUmurKurangDari17() {
        String hasil = validator.validasiPendaftaran(
                "Andi", 16, "andi@gmail.com", true);

        assertEquals("Umur minimal 17 tahun", hasil);
    }

    @Test
    void testEmailTidakValid() {
        String hasil = validator.validasiPendaftaran(
                "Andi", 20, "andigmail.com", true);

        assertEquals("Email tidak valid", hasil);
    }

    @Test
    void testTidakMenyetujuiSyarat() {
        String hasil = validator.validasiPendaftaran(
                "Andi", 20, "andi@gmail.com", false);

        assertEquals(
                "Harus menyetujui syarat dan ketentuan",
                hasil
        );
    }

    @Test
    void testPendaftaranBerhasil() {
        String hasil = validator.validasiPendaftaran(
                "Andi", 20, "andi@gmail.com", true);

        assertEquals("Pendaftaran berhasil", hasil);
    }
}