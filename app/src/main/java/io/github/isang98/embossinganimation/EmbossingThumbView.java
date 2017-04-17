package io.github.isang98.embossinganimation;

import android.content.Context;
import android.graphics.*;
import android.view.View;

/**
 * Created by word on 2017. 4. 17..
 */
public class EmbossingThumbView extends View {

    private Bitmap[] bitmaps = new Bitmap[10];
    int thumbNail[] = {
            R.mipmap.n_1,
            R.mipmap.n_2,
            R.mipmap.n_3,
            R.mipmap.n_4,
            R.mipmap.n_5,
            R.mipmap.n_6,
            R.mipmap.n_7,
            R.mipmap.n_8,
            R.mipmap.n_9
        };

    Rect rect = new Rect(0,0,0,0);
    int inset = -1;

    public EmbossingThumbView(Context context) {
        super(context);

        for (int i = 0; i < thumbNail.length; i++){
            bitmaps[i] = BitmapFactory.decodeResource(getResources(), thumbNail[i]);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if ( bitmaps.length < 10){
            return;
        }

        Matrix matrix = new Matrix();

        float target[][] = new float[9][8];
        Rect rectS = new Rect(0,0,300, 300);

        if(rect.width() <= 0){
            inset = -1;
        }else if(rect.width() >= 50){
            inset = 1;
        }

        rect.inset(inset, inset);

        target[0] = new float[] {rectS.left,rectS.top , rectS.right,rectS.top ,rectS.right+rect.left,rectS.bottom+rect.top, rectS.left,rectS.bottom };
        target[1] = new float[] {rectS.left,rectS.top , rectS.right,rectS.top ,rectS.right+rect.right,rectS.bottom+rect.top, rectS.left+rect.left,rectS.bottom+rect.top };
        target[2] = new float[] {rectS.left,rectS.top , rectS.right,rectS.top ,rectS.right,rectS.bottom , rectS.left+rect.right,rectS.bottom+rect.top };
        target[3] = new float[] {rectS.left,rectS.top , rectS.right+rect.left,rectS.top+rect.top ,rectS.right+rect.left,rectS.bottom+rect.bottom , rectS.left,rectS.bottom};
        target[4] = new float[] {rectS.left+rect.left,  rectS.top+rect.top ,rectS.right+rect.right,rectS.top+rect.top ,rectS.right+rect.right,rectS.bottom+rect.bottom , rectS.left+rect.left,rectS.bottom+rect.bottom };
        target[5] = new float[] {rectS.left+rect.right, rectS.top+rect.top ,rectS.right,rect.top ,rectS.right,rectS.bottom , rectS.left+rect.right,rectS.bottom+rect.bottom };
        target[6] = new float[] {rectS.left,rectS.top , rectS.right+rect.left,rectS.top+rect.bottom ,rectS.right,rectS.bottom , rectS.left,rectS.bottom };
        target[7] = new float[] {rectS.left+rect.left,  rectS.top+rect.bottom ,rectS.right+rect.right,rectS.top+rect.bottom ,rectS.right,rectS.bottom , rectS.left,rectS.bottom };
        target[8] = new float[] {rectS.left+rect.right, rectS.top+rect.bottom ,rectS.right,rectS.top ,rectS.right,rectS.bottom , rectS.left,rectS.bottom };


        int dx = 300;
        int dy = 300;
        for (int i = 0;i < 9; i++){
            canvas.save();

            int r = (int)( i / 3);
            int c= i % 3;
            canvas.translate(dx*c, dy*r);

            Bitmap bm = bitmaps[i];
            float source[] = new float[] {0,0, bm.getWidth(),0 , bm.getWidth(),bm.getHeight(), 0,bm.getHeight()};

            matrix.setPolyToPoly( source , 0, target[i], 0, source.length >> 1);

            canvas.drawBitmap(bm,matrix , new Paint());

            canvas.restore();
        }
        invalidate();
    }
}
