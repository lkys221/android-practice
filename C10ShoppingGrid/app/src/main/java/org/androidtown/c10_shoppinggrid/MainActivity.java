package org.androidtown.c10_shoppinggrid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    class ShoppingAdapter extends BaseAdapter{
        ArrayList<ShoppingItem> items = new ArrayList<ShoppingItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(ShoppingItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ShoppingItemView view = new ShoppingItemView(getApplicationContext());
            ShoppingItem item = items.get(position);
            view.setName(item.getName());
            view.setPrice(item.getPrice());
            view.setDescription(item.getDescription());
            view.setImageView(item.getResId());

            return  view;
        }
    }
}
