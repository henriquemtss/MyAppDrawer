package br.com.etecia.myappdrawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class FragmentHistorico extends Fragment {

    ListView lstHistorico;

    String NomeHistorico[] = {"Henrique Matos"};
    int imagemHistorico[] = {R.drawable.perfil_mobile};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_historico, container, false);

        lstHistorico = view.findViewById(R.id.idListaHistorico);

        MyAdapterHistorico adapterHistorico = new MyAdapterHistorico();

        lstHistorico.setAdapter(adapterHistorico);

        return view;
    }

    public class MyAdapterHistorico extends BaseAdapter {

        @Override
        public int getCount() {
            return imagemHistorico.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }


        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imgHistorico;
            TextView txtHistorico;

            View v = getLayoutInflater().inflate(R.layout.modelo_gallery, null);

            imgHistorico = v.findViewById(R.id.modeloImagemHistorico);
            txtHistorico = v.findViewById(R.id.modeloTxtNome);
            return null;
        }
    }
}