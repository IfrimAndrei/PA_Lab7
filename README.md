# PA_Lab7
Am facut partea de Compulsory, toti playerii incep in acelasi tip si nu iau cat de multe piese pot (fara sa astepte pe ceilalti)
Playerul alege o piesa in felul urmator:
  -prima piesa aleasa este random;
  -apoi incearca sa gaseasca o piesa sa o formeze un circuit imediat ( daca avem v[i][j], o sa aleaga v[j][i])
  -daca nu gaseste o asemnea piesa, alege o piesa random care e conectata cu piesa avuta  //metoda extendingSequence
  -daca nu reuseste ia alta piesa random si incearca sa formeze circuit la ea de la 0
  
  
update:
Am facut si o bucata din partea de Optional:
  -playerii sunt sincronizati
  -se calculeaza punctajul si se afiseaza un castigator (punctajul e calculat in felul urm: o muchie este punctata daca face parte din cel putin un ciclu )
  
Nu am facut timer-ul si schimbarea la jucator sa poata pune de la tastatura;
