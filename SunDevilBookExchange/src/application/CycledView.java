package application;

import application.CycledView;
import javafx.scene.layout.Pane;

public abstract class CycledView extends Pane { // Choose whatever is most appropriate class
	
    CycledView(CycledView next1, CycledView next2, CycledView next3, CycledView next4, CycledView next5) {
        this.next1 = next1;
        this.next2 = next2;
        this.next3 = next3;
        this.next4 = next4;
        this.next5 = next5;

        createGUI();
    }

    abstract void createGUI();

    protected void callNext1() {
        getScene().setRoot(next1);
    }
    protected void callNext2() {
        getScene().setRoot(next2);
    }
    protected void callNext3() {
        getScene().setRoot(next3);
    }
    protected void callNext4() {
        getScene().setRoot(next4);
    }
    protected void callNext5() {
        getScene().setRoot(next5);
    }

    public CycledView next1;
    public CycledView next2;
    public CycledView next3;
    public CycledView next4;
    public CycledView next5;
}
