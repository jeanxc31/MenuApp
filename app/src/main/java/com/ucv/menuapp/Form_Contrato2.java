package com.ucv.menuapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Form_Contrato2 extends AppCompatActivity {

    private String selecteddep, selectedprov;  //variables almacenan valor almacenado del departamento, ditrito y provincia
    //private TextView tvStateSpinner, tvDistrictSpinner;    //declarar txtview para mostrar errores
    private Spinner depSpinner, provSpinner, disSpinner, tipoSpinner, ubicaSpinner;   //spinners
    private ArrayAdapter<CharSequence> depAdapter, provAdapter, disAdapter, lsAdapter, ubAdapter;   //declaraciones

    private DatabaseReference DatosForm2;
    EditText hnom, hap, hcel, hemail, hcoment, hdom, hreferencia;
    Spinner splistado, departamentols, provincials, distritols, spubicacion2;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_contrato2);

        //REFERENCIA FIREBASE
       DatosForm2 = FirebaseDatabase.getInstance().getReference("Formulario");

        //VARIABLES
        //EDIT TEXT
        hnom = findViewById(R.id.hnom);
        hap = findViewById(R.id.hap);
        hcel = findViewById(R.id.hcel);
        hemail = findViewById(R.id.hemail);
        hcoment = findViewById(R.id.hcoment);
        hdom = findViewById(R.id.hdom);
        hreferencia = findViewById(R.id.hreferencia);

        //SPINNER
        splistado = findViewById(R.id.splistado);
        departamentols = findViewById(R.id.departamentols);
        provincials = findViewById(R.id.provincials);
        distritols = findViewById(R.id.distritols);
        spubicacion2 = findViewById(R.id.spubicacion2);

        //BOTON
        btn1 = findViewById(R.id.btn11);


        //CB TIPO DE SERVICIO
        tipoSpinner = findViewById(R.id.splistado);
        lsAdapter = ArrayAdapter.createFromResource(this, R.array.tiposervi, R.layout.itemspinner);
        lsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoSpinner.setAdapter(lsAdapter);


        //CB UBICACION

        ubicaSpinner = findViewById(R.id.spubicacion2);
        ubAdapter = ArrayAdapter.createFromResource(this, R.array.ubicacion, R.layout.itemspinner);
        ubAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ubicaSpinner.setAdapter(ubAdapter);

        //SPINNER DEPARTAMENTOS
        depSpinner = findViewById(R.id.departamentols);

        //LLENAR SPINNER USANDO UN STRING ARRAY Y DAR DISEÑO CON UN XML
        depAdapter = ArrayAdapter.createFromResource(this, R.array.departamentosperu, R.layout.itemspinner);

        //ESTILO DEL SPINNER
        depAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //VINCULAR EL SPINNER CON EL ADAPTADOR DECLARADO
        depSpinner.setAdapter(depAdapter);

        //UNA VEZ SE SELECCIONA UN ITEM DEL SPINNER DEPARTAMENTOS
        depSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //definimos las provincias spinner que se muestran cuando se selecciona un departamento
                provSpinner = findViewById(R.id.provincials); //define las provincias de acuerdo al estado seleccionado
                selecteddep = depSpinner.getSelectedItem().toString(); //obtener el departamento seleccionado
                // A TRAVES DEL ATRIBUTO
                int parentID = parent.getId();
                if (parentID == R.id.departamentols) {
                    //MULTIPLES RESULTADOS PARA LA VARIABLE PARENT
                    switch (selecteddep) {
                        case "Selecciona tu Departamento":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provinciasperu, R.layout.itemspinner); //captura datos
                            break;

                        case "Amazonas":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provamazonas, R.layout.itemspinner); //captura datos
                            break;

                        case "Ancash":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provancash, R.layout.itemspinner); //captura datos
                            break;

                        case "Apurímac":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provapurimac, R.layout.itemspinner); //captura datos
                            break;

                        case "Arequipa":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provarequipa, R.layout.itemspinner); //captura datos
                            break;

                        case "Ayacucho":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provayacucho, R.layout.itemspinner); //captura datos
                            break;

                        case "Cajamarca":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provcajamarca, R.layout.itemspinner); //captura datos
                            break;

                        case "Callao":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provcallao, R.layout.itemspinner); //captura datos
                            break;

                        case "Cusco":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provcusco, R.layout.itemspinner); //captura datos
                            break;

                        case "Huancavelica":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provhuancavelica, R.layout.itemspinner); //captura datos
                            break;

                        case "Huánuco":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provhuánuco, R.layout.itemspinner); //captura datos
                            break;

                        case "Ica":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provica, R.layout.itemspinner); //captura datos
                            break;

                        case "Junín":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provjunín, R.layout.itemspinner); //captura datos
                            break;

                        case "La Libertad":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provlalibertad, R.layout.itemspinner); //captura datos
                            break;

                        case "Lambayeque":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provlambayeque, R.layout.itemspinner); //captura datos
                            break;

                        case "Lima":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provlima, R.layout.itemspinner); //captura datos
                            break;

                        case "Loreto":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provloreto, R.layout.itemspinner); //captura datos
                            break;

                        case "Madre de Dios":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provmadrededios, R.layout.itemspinner); //captura datos
                            break;

                        case "Moquegua":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provmoquegua, R.layout.itemspinner); //captura datos
                            break;

                        case "Pasco":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provpasco, R.layout.itemspinner); //captura datos
                            break;

                        case "Piura":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provpiura, R.layout.itemspinner); //captura datos
                            break;

                        case "Puno":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provpuno, R.layout.itemspinner); //captura datos
                            break;

                        case "San Martín":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provsanmartin, R.layout.itemspinner); //captura datos
                            break;

                        case "Tacna":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provtacna, R.layout.itemspinner); //captura datos
                            break;

                        case "Tumbes":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provtumbes, R.layout.itemspinner); //captura datos
                            break;

                        case "Ucayali":
                            provAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.provucayali, R.layout.itemspinner); //captura datos
                            break;


                        default:
                            break;
                    }
                    provAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    //mostrar provincias de acuerdo al estado seleccionado
                    provSpinner.setAdapter(provAdapter);

                    provSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            //definimos los distritos que se muestran cuando se selecciona una provincia
                            disSpinner = findViewById(R.id.distritols); //define los distritos de acuerdo a la provincia seleccionado
                            selectedprov = provSpinner.getSelectedItem().toString(); //obtener la provincia seleccionado

                            int parentID = parent.getId();
                            if (parentID == R.id.provincials) {
                                switch (selectedprov) {
                                    case "Selecciona tu Provincia":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.distritosperu, R.layout.itemspinner); //captura datos
                                        break;


                                    //AMAZONAS
                                    case "Chachapoyas":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dischachapoyas, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Bagua":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disbagua, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Bongará":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disbongara, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Condorcanqui":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discondorcanqui, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Luya":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disluya, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Rodriguez de Mendoza":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disrodriguez, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Utcubamba":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disutcubamba, R.layout.itemspinner); //captura datos
                                        break;

                                    //ANCASH

                                    case "Huáraz":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuaraz, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Aija":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disaija, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Antonio Raymondi":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disantonioraymondi, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Asunción":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disasuncion, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Bolognesi":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disbolognesi, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Carhuáz":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discarhuaz, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Carlos Fermín Fitzcarrald":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discarlosfer, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Casma":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discasma, R.layout.itemspinner); //captura datos
                                        break;

                                    case "discorongo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disbongara, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Huári":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuari, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Huarmey":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuarmey, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Huaylas":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuaylas, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Mariscal Luzuriaga":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dismarisluzuriaga, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Ocros":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disocros, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Pallasca":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dispallasca, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Pomabamba":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dispomabamba, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Recuay":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disrecuay, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Santa":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissanta, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Sihuas":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissihuas, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Llungay":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disyungay, R.layout.itemspinner); //captura datos
                                        break;


                                    //APURIMAC

                                    case "Abancay":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disabancay, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Andahuaylas":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disandahuaylas, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Antabamba":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disantabamba, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Aymacraes":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disaymaraes, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Cotabambas":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discotabambas, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Chincheros":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dischincheros, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Grau":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disgrau, R.layout.itemspinner); //captura datos
                                        break;


                                    //AREQUIPA

                                    case "Arequipa":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disarequipa, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Camaná":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discamana, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Caravelí":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discaraveli, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Castilla":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discastilla, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Caylloma":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discaylloma, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Condesuyos":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discondesuyos, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Islay":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disislay, R.layout.itemspinner); //captura datos
                                        break;

                                    case "La Unión":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dislaunion, R.layout.itemspinner); //captura datos
                                        break;


                                    //AYACUCHO

                                    case "Huamanga":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuamanga, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Cangallo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discangallo, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Huanca Sancos":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuancasancos, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Huanta":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuantas, R.layout.itemspinner); //captura datos
                                        break;

                                    case "La Mar":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dislamar, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Lucanas":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dislucanas, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Parinacochas":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disparinacochas, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Páucar del Sara Sara":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissarasara, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Sucre":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissucre, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Victor Fajardo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disvíctorfajardo, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Vilcas Huamán":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disvilcashuamán, R.layout.itemspinner); //captura datos
                                        break;


                                    //CAJAMARCA

                                    case "Cajamarca":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discajamarca, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Cajabamba":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discajabamba, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Celedín":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discelendin, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Chota":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dischota, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Contuzamá":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discontumaza, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Cutervo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discutervo, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Hualgayoc":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishualgayoc, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Jaén":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disjaen, R.layout.itemspinner); //captura datos
                                        break;

                                    case "San Ignacio":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissanignacio, R.layout.itemspinner); //captura datos
                                        break;

                                    case "San Marcos":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissanmarcos, R.layout.itemspinner); //captura datos
                                        break;

                                    case "San Miguel":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissanmiguel, R.layout.itemspinner); //captura datos
                                        break;

                                    case "San Pablo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissanpablo, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Santa Cruz":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissantacruz, R.layout.itemspinner); //captura datos
                                        break;


                                    //CALLAO

                                    case "Prov. Const. Callao":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discallao, R.layout.itemspinner); //captura datos
                                        break;


                                    //CUSCO

                                    case "Cusco":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discusco, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Acomayo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disacomayo, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Anta":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disanta, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Calca":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discalca, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Canas":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discanas, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Canchis":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discanchis, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Chumbivilcas":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dischumbivilcas, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Espinar":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disespinar, R.layout.itemspinner); //captura datos
                                        break;

                                    case "La Convención":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dislaconvención, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Paruro":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disparuro, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Paucartambo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dispaucartambo, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Quispicanchi":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disquispicanchi, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Urubamba":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disurubamba, R.layout.itemspinner); //captura datos
                                        break;


                                    //HUANCAVELICA

                                    case "Huancavelica":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuancavelica, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Acobamba":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disacobamba, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Angaraes":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disangaraes, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Castrovirreyna":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discastrovirreyna, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Churcampa":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dischurcampa, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Huaytará":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuaytara, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Tayacaja":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.distayacaja, R.layout.itemspinner); //captura datos
                                        break;

                                    //HUÁNUCO

                                    case "Huánuco":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuanuco, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Ambo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disambo, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Dos de Mayo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disdosdemayo, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Huacaybamba":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuacaybamba, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Huamalíes":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuamalíes, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Leoncio Prado":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disleoncioprado, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Marañón":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dismarañón, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Pachitea":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dispachitea, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Puerto Inca":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dispuertonca, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Lauricocha":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dislauricocha, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Yarowilca":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disyarowilca, R.layout.itemspinner); //captura datos
                                        break;


                                    //ICA

                                    case "Ica":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disica, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Chincha":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dischincha, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Nazca":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disnazca, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Palpa":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dispalpa, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Pisco":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dispisco, R.layout.itemspinner); //captura datos
                                        break;


                                    //JUNIN

                                    case "Huancayo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuancayo, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Concepción":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disconcepcion, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Chanchamayo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dischanchamayo, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Jauja":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disjauja, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Junín":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disjunin, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Satipo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissatipo, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Tarma":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.distarma, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Yauli":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disyauli, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Chupaca":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dischupaca, R.layout.itemspinner); //captura datos
                                        break;

                                    //LA LIBERTAD

                                    case "Trujillo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.distrujillo, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Ascope":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disascope, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Bolívar":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disbolivar, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Chepén":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dischepen, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Julcán":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disjulcan, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Otuzco":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disotuzco, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Pacasmayo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dispacasmayo, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Pataz":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dispataz, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Sánchez Carrión":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissanchezcarrion, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Santiago de Chuco":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissantiagodechuco, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Gran Chimú":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disgranchimu, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Virú":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disviru, R.layout.itemspinner); //captura datos
                                        break;

                                    //LAMBAYEQUE

                                    case "Chiclayo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dischiclayo, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Ferreñafe":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disferreñafe, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Lambayeque":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dislambayeque, R.layout.itemspinner); //captura datos
                                        break;

                                    //LIMA

                                    case "Lima":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dislima, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Barranca":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disbarranca, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Cajatambo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discajatambo, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Canta":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discanta, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Cañete":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discañete, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Huaral":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuaral, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Huarochirí":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuarochiri, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Huaura":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuaura, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Oyón":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disoyon, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Yauyos":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disyauyos, R.layout.itemspinner); //captura datos
                                        break;


                                    //LORETO

                                    case "Maynas":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dismaynas, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Alto Amazonas":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disaltoamazonas, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Loreto":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disloreto, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Mariscal Ramón Castilla":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disramoncastilla, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Requena":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disrequena, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Ucayali":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disucayali, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Datem del Marañón":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dismarañon, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Putumayo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disputumayo, R.layout.itemspinner); //captura datos
                                        break;


                                    //MADRE DE DIOS


                                    case "Tambopata":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.distambopata, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Manu":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dismanu, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Tahuamanu":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.distahuamanu, R.layout.itemspinner); //captura datos
                                        break;


                                    //MOQUEGUA


                                    case "Mariscal Nieto":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dismarisnieto, R.layout.itemspinner); //captura datos
                                        break;

                                    case "General Sanchéz Cerro":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissanchezcerro, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Ilo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disilo, R.layout.itemspinner); //captura datos
                                        break;


                                    //PASCO


                                    case "Pasco":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dispasco, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Daniel Alcides Carrión":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disalcidescarrion, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Oxapampa":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disoxapampa, R.layout.itemspinner); //captura datos
                                        break;


                                    //PIURA

                                    case "Piura":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dispiura, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Ayabaca":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disayabaca, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Huancabamba":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuancabamba, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Morropón":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dismorropon, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Paita":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dispaita, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Sullana":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissullana, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Talara":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.distalara, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Sechura":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissechura, R.layout.itemspinner); //captura datos
                                        break;

                                    //PUNO

                                    case "Puno":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dispuno, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Azángaro":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disazangaro, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Carabaya":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discarabaya, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Chucuito":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dischucuito, R.layout.itemspinner); //captura datos
                                        break;

                                    case "El Collao":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.diselcollao, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Huancané":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuancane, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Lampa":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dislampa, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Melgar":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dismelgar, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Moho":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dismoho, R.layout.itemspinner); //captura datos
                                        break;

                                    case "San Antonio Putina":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disputina, R.layout.itemspinner); //captura datos
                                        break;

                                    case "San Román":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissanroman, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Sandia":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissandia, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Yunguyo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disyunguyo, R.layout.itemspinner); //captura datos
                                        break;

                                    //SAN MARTIN

                                    case "Moyobamba":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dismoyobamba, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Bellavista":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disbellavista, R.layout.itemspinner); //captura datos
                                        break;

                                    case "El Dorado":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.diseldorado, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Huagallaga":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dishuallaga, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Lamas":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dislamas, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Mariscal Cáceres":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dismariscaceres, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Picota":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dispicota, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Rioja":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disrioja, R.layout.itemspinner); //captura datos
                                        break;

                                    case "San Martín":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dissanmartin, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Tocache":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.distocache, R.layout.itemspinner); //captura datos
                                        break;


                                    //TACNA

                                    case "Tacna":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.distacna, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Candarave":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discandarave, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Jorge Basadre":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disjorgebasadre, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Tarata":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.distarata, R.layout.itemspinner); //captura datos
                                        break;


                                    //TUMBES

                                    case "Tumbes":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.distacna, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Contralmirante Villar":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discvillar, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Zarumilla":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.diszaru, R.layout.itemspinner); //captura datos
                                        break;


                                    //UCAYALI

                                    case "Coronel Portillo":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.discoronelportillo, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Atalaya":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.disatalaya, R.layout.itemspinner); //captura datos
                                        break;

                                    case "Padre Abad":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dispadreabad, R.layout.itemspinner); //captura datos
                                        break;


                                    case "Parús":
                                        disAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.dispurus, R.layout.itemspinner); //captura datos
                                        break;


                                    default:
                                        break;
                                }
                                disAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                                //mostrar DISTRITOS de acuerdo a LA PROVINCIA  seleccionada
                                disSpinner.setAdapter(disAdapter);

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    }); } }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                     });

    }

    public void Envform2(View view) {

        String nombre2 = hnom.getText().toString().trim();
        String apellido2 = hap.getText().toString().trim();
        String celular2 = hcel.getText().toString().trim();
        String email2 = hemail.getText().toString().trim();
        String coment2 = hcoment.getText().toString().trim();
        String domici2 = hdom.getText().toString().trim();
        String referen2 = hreferencia.getText().toString().trim();
        String list2 = splistado.getSelectedItem().toString();
        String dep2 = departamentols.getSelectedItem().toString();
        String prov2 = provincials.getSelectedItem().toString();
        String dis2 = distritols.getSelectedItem().toString();
        String ub2 = spubicacion2.getSelectedItem().toString();

        if (!TextUtils.isEmpty(nombre2)){
            String id = DatosForm2.push().getKey();
            Form2 formu2 = new Form2(id, nombre2, apellido2, celular2, email2, coment2, domici2, referen2, list2, dep2, prov2, dis2, ub2);
            DatosForm2.child("FORMULARIO CONSULTA NIVEL NACIONAL").child(id).setValue(formu2);

            Toast.makeText(this, "FORMULARIO ENVIADO", Toast.LENGTH_LONG).show();
            limpiar();
        }else {
            Toast.makeText(this, "INGRESE SUS DATOS", Toast.LENGTH_LONG).show();
        }


    }

private void limpiar(){
        hnom.setText("");
    hap.setText("");
    hcel.setText("");
    hemail.setText("");
    hcoment.setText("");
    hdom.setText("");
    hreferencia.setText("");
    splistado.setSelection(lsAdapter.NO_SELECTION);
    departamentols.setSelection(depAdapter.NO_SELECTION);
    provincials.setSelection(provAdapter.NO_SELECTION);
    distritols.setSelection(disAdapter.NO_SELECTION);
    spubicacion2.setSelection(ubAdapter.NO_SELECTION);
    hnom.requestFocus();

}

}
