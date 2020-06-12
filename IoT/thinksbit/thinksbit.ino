
#include <ESP8266WiFi.h>

#include <ESP8266HTTPClient.h>

WiFiClient client;

String thingSpeakAddress= "http://api.thingspeak.com/update?";
String writeAPIKey;
String tsfield1Name;
String request_string;

HTTPClient http;

void setup()
{
    Serial.begin(9600);
    WiFi.disconnect();
   WiFi.begin("barath","barathgopi");
  while ((!(WiFi.status() == WL_CONNECTED))){
    delay(300);

  }

}
String str;
char stro[5];
char bu[20];
int one,two,three,five;
float four;
int i=0;


void loop()
{
  str=Serial.readString();
    str.toCharArray(bu,20);
    sscanf(bu,"%d,%d,%d,%d,%f",&one,&two,&three,&five,&four);
    Serial.println(one);
    Serial.println(two);
    Serial.println(three);
    Serial.println(four);
    Serial.println(five);
    dtostrf(four, 2, 2, stro);
    str=(String)stro;
    

    if (client.connect("api.thingspeak.com",80)) {
      
      request_string = thingSpeakAddress;
      request_string += "key=";
      request_string += "V69ELEFR00VYLP3L";
      request_string += "&";
      request_string += "field1";
      request_string += "=";
      request_string += (String)one;
      request_string += "&field2";
      request_string += "=";
      request_string += (String)two;
      request_string += "&field3";
      request_string += "=";
      request_string += (String)three;
      request_string += "&field4";
      request_string += "=";
      request_string += str;
      request_string += "&field5";
      request_string += "=";
      request_string += (String)five;
      http.begin(request_string);
      http.GET();
      http.end();

    }
    
    delay(5000);

}
