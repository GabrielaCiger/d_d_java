package displayutils;
/**
 * Class containing static methods for formatting text.
 */
public class StringUtils {
    /**
     * Capitalizes the first letter of the given string.
     * This method is typically used for formatting name inputs and the beginning of sentences.
     * @param str String used in this method and returned.
     * @return Returns string with the capitalized first letter.
     */
    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
