package academy.springboot.utils;

import academy.springboot.config.ApplicationConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Slf4j
@Repository
@RequiredArgsConstructor
public class Cryptography {

    private final ApplicationConfig applicationConfig;

    public String Encrypt(String textToEncrypt) throws Exception {
        try {
            // Create key and cipher
            byte[] decodedKey = Base64.getDecoder().decode(applicationConfig.getSecretKey());
            Cipher cipher = Cipher.getInstance("AES");

            log.info("Text to encrypt: {}", textToEncrypt);

            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");

            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, originalKey);
            byte[] encrypted = cipher.doFinal(textToEncrypt.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encrypted);
        }
        catch (Exception ex) {
            log.warn("Error when encrypting the text '{}'. {}", textToEncrypt, ex);
            throw ex;
        }
    }

    public String Decrypt(String textEncrypted) throws Exception {
        try {
            // Create key and cipher
            byte[] decodedKey = Base64.getDecoder().decode(applicationConfig.getSecretKey());
            Cipher cipher = Cipher.getInstance("AES");

            log.info("Text to decrypt: {}", textEncrypted);

            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");

            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, originalKey);
            byte[] encrypted = cipher.doFinal(Base64.getDecoder().decode(textEncrypted));
            return new String(encrypted);
        }
        catch (Exception ex) {
            log.warn("Error when decrypting the text '{}'. {}", textEncrypted, ex);
            throw ex;
        }
    }

}
