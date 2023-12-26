package com.example.onlineproductcart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView productRecyclerView;
    TextView txtTotalItem, lytProduct;
    List<Product> productList;
    ProductAdapter productAdapter;
    EditText etvSearch;
    ImageView imgClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productRecyclerView = findViewById(R.id.productRecyclerView);
        txtTotalItem = findViewById(R.id.txtTotalItem);
        etvSearch = findViewById(R.id.etvSearch);
        imgClose = findViewById(R.id.imgClose);

        productAdapter = new ProductAdapter(this, productList, txtTotalItem);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        productRecyclerView.setAdapter(productAdapter);

        productList = new ArrayList<>();
        productList.add(new Product(1, "https://imgs.search.brave.com/8Qgv0STg5FRFaVQ5z5JAIdZIaq20Kl2fT-Pzt8Q6YLQ/rs:fit:500:0:0/g:ce/aHR0cHM6Ly81Lmlt/aW1nLmNvbS9kYXRh/NS9XTy9CSC9PTC9T/RUxMRVItMTI0MTcw/MDgvdGVhLXNwZWNp/YWwtcGFzdGV1cmlz/ZWQtaG9tb2dlbmlz/ZWQtbWlsay0yNTB4/MjUwLmpwZWc", "Milk", "500ml", 34.0));
        productList.add(new Product(2, "https://imgs.search.brave.com/1DrNazKy-Q5EtEA4N02uyov6WTHFJhn7myTCmvWx7Xo/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9pNS53/YWxtYXJ0aW1hZ2Vz/LmNvbS9hc3IvY2Uy/NTE0YmQtN2U4Mi00/MWJkLTg4YzItMWM5/ZDFkZWU3OWU3LmRh/YTBkYzM4NTg4ZmVl/NjQxZTZhYzgyNWQx/MjE4NzFlLmpwZWc_/b2RuSGVpZ2h0PTYx/MiZvZG5XaWR0aD02/MTImb2RuQmc9RkZG/RkZG", "Tea", "200g", 20.0));
        productList.add(new Product(3, "https://imgs.search.brave.com/XjSHBsQlkNETOtO3rxttIy5rpMuRb1wobe2atVDoVZg/rs:fit:500:0:0/g:ce/aHR0cHM6Ly93d3cu/ZG9taW5vc3VnYXIu/Y29tL3NpdGVzL2Rv/bWlub3N1Z2FyX2Nv/bS9maWxlcy9zdHls/ZXMvbGFyZ2UvcHVi/bGljLzIwMjItMDUv/V2ViX0IyQ19Qcm9k/dWN0LVN1Z2FyUGFj/a2V0c1BORy5qcGcu/d2VicD9pdG9rPWpY/elozQTkz","Sugar", "500g", 21.0));
        productList.add(new Product(4, "https://imgs.search.brave.com/_yUobJoNjHX2LaTLYd7iKOaNTp-bcryHQAqpWldyosw/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9tYXJh/cnRoaXN3YWQuYi1j/ZG4ubmV0L3dwLWNv/bnRlbnQvdXBsb2Fk/cy8yMDIxLzA2L2No/YWktbWFzYWxhLXNw/aWNlcy10ZWEtcG93/ZGVyLXBhY2tldC5w/bmc", "Tea Masala", "500g", 100.0));
        productList.add(new Product(5, "https://imgs.search.brave.com/Hz60apgZY8E84dT7bo4uTJ5_Qq0OW7sNMZoXa0IL3sM/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9pbWFn/ZXMtbmEuc3NsLWlt/YWdlcy1hbWF6b24u/Y29tL2ltYWdlcy9J/Lzcxb0NMMnZRNUNM/LmpwZw", "Rice", "1KG", 150.0));
        productList.add(new Product(6, "https://imgs.search.brave.com/b_oqwq-pLdqSTI3yKlx5MQfSNHbd770nUx_z8Ti-vG4/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL0kv/NTFUMHlZOHprVEwu/anBn","Ghee", "500g", 500.0));

//        productAdapter = new ProductAdapter(this, productList, txtTotalItem);
//        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        productRecyclerView.setAdapter(productAdapter);

        etvSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int total, int start, int flag) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (productAdapter != null) {
                    imgClose.setVisibility(View.VISIBLE);
                    productAdapter.search(charSequence, lytProduct, productRecyclerView);
                }
                if (i2 < 1) {
                    imgClose.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}