'''
Programa que toma la latitud y longitud de todas las estaciones, de acuerdo a estas y a un array
donde se registra cada conexioin entre estaciones, se genera una matriz con las distancias entre
las estaciones conectadas

NOTA: hay estaciones que aunque estan en varias lineas solo apareceran una vez en la matriz
'''
import numpy as np
import math

matriz_conectada = [''] * 163;
distancias = np.genfromtxt("distancias.data",dtype=float,delimiter=",");

#conexiones
conexion = []

# la funcion siguiente sirve para agregar secuencias consecutivas de conexiones
# entre estaciones al arreglo llamado conexion. esto solo sirve con las conexiones
def agregar_secuencia(inicio, final):
	for i in range(inicio,final):
		conexion.append([i,i+1])

#secuencias de conexiones consecituvas (lineas actuales)
agregar_secuencia(0,19)

#agregar_secuencia(20,42)
agregar_secuencia(20,32)
agregar_secuencia(33,42)

#agregar_secuencia(43,61)
agregar_secuencia(43,48)
agregar_secuencia(50,61)

#agregar_secuencia(62,70)
agregar_secuencia(62,64)
agregar_secuencia(65,70)

#agregar_secuencia(71,80)
agregar_secuencia(71,73)
conexion.append([74,75])
agregar_secuencia(76,80)

#agregar_secuencia(81,88)
agregar_secuencia(81,86)

#agregar_secuencia(89,99)
agregar_secuencia(89,91)
agregar_secuencia(92,95)
agregar_secuencia(96,99)

#agregar_secuencia(100,114)
conexion.append([102,103])
agregar_secuencia(105,114)

#agregar_secuencia(115,121)
agregar_secuencia(115,118)
conexion.append([120,121])

agregar_secuencia(122,130)
#agregar_secuencia(131,146)
agregar_secuencia(131,141)
conexion.append([142,143])
conexion.append([144,145])

#agregar_secuencia(147,162)
agregar_secuencia(147,157)
conexion.append([159,160])
conexion.append([161,162])

#conexiones particulares (estaciones compartidas)
conexion.append([0,80]) #pantitllan - hangares
conexion.append([0,1]) #pantitlan - zaragoza
conexion.append([0,115]) #pantitlan - puebla
conexion.append([0,122]) #Pantitlan - agricola oriental
conexion.append([6,65]) #san lazaro - morelos
conexion.append([6,143]) #san lazaro - flores magon
conexion.append([7,65]) # candelara - morelos
conexion.append([7,64]) # candelaria -  gray servando
conexion.append([9,32]) # pinosuarez -zocalo
conexion.append([9,33]) # pinosuarezz - san antonioabad
conexion.append([11,101]) # salto delagua - san juan de letran
conexion.append([11,102]) # salto delagua - doctores
conexion.append([12,49]) # balderas - juarez
conexion.append([12,50]) # balderas niños heroes
conexion.append([18,95]) # tacubaya - constituyentes
conexion.append([18,96]) # tacubaya - san pedro de los pinos
conexion.append([18,121]) # tacubaya - patriotismo

conexion.append([22,91]) # tacuba - refineria
conexion.append([22,92]) # tacuba - san joaquin
conexion.append([29,48]) # hidalgo - guerrero
conexion.append([29,49]) # hidalgo - juarez
conexion.append([30,100]) # bellas artes - garibaldi
conexion.append([30,101]) # bellas artes - san juan de letran
conexion.append([34,119]) # chabacano - lazaro cardenas
conexion.append([34,63]) # chabacano - jamaica
conexion.append([34,103]) # chabacano - obrera
conexion.append([34,104]) # chabacano - la viga
conexion.append([40,159]) # ermita - eje central
conexion.append([40,158]) # ermita - mexicaltzingo

conexion.append([44,87]) # deportivo 18 marzo - la villabasilica
conexion.append([44,88]) # deportivo 18 marzo - lindavista
conexion.append([46,73]) # la raza - autobuses del norte
conexion.append([46,74]) # la raza - misterios
conexion.append([48,100]) # guerrero - buenavista
conexion.append([48,146]) # guerrero - garibaldi
conexion.append([52,120]) # centro medico - chilpancingo
conexion.append([52,119]) # centro medico - lazaro cardenas
conexion.append([56,161]) # zapata - hospital 20 noviembre
conexion.append([56,160]) # centro medico - parque de los venados

conexion.append([62,104]) # santa anita - la viga
conexion.append([62,105]) # santa anita - coyuya
conexion.append([63,118]) # jamaica - mixhiuca
conexion.append([65,144]) # morelos - tepito
conexion.append([67,75]) # consulado - valle gómez
conexion.append([67,76]) # consulado - eduardo molina
conexion.append([70,88]) # martin carrera - la villabasilica

conexion.append([72,86]) # instituto del petroleo - vallejo
conexion.append([72,87]) # instituto del petroleo - lindavista
conexion.append([78,141]) # oceania - deportivo oceania
conexion.append([78,142]) # oceania - romero rubio

conexion.append([81,89]) # el rosario - aquiles serdan

conexion.append([98,162]) # mixcoac - insurgentes sur

conexion.append([100,145]) # garibaldi - lagunilla
conexion.append([110,158]) # atlalilco - mexicaltzingo
conexion.append([110,157]) # atlalilco - culhuacán

'''
#Hacer la matriz tomando en cuenta todas las conexiones
for elem in conexion:
	matriz_conectada[elem[0]][elem[1]] = distancias[elem[0]][elem[1]];
	matriz_conectada[elem[1]][elem[0]] = distancias[elem[0]][elem[1]];
#recorrer toda la matriz para guardarla en un data
texto =''
for elem in matriz_conectada:
	for elem2 in range(len(matriz_conectada)):
		texto+=str(int(elem[elem2]))+','
	texto +='\n'

print(texto)

f= open("conexiones.data","w+")
f.write(str(texto))
f.close()
print('listo')

texto =''
for elem in conexion:
	texto+= str(elem[0])+','+str(elem[1]);
	texto +='\n'

f= open("conexiones_individuales.data","w+")
f.write(str(texto))
f.close()
print('listo')
'''

#escribir en el archivo

for i in range(len(conexion)):
	primer = matriz_conectada[conexion[i][0]].split(',')
	segundo = matriz_conectada[conexion[i][1]].split(',')
	if str(conexion[i][1]) in primer:
		print('else 1: ',conexion[i][1],' en ',primer,sep='')
	else:
		matriz_conectada[conexion[i][0]] +=str(conexion[i][1])+','

	if str(conexion[i][0]) in segundo:
		print('else 2: ',conexion[i][0],' en ',segundo,sep='')
	else:
		matriz_conectada[conexion[i][1]] +=str(conexion[i][0])+','

texto =''
for elem in matriz_conectada:
	texto+= str(elem)
	texto +='\n'
f= open("conexiones.data","w+")
f.write(str(texto))
f.close()
print('listo')
