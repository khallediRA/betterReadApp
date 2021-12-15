package io.javabrains.search;

import java.util.List;

public class SearchResult {

    private int numFound;

    private List<SearchResultBook> docs;

    /**
     * @return int return the numFound
     */
    public int getNumFound() {
        return numFound;
    }

    /**
     * @param numFound the numFound to set
     */
    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    /**
     * @return List<SearchResultBook> return the docs
     */
    public List<SearchResultBook> getDocs() {
        return docs;
    }

    /**
     * @param docs the docs to set
     */
    public void setDocs(List<SearchResultBook> docs) {
        this.docs = docs;
    }

}
