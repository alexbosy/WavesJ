package com.wavesplatform.wavesj;

import org.bitcoinj.core.Base58;
import static org.junit.Assert.*;
import org.junit.Test;

public class AccountTest {

    @Test
    public void testAccountProperties() {
        String pk = "8LbAU5BSrGkpk5wbjLMNjrbc9VzN9KBBYv9X8wGpmAJT";
        String sk = "CMLwxbMZJMztyTJ6Zkos66cgU7DybfFJfyJtTVpme54t";
        String addr = "3MzZCGFyuxgC4ZmtKRS7vpJTs75ZXdkbp1K";

        PrivateKeyAccount acc = new PrivateKeyAccount(sk, Account.TESTNET);
        assertArrayEquals(Base58.decode(sk), acc.getPrivateKey());
        assertArrayEquals(Base58.decode(pk), acc.getPublicKey());
        assertEquals(addr, acc.getAddress());
    }

    @Test
    public void testAccountCreation() {
        String seed = "health lazy lens fix dwarf salad breeze myself silly december endless rent faculty report beyond";
        PrivateKeyAccount account = new PrivateKeyAccount(seed, 0, Account.TESTNET);
        assertArrayEquals(Base58.decode("CMLwxbMZJMztyTJ6Zkos66cgU7DybfFJfyJtTVpme54t"), account.getPrivateKey());
        assertArrayEquals(Base58.decode("8LbAU5BSrGkpk5wbjLMNjrbc9VzN9KBBYv9X8wGpmAJT"), account.getPublicKey());
        assertEquals("3MzZCGFyuxgC4ZmtKRS7vpJTs75ZXdkbp1K", account.getAddress());
    }
}
