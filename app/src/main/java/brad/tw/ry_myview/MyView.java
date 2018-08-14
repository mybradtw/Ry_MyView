package brad.tw.ry_myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.HashMap;
import java.util.LinkedList;

public class MyView extends View {
    private LinkedList<LinkedList<HashMap<String,Float>>> lines;
    private Paint paint;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setBackgroundColor(Color.GREEN);

        lines = new LinkedList<>();
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(4);

//        setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.v("brad", "Click");
//            }
//        });

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (LinkedList<HashMap<String,Float>> line : lines){
            for (int i=1; i<line.size(); i++){
                HashMap<String,Float> p0 = line.get(i-1);
                HashMap<String,Float> p1 = line.get(i);
                canvas.drawLine(p0.get("x"),p0.get("y"),
                        p1.get("x"),p1.get("y"),
                        paint);
            }
        }

    }

    public void clear(){
        lines.clear();
        invalidate();
    }

    public void undo(){
        if (lines.size()>0){
            lines.removeLast();
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            Log.v("brad", "down");
            setFirstPoint(event);
        }else if (event.getAction() == MotionEvent.ACTION_UP){
            Log.v("brad", "up");
        }else if (event.getAction() == MotionEvent.ACTION_MOVE){
            Log.v("brad", "move");
            setMovePoint(event);
        }


        //super.onTouchEvent(event);
        return true;
    }

    private void setFirstPoint(MotionEvent event){
        LinkedList<HashMap<String,Float>> line = new LinkedList<>();

        float ex = event.getX(), ey = event.getY();
        HashMap<String,Float> point = new HashMap<>();
        point.put("x", ex); point.put("y", ey);
        line.add(point);

        lines.add(line);

    }

    private void setMovePoint(MotionEvent event){
        float ex = event.getX(), ey = event.getY();
        HashMap<String,Float> point = new HashMap<>();
        point.put("x", ex); point.put("y", ey);
        lines.getLast().add(point);

        invalidate();
    }




}
