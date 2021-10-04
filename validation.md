installation
============

go
---
hard with gopath and stuff

python
------
easy : apt

rust:
-----
semble easy mais prend de la place

ocaml:
------
simple, fr, bien expliquer

haskell:
------
compliquer

scala
-----
simple, bien documenté, pas de dockerfile officiel

php
-----
simple, 
bien documenté, 
souci avec autoload et composer mais bein documenté

cpp
---
simple
g++ deja présent

csharp
------
assez simple

fsharp
------
plutot complexe

v
---
simple

koka
====
- pas encore au point

core
====

node
----
DI => pas forcement tres simple

go
--
DI => pas simple ?
test => pas simple de tester plusieur cas

python
------
bcp de runtime error on sait pas pk
tres rapide a ecrire ! et prise en main facile
comme le js, il faut des mock ou faire de l'injection de dependance

rust
----
les types ne sont pas strait forward (&str,str, String,....)
Future et Tokio complié

haskell
-------
compliqué

scala
------
call http facile a réaliser
parse json compliquer
facile a coder
test facile a mettre en place

php
---
+ simple
+ readable
+ facile a implementer
- le typage ne sert a rien car pas de compilation
- il n'y a pas de type Option ou Either => on retourne ?string

cpp
---
difficile d'utiliser des lib externe, pas de pkg manager
difficile de prototyper, debug

csharp
------
+ simple
+ readable
+ facile a implem

fsharp
------
simple a ecrire et comprendre
system de module et namespace pas clair
ne compile pas pour le moment

v
---
+ simple
+ readable
- manque certain outils de lang

koka
----
- pas facile de suivre ce qu'on importe et ce que l'on utilise (savoir d'ou ca viens)
- la stdlib n'est pas du tout complete

mise en place du cli en local (lancé emoji en cli)
==================================================

node
----
#!/usr/bin/env node dans index.js puis npm install -g => install le package en global


go
---
go build main.go => assez simple

cli code
========

node
----
difficil gestion d'erreur avec try:catch
difficil de parcé les couleur de la console

go
---
assez simple a mettre en place, ya des function toutes faites

csharp
------
simple

fsharp
------
dur

v
---
simple