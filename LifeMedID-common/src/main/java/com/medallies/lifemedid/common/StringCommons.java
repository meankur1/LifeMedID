package com.medallies.lifemedid.common;


import com.medallies.lifemedid.constants.ServiceConstants;
import com.medallies.lifemedid.exception.IllegalArgumentValueException;

/**
 * The type StringCommons.
 */
public class StringCommons {

    /**
     * Adjust key string.
     * This method is to change any lowercase word_lowercase word(abc_abc) to camelCase (abcAbc), for using in our
     * filter and sort api. Te 1st letter after underscore(_) is capitalized and underscored removed to achieve
     * camelCase.
     * If the string is already in camelCase or has no lower case alphabets then the method ignores the conversion
     * and only removes the _ except for the last one in the word.
     * e.g. abc_abc= abcAbc, abcAbc=abcAbc, abc_123=abc123,abc_ab_ab=abcAbAb,abc_$$56=abc$$56
     *
     * @param string the string
     * @return string string
     */
    public static String adjustKey (String string) {

        StringBuilder stringBuilder = new StringBuilder( );
        for (int i = 0; i < string.length( ); i++) {

            if (string.charAt(i) == '_' && i < ( string.length( ) - 1 )) {
                int charValueInInt = (int) string.charAt(i + 1);

                if (charValueInInt >= 97 && charValueInInt <= 122) {
                    stringBuilder.append((char) ( (int) string.charAt(i + 1) - 32 ));
                }
                if (charValueInInt < 97 || charValueInInt > 122) {
                    stringBuilder.append(string.charAt(i + 1));
                }
                i = i + 1;
            } else {
                stringBuilder.append(string.charAt(i));
            }
        }
        return stringBuilder.toString( );
    }

    /**
     * This method is to add the name of the Hibernate table within the property of the key so Hibernate can map to
     * the correct join table for retrieving the dataproperly.
     *
     * @param key {String} The property name formatted and to be used to search the database
     * @return string string
     */
    public static String alterKeyAccToHibMapping (final String key) {
        if (!key.contains(ServiceConstants.UNDERSCORE)) {
            throw new IllegalArgumentValueException("Invalid Key provided, cannot convert to Hibernate Table.Column" +
                    "Property Mapping from just column property");
        }
        return key.substring(0, key.lastIndexOf(ServiceConstants.UNDERSCORE)) + ServiceConstants.DOT + key;
    }
}
