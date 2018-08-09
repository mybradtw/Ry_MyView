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

public class MyView extends View {
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setBackgroundColor(Color.GREEN);

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
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            Log.v("brad", "down");
        }else if (event.getAction() == MotionEvent.ACTION_UP){
            Log.v("brad", "up");
        }else if (event.getAction() == MotionEvent.ACTION_MOVE){
            Log.v("brad", "move");
        }


        //super.onTouchEvent(event);
        return true;
    }

}
