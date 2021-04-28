public class Rating {
    int id;
    int rating;
    Produtor produtor;

    public Rating(int id, int rating, Produtor produtor) {
        this.id = id;
        this.rating = rating;
        this.produtor = produtor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }
}
