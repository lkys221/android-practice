package org.androidtown.c10_shoppinggrid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    GridView gridView;
    ShoppingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);

        adapter = new ShoppingAdapter();
        adapter.addItem(new ShoppingItem("Dog1", "1000", "Happy dog", R.drawable.dog1));
        adapter.addItem(new ShoppingItem("Dog2", "2000", "Sad dog", R.drawable.dog2));
        adapter.addItem(new ShoppingItem("Dog3", "3000", "Cute dog", R.drawable.dog3));
        adapter.addItem(new ShoppingItem("Dog4", "4000", "Little dog", R.drawable.dog4));

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShoppingItem item = (ShoppingItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택: " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });

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
