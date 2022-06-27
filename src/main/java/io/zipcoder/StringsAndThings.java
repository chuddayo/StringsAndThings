package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {



    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        Integer counter = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            if ((input.charAt(i) == 'y' || input.charAt(i) == 'Y' || input.charAt(i) == 'z' || input.charAt(i) == 'Z') && !Character.isLetter(input.charAt(i+1))) {
                counter ++;
            }
        }
        if (input.charAt(input.length() - 1) == 'y' || input.charAt(input.length() - 1) == 'Y' || input.charAt(input.length() - 1) == 'z' || input.charAt(input.length() - 1) == 'Z') {
            counter++;
        }
        return counter;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        while (base.contains(remove)) {
            base = base.replace(remove, "");
        }
        return base;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        int isCounter = 0;
        int notCounter = 0;

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.substring(i, i+2).equals("is")) {
                isCounter++;
            }
        }
        for (int i = 0; i < input.length() - 2; i++) {
            if (input.substring(i, i+3).equals("not")) {
                notCounter++;
            }
        }
        if (isCounter == notCounter) return true;
        return false;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        for (int i = 1; i < input.length() - 1; i++) {
            if (input.charAt(i) == 'g') {
                if ((input.charAt(i-1) != 'g')&&(input.charAt(i+1) != 'g')) {
                    System.out.println(input);
                    System.out.println(i);
                    return false;
                }
            }
        }
        // look at first letter
        if (input.charAt(0) == 'g') {
            if (input.charAt(1) != 'g') return false;
        }
        // look at last letter
        if (input.charAt(input.length() - 1) == 'g') {
            if (input.charAt(input.length() - 2) != 'g') return false;
        }
        return true;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int tripleCounter = 0;
        for (int i = 0; i < input.length() - 2; i++) {
            if (input.charAt(i) == input.charAt(i+1) && input.charAt(i) == input.charAt(i+2)) {
                tripleCounter++;
            }
        }
        return tripleCounter;
    }
}
