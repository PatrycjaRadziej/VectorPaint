package pl.patrycja.radziej.vector.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ellipse extends Shape {
    private double x;
    private double y;
    private double w;
    private double h;

    public Ellipse(double x1, double y1, double x2, double y2) {
        this.x = Math.min(x1, x2);
        this.y = Math.min(y1, y2);
        this.w = Math.abs(x1 - x2);
        this.h = Math.abs(y1 - y2);
    }
    private Ellipse(Builder builder){
        this.x = builder.x;
        this.y = builder.y;
        this.w = builder.w;
        this.h = builder.h;
        setFillColor(builder.fillColor);
        setStrokeColor(builder.strokeColor);
    }

    public void draw(GraphicsContext context) {
        context.strokeOval(x,y,w,h);
        context.fillOval(x,y,w,h);


//        context.beginPath();
//        context.moveTo(x,y);
//        context.lineTo(x+200,y+200);
//        context.lineTo(x+200,y);
//        context.lineTo(x+200,y+100);
//        context.stroke();
//        context.fill();
//        context.closePath();
    }

    @Override
    public String getData() {
        StringBuilder builder = new StringBuilder();
        builder.append("Ellipse;");
        builder.append(x).append(";");
        builder.append(y).append(";");
        builder.append(w).append(";");
        builder.append(h).append(";");
        builder.append(getFillColor()).append(";");
        builder.append(getStrokeColor()).append(";");
        return builder.toString();
    }
    public static class Builder{
        double x;
        double y;
        double w;
        double h;
        Color fillColor;
        Color strokeColor;


        public Ellipse build(){
            return new Ellipse(this);
        }

        public Builder setX(double x) {
            this.x = x;
            return this;
        }

        public Builder setY(double y) {
            this.y = y;
            return this;
        }

        public Builder setW(double w) {
            this.w = w;
            return this;
        }

        public Builder setH(double h) {
            this.h = h;
            return this;
        }

        public Builder setFillColor(String fillColor) {
            this.fillColor = Color.valueOf(fillColor);
            return this;
        }

        public Builder setStrokeColor(String strokeColor) {
            this.strokeColor = Color.valueOf(strokeColor);
            return this;
        }
    }


}
