package exercice_3;

public class MyString {
	
	// Instance des variables
    private StringBuffer sb;

    /**
     * Constructor for objects of class MyString
     */
    public MyString(String s) {
        // initialise instance variables
        sb = new StringBuffer(s);
    }

    // Getters & setters
    public String getString() { 
    	return sb.toString();
    }
    
    public void setString(String s) { 
    	sb = new StringBuffer(s);
    }
    
    // Convertir tous les caractères de la chaîne en majuscule : 
    public void toUpperCase() {
    	for (int i = 0; i < sb.length(); i++) {
			sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
		}
    }
    
    // Obtenir le nombre d'occurence d'un caractère donné : 
    public int numberOfChar(char c) {
    	int count = 0;
    	for (int i = 0; i < sb.length(); i++) {
    		if(sb.charAt(i)==c) {
    			count++;
    		}
    	}
    	return count;
    }
    
    // Obtenir le nombre de voyelles (le Y sera considéré comme consonne) : 
    public int numberOfVoyelles() {
    	int numberOfVoyelles = 0;
    	toUpperCase();
    	char[] voyelles = {'A', 'E', 'I', 'O', 'U'};
    	for (char c : voyelles) {
    		numberOfVoyelles += numberOfChar(c);
		}
    	return numberOfVoyelles;
    }
    
    // Obtenir le premier mot de la chaîne : 
    public String getFirstWord() {
    	String[] words = getString().split(" ");
    	return words[0];
    }
}
