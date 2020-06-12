#include <dht.h>

dht DHT;
int humi,temp,moiste,moist,cal,pho,ldr;
float ph;
int sensormo=A0;
int sn=A7;
int ld=A3;
#define DHT11_PIN 22

void setup(){
  Serial.begin(9600);
  Serial1.begin(9600);
  
}
  String str;
  
void loop()
  {   DHT.read11(DHT11_PIN);
      moiste=analogRead (sensormo);
      moist=map(moiste,0,1023,0,100);
      pho=analogRead(sn);   
      ph=(pho * 0.02) - 0.8; 
      temp=DHT.temperature;
      humi=DHT.humidity;
      ldr=analogRead(A3);
      if(ldr>0)
        ld=1;
      else 
        ld=0;
      Serial.print("Temperature = ");
      Serial.println(temp);
      Serial.print("Humidity = ");
      Serial.println(humi);
      Serial.print("Moisture = ");
      Serial.println(moist);
      Serial.print("Light=");
      Serial.println(ld);
      Serial.print("pH=");
      Serial.println(ph);
      str=String(temp)+String(',')+String(humi)+String(',')+String(moist)+String(',')+String(ld)+String(',')+String(ph);
      Serial1.println(str);
      delay(5000);
      
   
}



