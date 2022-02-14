public class FictonBook extends Book{
    private String category;

    public FictonBook(String bookCode, String name, int price, String author) {
        super(bookCode, name, price, author);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
