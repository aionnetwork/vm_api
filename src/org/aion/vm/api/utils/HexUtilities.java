package org.aion.vm.api.utils;

/**
 * A class that provides basic hexadecimal-related functionality.
 */
public final class HexUtilities {
    private static final char[] hexArray = "0123456789abcdef".toCharArray();

    /**
     * Converts a byte array into its hexadecimal string representation.
     *
     * @param bytes The byte array to convert.
     * @return The hexadecimal string representation of the byte array.
     */
    public static String bytesToHexString(byte[] bytes) {
        if (null == bytes) {
            return "";
        }

        int length = bytes.length;
        char[] hexCharacters = new char[length * 2];
        for (int i = 0; i < length; i++) {
            int currentByte = bytes[i] & 0xFF;
            hexCharacters[i * 2] = hexArray[currentByte >>> 4];
            hexCharacters[i * 2 + 1] = hexArray[currentByte & 0x0F];
        }
        return new String(hexCharacters);
    }

    //TODO: document exception
    /**
     * Converts a hexadecimal string into its byte array representation.
     *
     * @param string A hexadecimal string.
     * @return The byte array representation of the hexadecimal string.
     */
    public static byte[] hexStringToBytes(String string) {
        if (string.startsWith("0x")) {
            string = string.substring(2);
        }

        int length = string.length();
        byte[] bytes = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bytes[i / 2] = (byte) ((Character.digit(string.charAt(i), 16) << 4)
                + Character.digit(string.charAt(i + 1), 16));
        }
        return bytes;
    }

}
