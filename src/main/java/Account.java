import io.qameta.allure.Step;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    @Step ("Run the validator")
    public boolean checkNameToEmboss() throws NullPointerException{

        try {
        boolean isEmpty = name.isEmpty();
        boolean isBlanc = name.isBlank();
        boolean lengthOK = name.length() >= 3 && name.length() <= 19;
        boolean startSpace = name.startsWith(" ");
        boolean endSpace = name.endsWith(" ");
        boolean singleSpace = name.indexOf(" ") == name.lastIndexOf(" ") && name.indexOf(" ") != -1;


        return !isEmpty && !isBlanc && !endSpace && !startSpace && lengthOK && singleSpace;

        } catch (NullPointerException e){
            return false;
        }
    }
}