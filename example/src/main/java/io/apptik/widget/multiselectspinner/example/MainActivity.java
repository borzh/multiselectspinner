/*
 * Copyright (C) 2014 Kalin Maldzhanski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apptik.widget.multiselectspinner.example;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import io.apptik.widget.multiselectspinner.ExpandableMultiSelectSpinner;
import io.apptik.widget.multiselectspinner.MultiSelectSpinner;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> options = new ArrayList<>();
        options.add("1");
        options.add("2");
        options.add("3");
        options.add("A");
        options.add("B");
        options.add("C");


        final MultiSelectSpinner multiSelectSpinner1 = (MultiSelectSpinner) findViewById(R.id.multiselectSpinner1);
        multiSelectSpinner1.setItems(options)

                .setListener(new MultiSelectSpinner.MultiSpinnerListener() {
                    @Override
                    public void onItemsSelected(boolean[] selected) {
                        int i = 0;
                    }

                    @Override
                    public void onCreateSelectionDialog(final AlertDialog alertDialog) {
                        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Select all", (DialogInterface.OnClickListener)null);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Select none", (DialogInterface.OnClickListener)null);
                        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                            @Override
                            public void onShow(DialogInterface dialogInterface) {
                                Button button = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                                button.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        ListView listView = alertDialog.getListView();
                                        for ( int i=0; i < listView.getAdapter().getCount(); i++) {
                                            listView.setItemChecked(i, true);
                                        }
                                        multiSelectSpinner1.setSelectAll(true, false);
                                    }
                                });
                                button = alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
                                button.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        ListView listView = alertDialog.getListView();
                                        for ( int i=0; i < listView.getAdapter().getCount(); i++) {
                                            listView.setItemChecked(i, false);
                                        }
                                        multiSelectSpinner1.setSelectAll(false, false);
                                    }
                                });
                            }
                        });
                    }
                })
                .setAllCheckedText("All types")
                .setAllUncheckedText("none selected")
                .setSelectAll(false)
                .selectItem(0, true)
                .selectItem(1, true)
                .selectItem(2, true)
        ;

        MultiSelectSpinner multiSelectSpinner2 = (MultiSelectSpinner) findViewById(R.id.multiselectSpinner2);
        MultiSelectSpinner multiSelectSpinner3 = (MultiSelectSpinner) findViewById(R.id.multiselectSpinner3);
        MultiSelectSpinner multiSelectSpinner4 = (MultiSelectSpinner) findViewById(R.id.multiselectSpinner4);
        MultiSelectSpinner multiSelectSpinner5 = (MultiSelectSpinner) findViewById(R.id.multiselectSpinner5);
        ArrayAdapter<String> adapter2 = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_multiple_choice, options);
        ArrayAdapter<String> adapter3 = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_checked, options);
        ArrayAdapter<String> adapter4 = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_activated_1, options);
        ArrayAdapter<String> adapter5 = new ArrayAdapter <String>(this, R.layout.custom_item, options);


        multiSelectSpinner2
                .setListAdapter(adapter2)

                .setListener(new MultiSelectSpinner.MultiSpinnerListener() {
                    @Override
                    public void onItemsSelected(boolean[] selected) {

                    }
                    @Override
                    public void onCreateSelectionDialog(AlertDialog dialog) {

                    }
                })
                .setAllCheckedText("All types")
                .setAllUncheckedText("none selected")
                .setSelectAll(true)
                //deselects item
                .selectItem(2,false)
                .setMinSelectedItems(1);

        multiSelectSpinner3
                .setListAdapter(adapter3)

                .setListener(new MultiSelectSpinner.MultiSpinnerListener() {
                    @Override
                    public void onItemsSelected(boolean[] selected) {

                    }
                    @Override
                    public void onCreateSelectionDialog(AlertDialog dialog) {

                    }
                })
                .setAllCheckedText("All types")
                .setAllUncheckedText("none selected")
                .setSelectAll(true)
                .setTitle(R.string.title)
                .setMinSelectedItems(1);

        multiSelectSpinner4
                .setListAdapter(adapter4)

                .setListener(new MultiSelectSpinner.MultiSpinnerListener() {
                    @Override
                    public void onItemsSelected(boolean[] selected) {

                    }
                    @Override
                    public void onCreateSelectionDialog(AlertDialog dialog) {

                    }
                })
                .setAllCheckedText("All types")
                .setAllUncheckedText("none selected")
                .setSelectAll(true)
                .setTitle(getResources().getString(R.string.title))
                .setMinSelectedItems(1);

        multiSelectSpinner5
                .setListAdapter(adapter5)
                .setListener(new MultiSelectSpinner.MultiSpinnerListener() {
                    @Override
                    public void onItemsSelected(boolean[] selected) {

                    }
                    @Override
                    public void onCreateSelectionDialog(AlertDialog dialog) {

                    }
                })
                .setSpinnerItemLayout(R.layout.custom_spinner_item)
                .setAllCheckedText("All types")
                .setAllUncheckedText("none selected")
                .setSelectAll(true)
                .setTitle("Custom Types Selector")
                .setMinSelectedItems(1);



        ExpandableMultiSelectSpinner multiSelectSpinner6 = (ExpandableMultiSelectSpinner) findViewById(R.id.multiselectSpinner6);
        LinkedHashMap<String, List<String>> items =  new LinkedHashMap<>();
        ArrayList<String> items1 = new ArrayList<>();
        items1.add("A");items1.add("B");items1.add("C");items1.add("D");items1.add("E");
        ArrayList<String> items2 = new ArrayList<>();
        items2.add("1");items2.add("2");items2.add("3");items2.add("4");items2.add("5");

        items.put("Abc", items1);
        items.put("123", items2);
        multiSelectSpinner6.setItems(items)
//                .setListAdapter(adapter5, "All Types", "none selected",
//                        new MultiSelectSpinner.MultiSpinnerListener() {
//                    @Override
//                    public void onItemsSelected(boolean[] checkedItems) {
//                    }
//                })
               //
                .setAllCheckedText("All types")
                .setAllUncheckedText("none selected")

               // .setSelectAll(true)
                .setTitle("Select Types from Groups")


        ;

        MultiSelectSpinner multiSelectSpinner7 = (MultiSelectSpinner) findViewById(R.id.multiselectSpinner7);
        ArrayAdapter<String> adapter7 = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_checked, options);
        MultiSelectSpinner multiSelectSpinner8 = (MultiSelectSpinner) findViewById(R.id.multiselectSpinner8);
        ArrayAdapter<String> adapter8 = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_checked, options);
        MultiSelectSpinner multiSelectSpinner9 = (MultiSelectSpinner) findViewById(R.id.multiselectSpinner9);
        ArrayAdapter<String> adapter9 = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_checked, options);
        MultiSelectSpinner multiSelectSpinner10 = (MultiSelectSpinner) findViewById(R.id
                .multiselectSpinner10);
        ArrayAdapter<String> adapter10 = new ArrayAdapter <String>(this, android.R.layout
                .simple_list_item_checked, options);

        multiSelectSpinner7
                .setListAdapter(adapter7)

                .setListener(new MultiSelectSpinner.MultiSpinnerListener() {
                    @Override
                    public void onItemsSelected(boolean[] selected) {

                    }
                    @Override
                    public void onCreateSelectionDialog(AlertDialog dialog) {

                    }
                })
                .setAllCheckedText("All types")
                .setAllUncheckedText("none selected")
                .setSelectAll(true)
                .setTitle(R.string.title)
                .setMinSelectedItems(1);

        multiSelectSpinner8
                .setListAdapter(adapter8)

                .setListener(new MultiSelectSpinner.MultiSpinnerListener() {
                    @Override
                    public void onItemsSelected(boolean[] selected) {

                    }
                    @Override
                    public void onCreateSelectionDialog(AlertDialog dialog) {

                    }
                })
                .setAllCheckedText("All types")
                .setAllUncheckedText("none selected")
                .setSelectAll(true)
                .setTitle(R.string.title)
                .setMinSelectedItems(1);

        multiSelectSpinner9
                .setListAdapter(adapter9)

                .setListener(new MultiSelectSpinner.MultiSpinnerListener() {
                    @Override
                    public void onItemsSelected(boolean[] selected) {

                    }
                    @Override
                    public void onCreateSelectionDialog(AlertDialog dialog) {

                    }
                })
                .setAllCheckedText("All types")
                .setAllUncheckedText("none selected")
                .setSelectAll(true)
                .setTitle(R.string.title)
                .setMinSelectedItems(1);

        multiSelectSpinner10
                .setListAdapter(adapter10)

                .setListener(new MultiSelectSpinner.MultiSpinnerListener() {
                    @Override
                    public void onItemsSelected(boolean[] selected) {

                    }
                    @Override
                    public void onCreateSelectionDialog(AlertDialog dialog) {

                    }
                })
                .setAllCheckedText("All types")
                .setAllUncheckedText("none selected")
                .setSelectAll(true)
                .setTitle(R.string.title)
                .setMinSelectedItems(1);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
