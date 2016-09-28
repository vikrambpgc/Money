package CelebrityLibrary;

public class Celebrity {
    private String name;
    private String movie;
    
    public Celebrity(String name, String movie) {
        this.name = name;
        this.movie = movie;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setMovie(String movie) {
        this.movie = movie;
    }
    
    public String getMovie() {
        return movie;
    }
}
