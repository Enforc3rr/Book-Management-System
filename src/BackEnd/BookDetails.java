package BackEnd;

public class BookDetails {
    private String nameOfBook;
    private String nameOfAuthor;
    private String genreOfBook;
    private String yearOfPublication;
    private String description;

    public BookDetails(String nameOfBook, String nameOfAuthor, String genreOfBook, String yearOfPublication, String description) {
        this.nameOfBook = nameOfBook;
        this.nameOfAuthor = nameOfAuthor;
        this.genreOfBook = genreOfBook;
        this.yearOfPublication = yearOfPublication;
        this.description = description;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public String getNameOfAuthor() {
        return nameOfAuthor;
    }

    public String getGenreOfBook() {
        return genreOfBook;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public String getDescription() {
        return description;
    }
}
