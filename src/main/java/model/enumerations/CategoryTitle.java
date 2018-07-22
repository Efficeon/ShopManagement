package model.enumerations;

public enum CategoryTitle {
    MILK("milk products"),
    VEGETABLES("vegetables"),
    ALCOHOL ("alcohol"),
    BAKERY("bakery products");

    protected String categoryTitle;

    CategoryTitle(String categoryTitle){
        this.categoryTitle=categoryTitle;
    }

    public static CategoryTitle fromString(String categoryTitle) {
        for (CategoryTitle condition : CategoryTitle.values()) {
            if (condition.categoryTitle.equalsIgnoreCase(categoryTitle)) return condition;
        }
        return BAKERY;
    }

    public String toString() {
        return categoryTitle;
    }
}
