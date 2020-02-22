package pl.patrycja.radziej.vector.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public abstract class Shape {
    private Paint fillColor = Color.BLUEVIOLET;
    private Paint strokeColor = Color.CHOCOLATE;

    public Paint getFillColor() {
        return fillColor;
    }

    public void setFillColor(Paint fillColor) {
        this.fillColor = fillColor;
    }

    public Paint getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Paint strokeColor) {
        this.strokeColor = strokeColor;
    }
    public void drawShape(GraphicsContext context){
        context.setLineWidth(2);
        context.setStroke(getStrokeColor());
        context.setFill(getFillColor());
        draw(context);
    }

    public abstract void draw(GraphicsContext context);

    public abstract String getData();

}
