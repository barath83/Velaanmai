import urllib
import re
from bs4 import BeautifulSoup
import pandas as pd
"""
import pyrebase

config ={
   "apiKey": "AIzaSyDxO-jBDXjEzRGt8MOfXLAu2EhnYsU1AqE",
    "authDomain": "pythonex-54fe2.firebaseapp.com",
    "databaseURL": "https://pythonex-54fe2.firebaseio.com",
    "projectId": "pythonex-54fe2",
    "storageBucket": "pythonex-54fe2.appspot.com",
    "messagingSenderId": "1046323810913"
}
while(True):

     firebase=pyrebase.initialize_app(config)
     db = firebase.database()
     users = db.child("query/month").get()
"""     
crop_name={1:"rice",2:"groundnut",3:"tobbaco",4:"cotton"}     
     
data=urllib.request.urlopen("https://api.thingspeak.com/channels/683850/feeds.json?api_key=L0R9S1PYQ13LEZJI&results=2")
full=data.read()
full=str(full[300:])

temperature=re.search('field1":"(.+?)",',full)
temperature=float(temperature.group(1))

humidity=re.search('field2":"(.+?)",',full)
humidity=float(humidity.group(1))




moisture=re.search('field3":"(.+?)",',full)
moisture=float(moisture.group(1))

pH=re.search('field4":"(.+?)",',full)
pH=float(pH.group(1))



light=re.search('field5":"(.+?)"',full)
light=float(light.group(1))



crops={1:"rice",2:"wheat",3:"maize",4:"lemon"}
crop_data=pd.read_csv("crops.csv")

data = [l for l in crop_data]
row_count = sum(1 for row in crop_data)


for i in range(1,row_count-1):
    if crops[i]==crop_name:
        data_row=i
    
x=crop_data.iloc[data_row,[1,2,3,4,5]].values    

if x[0]>=light:
    if x[1]>=pH:
        if x[2]>=temperature:
            if x[3]>=moisture:
                if x[4]>=humidity:
                    """send data"""
                else:
                    """humidity error"""
            else:
                """moisture error"""
        else:
             """ temperature error"""
    else:
         """pH error"""
else:
   """light error"""
         

