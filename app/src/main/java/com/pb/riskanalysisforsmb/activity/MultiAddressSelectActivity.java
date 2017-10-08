package com.pb.riskanalysisforsmb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.pb.riskanalysisforsmb.R;
import com.pb.riskanalysisforsmb.adaptor.AddressAdapter;
import com.pb.riskanalysisforsmb.beans.AddressVO;
import com.pb.riskanalysisforsmb.georisk.tasks.MultiAddressProcessingTask;

import java.util.ArrayList;
import java.util.List;

public class MultiAddressSelectActivity extends AppCompatActivity implements View.OnLongClickListener {
    private static final String LOG_TAG = "MultiAddressSelect";
    private final List<AddressVO> addressList = createMockedAddressList();
    private final ArrayList<AddressVO> selectedList = new ArrayList<>();
    private Toolbar toolbar;
    private TextView counterTextView;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private boolean isRecycleViewInAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiple_address);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Keep counter text view in gone state at start.
        counterTextView = (TextView) findViewById(R.id.counter_text);
        counterTextView.setVisibility(View.GONE);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new AddressAdapter(addressList, MultiAddressSelectActivity.this);
        recyclerView.setAdapter(adapter);
    }

    @NonNull
    private List<AddressVO> createMockedAddressList() {

        List<AddressVO> addressList = new ArrayList<>();
        addressList.add(new AddressVO("Alexis Buckland", "87 Maywood Road", "53472 Vahlen Pass", "3169 Gale Trail" ,"Little Rock" ,"Arkansas", "United States", "72204"));
        addressList.add(new AddressVO("Berta O'Doohaine", "90 Northview Road", "3 Glendale Hill", "693 Bluestem Plaza", "Sacramento", "California", "United States", "94230"));
        addressList.add(new AddressVO("Brenden Evins", "813 Longview Street", "3 Nova Way", "7686 Porter Hill", "Colorado Springs", "Colorado", "United States", "80920"));
        addressList.add(new AddressVO("Carena Redholls", "26654 Caliangt Crossing", "5168 Kipling Place", "1 Calypso Point", "Jackson", "Mississippi", "United States", "39282"));
        addressList.add(new AddressVO("Colleen Whibley", "28135 Mallory Hill", "273 Morrow Hill", "536 Eliot Place", "San Antonio", "Texas", "United States", "78291"));
        addressList.add(new AddressVO("Creight Tallow", "41 Pankratz Way", "44224 Loeprich Plaza", "94 Melby Hill", "Boise", "Idaho", "United States", "83732"));
        addressList.add(new AddressVO("Electra Antoshin", "863 Lawn Court", "6878 4th Hill", "6503 Pennsylvania Place", "Washington", "District of Columbia", "United States", "20456"));
        addressList.add(new AddressVO("Feliza Jarman", "9756 School Alley", "6 4th Court", "059 Surrey Park", "Saint Petersburg", "Florida", "United States", "33731"));
        addressList.add(new AddressVO("Ferris Peebles", "39226 Stone Corner Hill", "3 Florence Trail", "452 Helena Alley", "Topeka", "Kansas", "United States", "66606"));
        addressList.add(new AddressVO("Flint Owtram", "30 Comanche Plaza", "8 Bay Crossing", "95526 Merry Lane", "Charlotte", "North Carolina", "United States", "28272"));
        addressList.add(new AddressVO("Gloriane Vlasenko", "12746 Northwestern Circle", "3 Talisman Plaza", "398 Village Lane", "San Diego", "California", "United States", "92176"));
        addressList.add(new AddressVO("Gradeigh Rafferty", "567 Autumn Leaf Plaza", "01 Marcy Hill", "01 Sauthoff Park", "Phoenix", "Arizona", "United States", "85005"));
        addressList.add(new AddressVO("Gray Camies", "2 Lakewood Hill", "1 Heffernan Court", "684 Washington Terrace", "Midland", "Michigan", "United States", "48670"));
        addressList.add(new AddressVO("Ingemar Baurerich", "9 Burrows Pass", "70129 Larry Road", "53 Becker Pass", "Brooklyn", "New York", "United States", "11205"));
        addressList.add(new AddressVO("Jareb Belone", "3 Kedzie Junction", "37296 Dottie Place", "42081 Fairview Parkway", "Redwood City", "California", "United States", "94064"));
        addressList.add(new AddressVO("Jeffie Spink", "19 Bluejay Parkway", "1 Manufacturers Park", "25 3rd Drive", "Lexington", "Kentucky", "United States", "40591"));
        addressList.add(new AddressVO("Jephthah Chisman", "6087 Cordelia Plaza", "84 Bunker Hill Avenue", "08 Eliot Court", "Longview", "Texas", "United States", "75605"));
        addressList.add(new AddressVO("Julio Maystone", "6398 Eggendart Place", "851 Westridge Place", "38 Texas Avenue", "Orlando", "Florida", "United States", "32803"));
        addressList.add(new AddressVO("Leroi Yedy", "1334 Stoughton Place", "5 Melody Way", "1340 Merchant Road", "Colorado Springs", "Colorado", "United States", "80905"));
        addressList.add(new AddressVO("Lianna Crier", "1 Eliot Center", "3856 Onsgard Point", "9057 Continental Street", "Des Moines", "Iowa", "United States", "50335"));
        addressList.add(new AddressVO("Lezlie Gosland", "45 Graedel Way", "35947 Lukken Avenue", "07 Warrior Trail", "Detroit", "Michigan", "United States", "48206"));
        addressList.add(new AddressVO("Lucille Gyorffy", "008 5th Park", "0729 Canary Trail", "2 Carberry Place", "Watertown", "Massachusetts", "United States", "2472"));
        addressList.add(new AddressVO("Marcille Hasney", "98 Sachs Circle", "48 Manitowish Crossing", "9544 Ridge Oak Trail", "Macon", "Georgia", "United States", "31296"));
        addressList.add(new AddressVO("Meghan Bridgestock", "98454 Bowman Center", "789 Kropf Terrace", "435 Waubesa Place", "Spartanburg", "South Carolina", "United States", "29319"));
        addressList.add(new AddressVO("Nani McCrow", "85899 Ronald Regan Place", "0590 Carey Circle", "1 Lakewood Plaza", "Colorado Springs", "Colorado", "United States", "80910"));
        addressList.add(new AddressVO("Raina Camelin", "70 Pierstorff Trail", "6 Forest Run Park", "1 Warner Road", "San Angelo", "Texas", "United States", "76905"));
        addressList.add(new AddressVO("Robenia Windas", "7 Westend Parkway", "4 Badeau Hill", "518 Grasskamp Alley", "Tucson", "Arizona", "United States", "85737"));
        addressList.add(new AddressVO("Rockwell Haddeston", "01911 Morrow Street", "63986 Rieder Crossing", "191 Lerdahl Terrace", "San Antonio", "Texas", "United States", "78215"));
        addressList.add(new AddressVO("Sasha Clampton", "5069 Arrowood Crossing", "135 Kensington Plaza", "4235 Springview Street", "Gilbert", "Arizona", "United States", "85297"));
        addressList.add(new AddressVO("Shelagh Frankham", "5 American Ash Avenue", "9 Elka Junction", "5161 North Park", "Indianapolis", "Indiana", "United States", "46295"));
        addressList.add(new AddressVO("Silvano Shervil", "1514 Cambridge Hill", "844 Main Road", "03 Evergreen Lane", "Winston Salem", "North Carolina", "United States", "27157"));
        addressList.add(new AddressVO("Shelton Compford", "07197 Lakeland Alley", "80 Loomis Trail", "94249 Mockingbird Road", "Wilmington", "North Carolina", "United States", "28405"));
        addressList.add(new AddressVO("Tabitha Barck", "956 Magdeline Center", "3517 Emmet Parkway", "9 Macpherson Alley", "Lancaster", "Pennsylvania", "United States", "17605"));
        addressList.add(new AddressVO("Terrie Dougher", "8 Carpenter Drive", "3747 1st Avenue", "5 Nelson Way", "Spring", "Texas", "United States", "77388"));
        addressList.add(new AddressVO("Tove Brouncker", "1 Fisk Lane", "8033 Anderson Plaza", "5 Pawling Place", "Vancouver", "Washington", "United States", "98682"));
        addressList.add(new AddressVO("Win Common", "23165 Loomis Lane", "5 Sheridan Avenue", "73193 Eastwood Point", "Kansas City", "Missouri", "United States", "64142"));
        addressList.add(new AddressVO("Wheeler Nequest", "1 Transport Junction", "21070 Jenna Lane", "4 Knutson Trail", "Chattanooga", "Tennessee", "United States", "37410"));
        return addressList;

        /*List<AddressVO> addressList = new ArrayList<>();
        addressList.add(new AddressVO("Meghan Bridgestock", "98454 Bowman Center,789 Kropf Terrace,435 Waubesa Place,Spartanburg,South Carolina,United States,29319"));
        addressList.add(new AddressVO("Shaylah Wornham", "794 Forest Dale Parkway,87007 Manufacturers Road,1 Buena Vista Street,Waltham,Massachusetts,United States,02453"));
        addressList.add(new AddressVO("Lianna Crier", "1 Eliot Center,3856 Onsgard Point,9057 Continental Street,Des Moines,Iowa,United States,50335"));
        addressList.add(new AddressVO("Gray Camies", "2 Lakewood Hill,1 Heffernan Court,684 Washington Terrace,Midland,Michigan,United States,48670"));

        addressList.add(new AddressVO("Gloriane Vlasenko", "12746 Northwestern Circle,3 Talisman Plaza,398 Village Lane,San Diego,California,United States,92176"));
        addressList.add(new AddressVO("Shelton Compford", "07197 Lakeland Alley,80 Loomis Trail,94249 Mockingbird Road,Wilmington,North Carolina,United States,28405"));
        addressList.add(new AddressVO("Rockwell Haddeston", "01911 Morrow Street,63986 Rieder Crossing,191 Lerdahl Terrace,San Antonio,Texas,United States,78215"));
        addressList.add(new AddressVO("Konrad Tungay", "68 Daystar Park,6 Spohn Pass,633 Maryland Pass,Jacksonville,Florida,United States,32215"));
        addressList.add(new AddressVO("Jephthah Chisman", "6087 Cordelia Plaza,84 Bunker Hill Avenue,08 Eliot Court,Longview,Texas,United States,75605"));
        return addressList;*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        //getMenuInflater().inflate(R.menu.menu_action_mode,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_calculate_risk) {
            Log.i(LOG_TAG, "Selected Items :" + selectedList);

            if (selectedList.size() == 0) {
                Toast.makeText(
                        this,
                        "Select at least one address to calculate risk",
                        Toast.LENGTH_SHORT
                ).show();
            } else {
                //Run in the background.
                MultiAddressProcessingTask task = new MultiAddressProcessingTask(MultiAddressSelectActivity.this);
                task.execute(selectedList.toArray(new AddressVO[selectedList.size()]));
            }
        }

        if (item.getItemId() == R.id.item_csv_upload) {
            Log.i(LOG_TAG, "--- Upload CSV Called ----");

            Intent intent = new Intent(this, CSVFileSelectActivity.class);
            startActivity(intent);

        }
        return true;
    }

    public boolean isRecycleViewInAction() {
        return isRecycleViewInAction;
    }

    @Override
    public boolean onLongClick(View v) {
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.menu_action_mode);

        counterTextView.setVisibility(View.VISIBLE);
        isRecycleViewInAction = true;

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        adapter.notifyDataSetChanged();
        return false;
    }

    public void prepareSelection(View view, int position) {
        CheckBox checkBox = (CheckBox) view;
        if (checkBox.isChecked()) {
            selectedList.add(addressList.get(position));
        } else {
            selectedList.remove(addressList.get(position));
        }
        //Update counter text
        if (selectedList.size() == 0) {
            counterTextView.setText("0 address selected");
        } else {
            counterTextView.setText(selectedList.size() + "  addresses selected");
        }

    }
}
