package pl.patrycja.radziej.vector.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Star extends Shape {
    private double xc;
    private double yc;
    private double radius;


    public Star(double x1, double y1, double x2, double y2) {
        this.xc = (x1 + x2) / 2;
        this.yc = (y1 + y2) / 2;
        double width = Math.abs(x1 - x2);
        double height = Math.abs(y1 - y2);
        double d = Math.min(width, height);
        radius = d / 2;
    }

    private Star(Builder builder) {
        this.xc = builder.x;
        this.yc = builder.y;
        this.radius = builder.w;
        setFillColor(builder.fillColor);
        setStrokeColor(builder.strokeColor);
    }

    public void draw(GraphicsContext context) {
        context.beginPath();
        int count = 10;
        context.moveTo(xc, yc - radius);

        for (int i = 1; i < count; i++) {
            double a= (double)i/count * 2 * Math.PI;
            double r = i% 2 ==0 ?radius : radius/2;
            double xDelta = Math.sin(a) * r;
            double yDelta = Math.cos(a) * r;
            double x = xc + xDelta;
            double y = yc - yDelta;

        context.lineTo(x, y);
    }
        context.closePath();
        context.stroke();
        context.fill();


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
        builder.append("Star;");
        builder.append(xc).append(";");
        builder.append(yc).append(";");
        builder.append(radius).append(";");
        builder.append(getFillColor()).append(";");
        builder.append(getStrokeColor()).append(";");
        return builder.toString();
    }

    public static class Builder {
        double x;
        double y;
        double w;
        double h;
        Color fillColor;
        Color strokeColor;


        public Star build() {
            return new Star(this);
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
