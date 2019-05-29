/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyroom;

/**
 *
 * @author jteet
 */
class Student {
    protected String id;
    protected String title;
    protected String artist;
    protected String genre;
    protected int year;
    protected double price;
    
     // ----- ID Get and Set -----
    public void setID(String id) {
       this.id = id; 
    }
    public String getID() {
        return id;
    }
    
    // ----- Title Get and Set -----
    public void setTitle(String title) {
        this.title = title;
    } 
    public String getTitle() {
        return title;
    }
    
    // ----- Artist Get and Set -----
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getArtist() {
        return artist;
    }
    
    // ----- Genre Get and Set -----
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getGenre() {
        return genre;
    }
    
    // ----- Year Get and Set -----
    public void setYear(int year) {
        this.year = year;
    }
    public int getYear() {
        return year;
    }
    
    // ----- Price Get and Set -----
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    
    
    
    public void fromCSV (String CSV) {
        String[] kv = CSV.split(":");
        String key = kv[0];
        
        String[] arrOfStr = kv[1].split(",");
        
        this.id = key;
        this.title = arrOfStr[0];
        this.artist = arrOfStr[1];
        this.genre = arrOfStr[2];
        this.year = Integer.parseInt(arrOfStr[3]);
        this.price = Double.parseDouble(arrOfStr[4]);
    }
    
    public String toCSV() {
        return this.id + ":" + this.title + "," + this.artist + "," + this.genre + "," + this.year + "," + this.price + "\n";
    }
}
