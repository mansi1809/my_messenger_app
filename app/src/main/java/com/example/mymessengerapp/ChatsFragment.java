package com.example.mymessengerapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ChatsFragment extends Fragment {
    FloatingActionButton floatBtnAdd;
    RecyclerContactAdapter adapter;
    RecyclerView recyclerView;
    EditText edtName, edtNumber;
    Button btnAction, btnDelete;

    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    public ChatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chats, container, false);

        floatBtnAdd = view.findViewById(R.id.floatBtnAdd);
        recyclerView = view.findViewById(R.id.chatRecycler);

        floatBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.add_update_lay);

                edtName = dialog.findViewById(R.id.edtName);
                edtNumber = dialog.findViewById(R.id.edtNumber);
                btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name="", number="";
                        if(!edtName.getText().toString().equals("")) {
                            name = edtName.getText().toString();
                        }else{
                            Toast.makeText(getActivity(), "Please Enter Contact Name", Toast.LENGTH_SHORT).show();
                        }
                        if(!edtNumber.getText().toString().equals("")) {
                            number = edtNumber.getText().toString();
                        }else{
                            Toast.makeText(getActivity(), "Please Enter Contact Number", Toast.LENGTH_SHORT).show();
                        }
                        arrContacts.add(new ContactModel(name,number));
                        adapter.notifyItemInserted(arrContacts.size()-1);
                        recyclerView.scrollToPosition(arrContacts.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });




        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        arrContacts.add(new ContactModel(R.drawable.a, "A","1234567890"));
        arrContacts.add(new ContactModel(R.drawable.b, "B","1234567890"));
        arrContacts.add(new ContactModel(R.drawable.c, "C","1234567890"));
        arrContacts.add(new ContactModel(R.drawable.d, "D","1234567890"));
        arrContacts.add(new ContactModel(R.drawable.e, "E","1234567890"));
        arrContacts.add(new ContactModel(R.drawable.f, "F","1234567890"));
        arrContacts.add(new ContactModel(R.drawable.g, "G","1234567890"));
        arrContacts.add(new ContactModel(R.drawable.h, "H","1234567890"));
        arrContacts.add(new ContactModel(R.drawable.i, "I","1234567890"));
        arrContacts.add(new ContactModel(R.drawable.j, "J","1234567890"));
        arrContacts.add(new ContactModel(R.drawable.k, "K","1234567890"));
        arrContacts.add(new ContactModel(R.drawable.l, "L","1234567890"));

         adapter = new RecyclerContactAdapter(getActivity(),arrContacts);
        recyclerView.setAdapter(adapter);

        return view;
    }

}