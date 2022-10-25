package by.Jlevk.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

import androidx.core.content.ContextCompat;

public class DrawingView extends View {

    private final Paint paint = new Paint();

    private final Paint lighter;
    private final Paint light;
    private final Paint green;
    private final Paint darkGreen;
    private final Paint tree;


    private final RectF rectfLeft;
    private final RectF rectfRight;

    private final int snowBlueColor;
    private final int lightGreenColor;
    private final int greenColor;
    private final int darkGreenColor;
    private final int treeColor;
    private final int lighterGreenColor;
    private final int purple_200Color;

    public DrawingView(Context context) {
        super(context);

        snowBlueColor = ContextCompat.getColor(context, R.color.snow_blue);
        lightGreenColor = ContextCompat.getColor(context, R.color.light_green);
        greenColor = ContextCompat.getColor(context, R.color.green);
        darkGreenColor = ContextCompat.getColor(context, R.color.dark_green);
        treeColor = ContextCompat.getColor(context, R.color.tree);
        lighterGreenColor = ContextCompat.getColor(context, R.color.lighter_green);
        purple_200Color = ContextCompat.getColor(context, R.color.purple_200);

        rectfLeft = new RectF(200,1200,550,1250);
        rectfRight = new RectF(550,1200,800,1250);

        lighter = new Paint();
        lighter.setAntiAlias(true);
        lighter.setColor(lighterGreenColor);
        lighter.setStyle(Paint.Style.FILL);

        light = new Paint();
        light.setAntiAlias(true);
        light.setColor(lightGreenColor);
        light.setStyle(Paint.Style.FILL);

        green = new Paint();
        green.setAntiAlias(true);
        green.setColor(greenColor);
        green.setStyle(Paint.Style.FILL);

        darkGreen = new Paint();
        darkGreen.setAntiAlias(true);
        darkGreen.setColor(darkGreenColor);
        darkGreen.setStyle(Paint.Style.FILL);

        tree = new Paint();
        tree.setAntiAlias(true);
        tree.setColor(treeColor);
        tree.setStyle(Paint.Style.FILL);
        tree.setStrokeWidth(23f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(purple_200Color);
        paint.setTextSize(70);
        paint.setAntiAlias(true);

        canvas.drawRect(450, 1250, 600, 1800, tree);

        drawTriangle(canvas, darkGreen,520, 1500, 500);
        drawTriangle(canvas, green,520, 1400, 500);
        drawTriangle(canvas, light,520, 1300, 480);
        drawTriangle(canvas, lighter,520, 1200, 400);

        canvas.drawText("C Наступающим Новым Годом!", 35, 300, paint);
    }
    public void drawTriangle(Canvas canvas, Paint paint, int x, int y, int width) {
        int halfWidth = width / 2;

        Path path = new Path();
        path.moveTo(x, y - halfWidth); // Top
        path.lineTo(x - halfWidth, y + halfWidth); // Bottom left
        path.lineTo(x + halfWidth, y + halfWidth); // Bottom right
        path.lineTo(x, y - halfWidth); // Back to Top
        path.close();

        canvas.drawPath(path, paint);
    }
}