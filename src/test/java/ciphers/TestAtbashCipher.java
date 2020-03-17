package ciphers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAtbashCipher {

    @Test
    public void testEncryptMethod(){
        Cipher cipher = new Atbash();

        assertEquals("SVOOL DLIOW.", cipher.encrypt("HELLO WORLD."));

    }

    @Test
    public void testDecryptMethod(){
        Cipher cipher = new Atbash();

        assertEquals("HELLO WORLD", cipher.encrypt("SVOOL DLIOW"));

    }
}
