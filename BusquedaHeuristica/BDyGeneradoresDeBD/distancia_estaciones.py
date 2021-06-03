#Info de estaciones
'''
Rosa:			20
Azul:			24
Verde militar:	21
Verde agua:		10
Amarilla:		13
Roja:			11
Naranja:		14
verde oscuro:	19
café:			12
Morada:			10
Gris:			21
Dorada:			20
-- Total:		195
195*195= 38,025

'''

#Profe si ve esto, el error no estaba aquí, la fórmula calcula la misma distancia 
#entre estaciones que te da google, comprobé la mayoría, so... están bien los resultados xD
import numpy as np
import math

estaciones = np.genfromtxt("estaciones.data",dtype=float,delimiter=",");
constante= math.pi /180

R = 6378000; # metres

compilacion="";

for i in range(163):
	print(i)
	for j in range(163):
		lat1 = estaciones[i][0];
		lon1 =estaciones[i][1];

		lat2 = estaciones[j][0];
		lon2 =estaciones[j][1];

		φ1 = lat1 * math.pi/180;
		φ2 = lat2 * math.pi/180;
		Δφ = (lat2-lat1) * math.pi/180;
		Δλ = (lon2-lon1) * math.pi/180;

		a = math.sin(Δφ/2) * math.sin(Δφ/2) + math.cos(φ1) * math.cos(φ2) *math.sin(Δλ/2) * math.sin(Δλ/2);
		c = 2 * math.atan2(math.sqrt(a), math.sqrt(1-a));

		formula = int(R * c);

		compilacion+= str(formula)+",";
	compilacion+= "\n";

f= open("distancias.data","w+")
f.write(str(compilacion))
f.close()
print('listo')