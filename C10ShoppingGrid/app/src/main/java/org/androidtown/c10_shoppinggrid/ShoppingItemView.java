package org.androidtown.c10_shoppinggrid;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by young on 2018-04-03.
 */

public class ShoppingItemView extends LinearLayout {
    TextView name;
    TextView price;
    TextView description;
    ImageView imageView;

    public ShoppingItemView(Context context) {
        super(context);

        init(context);
    }

    public ShoppingItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.shopping_item, this, true);

        name = (TextView) findViewById(R.id.name);
        price = (TextView) findViewById(R.id.price);
        description = (TextView) findViewById(R.id.description);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void setName(String n) {
        name.setText(n);
    }

    public void setPrice(String p) {
        price.setText(p);
    }

    public void setDescription(String d) {
        description.setText(d);
    }

    public void setImageView(int resId) {
        imageView.setImageResource(resId);
    }
}
