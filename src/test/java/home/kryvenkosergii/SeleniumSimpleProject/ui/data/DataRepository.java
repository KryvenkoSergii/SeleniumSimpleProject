package home.kryvenkosergii.SeleniumSimpleProject.ui.data;

import home.kryvenkosergii.SeleniumSimpleProject.ui.tools.Randomizer;

/**
 * DataRepository class which holds different sets of data. 
 * @author SergiiK
 */
public final class DataRepository {
    private static volatile DataRepository instance = null;

    private DataRepository() {
    }

    public static DataRepository get() {
        if (instance == null) {
            synchronized (DataRepository.class) {
                if (instance == null) {
                    instance = new DataRepository();
                }
            }
        }
        return instance;
    }

    public SearchData getDefault() {
        return oneRandomLetterSearchData();
    }

    /**
     * Default search a random word (one random letter).
     * @return SearchData class.
     */
    public SearchData oneRandomLetterSearchData() {
        return new SearchData(Randomizer.getRamdomStringLetters1(1));
    }
    
    /**
     * Search a random word (20 letter).
     * @return SearchData class.
     */
    public SearchData oneRandomWordSearchData() {
        return new SearchData(Randomizer.getRamdomString20Letters());
    }
    
}