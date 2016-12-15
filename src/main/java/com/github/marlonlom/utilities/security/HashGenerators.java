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

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility class that uses {@link MessageDigest} for obtaining a hashed text
 * using algorithms such as MD5 and SHA-1.
 *
 * @author marlonlom
 */
public enum HashGenerators {

    /**
     * The MD5 algorithm reference.
     */
    MD5(new Hashable() {
        public String generate(String input) throws NoSuchAlgorithmException {
            return HashDigester.digest(input, "MD5");
        }
    }),
    /**
     * The SHA-1 algorithm reference.
     */
    SHA1(new Hashable() {
        public String generate(String input) throws NoSuchAlgorithmException {
            return HashDigester.digest(input, "SHA-1");
        }
    }),
    /**
     * The SHA-256 algorithm reference.
     */
    SHA256(new Hashable() {
        public String generate(String input) throws NoSuchAlgorithmException {
            return HashDigester.digest(input, "SHA-256");
        }
    }),
    /**
     * The SHA-512 algorithm reference.
     */
    SHA512(new Hashable() {
        public String generate(String input) throws NoSuchAlgorithmException {
            return HashDigester.digest(input, "SHA-512");
        }
    });

    /**
     * The Hash digester reference.
     */
    private Hashable hash;

    /**
     * Private constructor.
     *
     * @param generation hash generation reference
     */
    HashGenerators(final Hashable generation) {
        this.hash = generation;
    }

    /**
     * Returns hash digest generation algorithm.
     *
     * @return the hashing algorithm
     */
    public Hashable getHash() {
        return this.hash;
    }

    /**
     * Interface definition for hash generation.
     *
     * @author marlonlom
     */
    interface Hashable {
        /**
         * Generate string.
         *
         * @param input text input
         * @return generated hash as string
         * @throws NoSuchAlgorithmException the no such algorithm exception
         */
        String generate(final String input) throws NoSuchAlgorithmException;
    }

    /**
     * Static class for Hash digest processing.
     *
     * @author marlonlom
     */
    final static class HashDigester {

        /**
         * Private constructor
         */
        private HashDigester() {
        }

        /**
         * Digest input and generates hash as String.
         *
         * @param input     text input
         * @param algorithm algorithm reference name
         * @return generated hash as string
         * @throws NoSuchAlgorithmException when no such algorithm exists
         */
        static String digest(String input, final String algorithm)
                throws NoSuchAlgorithmException {
            final int sigNum = 1, radix = 16;
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] digested = md.digest(input.getBytes());
            return new BigInteger(sigNum, digested).toString(radix);
        }
    }
}
