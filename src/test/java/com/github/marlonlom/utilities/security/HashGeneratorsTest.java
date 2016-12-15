/*
 * Copyright (c) 2016, marlonlom
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.github.marlonlom.utilities.security;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.security.NoSuchAlgorithmException;

/**
 * The type Hash generators test case.
 *
 * @author marlonlom
 */
@RunWith(JUnit4.class)
public class HashGeneratorsTest {
    /**
     * Verify md5 hash for empty text.
     *
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    @Test
    public void verifyMd5HashForEmptyText() throws NoSuchAlgorithmException {
        final String emptyText = "";
        final String expectedHash = "d41d8cd98f00b204e9800998ecf8427e";
        final String generatedHash = HashGenerators.MD5.getHash().generate(emptyText);
        Assert.assertEquals(expectedHash, generatedHash);
    }

    /**
     * Verify sha-1 hash for empty text.
     *
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    @Test
    public void verifySha1HashForEmptyText() throws NoSuchAlgorithmException {
        final String emptyText = "";
        final String expectedHash = "da39a3ee5e6b4b0d3255bfef95601890afd80709";
        final String generatedHash = HashGenerators.SHA1.getHash().generate(emptyText);
        Assert.assertEquals(expectedHash, generatedHash);
    }

    /**
     * Verify sha-256 hash for empty text.
     *
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    @Test
    public void verifySha256HashForEmptyText() throws NoSuchAlgorithmException {
        final String emptyText = "";
        final String expectedHash = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";
        final String generatedHash = HashGenerators.SHA256.getHash().generate(emptyText);
        Assert.assertEquals(expectedHash, generatedHash);
    }

    /**
     * Verify sha-512 hash for empty text.
     *
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    @Test
    public void verifySha512HashForEmptyText() throws NoSuchAlgorithmException {
        final String emptyText = "";
        final String expectedHash = "cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce" +
                "47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e";
        final String generatedHash = HashGenerators.SHA512.getHash().generate(emptyText);
        Assert.assertEquals(expectedHash, generatedHash);
    }
}
