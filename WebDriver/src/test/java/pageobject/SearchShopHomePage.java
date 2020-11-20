package pageobject;

public class SearchShopHomePage {
    private String searchWord;
    private String correctedWord;

    public SearchShopHomePage(String searchWord, String correctedWord) {
        this.searchWord = searchWord;
        this.correctedWord = correctedWord;
    }

    public String getSearchWord(){
        return searchWord;
    }

    public String getCorrectedWord(){
        return correctedWord;
    }
}
