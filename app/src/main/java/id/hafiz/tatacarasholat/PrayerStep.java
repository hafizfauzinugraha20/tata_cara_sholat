package id.hafiz.tatacarasholat;

import java.util.List;

public class PrayerStep {
    private int id;
    private String title;
    private String desc;
    private String arabic;
    private String latin;
    private String meaning;
    private int imageResId; // BERUBAH: Menggunakan int resource ID (R.drawable.xxx)
    private boolean isExpanded;
    private List<Niat> niatList;

    public PrayerStep(int id, String title, String desc, String arabic, String latin, String meaning, int imageResId, List<Niat> niatList) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.arabic = arabic;
        this.latin = latin;
        this.meaning = meaning;
        this.imageResId = imageResId;
        this.niatList = niatList;
        this.isExpanded = false;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDesc() { return desc; }
    public String getArabic() { return arabic; }
    public String getLatin() { return latin; }
    public String getMeaning() { return meaning; }
    public int getImageResId() { return imageResId; } // BERUBAH: Return int
    public boolean isExpanded() { return isExpanded; }
    public List<Niat> getNiatList() { return niatList; }

    // Setter for expansion
    public void setExpanded(boolean expanded) { isExpanded = expanded; }

    // Inner class for Niat
    public static class Niat {
        public String name;
        public String arabic;
        public String latin;
        public String meaning;

        public Niat(String name, String arabic, String latin, String meaning) {
            this.name = name;
            this.arabic = arabic;
            this.latin = latin;
            this.meaning = meaning;
        }
    }
}