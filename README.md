# ConvexHullClassifier
Dado um conjunto de pontos dispersos num mapa bidimensional, pretendese encontrar a forma geom´etrica do contorno delimitado por esses pontos,
tal como exemplificado na seguinte figura.
A partir de um conjunto de pontos é necessario encontrar a area delimitadora que envolve todos os pontos. O algoritmo Convex Hull permite resolver
este problema, nomeadamente a partir de uma lista de pontos é obtido uma
outra lista de pontos mınima, contendo os pontos externos que definem os
limites ocupado por todos os pontos. Essa lista de pontos percorrida por
uma determinada ordem permite representar um polıgono.
O polıgono obtido necessita de ser classificado enquanto figura geometrica,
podendo ter duas formas geom´etricas b´asicas, designadamente triangulo ou
quadrilatero. Estas figuras geometricas basicas podem ainda ser identificadas com maior detalhe, nomeadamente o triangulo pode ser equilatero e por
outro lado, o quadrilatero pode ser retangulo ou quadrado.
Depois de identificada a figura é tambem necessario calcular o seu perımetro.
Resumidamente, a partir de um conjunto de pontos deve ser classificada a figura geometrica do Convex Hull formado por esses pontos e o seu perımetro. Note que pode utilizar um algoritmo Convex Hull ja implementado. Assim é necessario desenvolver um programa que permita resolver o
problema utilizando o paradigma de POO.
