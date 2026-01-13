package id.hafiz.tatacarasholat;

public class Doa {
    private int id;
    private String category;
    private String title;
    private String arabic;
    private String latin;
    private String translation;
    private boolean isExpanded;

    public Doa(int id, String category, String title, String arabic, String latin, String translation) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.arabic = arabic;
        this.latin = latin;
        this.translation = translation;
        this.isExpanded = false;
    }

    // Getters
    public int getId() { return id; }
    public String getCategory() { return category; }
    public String getTitle() { return title; }
    public String getArabic() { return arabic; }
    public String getLatin() { return latin; }
    public String getTranslation() { return translation; }
    public boolean isExpanded() { return isExpanded; }

    // Setter
    public void setExpanded(boolean expanded) { isExpanded = expanded; }
}