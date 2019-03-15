package block.guess.widget.horizontalball;

public class NumberBallBean {

    private int left;
    private String txt;
    private int bgResId;
    private int txtColorId;

    public int getLeft() {
        return left;
    }

    public String getNumber() {
        return txt;
    }


    public int getBgResId() {
        return bgResId;
    }

    public int getTxtColorId() {
        return txtColorId;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void setBgResId(int bgResId) {
        this.bgResId = bgResId;
    }

    public void setTxtColorId(int txtColorId) {
        this.txtColorId = txtColorId;
    }
}
