package kz.seisen.sellflowforexample.model;



public class Product {
    private Long id;
    private String title;
    private String description;
    private String city;
    private int price;
    private String author;
    private Long categoryId;

    public Product(Long id, String title, String description, String city, int price, String author, Long categoryId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.city = city;
        this.price = price;
        this.author = author;
        this.categoryId = categoryId;
    }


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
