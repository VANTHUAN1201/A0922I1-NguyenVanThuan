package codegym.model;

public class Gmail {
    int pageSize;
    String languages;
    boolean spamsFilter;
    String signature;

    public Gmail() {
    }

    public Gmail(int pageSize, String languages, boolean spamsFilter, String signature) {
        this.pageSize = pageSize;
        this.languages = languages;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }



    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public boolean isSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
