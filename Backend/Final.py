import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
from sklearn import metrics
from sklearn.linear_model import LinearRegression
import seaborn as sns


dataset=pd.read_csv("rainfall_dataxxx.csv")
s_months = list(dataset.columns)
s_months.remove('Year')
months = []
for i in range(12):
    months.append(i+1)
m_map = {}
for i in range(11):
    m_map[s_months[i]] = i+1    
avgscores = []
atpr = dataset.drop('Year', axis=1)
np_df = atpr.as_matrix()

for i in range(102):
    for k in range(12):
        avgscores.append(np_df[i,k])
months = months*102
year = dataset['Year']
years = list(year)
k = []
for year in years:
    for i in range(12):
        k.append(year)
    
df = pd.DataFrame(
    {'year': k,
     'months': months,
     'avg-rain': avgscores
    })
cols = list(df.columns)
cols.remove('avg-rain')
cols.remove('year')
"""
print(cols)
"""  
X = df[cols]
Y = df['avg-rain']
type(X)

train_X= X[:864]
train_Y = Y[:864]
test_X = X[-360:]
test_Y = Y[-360:] 


linreg = LinearRegression()
linreg.fit(train_X,train_Y)
linreg.score(train_X,train_Y)
linreg.predict(test_X)

df.head()

plt.scatter(df['months'], df['avg-rain'])
plt.show()
plt.scatter(df['year'],df['avg-rain'])
plt.show()
sns.lmplot('year','avg-rain',
data= pd.concat([df['avg-rain'],
            df['year'],
            df['months']],axis=1),hue='months',fit_reg=False)
plt.show()


from sklearn.neighbors import KNeighborsRegressor
neigh = KNeighborsRegressor(n_neighbors=2)
neigh.fit(train_X, train_Y)
neigh.score(train_X,train_Y)
neigh.score(test_X,test_Y)

k = list(range(26))
k.remove(0)
for i in k:
    neigh = KNeighborsRegressor(n_neighbors=i)
    neigh.fit(train_X, train_Y)
    """
    print(" train on {} = ".format(i)+ str(neigh.score(train_X,train_Y)))
    print(" test on {} =  ".format(i) + str(neigh.score(test_X,test_Y)))
    """
neigh = KNeighborsRegressor(n_neighbors=12)
neigh.fit(train_X, train_Y)
"""
print("ACCURACY IN TRAINING SET:",neigh.score(train_X,train_Y))
print("ACCURACY IN TEST SET:",neigh.score(test_X,test_Y))    
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
     y_pred1=neigh.predict(users.val())
     db.child("weather")
     db.update({"rainfall":(float(y_pred1))})


