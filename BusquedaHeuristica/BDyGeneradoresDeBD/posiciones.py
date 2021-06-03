import numpy as np
import math
from graphics import *

estaciones = np.genfromtxt("estaciones.data",dtype=float,delimiter=",");
constante= math.pi /180

R = 6378000; # metres

texto = ''
for i in range(len(estaciones)):
	lat = estaciones[i][0]-19
	lon = estaciones[i][1]-19

	lat *=1100
	lat -=577 #327
	lat *=-1
	
	lon *=-1000
	lon -=118000
	lon -=317  #467
	lon *=-1
	
	texto +=str(int(lon))+'-'+str(int(lat))
	texto+='\n'


f= open("coordenadas_nodos.data","w+")
f.write(str(texto))
f.close()
print('listo')