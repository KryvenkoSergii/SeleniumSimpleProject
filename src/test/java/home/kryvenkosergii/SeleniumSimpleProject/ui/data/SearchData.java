package home.kryvenkosergii.SeleniumSimpleProject.ui.data;

/**
 * SearchData class.
 * @author SergiiK
 */
public class SearchData {
    
    private String searchText;

    /**
     * Default constructor.
     */
    public SearchData() {
        this.searchText = "";
    }

    /**
     * Constructor with an entered parameter.
     * @param searchText String
     */
    public SearchData(String searchText) {
        this.searchText = searchText;
    }

    /**
     * Getting a search string.
     * @return String
     */
    public String getSearchText() {
        return searchText;
    }

    /**
     * Setting a searchText field.
     * @param searchText String
     */
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    @Override
    public String toString() {
        return "SearchData [searchText=" + searchText + "]";
    }
    
}
