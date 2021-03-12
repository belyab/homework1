package tasks.first;

public class Vertex {
    private int numb;
    boolean isVisited;

    public Vertex(int numb) {
        this.numb = numb;

    }


    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
