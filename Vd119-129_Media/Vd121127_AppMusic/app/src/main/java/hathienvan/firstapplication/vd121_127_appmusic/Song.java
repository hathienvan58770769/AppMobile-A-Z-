package hathienvan.firstapplication.vd121_127_appmusic;

public class Song {
    private String title;
    private int fileMp3;

    public Song(String title, int fileMp3) {
        this.title = title;
        this.fileMp3 = fileMp3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFileMp3() {
        return fileMp3;
    }

    public void setFileMp3(int fileMp3) {
        this.fileMp3 = fileMp3;
    }
}
