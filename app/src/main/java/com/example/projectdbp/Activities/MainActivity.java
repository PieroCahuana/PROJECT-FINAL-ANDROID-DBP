package com.example.projectdbp.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectdbp.Api.Service;
import com.example.projectdbp.Conexion.Connection;
import com.example.projectdbp.Models.Paciente;
import com.example.projectdbp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText etResultado;
    private EditText _etIdPaciente;
    private EditText _etNombre;
    private EditText _etApellido;
    private EditText _etDni;
    private EditText _etNacimiento;
    private EditText _etIdGenero;
    private EditText _etCelular;
    private EditText _etUsuario;
    private EditText _etContrasena;
    private Button _btnGrabar;
    private Button _btnModificar;
    private Button _btnEliminar;
    private Service serviceAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etResultado = (EditText) findViewById(R.id.etResultado_);
        _etIdPaciente=(EditText) findViewById(R.id.etIdPaciente);
        _etNombre=(EditText) findViewById(R.id.etNombre);
        _etApellido=(EditText) findViewById(R.id.etApellido);
        _etDni=(EditText) findViewById(R.id.etDni);
        _etNacimiento=(EditText) findViewById(R.id.etNacimiento);
        _etIdGenero=(EditText) findViewById(R.id.etIdGenero);
        _etCelular=(EditText) findViewById(R.id.etCelular);
        _etUsuario=(EditText) findViewById(R.id.etUsuario);
        _etContrasena=(EditText) findViewById(R.id.etContrasena);
        _btnGrabar=(Button) findViewById(R.id.btnGrabar);
        _btnModificar=(Button) findViewById(R.id.btnModificar);
        _btnEliminar=(Button) findViewById(R.id.btnEliminar);
        /*Conexión*/
        serviceAPI = Connection.getConnection().create(Service.class);
        load();
        _btnGrabar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Paciente pPac = new Paciente(Integer.parseInt(_etIdPaciente.getText().toString()),
                        _etNombre.getText().toString(),
                        _etApellido.getText().toString(),
                        _etDni.getText().toString(),
                        _etNacimiento.getText().toString(),
                        Integer.parseInt(_etIdGenero.getText().toString()),
                        _etCelular.getText().toString(),
                        _etUsuario.getText().toString(),
                        _etContrasena.getText().toString()
                );
                agregarPaciente(pPac);
            }
        });

        _btnEliminar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                eliminarPaciente(Integer.parseInt(_etIdPaciente.getText().toString()));
            }
        });

        _btnModificar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Paciente pPac = new Paciente(Integer.parseInt(_etIdPaciente.getText().toString()),
                        _etNombre.getText().toString(),
                        _etApellido.getText().toString(),
                        _etDni.getText().toString(),
                        _etNacimiento.getText().toString(),
                        Integer.parseInt(_etIdGenero.getText().toString()),
                        _etCelular.getText().toString(),
                        _etUsuario.getText().toString(),
                        _etContrasena.getText().toString()
                );
                modificarPaciente(pPac);
            }
        });
    }

    private void eliminarPaciente(int parseInt) {
        Call<Paciente> call = serviceAPI.removePaciente(parseInt);
        call.enqueue(new Callback<Paciente>() {
            @Override
            public void onResponse(Call<Paciente> call,
                                   Response<Paciente> response) {
                if(response.isSuccessful())
                {
                    mensaje("Los datos se eliminaron satisfactoriamente!!!");
                }
                else
                {
                    mensaje("Ocurrio un error desconocido!!!");
                }
            }

            @Override
            public void onFailure(Call<Paciente> call,
                                  Throwable t) {
                mensaje("Ocurrio un error!!!" + t.getMessage());
            }
        });
    }

    private void modificarPaciente(Paciente pPac) {
        Call<Paciente> call = serviceAPI.modifyPaciente(pPac);
        call.enqueue(new Callback<Paciente>() {

            @Override
            public void onResponse(Call<Paciente> call,
                                   Response<Paciente> response) {
                if(response.isSuccessful())
                {
                    Paciente pac = response.body();

                    mensaje("Los datos se modificaron satisfactoriamente!!!");
                }
                else
                {
                    mensaje("Ocurrio un error desconocido!!!");
                }
            }

            @Override
            public void onFailure(Call<Paciente> call,
                                  Throwable t) {
                mensaje("Ocurrio un error!!!" + t.getMessage());
            }
        });
    }

    public void agregarPaciente(Paciente pPac) {
        Call<Paciente> call = serviceAPI.addPaciente(pPac);
        call.enqueue(new Callback<Paciente>() {

            @Override
            public void onResponse(Call<Paciente> call,
                                   Response<Paciente> response) {
                if (response.isSuccessful()) {
                    Paciente pac = response.body();
                    mensaje("Registro grabado satisfactoriamente!");
                } else {
                    mensaje("Ocurrio un error al grabar los datos!");
                }
            }

            @Override
            public void onFailure(Call<Paciente> call,
                                  Throwable t) {
                mensaje("Ocurrio un error desconocido!" + t.getMessage());
            }
        });
    }
    public void load()
    {
        Call<List<Paciente>> call = serviceAPI.listPaciente();
        call.enqueue(new Callback<List<Paciente>>() {
            @Override
            public void onResponse(Call<List<Paciente>> call, Response<List<Paciente>> response) {
                if(response.isSuccessful())
                {
                    List<Paciente> lst = response.body();
                    etResultado.setText("");
                    for(Paciente x:lst)
                    {
                        etResultado.append("ID: "+x.getIdPaciente()+"\n"+
                                            "NOMBRE: " +x.getNomPaciente()+"\n"+
                                            "APELLIDO: "+x.getApePaciente()+"\n"+
                                            "DNI: "+x.getDniPaciente()+"\n"+
                                            "FECHA DE NACIMIENTO: "+x.getNacPaciente()+"\n"+
                                            "ID DE GÉNERO: "+x.getIdGenero()+"\n"+
                                            "TELÉFONO: "+x.getTelPaciente()+"\n"+
                                            "USUARIO: "+x.getUsuPaciente()+"\n"+
                                            "CONTRASEÑA: "+x.getContraPaciente()+"\n\n");
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Paciente>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Ocurrio un error", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void mensaje(String msg)
    {
        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
        alerta.setMessage(msg);
        alerta.show();
    }
}