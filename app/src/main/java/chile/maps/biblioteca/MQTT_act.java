package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MQTT_act extends AppCompatActivity {

    //Variables de conexion
    static String MQTTHOST = "tpc://tailor.cloudmqtt.com:14147";
    static String USERNAME = "dqmkrprs";
    static String PASSWORD = "U_7vUiPZnPA6";
    String topicStr = "Libros";
    MqttAndroidClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt_act);

        //Genera ClientID para la conexion
        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(), MQTTHOST , clientId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(USERNAME);
        options.setPassword(PASSWORD.toCharArray());

        try {
            IMqttToken token = client.connect(options);
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    Toast.makeText(getBaseContext(),"Conexion exitosa",Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Toast.makeText(getBaseContext(),"Conexion no realizada",Toast.LENGTH_LONG).show();
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(),e.toString(),Toast.LENGTH_LONG).show();
        }

    }

    public void LibroUno(View v){
        String topic = topicStr;
        String message = "Farenheith";
        try{
            client.publish(topic, message.getBytes(), 0 ,false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void LibroDos(View v){
        String topic = topicStr;
        String message = "Revival";
        try{
            client.publish(topic, message.getBytes(), 0 ,false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void LibroTres(View v){
        String topic = topicStr;
        String message = "El Alquimista";
        try{
            client.publish(topic, message.getBytes(), 0 ,false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void LibroCuatro(View v){
        String topic = topicStr;
        String message = "El poder";
        try{
            client.publish(topic, message.getBytes(), 0 ,false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void LibroCinco(View v){
        String topic = topicStr;
        String message = "Despertar";
        try{
            client.publish(topic, message.getBytes(), 0 ,false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
